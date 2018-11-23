package com.prs.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.prs.Db.DBclass;
import com.prs.dao.Dao;
import com.prs.dao.DaoFactory;
import com.prs.model.ImageBean;

public class ImageQueries {
	/**
	 * SQL TABLE efuturelk.imagetbl
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
	
	public int updateQuery(ImageBean imageBean){
        int numOfRow = 0;
		try {
            String query = "UPDATE imagetbl SET filename = ?, pathname = ? WHERE user_id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, imageBean.getFilename());
            preparedStatement.setString(2, imageBean.getPathname());
            preparedStatement.setString(3, imageBean.getUser_id());

            numOfRow = dao.update(preparedStatement);
            return numOfRow;
        } catch (Exception e) {
            e.printStackTrace();
        }		
		return numOfRow;
	}
	/**
	 * USED BY <IMG> TAG
	 * SELECT THE IMAGE PATH TO SHOW
	 * @param user_id
	 * @return
	 */
	public String selectQuery(String user_id){
		String user_image = null;
		String query = "SELECT filename FROM imagetbl WHERE	user_id = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_id);
			rSet = dao.get(preparedStatement);
			if(rSet.next()){
				user_image = rSet.getString("filename");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user_image;
	}
	
	public int insertQuery(String user_id) {
		int numOfRow = 0;
		String insertQuery = "INSERT INTO imagetbl(user_id)"
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
