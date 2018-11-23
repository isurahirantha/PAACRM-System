package com.prs.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.prs.Db.DBclass;
import com.prs.dao.Dao;
import com.prs.dao.DaoFactory;
import com.prs.model.MsgBean;

public class MsgQueries {

	/**
	 * SQL TABLE efuturelk.chattble
	 */
	/*
	 * singleton connection
	 */
	private Connection connection = DBclass.getInstance().getConnection();
	private PreparedStatement preparedStatement;

	/**
	 * Dao Factory to get new Msg Dao
	 * Get CommanDao instance using Dao dao = DaoFactory.getCommanDao()
	 */
	//Dao dao = DaoFactory.getMsgDao();
	Dao dao = DaoFactory.getCommanDao();
	/**
	 * This method build and pass the Query to add method in MsgDao implemented by Dao interface to execute
	 * @param MsgBean
	 * @return integer[0 or 1]
	 */
	public int insertQuery(MsgBean msgBean){
		int numOfRow = 0;
		String insertQuery = "INSERT INTO chattble(professional_id, client_id, message, isClient, date_msg, time_msg)"
				+ "VALUES(?,?,?,?,?,?)";
		try{
		preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setString(1, msgBean.getProfessional_id());
		preparedStatement.setString(2, msgBean.getClient_id());
		preparedStatement.setString(3, msgBean.getMessage());
		preparedStatement.setBoolean(4, msgBean.getisClient());
		preparedStatement.setDate(5, msgBean.getDate_msg());
		preparedStatement.setString(6, msgBean.getTime_msg());

		numOfRow = dao.add(preparedStatement);
		return numOfRow;
		}catch(Exception e){
			e.printStackTrace();
		}
		return numOfRow;
	}

	
	/**
	 * This method build and pass the Query to select method in MsgDao implemented by Dao interface to execute
	 * @param professional_id, client_id
	 * @return List [msges]
	 */
	public List<MsgBean> selectQuery(String professional_id,String client_id){
		ResultSet rSet;
		List <MsgBean> msges = new ArrayList<MsgBean>();
		
		String selectQuery = "SELECT * FROM chattble WHERE professional_id = ? AND client_id = ? ORDER BY auto_id DESC";
		try{
		preparedStatement = connection.prepareStatement(selectQuery);
		preparedStatement.setString(1, professional_id);
		preparedStatement.setString(2, client_id);

		if(dao.getAll(preparedStatement)!=null){
			rSet = dao.getAll(preparedStatement);
			while(rSet.next()){
				MsgBean msg = new MsgBean();
				msg.setAuto_id(rSet.getInt("auto_id"));
				msg.setProfessional_id(rSet.getString("professional_id"));
				msg.setClient_id(rSet.getString("client_id"));
				msg.setMessage(rSet.getString("message"));
				msg.setisClient(rSet.getBoolean("isClient"));
				msg.setDate_msg(rSet.getDate("date_msg"));
				msg.setTime_msg(rSet.getString("time_msg"));
				msges.add(msg);
			}
		}	
		}catch(Exception e){e.printStackTrace();}
		
		return msges;
	}

	/**
	 * This method build and pass the Query to update method in MsgDao implemented by Dao interface to execute
	 * Set messages to red == true
	 * if isClient true == old message, else new message
	 * @param auto_id [chattble]
	 * @return integer[0 or 1]
	 */
	public int updateQuery(int auto_id){
		int numOfRow = 0;
		String updateQuery = "UPDATE chattble SET isClient = ? WHERE auto_id = ?";
		try{
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setBoolean(1, true);
			preparedStatement.setInt(2, auto_id);
			numOfRow = dao.update(preparedStatement);
			return numOfRow;
		}catch(Exception e){e.printStackTrace();}
		return numOfRow;
	}	
	
	
	
}
