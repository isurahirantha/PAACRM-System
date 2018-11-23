package com.prs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommanDao implements Dao{

	@Override
	public int add(PreparedStatement preparedStatement) {
		int numOfRows= 0;
		try
		{
		numOfRows = preparedStatement.executeUpdate();
		return numOfRows;
		
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		return numOfRows;
	}

	@Override
	public ResultSet getAll(PreparedStatement preparedStatement) {
		ResultSet rSet = null;
		try
		{
		rSet = preparedStatement.executeQuery();
		return rSet;
		
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		return rSet;
	}

	@Override
	public int update(PreparedStatement preparedStatement) {
		int numOfRows= 0;
		try
		{
		numOfRows = preparedStatement.executeUpdate();
		return numOfRows;
		
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		return numOfRows;
	}

	@Override
	public int delete(PreparedStatement preparedStatement) {
		int numOfRows= 0;
		try
		{
		numOfRows = preparedStatement.executeUpdate();
		return numOfRows;
		
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		return numOfRows;
	}

	@Override
	public ResultSet get(PreparedStatement preparedStatement) {
		ResultSet rSet = null;
		try
		{
		rSet = preparedStatement.executeQuery();
		return rSet;
		
		}catch(SQLException exception){
			exception.printStackTrace();
		}
		return rSet;
	}

}
