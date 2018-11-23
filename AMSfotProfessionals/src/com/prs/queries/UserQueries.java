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
import com.prs.model.UserBean;


public class UserQueries {
	/**
	 * SQL TABLE efuturelk.logintbl
	 */
	/**
	 * Singleton Connection
	 */
	private Connection connection = DBclass.getInstance().getConnection();
	
	/**
	 * Dao Factory to get new UserDao
	 *  Get CommanDao instance using Dao dao = DaoFactory.getCommanDao()
	 */
	//Dao dao = DaoFactory.getUserDao();
	Dao dao = DaoFactory.getCommanDao();
	
	private PreparedStatement  preparedStatement=null;
	private ResultSet rSet;
	
	/**
	 * <p>This method build and pass the Query to add method in UserDao implemented by Dao interface to execute</p> 
	 * <p>Executed in UserDao.add(PreparedStatement ps);
	 * @param UserDao
	 * @return numOfRow (integer value)
	 */
	public int insertQuery(UserBean userBean){
		int numOfRow = 0 ; 
		String insertQuery = "INSERT INTO loginTbl(firstname, lastname, email, password, usertype, user_id)"
				+ "VALUES(?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, userBean.getFirstname());
			preparedStatement.setString(2, userBean.getLastname());
			preparedStatement.setString(3, userBean.getEmail());
			preparedStatement.setString(4, userBean.getPassword());
			preparedStatement.setInt(5,userBean.getUsertype());
			preparedStatement.setString(6,userBean.getUser_id());
			numOfRow = dao.add(preparedStatement);
			return numOfRow;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numOfRow;
	}

	
	/**
	 * <p>This method build and pass the Query to select method in UserDao implemented by Dao interface to execute</p> 
	 * <p>Executed in UserDao.get(PreparedStatement);</p>
	 * This is for Update LoginTbl value
	 * @param userBean
	 * @return userBean
	 */
	public UserBean selectQuery(UserBean userBean){
		UserBean user = new UserBean();
		String query = "SELECT user_id, usertype FROM logintbl"
				+ " WHERE email = ? AND password = ? AND usertype = ? ";
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userBean.getEmail());
			preparedStatement.setString(2, userBean.getPassword());
			preparedStatement.setInt(3, userBean.getUsertype());
			
			//System.out.println(preparedStatement);
			
			ResultSet rSet = dao.get(preparedStatement);
			
			if(rSet.first()){
			user.setUser_id(rSet.getString("user_id"));
			user.setUsertype(rSet.getInt("usertype"));
			return user;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}	
	
	/**
	 * Check wether email is exsisted in registering 
	 * @param email
	 * @return Boolean
	 */
	public Boolean selectQuery(String email){
		String query = "SELECT user_id FROM logintbl"
				+ " WHERE email = ? ";
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			
			ResultSet rSet = dao.get(preparedStatement);
			
			if(rSet.next()){
			return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}	
	

	/**
	 * <p>This method build and pass the Query to update method in UserDao implemented by Dao interface to execute</p> 
	 * This is for Update LoginTbl value
	 * There is Update preparedStatement for LoginTbl
	 * Executed in UserDao.update(PreparedStatement);
	 * @param userBean
	 * @return nuOfRow (integer) affected number of row in DB table
	 */
	public int updateQuery(UserBean userBean){
		int numOfRow = 0;
		String updateQuery = "UPDATE logintbl SET firstname=? , lastname=? ,email=? WHERE user_id = ?";
		try{
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, userBean.getFirstname());
			preparedStatement.setString(2,userBean.getLastname());
			preparedStatement.setString(3, userBean.getEmail());
			//preparedStatement.setInt(4, userBean.getGender());
			preparedStatement.setString(4, userBean.getUser_id());
			numOfRow = dao.update(preparedStatement);
			return numOfRow;
		}catch(Exception e){e.printStackTrace();}
		return numOfRow;
	}
	
	/**
	 * <p>This method build and pass the Query to update method in UserDao implemented by Dao interface to execute</p> 
	 * This is for Update LoginTbl value
	 * There is Update preparedStatement for LoginTbl
	 * Executed in UserDao.update(PreparedStatement);
	 * @param userBean
	 * @return nuOfRow (integer) affected number of row in DB table
	 */
	public int adminUpdateQuery(UserBean userBean){
		int numOfRow = 0;
		String updateQuery = "UPDATE logintbl SET firstname=? , lastname=? ,email=? WHERE user_id = ?";
		try{
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, userBean.getFirstname());
			preparedStatement.setString(2,userBean.getLastname());
			preparedStatement.setString(3, userBean.getEmail());
			preparedStatement.setString(4, userBean.getUser_id());
			numOfRow = dao.update(preparedStatement);
			return numOfRow;
		}catch(Exception e){e.printStackTrace();}
		return numOfRow;
	}
	/**
	 * <p>This method build and pass the Query to update method in UserDao implemented by Dao interface to execute</p> 
	 * This is for Update LoginTbl password
	 * @param  email, password [String]
	 * @return nuOfRow (integer) affected number of row in DB table
	 */
	public int updatePasswordQuery(String email, String password){
		int numOfRow = 0;
		String updateQuery = "UPDATE logintbl SET password = ? WHERE email = ?";
		try{
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, email);
			numOfRow = dao.update(preparedStatement);
			return numOfRow;
		}catch(Exception e){e.printStackTrace();}
		return numOfRow;
	}	
	
	/**
	 * <p>This method build and pass the Query to add method in UserDao implemented by Dao interface to execute</p> 
	 * This is for Delete LoginTbl value
	 * There is Update preparedStatement for LoginTbl
	 * Executed in UserDao.update(PreparedStatement);
	 * @param userBean
	 * @return nuOfRow (integer) affected number of row in DB table
	 */
	public int deleteQuery(UserBean userBean){
		return 0;
	}

	/**
	 * To Generate user_id, get the index of last row in the login table 
	 * @return integer(LastuserId)
	 */
	public int getLastUserId() {
	    int LastUserId = 0;
	    String sql = "SELECT auto_id FROM logintbl ORDER BY auto_id DESC LIMIT 1";
	    try {
			preparedStatement = connection.prepareStatement(sql);
		    ResultSet rSet = dao.get(preparedStatement);
		    if(rSet.next()){
		    	LastUserId = rSet.getInt("auto_id");
		    	return LastUserId;
		    }
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    return LastUserId;
	}

	/**
	 * SELECT users realted to professionals
	 * @param ProfessionalBean
	 * @return
	 */
	public UserBean selectQuery(ProfessionalBean pBean){
		
		UserBean userBean = new UserBean();
		String query = "SELECT * FROM logintbl WHERE user_id = ?";
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pBean.getUser_id());
			
			
				rSet = dao.getAll(preparedStatement);
				if(rSet.next()){
					
					userBean.setAuto_id(rSet.getInt("auto_id"));
					userBean.setFirstname(rSet.getString("firstname"));
					userBean.setLastname(rSet.getString("lastname"));
					userBean.setEmail(rSet.getString("email"));
					userBean.setUser_id(rSet.getString("user_id"));
					return userBean;
				}
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return userBean;
	}
	
	public UserBean selectquery(String user_id){
		
		UserBean userBean = new UserBean();
		String query = "SELECT * FROM logintbl WHERE user_id = ?";
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user_id);
			
			
				rSet = dao.getAll(preparedStatement);
				if(rSet.next()){
					
					userBean.setAuto_id(rSet.getInt("auto_id"));
					userBean.setFirstname(rSet.getString("firstname"));
					userBean.setLastname(rSet.getString("lastname"));
					userBean.setEmail(rSet.getString("email"));
					userBean.setUser_id(rSet.getString("user_id"));
					return userBean;
				}
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return userBean;
	}
	
}
