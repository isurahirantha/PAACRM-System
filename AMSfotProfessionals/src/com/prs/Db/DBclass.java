package com.prs.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBclass implements MysqlProperties{

	private static DBclass dBclass;
	
	private Connection connection;
		private DBclass()
		{
		}//DBclass constructor
		
		
		
		public synchronized Connection getConnection(){
			
			try {
				Class.forName(DRIVER);
				connection = DriverManager.getConnection(URL,USER,PASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return connection;
		}
		
		public static synchronized DBclass getInstance() //step 1
		  {
		    if(dBclass == null)
		    {
		      return new DBclass();
		    } 
		    else    
		    {
		      return dBclass;
		    }
		  }	
	
}
