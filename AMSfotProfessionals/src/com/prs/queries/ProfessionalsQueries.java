/**
 * 
 */
package com.prs.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.prs.Db.DBclass;
import com.prs.dao.Dao;
import com.prs.dao.DaoFactory;
import com.prs.model.ProfessionalBean;

/**
 * @author Isura Hirantha
 *
 */
public class ProfessionalsQueries {
	/**
	 * SQL TABLE efuturelk.about_professiontbl
	 */
	/*
	 * singleton connection
	 */
	DBclass dBclass = DBclass.getInstance();
	private Connection connection = dBclass.getConnection();
	
	private PreparedStatement preparedStatement;
	private ResultSet rSet;
	/**
	 * Factory Pattern + Dao Pattern = DaoFactory
	 * Get ProfessionalsDao instance using DaoFactory.getProfessionalsDao();
	 * Get CommanDao instance using Dao dao = DaoFactory.getCommanDao()
	 */
		//Dao dao = DaoFactory.getProfessionalsDao();
	Dao dao = DaoFactory.getCommanDao();
	/**
	 * <p>Insert Professional(Register)</p> 
	 * <p>Executed in ProfessionalDao.add(PreparedStatement);
	 * @param professionalBean
	 * @return numOfRow (integer value)
	 */

	public int insertQuery(ProfessionalBean professionalBean){
		int numOfRow = 0; 
		try
		{
		String insertQuery = "INSERT INTO about_professiontbl (user_id, firstname, lastname)"
				+ "VALUES(?,?,?)";
		preparedStatement = connection.prepareStatement(insertQuery);
		//session user_id
		preparedStatement.setString(1, professionalBean.getUser_id());
		preparedStatement.setString(2, professionalBean.getFirstname());
		preparedStatement.setString(3, professionalBean.getLastname());
		//Execute the preparedStatment using ProfessionalDao.add();
		numOfRow=dao.add(preparedStatement);
		return numOfRow;
		
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return numOfRow;
	}	
/*	public int insertQuery(ProfessionalBean professionalBean){
		int numOfRow = 0; 
		try
		{
		String insertQuery = "INSERT INTO about_professiontbl (user_id, profession, specify, other_info, tags, headline, company, address, phone, firstname,lastname)"
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		preparedStatement = connection.prepareStatement(insertQuery);
		//session user_id
		preparedStatement.setString(1, professionalBean.getUser_id());
		preparedStatement.setString(2, professionalBean.getProfession());
		preparedStatement.setString(3, professionalBean.getSpecify());
		preparedStatement.setString(4, professionalBean.getOther_info());
		preparedStatement.setString(5, professionalBean.getTags());
		preparedStatement.setString(6, professionalBean.getHeadLine());
		preparedStatement.setString(7, professionalBean.getCompany());
		preparedStatement.setString(8, professionalBean.getAddress());
		preparedStatement.setString(9, professionalBean.getPhone());
		preparedStatement.setString(10, professionalBean.getFirstname());
		preparedStatement.setString(11, professionalBean.getLastname());
		//Execute the preparedStatment using ProfessionalDao.add();
		numOfRow=dao.add(preparedStatement);
		return numOfRow;
		
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return numOfRow;
	}
*/	

	
	/**
	 * This is for Update professionalsTbl
	 * There is Update preparedStatement for professionalsTbl
	 * Executed in ProfessionlDao.update(PreparedStatement);
	 * @param professionalBean
	 * @return nuOfRow (integer) affected number of row in DB table
	 */
	public int updateQuery(ProfessionalBean professionalBean){
		int numOfRow = 0;
		String updateQuery = "UPDATE about_professiontbl SET  profession = ? , specify = ? , other_info = ? , tags= ? , headline = ? , "
				+ " company = ? , address = ? , phone= ? , firstname= ? , lastname= ? WHERE user_id = ?";
		try{
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, professionalBean.getProfession());
			preparedStatement.setString(2, professionalBean.getSpecify());
			preparedStatement.setString(3, professionalBean.getOther_info());
			preparedStatement.setString(4, professionalBean.getTags());
			preparedStatement.setString(5, professionalBean.getHeadLine());
			preparedStatement.setString(6, professionalBean.getCompany());
			preparedStatement.setString(7, professionalBean.getAddress());
			preparedStatement.setString(8, professionalBean.getPhone());
			preparedStatement.setString(9, professionalBean.getFirstname());
			preparedStatement.setString(10, professionalBean.getLastname());
			preparedStatement.setString(11, professionalBean.getUser_id());
			numOfRow = dao.update(preparedStatement);
			return numOfRow;
		}catch(Exception e){e.printStackTrace();}
		return numOfRow;
	}
	
	public List<ProfessionalBean> selectQuery(String district, String profession){
		List<ProfessionalBean> pBeans = new ArrayList<ProfessionalBean>();
		
		String query = "SELECT * FROM about_professiontbl WHERE address LIKE ? AND profession LIKE ?";
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "%" + district + "%");
			preparedStatement.setString(2, "%" + profession + "%");
			//preparedStatement.setString(3, "%" + profession + "%");
			if(dao.getAll(preparedStatement)!=null){
				rSet = dao.getAll(preparedStatement);
				while(rSet.next()){
					ProfessionalBean professionalBean = new ProfessionalBean();
					professionalBean.setAuto_id(rSet.getInt("auto_id"));
					professionalBean.setUser_id(rSet.getString("user_id"));
					professionalBean.setProfession(rSet.getString("profession"));
					professionalBean.setSpecify(rSet.getString("specify"));
					professionalBean.setOther_info(rSet.getString("other_info"));
					professionalBean.setTags(rSet.getString("tags"));
					professionalBean.setHeadLine(rSet.getString("headLine"));
					professionalBean.setCompany(rSet.getString("company"));
					professionalBean.setAddress(rSet.getString("address"));
					professionalBean.setPhone(rSet.getString("phone"));
					professionalBean.setFirstname(rSet.getString("firstname"));
					professionalBean.setLastname(rSet.getString("lastname"));
					pBeans.add(professionalBean);
				}
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		return pBeans;
	}
	
	public ProfessionalBean selectQuery(String user_id){
		
		ProfessionalBean professionalBean = new ProfessionalBean();
		String query = "SELECT * FROM about_professiontbl WHERE user_id = ? ";
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_id);
			
				rSet = dao.getAll(preparedStatement);
				if(rSet.next()){
					
					professionalBean.setAuto_id(rSet.getInt("auto_id"));
					professionalBean.setUser_id(rSet.getString("user_id"));
					professionalBean.setProfession(rSet.getString("profession"));
					professionalBean.setSpecify(rSet.getString("specify"));
					professionalBean.setOther_info(rSet.getString("other_info"));
					professionalBean.setTags(rSet.getString("tags"));
					professionalBean.setHeadLine(rSet.getString("headLine"));
					professionalBean.setCompany(rSet.getString("company"));
					professionalBean.setAddress(rSet.getString("address"));
					professionalBean.setPhone(rSet.getString("phone"));
					professionalBean.setFirstname(rSet.getString("firstname"));
					professionalBean.setLastname(rSet.getString("lastname"));
					
					return professionalBean;
				}
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return professionalBean;
	}
	
	
}
