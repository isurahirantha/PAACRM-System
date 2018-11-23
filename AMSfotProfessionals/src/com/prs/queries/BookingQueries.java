package com.prs.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.prs.Db.DBclass;
import com.prs.dao.Dao;
import com.prs.dao.DaoFactory;
import com.prs.model.BookingBean;
import com.prs.model.ClientBean;
import com.prs.model.ProfessionalBean;
import com.prs.model.SchedulerBean;

public class BookingQueries {
	/**
	 * SQL TABLE efuturelk.bookingtbl
	 */
	/*
	 * singleton connection
	 */
	DBclass dBclass =DBclass.getInstance();
	private Connection connection = dBclass.getConnection();
	private PreparedStatement preparedStatement=null;
	private ResultSet rSet;
	/**
	 * Factory Pattern + Dao Pattern = DaoFactory
	 * Get CommanDao instance using Dao dao = DaoFactory.getCommanDao()
	 */
	//Dao dao = DaoFactory.getSchedulerDao(); 
	Dao dao = DaoFactory.getCommanDao();
	
	/**
	 * This method build and pass the Query to add method in CommanDao implemented by Dao interface to execute
	 * @param experienceBean
	 * @return integer[0 or 1]
	 */
	public int insertQuery(BookingBean bookingBean){
		int numOfRow = 0;
		String insertQuery = "INSERT INTO bookingtbl("
				+ "schedule_id, professional_id, client_id, date_booked, time_from, time_to,professional_name,"
				+ " client_name, isConfirmed,  random_code)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";
		try{
		preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setInt(1, bookingBean.getSchedule_id());
		preparedStatement.setString(2, bookingBean.getProfessional_id());
		preparedStatement.setString(3, bookingBean.getClient_id());
		preparedStatement.setDate(4, bookingBean.getDate_booked());
		preparedStatement.setString(5, bookingBean.getTime_from());
		preparedStatement.setString(6, bookingBean.getTime_to());
		preparedStatement.setString(7, bookingBean.getProfessional_name());
		preparedStatement.setString(8, bookingBean.getClient_name());
		preparedStatement.setBoolean(9,bookingBean.getIsConfirmed());
		preparedStatement.setString(10,bookingBean.getRandom_code());
		numOfRow = dao.add(preparedStatement);
		return numOfRow;
		}catch(Exception e){
			e.printStackTrace();
		}
		return numOfRow;
	}

	
	public List<BookingBean> selectQuery(){

		List<BookingBean> bookingBeans = new ArrayList<BookingBean>();
		String selectQuery = "SELECT * FROM bookingTbl ORDER BY auto_id ASC";
		try{
			preparedStatement = connection.prepareStatement(selectQuery);
			
			if(dao.getAll(preparedStatement)!=null){
				rSet = dao.getAll(preparedStatement);
				while(rSet.next()){
					BookingBean bookingBean = new BookingBean();
					bookingBean.setAuto_id(rSet.getInt("auto_id"));
					bookingBean.setSchedule_id(rSet.getInt("schedule_id"));
					bookingBean.setProfessional_id(rSet.getString("professional_id"));
					bookingBean.setClient_id(rSet.getString("client_id"));
					bookingBean.setDate_booked(rSet.getDate("date_booked"));
					bookingBean.setTime_from(rSet.getString("time_from"));
					bookingBean.setTime_to(rSet.getString("time_to"));
					bookingBean.setProfessional_name(rSet.getString("professional_name"));
					bookingBean.setClient_name(rSet.getString("client_name"));
					bookingBean.setIsConfirmed(rSet.getBoolean("isConfirmed"));
					bookingBean.setRandom_code(rSet.getString("random_code"));
					bookingBeans.add(bookingBean);
				}
			}	
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookingBeans;		
		
		
	}	

	/**
	 * select ChatJoins For Clients
	 * @param client_id
	 * @return List<BookingBean> 
	 */	
	public List<BookingBean> selectChatJoinsForClients(String user_id){

		List<BookingBean> bookingBeans = new ArrayList<BookingBean>();
		String selectQuery = "";
		selectQuery = "SELECT * FROM bookingTbl WHERE  client_id = ? ORDER BY date_booked ASC";
		//selectQuery = "SELECT * FROM bookingTbl WHERE professional_id = ?  ORDER BY date_booked ASC";
		try{
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, user_id);
			
			if(dao.getAll(preparedStatement)!=null){
				rSet = dao.getAll(preparedStatement);
				while(rSet.next()){
					BookingBean bookingBean = new BookingBean();
					bookingBean.setAuto_id(rSet.getInt("auto_id"));
					bookingBean.setSchedule_id(rSet.getInt("schedule_id"));
					bookingBean.setProfessional_id(rSet.getString("professional_id"));
					bookingBean.setClient_id(rSet.getString("client_id"));
					bookingBean.setDate_booked(rSet.getDate("date_booked"));
					bookingBean.setTime_from(rSet.getString("time_from"));
					bookingBean.setTime_to(rSet.getString("time_to"));
					bookingBean.setProfessional_name(rSet.getString("professional_name"));
					bookingBean.setClient_name(rSet.getString("client_name"));
					bookingBean.setIsConfirmed(rSet.getBoolean("isConfirmed"));
					bookingBean.setRandom_code(rSet.getString("random_code"));
					bookingBeans.add(bookingBean);
				}
			}	
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookingBeans;		
		
		
	}	

	/**
	 * select ChatJoins For Professionals
	 * @param client_id
	 * @return List<BookingBean> 
	 */	
	public List<BookingBean> selectChatJoinsForProfessionals(String user_id){

		List<BookingBean> bookingBeans = new ArrayList<BookingBean>();
		String selectQuery = "";
		//selectQuery = "SELECT * FROM bookingTbl WHERE  client_id ? ORDER BY date_booked ASC";
		selectQuery = "SELECT * FROM bookingTbl WHERE professional_id = ?  ORDER BY date_booked ASC";
		try{
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, user_id);
			
			if(dao.getAll(preparedStatement)!=null){
				rSet = dao.getAll(preparedStatement);
				while(rSet.next()){
					BookingBean bookingBean = new BookingBean();
					bookingBean.setAuto_id(rSet.getInt("auto_id"));
					bookingBean.setSchedule_id(rSet.getInt("schedule_id"));
					bookingBean.setProfessional_id(rSet.getString("professional_id"));
					bookingBean.setClient_id(rSet.getString("client_id"));
					bookingBean.setDate_booked(rSet.getDate("date_booked"));
					bookingBean.setTime_from(rSet.getString("time_from"));
					bookingBean.setTime_to(rSet.getString("time_to"));
					bookingBean.setProfessional_name(rSet.getString("professional_name"));
					bookingBean.setClient_name(rSet.getString("client_name"));
					bookingBean.setIsConfirmed(rSet.getBoolean("isConfirmed"));
					bookingBean.setRandom_code(rSet.getString("random_code"));
					bookingBeans.add(bookingBean);
				}
			}	
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookingBeans;		
		
		
	}		
	/**
	 * call by Professionals. To see their appointments, to confirm them.
	 * GET All the bookings related each  Professionals' scheduler_id.
	 * Get ALL bookings from bookingtbl, which related to specific id in schedulartbl which related to specific user_id(professional)
	 * This method build and pass the Query to select method in CommanDao implemented by Dao interface to execute
	 * @param user_id (schedualerbean)
	 * @return List<Experiences>
	 */
	public List<BookingBean> selectQuery(ProfessionalBean bean){

		List<BookingBean> bookingBeans = new ArrayList<BookingBean>();
		String selectQuery = "SELECT * FROM bookingTbl WHERE schedule_id IN(SELECT auto_id FROM scheduletbl WHERE user_id = ?)";
		try{
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1,bean.getUser_id());
			if(dao.getAll(preparedStatement)!=null){
				rSet = dao.getAll(preparedStatement);
				while(rSet.next()){
					BookingBean bookingBean = new BookingBean();
					bookingBean.setAuto_id(rSet.getInt("auto_id"));
					bookingBean.setSchedule_id(rSet.getInt("schedule_id"));
					bookingBean.setProfessional_id(rSet.getString("professional_id"));
					bookingBean.setClient_id(rSet.getString("client_id"));
					bookingBean.setDate_booked(rSet.getDate("date_booked"));
					bookingBean.setTime_from(rSet.getString("time_from"));
					bookingBean.setTime_to(rSet.getString("time_to"));
					bookingBean.setProfessional_name(rSet.getString("professional_name"));
					bookingBean.setClient_name(rSet.getString("client_name"));
					bookingBean.setIsConfirmed(rSet.getBoolean("isConfirmed"));
					bookingBean.setRandom_code(rSet.getString("random_code"));
					bookingBeans.add(bookingBean);
				}
			}	
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookingBeans;		
		
		
	}
	
	/**
	 * GET A LIST OF THE BOOKINGS RELATED TO SPECIFIC CLIENT
	 * @param bean
	 * @return List<BookingBean>
	 */
	public List<BookingBean> selectQuery(ClientBean bean){

		List<BookingBean> bookingBeans = new ArrayList<BookingBean>();
		String selectQuery = "SELECT * FROM bookingTbl WHERE client_id = ? ORDER BY auto_id DESC";
		try{
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1,bean.getUser_id());
			if(dao.getAll(preparedStatement)!=null){
				rSet = dao.getAll(preparedStatement);
				while(rSet.next()){					
					BookingBean bookingBean = new BookingBean();
					bookingBean.setAuto_id(rSet.getInt("auto_id"));
					bookingBean.setSchedule_id(rSet.getInt("schedule_id"));
					bookingBean.setProfessional_id(rSet.getString("professional_id"));
					bookingBean.setClient_id(rSet.getString("client_id"));
					bookingBean.setDate_booked(rSet.getDate("date_booked"));
					bookingBean.setTime_from(rSet.getString("time_from"));
					bookingBean.setTime_to(rSet.getString("time_to"));
					bookingBean.setProfessional_name(rSet.getString("professional_name"));
					bookingBean.setClient_name(rSet.getString("client_name"));
					bookingBean.setIsConfirmed(rSet.getBoolean("isConfirmed"));
					bookingBean.setRandom_code(rSet.getString("random_code"));
					bookingBeans.add(bookingBean);
				}
			}	
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookingBeans;		
	}
	
	/**
	 * GET BOOING DETAILS OF CLIENT ID FOR report
	 */
	public BookingBean selectQuery(String book_id){

		BookingBean bookingBean = new BookingBean();
		String selectQuery = "SELECT * FROM bookingTbl WHERE random_code = ? ORDER BY auto_id DESC";
		try{
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1,book_id);
			if(dao.getAll(preparedStatement)!=null){
				rSet = dao.getAll(preparedStatement);
				while(rSet.next()){					
		
					bookingBean.setAuto_id(rSet.getInt("auto_id"));
					bookingBean.setSchedule_id(rSet.getInt("schedule_id"));
					bookingBean.setProfessional_id(rSet.getString("professional_id"));
					bookingBean.setClient_id(rSet.getString("client_id"));
					bookingBean.setDate_booked(rSet.getDate("date_booked"));
					bookingBean.setTime_from(rSet.getString("time_from"));
					bookingBean.setTime_to(rSet.getString("time_to"));
					bookingBean.setProfessional_name(rSet.getString("professional_name"));
					bookingBean.setClient_name(rSet.getString("client_name"));
					bookingBean.setIsConfirmed(rSet.getBoolean("isConfirmed"));
					bookingBean.setRandom_code(rSet.getString("random_code"));
					
				}
			}	
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookingBean;		
	}
	
	
	
	/**
	 * Set Confirmed ==  true;
	 * @param bean [isConfirm and auto_id]
	 * @return integer
	 */
	public int updateQuery(BookingBean bean){
		int numOfRow = 0;
		String updateQuery = "UPDATE  bookingTbl SET isConfirmed= ? , random_code = ? WHERE auto_id = ?";
		try{
		preparedStatement = connection.prepareStatement(updateQuery);
		preparedStatement.setBoolean(1, bean.getIsConfirmed());		
		preparedStatement.setString(2, bean.getRandom_code());
		preparedStatement.setInt(3, bean.getAuto_id());
		numOfRow = dao.update(preparedStatement);
		return numOfRow;
		}catch(Exception e){
			e.printStackTrace();
		}
		return numOfRow;

	}
	
	/**
	 * GET A 1 ROW BOOKINGTABLE  
	 * @param user_id
	 * @return BookingBean
	 */
	public BookingBean selectQuery(int schedule_id){
		BookingBean bookingBean = new BookingBean();
		String selectQuery = "SELECT * FROM bookingTbl WHERE schedule_id = ?";
		try{
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1,schedule_id);
			while(dao.getAll(preparedStatement)!=null){
				rSet = dao.getAll(preparedStatement);
				if(rSet.next()){
					
					bookingBean.setSchedule_id(rSet.getInt("schedule_id"));
					bookingBean.setProfessional_id(rSet.getString("professional_id"));
					bookingBean.setClient_id(rSet.getString("client_id"));
					bookingBean.setIsConfirmed(rSet.getBoolean("isConfirmed"));
					bookingBean.setRandom_code(rSet.getString("random_code"));
					
					return bookingBean;
				}
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookingBean;		
	}
	
	/**
	 * NOT YET USED
	 * DELETE bookings WHICH are expired. date Less than today
	 * @return numOfRow
	 */
	public int deleteQuery(){
		int numOfRow = 0;
		try{
			String deleteQuery = "DELETE FROM bookingtbl  WHERE schedule_id IN(SELECT schedule_id FROM scheduletbl WHERE date_available < CURRENT_DATE )";
			preparedStatement = connection.prepareStatement(deleteQuery);
			numOfRow = dao.delete(preparedStatement);
			return numOfRow;
		}catch(Exception e){e.printStackTrace();}
		return numOfRow;
	}

	/**
	 * USED
	 * DELETE bookings 
	 * @return numOfRow
	 */
	public int deleteQuery(int id){
		int numOfRow = 0;
		try{
			String deleteQuery = "DELETE FROM bookingtbl  WHERE auto_id = ? LIMIT 1";
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, id);
			numOfRow = dao.delete(preparedStatement);
			return numOfRow;
		}catch(Exception e){e.printStackTrace();}
		return numOfRow;
	}	
	
	public int check(BookingBean bkBean) {
		int result = 0 ;
		String selectQuery = "SELECT * FROM bookingTbl WHERE schedule_id = ?";
		try{
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1,bkBean.getSchedule_id());
			
				rSet = dao.get(preparedStatement);
				if(rSet.next()){
					result = 1;
				}
				
		}catch(Exception e){
			e.printStackTrace();
		}
				
		return result;
	}
}
