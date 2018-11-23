/**
 * 
 */
package com.prs.utils;

import java.util.ArrayList;
import java.util.List;

import com.prs.dao.QueryFactory;
import com.prs.model.BookingBean;
import com.prs.model.MsgBean;
import com.prs.model.ProfessionalBean;
import com.prs.model.SchedulerBean;

/**
 * @author Isura
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String email = "isurahirantha@gmail.com";
		String password = "87654321";
		int r =0; //0=false | 1 == true
		r = QueryFactory.getUserQueries().updatePasswordQuery(email,password);
		System.out.println(r);
		System.out.println("END of Test Case for login");
		
		// Test Case for User ID Generation , 0==client | 1== professional
		System.out.println("\nTest Case for User ID Generation for clients");
		String client_id = ServletFunctions.generateUserID("0");
		System.out.println("\tTESTING Generated ID = "+client_id);
		System.out.println("\nTest Case for User ID Generation for professionals");
		String seller_id = ServletFunctions.generateUserID("1");
		System.out.println("\tTESTING Generated ID = "+seller_id);		
		System.out.println("END Of Test Case for User ID Generation");
		
		//Test case for Generate Error message
		String errorType = JspFunctions.getJspFunctionsClassInstance().loginError(2);
		System.out.println("getJspFunctionsClassInstance=  "+errorType);
		//Test case for Convert Date String to Sql.Date format
		java.sql.Date d = ServletFunctions.getSqlDate("10/08/2017");
		System.out.println(d);
		
		System.out.println("TEST case for Schedule program");
		SchedulerBean sb = new SchedulerBean();
		sb.setUser_id("ams/seller/2018/01");	sb.setMonth(3);		sb.setYear(2018);
		List<SchedulerBean> sbl = new ArrayList<SchedulerBean>();
		sbl = QueryFactory.getSchedulerQueries().selectQuery(sb);	
		for(SchedulerBean s:sbl){
			System.out.println(s.getDate_available());
			System.out.println(s.getTime_from());
			System.out.println(s.getTime_to());
			System.out.println(s.getSeats());
			System.out.println("====END======");
		}
		
		System.out.println("TEST case for Connecting client and professional for chatting");
		List<BookingBean> bookingBns = new ArrayList<BookingBean>();
		bookingBns = QueryFactory.getBookingQueries().selectChatJoinsForClients("ams/buyer/2018/16");
		for(BookingBean bn : bookingBns){
			System.out.println(bn.toString());
		}
		System.out.println("====END CHAT JOIN======");
		
		System.out.println("TEST case for get messages related to client and professionals");
		List<MsgBean> chatList = new ArrayList<MsgBean>();
		chatList = QueryFactory.getMsgQueries().selectQuery("ams/seller/2018/01", "ams/buyer/2018/16");
		System.out.println(chatList.toString());
		for(MsgBean bn : chatList){
			System.out.println(bn.toString());
		}
		
		String n = QueryFactory.getImageQueries().selectQuery("ams/seller/2018/07");
		System.out.println(n);
	}
}
