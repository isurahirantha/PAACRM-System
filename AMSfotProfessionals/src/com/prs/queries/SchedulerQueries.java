/**
 * 
 */
package com.prs.queries;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.prs.Db.DBclass;
import com.prs.dao.Dao;
import com.prs.dao.DaoFactory;
import com.prs.model.SchedulerBean;

/**
 * @author Isura
 *
 */
public class SchedulerQueries {
	/**
	 * SQL TABLE efuturelk.scheduletbl
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
	 * @param schedulerBean
	 * @return integer[0 or 1]
	 */
	public int insertQuery(SchedulerBean schedulerBean){
		int numOfRow = 0;
		String insertQuery = "INSERT INTO scheduletbl("
				+ "user_id, date_available, cur_day, cur_month, cur_year, time_from, time_to, just_call_me, seats)"
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		try{
		preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setString(1, schedulerBean.getUser_id());
		preparedStatement.setDate(2, schedulerBean.getDate_available());
		preparedStatement.setInt(3, schedulerBean.getDay());
		preparedStatement.setInt(4, schedulerBean.getMonth());
		preparedStatement.setInt(5, schedulerBean.getYear());
		preparedStatement.setString(6, schedulerBean.getTime_from());
		preparedStatement.setString(7, schedulerBean.getTime_to());
		preparedStatement.setInt(8, schedulerBean.getJust_call_me());
		preparedStatement.setInt(9, schedulerBean.getSeats());
		numOfRow = dao.add(preparedStatement);
		return numOfRow;
		}catch(Exception e){
			e.printStackTrace();
		}
		return numOfRow;
	}	
	
	/**
	 * SELECT Schedules by user_id AND cur_month AND cur_year ORDER BY cur_day Ascending
	 * This method build and pass the Query to getAll method in CommanDao implemented by Dao interface to execute
	 * @param schedulerBean
	 * @return List<SchedulerBean>
	 */
	public List<SchedulerBean> selectQuery(SchedulerBean schedulerBean){
		
		List<SchedulerBean> schedules = new ArrayList<SchedulerBean>();
		String selectQuery = "SELECT * FROM scheduletbl WHERE user_id = ? AND cur_month=? AND cur_year = ? ORDER BY cur_day ASC";
		try{
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1,schedulerBean.getUser_id());
			preparedStatement.setInt(2,schedulerBean.getMonth());
			preparedStatement.setInt(3, schedulerBean.getYear());
			
			if(dao.getAll(preparedStatement)!=null){
				rSet = dao.get(preparedStatement);
				while(rSet.next()){
					SchedulerBean returnSchedulerBean = new SchedulerBean();
					returnSchedulerBean.setId(rSet.getInt("auto_id"));
					returnSchedulerBean.setUser_id(rSet.getString("user_id"));
					returnSchedulerBean.setDate_available(rSet.getDate("date_available"));
					returnSchedulerBean.setDay(rSet.getInt("cur_day"));
					returnSchedulerBean.setMonth(rSet.getInt("cur_month"));
					returnSchedulerBean.setYear(rSet.getInt("cur_year"));
					returnSchedulerBean.setTime_from(rSet.getString("time_from"));
					returnSchedulerBean.setTime_to(rSet.getString("time_to"));
					returnSchedulerBean.setJust_call_me(rSet.getInt("just_call_me"));
					returnSchedulerBean.setSeats(rSet.getInt("seats"));
					schedules.add(returnSchedulerBean);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return schedules;
	}
	
public SchedulerBean selectQuery(int auto_id){
		
		SchedulerBean schedule= new SchedulerBean();
		String selectQuery = "SELECT * FROM scheduletbl WHERE auto_id = ?";
		try{
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setInt(1, auto_id);
			
			
			if(dao.getAll(preparedStatement)!=null){
				rSet = dao.get(preparedStatement);
				while(rSet.next()){
					schedule.setId(rSet.getInt("auto_id"));
					schedule.setUser_id(rSet.getString("user_id"));
					schedule.setDate_available(rSet.getDate("date_available"));
					schedule.setDay(rSet.getInt("cur_day"));
					schedule.setMonth(rSet.getInt("cur_month"));
					schedule.setYear(rSet.getInt("cur_year"));
					schedule.setTime_from(rSet.getString("time_from"));
					schedule.setTime_to(rSet.getString("time_to"));
					schedule.setJust_call_me(rSet.getInt("just_call_me"));
					schedule.setSeats(rSet.getInt("seats"));
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return schedule;
	}
	
	/**
	 * UPDATE Schedule by id and user_id
	 * This method build and pass the Query to update method in CommanDao implemented by Dao interface to execute
	 * @param schedulerBean
	 * @return integer
	 */
	public int updateQuery(SchedulerBean schedulerBean){
		int numOfRow = 0;
		String updateQuery = "UPDATE  scheduletbl SET  cur_day = ? , cur_month = ? , cur_year = ? , time_from = ?,"
		+ " time_to = ?, just_call_me = ?, seats = ? WHERE date_available = ? AND user_id = ?";
		try{
		preparedStatement = connection.prepareStatement(updateQuery);
		preparedStatement.setInt(1, schedulerBean.getDay());
		preparedStatement.setInt(2, schedulerBean.getMonth());
		preparedStatement.setInt(3, schedulerBean.getYear());
		preparedStatement.setString(4, schedulerBean.getTime_from());
		preparedStatement.setString(5, schedulerBean.getTime_to());
		preparedStatement.setInt(6, schedulerBean.getJust_call_me());
		preparedStatement.setInt(7, schedulerBean.getSeats());
		preparedStatement.setDate(8, schedulerBean.getDate_available());
		preparedStatement.setString(9, schedulerBean.getUser_id());
		
		numOfRow = dao.update(preparedStatement);
		return numOfRow;
		}catch(Exception e){
			e.printStackTrace();
		}
		return numOfRow;
	}	
	
	/**
	 * DELETE Schedule by id and user_id
	 * This method build and pass the Query to delete method in CommanDao implemented by Dao interface to execute
	 * @param schedulerBean
	 * @return integer
	 */
	public int deleteQuery(int auto_id){
		int numOfRow = 0;
		String deleteQuery = "DELETE FROM scheduletbl WHERE auto_id = ? LIMIT 1";
		try{
		preparedStatement = connection.prepareStatement(deleteQuery);
		
		preparedStatement.setInt(1, auto_id);

		
		numOfRow = dao.delete(preparedStatement);
		return numOfRow;
		}catch(Exception e){
			e.printStackTrace();
		}
		return numOfRow;
	}

	/**
	 * IF RETURN true THEN THAT DAY FOR THAT PROFESSIONAL IS ALREADY SCHEDULED BY HIM.
	 * @param sBean
	 * @return Boolean
	 */
	public Boolean checkAvailability(SchedulerBean sBean) {
		String query = "SELECT * FROM scheduletbl WHERE user_id = ? AND date_available = ?";
		//String query = "SELECT * FROM scheduletbl WHERE  AND auto_id = ?";
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,sBean.getUser_id());
			preparedStatement.setDate(2,sBean.getDate_available());
			//preparedStatement.setInt(1, sBean.getId());
			
			ResultSet rSet = dao.get(preparedStatement);
			
			if(rSet.next()){
			return true;
			}else{
				return false;
			}
			}catch(Exception e){
				e.printStackTrace();	
			}
		return false;
	}
	
	/**
	 * NOT YET USED
	 * DELETE scheduletbl WHICH are expired. date Less than today
	 * @return numOfRow
	 */
	public int deleteQuery(){
		int numOfRow = 0;
		try{
			String deleteQuery = "DELETE FROM scheduletbl  WHERE date_available < CURRENT_DATE  ";
			preparedStatement = connection.prepareStatement(deleteQuery);
			numOfRow = dao.delete(preparedStatement);
			return numOfRow;
		}catch(Exception e){e.printStackTrace();}
		return numOfRow;
	}
}
