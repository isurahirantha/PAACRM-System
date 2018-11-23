/**
 * 
 */
package com.prs.dao;

/**
 * @author Isura
 * 
 * <p>This Dao Factory Produces <b>Data Access Objects</b> and return them</p>
 * 
 */
public class DaoFactory {

	public static Dao getCommanDao(){
		return new CommanDao();
	}
	
}
