//auto_id	user_id	title	institute	duedate
package com.prs.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.prs.Db.DBclass;
import com.prs.dao.Dao;
import com.prs.dao.DaoFactory;
import com.prs.model.AchievmentBean;


public class AchievmentQueries {
	/**
	 * SQL TABLE efuturelk.achievmentstbl
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
	
	public int insertQuery(AchievmentBean achievmentBean){
		int numOfRow = 0;
		String insertQuery = "INSERT INTO achievmentstbl("
				+ "user_id, title, institute, duedate)"
				+ "VALUES(?,?,?,?)";
		try{
		preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setString(1, achievmentBean.getUser_id());
		preparedStatement.setString(2, achievmentBean.getTitle());
		preparedStatement.setString(3, achievmentBean.getInstitute());
		preparedStatement.setDate(4,achievmentBean.getDuedate());
		numOfRow = dao.add(preparedStatement);
		return numOfRow;
		}catch(Exception e){
			e.printStackTrace();
		}
		return numOfRow;
	}
	
	public List<AchievmentBean> selectQuery(AchievmentBean achievmentBean){
		List<AchievmentBean> achievments = new ArrayList<AchievmentBean>();
		String selectQuery = "SELECT * FROM achievmentstbl WHERE user_id = ?";
		try{
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1,achievmentBean.getUser_id());
			if(dao.getAll(preparedStatement)!=null){
				rSet = dao.getAll(preparedStatement);
				while(rSet.next()){
					AchievmentBean achievment = new AchievmentBean();
					achievment.setUser_id(rSet.getString("user_id"));
					achievment.setTitle(rSet.getString("title"));
					achievment.setInstitute(rSet.getString("institute"));
					achievment.setDuedate(rSet.getDate("duedate"));
					achievments.add(achievment);
					return achievments;
				}
			}	
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return achievments;
	}

	public AchievmentBean selectQuery(String user_id){
		AchievmentBean achievment = new AchievmentBean();
		String selectQuery = "SELECT * FROM achievmentstbl WHERE user_id = ?";
		try{
			preparedStatement = connection.prepareStatement(selectQuery);
			preparedStatement.setString(1,user_id);
			
				rSet = dao.getAll(preparedStatement);
				while(rSet.next()){
				
					achievment.setUser_id(rSet.getString("user_id"));
					achievment.setTitle(rSet.getString("title"));
					achievment.setInstitute(rSet.getString("institute"));
					achievment.setDuedate(rSet.getDate("duedate"));	
					return achievment;
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		return achievment;
	}	
	
	public int updateQuery(AchievmentBean achievmentBean){
		int numOfRow = 0;
		String updateQuery = "UPDATE achievmentstbl SET title = ? , institute = ? , duedate = ? WHERE user_id = ?";
				
		try{
		preparedStatement = connection.prepareStatement(updateQuery);
		
		preparedStatement.setString(1, achievmentBean.getTitle());
		preparedStatement.setString(2, achievmentBean.getInstitute());
		preparedStatement.setDate(3, achievmentBean.getDuedate());
		preparedStatement.setString(4, achievmentBean.getUser_id());
		numOfRow = dao.update(preparedStatement);
		return numOfRow;
		}catch(Exception e){
			e.printStackTrace();
		}
		return numOfRow;
	}
	
	public int deleteQuery(){
		return 0;
	}
	
	/**
	 * When Login
	 * @param user_id
	 * @return
	 */
	public int insertQuery(String user_id) {
		int numOfRow = 0;
		String insertQuery = "INSERT INTO achievmentstbl(user_id)"
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
