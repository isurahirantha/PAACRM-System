package com.prs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.prs.dao.QueryFactory;
import com.prs.model.BookingBean;
import com.prs.model.MsgBean;
import com.prs.utils.JspFunctions;
import com.prs.utils.ServletFunctions;

/**
 * Servlet implementation class MsgController
 */
@WebServlet("/MsgController")
public class MsgController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MsgController() {super();}
    
    String uri = "";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession sess  = request.getSession();
	if(sess.getAttribute("User-ID")=="" && sess.getAttribute("Admin-User-ID")==""){
	response.sendRedirect("default.jsp");
	}else
	{
		JspFunctions jsp = JspFunctions.getJspFunctionsClassInstance();
		int usertype = jsp.getSessionUsertype(request, response);
		String user_id = jsp.getSession(request, response);
		//System.out.println(user_id);
		if(request.getParameter("action")!=null && request.getParameter("action")!=null){
		String action = request.getParameter("action");
			if(action.equalsIgnoreCase("load-msg")){
				uri = "c_messages.jsp";
				ServletFunctions.dispatchchatJoinsForClient(request, response, user_id);
				RequestDispatcher rd = request.getRequestDispatcher("c_messages.jsp");
				rd.forward(request, response);
			}else if(action.equalsIgnoreCase("load-msg-prof")){
				uri = "p_messages.jsp";
		//System.out.println("load msg prof");
				ServletFunctions.dispatchchatJoinsForProfessional(request, response, user_id);
				RequestDispatcher rd = request.getRequestDispatcher("p_messages.jsp");
				rd.forward(request, response);
			}
		//IF doGET HAVE prof_id && client_id
		//GRAB AND DISPATCH RELEVENT chatJoins and MSGBEANS TO MSGAREA	
		}else if(request.getParameter("prof_id")!=null && request.getParameter("client_id")!=null){
		//CLIENTS MESSAGE SECTION
			//System.out.println("not p");
			ServletFunctions.dispatchchatJoinsForClient(request, response, user_id);
			ServletFunctions.dispatchChatList(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("c_messages.jsp");
			rd.forward(request, response);
			
		}else if(request.getParameter("p_client_id")!=null && request.getParameter("p_prof_id")!=null){
		//PROFESSIONAL MESSAGE SECTION	
			//System.out.println(" p");
			
			ServletFunctions.dispatchchatJoinsForProfessional(request, response, user_id);
			ServletFunctions.dispatchChatListofProfessional(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("p_messages.jsp");
			rd.forward(request, response);
		}
		
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Hello, Can I get the Budget details?
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess  = request.getSession();
		if(sess.getAttribute("User-ID")=="" && sess.getAttribute("Admin-User-ID")==""){
		response.sendRedirect("default.jsp");
		}else
		{	
			JspFunctions jsp = JspFunctions.getJspFunctionsClassInstance();
			int usertype = jsp.getSessionUsertype(request, response);
			String user_id = jsp.getSession(request, response);
			
			if(request.getParameter("prof_id")!=null && request.getParameter("client_id")!=null){
				String msgText = request.getParameter("msg");
				String client_id = request.getParameter("client_id");
				String professional_id = request.getParameter("prof_id");
				//System.out.println(professional_id);System.out.println(client_id);
				MsgBean msgBean = new MsgBean();
				
				msgBean.setClient_id(client_id);
				msgBean.setProfessional_id(professional_id);
				msgBean.setDate_msg(ServletFunctions.getSqlDate(ServletFunctions.getToday()));
				msgBean.setTime_msg(ServletFunctions.getNowTime().toString());
				msgBean.setMessage(msgText);
				msgBean.setisClient(true);
				
				//System.out.println(msgBean.getTime_msg()+"||"+msgBean.getDate_msg()+"||"+msgBean.getProfessional_id()+"||"+msgBean.getClient_id()+"||"+msgBean.getMessage());
				//System.out.println(msgBean.getMessage());
				int numOfRows = 0 ;
				numOfRows = QueryFactory.getMsgQueries().insertQuery(msgBean);
				if(numOfRows==1){
					System.out.println("OK"+ numOfRows);
				}
				ServletFunctions.dispatchchatJoinsForClient(request, response, user_id);
				ServletFunctions.dispatchChatList(request, response);
				RequestDispatcher rd = request.getRequestDispatcher("c_messages.jsp");
				rd.forward(request, response);
				
			}else if(request.getParameter("p_prof_id")!=null && request.getParameter("p_client_id")!=null){
				
				String msgText = request.getParameter("msg");
				String client_id = request.getParameter("p_client_id");
				String professional_id = request.getParameter("p_prof_id");
				//System.out.println(professional_id);System.out.println(client_id);
				
				MsgBean msgBean = new MsgBean();
				
				msgBean.setClient_id(client_id);
				msgBean.setProfessional_id(professional_id);
				msgBean.setDate_msg(ServletFunctions.getSqlDate(ServletFunctions.getToday()));
				msgBean.setTime_msg(ServletFunctions.getNowTime().toString());
				msgBean.setMessage(msgText);
				msgBean.setisClient(false);
				
				//System.out.println(msgBean.getTime_msg()+"||"+msgBean.getDate_msg()+"||"+msgBean.getProfessional_id()+"||"+msgBean.getClient_id()+"||"+msgBean.getMessage());
				//System.out.println(msgBean.getMessage());
				int numOfRows = 0 ;
				numOfRows = QueryFactory.getMsgQueries().insertQuery(msgBean);
				if(numOfRows==1){
					System.out.println("OK"+ numOfRows);
				}
				ServletFunctions.dispatchchatJoinsForProfessional(request, response, user_id);
				ServletFunctions.dispatchChatListofProfessional(request, response);
				RequestDispatcher rd = request.getRequestDispatcher("p_messages.jsp");
				rd.forward(request, response);
			}
		}
	}

}
