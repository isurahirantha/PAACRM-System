/**
 * 
 */
package com.prs.Db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Isura
 *
 */
public class TestDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBclass dBclass = DBclass.getInstance();
		Connection connection =null;
		try {
			connection = dBclass.getConnection();
			System.out.println(connection.toString());
			connection.close();
			System.out.println("Connection closed: "+connection.isClosed());
			connection = dBclass.getConnection();
			System.out.println(connection.toString());
			connection.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
