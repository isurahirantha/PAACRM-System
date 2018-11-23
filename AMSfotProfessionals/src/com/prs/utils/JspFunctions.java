package com.prs.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.prs.dao.QueryFactory;
import com.prs.model.UserBean;

public class JspFunctions {
	
	public static JspFunctions jspFunctions;
	
	private JspFunctions(){}
	
	public static synchronized JspFunctions getJspFunctionsClassInstance() //step 1
	  {
	    if(jspFunctions == null)
	    {
	      return new JspFunctions();
	    } 
	    else    
	    {
	      return jspFunctions;
	    }
	  }	
	
	/**
	 * Login Error Message Creator
	 * 1 = Hello , Enter Your Associated Email and Password and try again..
	 * 2 = You Are Successfully Logged In
	 * 3 = Registration Successful, Please Login to continue. Thank you!
	 * 4 = Opps, Something went Wrong Its all our mistake.Please try again later..!
	 * code imply user type. 
	 * @param code
	 * @return message String
	 */
	public  String loginError(int loginCode){
		String message =null;
		if(loginCode==1){
			return message = "Hello , Enter Your Associated Email and Password and try again..";
		}else if(loginCode==2){
			return message = "You Are Successfully Logged In";
		}else if(loginCode==3){
			return message = "Registration Successful, Please Login to continue. Thank you!";
		}else if(loginCode==4){
			return message = " The Email you entered is already associated with an account.Please try again later..!";
		}else if(loginCode==5){
			return message = "That User does not exsist..!";
		}else if(loginCode==6){
			return message = "Please Fill All the Information below..!";
		}else if(loginCode==7){
			return message = "Administrator Login error..! Please Fill All the Information below..!";
		}else{
			return message;
		}
	}	

	/**
	 * 1 = Hello , Enter Your Associated Email and try again..
	 * 2 = Password Successfully Changed, Continue Login
	 * @param code
	 * @return message
	 */
	public  String passwordResetError(int resetCode){
		String message =null;
		if(resetCode==1){
			return message = "Hello , Enter Your Associated Email and try again..";
		}else if(resetCode==2){
			return message = "Password Successfully Changed, Continue Login";
		}else{
			return message;
		}
	}
	
	/**
	 * 1 = Hello , Enter Your Associated Email and try again..
	 * 2 = Password Successfully Changed, Continue Login
	 * @param code
	 * @return message
	 */
	public  String updateError(int updateCode){
		String message =null;
		if(updateCode==1){
			return message = "UPDATION SUCCESS..!";
		}else if(updateCode==2){
			return message = "UPDATION NOT SUCCESSED!";
		}else{
			return message;
		}
	}	
	/*
	public static void validateSession(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		if(session.getAttribute("User-ID")==null){
			try {
				response.sendRedirect("default.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	*/
	
	public void validateSession(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession ses = request.getSession();
		if((request.getSession().getAttribute("User-ID"))==null && (request.getSession().getAttribute("Admin-User-ID")==null)){
			response.sendRedirect("default.jsp");
		}
	}
	
	/**
	 * SESSION User ID
	 * @param request
	 * @param response
	 * @return String 
	 */
	public String getSession(HttpServletRequest request, HttpServletResponse response){
		HttpSession ses = request.getSession();
		//UserBean uBean  = new UserBean();
		String u_id ="";
		if(request.getSession().getAttribute("User-ID")!=null){
		 u_id = ses.getAttribute("User-ID").toString();
		}
		else if(request.getSession().getAttribute("Admin-User-ID")!=null){
		 u_id = ses.getAttribute("Admin-User-ID").toString();
		}
		return u_id;
	}
	
	public int getSessionUsertype(HttpServletRequest request, HttpServletResponse response){
		HttpSession ses = request.getSession();
		int ses_user_type =0;
		if(ses.getAttribute("User-ID")!=null ||ses.getAttribute("User-ID").toString()!=""){
			ses_user_type = Integer.parseInt(ses.getAttribute("User-Type").toString());
			//return ses_user_type;
		}else if(ses.getAttribute("Admin-User-ID")!=null ||ses.getAttribute("Admin-User-ID").toString()!=""){
			ses_user_type = Integer.parseInt(ses.getAttribute("User-Type").toString());
		}
		return ses_user_type;
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return String fullname
	 * @throws IOException
	 */
	public String showName(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession ses = request.getSession();
		UserBean uBean  = new UserBean();
		String fullname ="";
		if(request.getSession().getAttribute("User-ID")!=null){
		String u_id = ses.getAttribute("User-ID").toString();
		uBean = QueryFactory.getUserQueries().selectquery(u_id);

		String fname = uBean.getFirstname();
		String lname = uBean.getLastname();
		fullname = fname+" "+lname;
		}
		else if(request.getSession().getAttribute("Admin-User-ID")!=null){
			String u_id = ses.getAttribute("Admin-User-ID").toString();
			uBean = QueryFactory.getUserQueries().selectquery(u_id);

			String fname = uBean.getFirstname();
			String lname = uBean.getLastname();
			fullname = fname+" "+lname;
		}
		return fullname;
	}

}
