package com.prs.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.prs.Db.DBclass;
import com.prs.dao.Dao;
import com.prs.dao.DaoFactory;
import com.prs.model.EducationBean;


public class EducationQueries {
	/**
	 * SQL TABLE efuturelk.university
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
	private ResultSet rSet;
	
	public int insertQuery(String user_id) {
		int numOfRow = 0;
		String insertQuery = "INSERT INTO university(user_id)"
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
	
	public int updateQuery(EducationBean edBean){
		int numOfRow = 0;
		String updateQuery = "UPDATE university SET name = ? , degree = ? , from_date = ?, to_date = ? WHERE user_id = ?";
				
		try{
		preparedStatement = connection.prepareStatement(updateQuery);
		
		preparedStatement.setString(1, edBean.getName());
		preparedStatement.setString(2, edBean.getDegree());
		preparedStatement.setDate(3, edBean.getFromTime());
		preparedStatement.setDate(4, edBean.getToTime());
		preparedStatement.setString(5, edBean.getUser_id());
		numOfRow = dao.update(preparedStatement);
		return numOfRow;
		}catch(Exception e){
			e.printStackTrace();
		}
		return numOfRow;
	}

	public EducationBean selectQuery(String user_id) {
		EducationBean edBean = new EducationBean();
		String selectQuery = "SELECT * FROM university WHERE user_id = ?";
		try{
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1, user_id);
			
			rSet = dao.get(preparedStatement);
			while(rSet.next()){
				edBean.setAuto_id(rSet.getInt("auto_id"));
				edBean.setDegree(rSet.getString("degree"));
				edBean.setName(rSet.getString("name"));
				edBean.setFromTime(rSet.getDate("from_date"));
				edBean.setToTime(rSet.getDate("to_date"));
				edBean.setUser_id(rSet.getString("user_id"));
				return edBean;
			}
			
		}catch(Exception e){e.printStackTrace();}
		return edBean;
	}
}
