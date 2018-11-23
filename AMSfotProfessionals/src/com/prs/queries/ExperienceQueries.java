package com.prs.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.prs.Db.DBclass;
import com.prs.dao.Dao;
import com.prs.dao.DaoFactory;
import com.prs.model.PExperienceBean;

public class ExperienceQueries {
	/**
	 * SQL TABLE efuturelk.experiencetbl
	 */
	/**
	 * Singleton Connection
	 */
	private Connection connection  = DBclass.getInstance().getConnection();
	
	/**
	 * Dao Factory to get new Experience Dao
	 * Get CommanDao instance using Dao dao = DaoFactory.getCommanDao()
	 */
	
	//Dao dao = DaoFactory.getExperienceDao();
	Dao dao = DaoFactory.getCommanDao();
	private PreparedStatement preparedStatement = null;
	
	
	/**
	 * This method build and pass the Query to add method in CommanDao implemented by Dao interface to execute
	 * @param experienceBean
	 * @return integer[0 or 1]
	 */
	public int insertQuery(PExperienceBean experienceBean){
		int numOfRow = 0;
		String insertQuery = "INSERT INTO experiencetbl(user_id, aria, place, from_date, to_date)"
				+ "VALUES(?,?,?,?,?)";
		try{
		preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setString(1, experienceBean.getUser_id());
		preparedStatement.setString(2, experienceBean.getAria());
		preparedStatement.setString(3, experienceBean.getPlace());
		preparedStatement.setDate(4, experienceBean.getFrom_date());
		preparedStatement.setDate(5, experienceBean.getTo_date());
		numOfRow = dao.add(preparedStatement);
		return numOfRow;
		}catch(Exception e){
			e.printStackTrace();
		}
		return numOfRow;
	}

	
	/**
	 * This method build and pass the Query to update method in CommanDao implemented by Dao interface to execute
	 * @param experienceBean
	 * @return integer[0 or 1]
	 */
	public int updateQuery(PExperienceBean experienceBean){
		int numOfRow = 0;
		String updateQuery = "UPDATE experiencetbl SET aria = ?, place=?, from_date= ?, to_date=? WHERE user_id = ?";
		try{
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, experienceBean.getAria());
			preparedStatement.setString(2, experienceBean.getPlace());
			preparedStatement.setDate(3, experienceBean.getFrom_date());
			preparedStatement.setDate(4, experienceBean.getTo_date());
			preparedStatement.setString(5, experienceBean.getUser_id());
			numOfRow = dao.update(preparedStatement);
			return numOfRow;
		}catch(Exception e){e.printStackTrace();}
		return numOfRow;
	}
	
	
	/**
	 * This method build and pass the Query to delete method in ExperienceDao implemented by Dao interface to execute
	 * @param user_id
	 * @return integer[0 or 1]
	 */
	public int deleteQuery(String user_id){
		int numOfRow = 0;
		String updateQuery = "DELETE experiencetbl  WHERE user_id = ?";
		try{
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, user_id);
			numOfRow = dao.delete(preparedStatement);
			return numOfRow;
		}catch(Exception e){e.printStackTrace();}
		return numOfRow;
	}	
	
	
	/**
	 * This method build and pass the Query to select method in ExperienceDao implemented by Dao interface to execute
	 * @param user_id
	 * @return PExperienceBean [experiences]
	 */
	public PExperienceBean selectQuery(String user_id){
		ResultSet rSet;
		PExperienceBean experience = new PExperienceBean();
		String selectQuery = "SELECT * FROM experiencetbl WHERE user_id = ?";
		try{
		preparedStatement = connection.prepareStatement(selectQuery);
		preparedStatement.setString(1, user_id);

		
			rSet = dao.get(preparedStatement);
			while(rSet.next()){
				experience.setUser_id(rSet.getString("user_id"));
				experience.setAria(rSet.getString("aria"));
				experience.setPlace(rSet.getString("place"));
				experience.setFrom_date(rSet.getDate("from_date"));
				experience.setTo_date(rSet.getDate("to_date"));
				
				return experience;
			}
			
		}catch(Exception e){e.printStackTrace();}
		
		return experience;
	}


	public int insertQuery(String user_id) {
		int numOfRow = 0;
		String insertQuery = "INSERT INTO experiencetbl(user_id)"
				+ " VALUES(?)";
		try{
		preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setString(1, user_id);
		numOfRow = dao.add(preparedStatement);
		return numOfRow;
		}catch(Exception e){
			e.printStackTrace();
		}
		return numOfRow;
	}
	
}
