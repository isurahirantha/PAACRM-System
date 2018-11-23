package com.prs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * <h1>Main Dao Interface</h1>
 * <p> This can be implemented by other Dao Clasess</p>
 * <p> For CRUD operations</p>
 * @author Isura
 * @param <E>
 */

public interface Dao {

	public int add(PreparedStatement preparedStatement);
	
	public ResultSet getAll(PreparedStatement preparedStatement);
	
	public int update(PreparedStatement preparedStatement);
	
	public int delete(PreparedStatement preparedStatement);
	
	public ResultSet get(PreparedStatement preparedStatement);
	
}
