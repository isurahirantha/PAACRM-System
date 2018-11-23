package com.prs.queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.prs.Db.DBclass;
import com.prs.dao.Dao;
import com.prs.dao.DaoFactory;
import com.prs.model.RatingBean;

public class RateQueries {
	/**
	 * SQL TABLE efuturelk.ratingstbl
	 */
	/**
	 * Singleton Connection
	 */
	private Connection connection  = DBclass.getInstance().getConnection();
	
	/**
	 * Get CommanDao instance using Dao dao = DaoFactory.getCommanDao()
	 */
	//Dao dao = DaoFactory.getRateDao();
	Dao dao = DaoFactory.getCommanDao();
	
	private PreparedStatement preparedStatement = null;
	
	/**
	 * This method build and pass the Query to add method in RateDao implemented by Dao interface to execute
	 * @param ratingBean
	 * @return integer[0 or 1]
	 */
	public int insertQuery(RatingBean ratingBean){
		int numOfRow = 0;
		String insertQuery = "INSERT INTO ratingstbl(client_id, buyer_name, professional_id, stars, review)"
				+ "VALUES(?,?,?,?,?)";
		try{
		preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setString(1, ratingBean.getBuyer_id());
		preparedStatement.setString(2, ratingBean.getBuyer_name());
		preparedStatement.setString(3, ratingBean.getProfessionals_id());
		preparedStatement.setInt(4, ratingBean.getRate());
		preparedStatement.setString(5, ratingBean.getReview());
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
	public List<RatingBean> selectQuery(String professional_id){
		ResultSet rSet;
		List <RatingBean> rates = new ArrayList<RatingBean>();
		
		String selectQuery = "SELECT * FROM ratingstbl WHERE professional_id = ?";
		try{
		preparedStatement = connection.prepareStatement(selectQuery);
		preparedStatement.setString(1, professional_id);

		if(dao.getAll(preparedStatement)!=null){
			rSet = dao.get(preparedStatement);
			while(rSet.next()){
				RatingBean rate = new RatingBean();
				rate.setAuto_id(rSet.getInt("auto_id"));
				rate.setBuyer_id(rSet.getString("client_id"));
				rate.setProfessionals_id(rSet.getString("professional_id"));
				rate.setBuyer_name(rSet.getString("buyer_name"));
				rate.setRate(rSet.getInt("stars"));
				rate.setReview(rSet.getString("review"));
				rates.add(rate);
			}
		}	
		}catch(Exception e){e.printStackTrace();}
		
		return rates;
	}	
}
