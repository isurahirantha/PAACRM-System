package com.prs.queries;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.prs.Db.DBclass;
import com.prs.dao.Dao;
import com.prs.dao.DaoFactory;
import com.prs.model.ClientBean;


public class ClientQueries {
	/**
	 * SQL TABLE efuturelk.clientstbl
	 */
	/*
	 * singleton connection
	 */
	private Connection connection = DBclass.getInstance().getConnection();
	private PreparedStatement preparedStatement;
	private ResultSet rSet;
	/**
	 * Factory Pattern + Dao Pattern = DaoFactory
	 * Get CommanDao instance using Dao dao = DaoFactory.getCommanDao()
	 */
		//Dao dao = DaoFactory.getClientDao();
		Dao dao = DaoFactory.getCommanDao();
	
	/**
	 * <p>Insert Client</p>
	 * called inside register
	 * @param clientBean
	 * @return integer of number of rows affected
	 */
	public int insertQuery(ClientBean clientBean){
		
		int numOfRow = 0;
		try
		{
		String insertQuery = "INSERT INTO clientstbl (user_id)"
				+ " VALUES(?)";
		preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setString(1, clientBean.getUser_id());
		//Execute the preparedStatment using ClientDao.add();
		numOfRow = dao.add(preparedStatement);
		
		return numOfRow;
		
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return numOfRow;
	}
	
	/**
	 * Update Clients Query using autoID
	 * @param clientBean
	 * @return numOfRow (integer of rows affected)
	 */
	public int updateQuey(ClientBean clientBean){
		int numOfRow = 0;
		try{
		String updateQuery ="UPDATE clientstbl SET phone = ?, address = ? WHERE user_id = ? ";
		preparedStatement = connection.prepareStatement(updateQuery);
		preparedStatement.setString(1, clientBean.getPhone());
		preparedStatement.setString(2, clientBean.getAddress());
		preparedStatement.setString(3, clientBean.getUser_id());
		
		//Execute the preparedStatment using ClientDao.update();
		numOfRow = dao.update(preparedStatement);
		return numOfRow;
		
		}catch(SQLException sqlException){
			sqlException.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return numOfRow;
	}

	public ClientBean selectQuery(String user_id) {
		ClientBean cBean = new ClientBean();
		try{
			String sql = "SELECT * FROM clientstbl WHERE user_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user_id);
			rSet = dao.getAll(preparedStatement);
			if(rSet.next()){
				cBean.setauto_id(rSet.getInt("auto_id"));
				cBean.setUser_id(rSet.getString("user_id"));
				cBean.setPhone(rSet.getString("phone"));
				cBean.setAddress(rSet.getString("address"));
			}
		}catch(Exception e){e.printStackTrace();}
		// TODO Auto-generated method stub
		return cBean;
	}
	
}
