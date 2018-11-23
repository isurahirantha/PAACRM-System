package com.prs.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.prs.Db.DBclass;
import com.prs.dao.Dao;
import com.prs.dao.DaoFactory;
import com.prs.model.TrackingBean;

public class TrackerQueries {

	/**
	 * SQL TABLE efuturelk.tracker
	 */
	/*
	 * singleton connection
	 */
	DBclass dBclass =DBclass.getInstance();
	private Connection connection = dBclass.getConnection();
	private PreparedStatement preparedStatement=null;
	
	/**
	 * Factory Pattern + Dao Pattern = DaoFactory
	 * Get CommanDao instance using Dao dao = DaoFactory.getCommanDao()
	 */
	//Dao dao = DaoFactory.getTrackerDao(); 
	Dao dao = DaoFactory.getCommanDao();
	/**
	 * This method build and pass the Query to add method in TrackerDao implemented by Dao interface to execute
	 * @param trackingBean
	 * @return integer[0 or 1]
	 */
	public int insertQuery(TrackingBean trackingBean){
		int numOfRow = 0;
		String insertQuery = "INSERT INTO tracker(user_id, ip, log_time, log_date)"
				+ "VALUES(?,?,?,?)";
		try{
		preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setString(1, trackingBean.getUser_id());
		preparedStatement.setString(2, trackingBean.getIp());
		preparedStatement.setTime(3, trackingBean.getLog_time());
		preparedStatement.setDate(4, trackingBean.getLog_date());

		numOfRow = dao.add(preparedStatement);
		return numOfRow;
		}catch(Exception e){
			e.printStackTrace();
		}
		return numOfRow;
	}	
	
	/**
	 * This method build and pass the Query to select method in ExperienceDao implemented by Dao interface to execute
	 * @param user_id
	 * @return List [experiences]
	 */
	public List<TrackingBean> selectQuery(){
		ResultSet rSet;
		List <TrackingBean> logs = new ArrayList<TrackingBean>();
		
		String selectQuery = "SELECT * FROM tracker ORDER BY auto_id ASC";
		try{
		preparedStatement = connection.prepareStatement(selectQuery);
		

		if(dao.getAll(preparedStatement)!=null){
			rSet = dao.get(preparedStatement);
			while(rSet.next()){
				TrackingBean log = new TrackingBean();
				log.setAuto_id(rSet.getInt("auto_id"));
				log.setUser_id(rSet.getString("user_id"));
				log.setIp(rSet.getString("ip"));
				log.setLog_time(rSet.getTime("log_time"));
				log.setLog_date(rSet.getDate("log_date"));
				logs.add(log);
			}
		}	
		}catch(Exception e){e.printStackTrace();}
		
		return logs;
	}	
	
}
