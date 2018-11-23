package com.prs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.prs.dao.QueryFactory;
import com.prs.model.ClientBean;
import com.prs.model.UserBean;
import com.prs.utils.ServletFunctions;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    String uri="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getAttribute("Admin-User-ID")==""){
			response.sendRedirect("default.jsp");
			}else
			{	
				
				HttpSession session = request.getSession();
				String user_id = session.getAttribute("Admin-User-ID").toString();
				
				if(request.getParameter("action")!=null)
				{
						String action = request.getParameter("action");
						///When Account Setting link clicked, 
						if(action.equalsIgnoreCase("stats")){
							System.out.println(action);
							uri = "stat.jsp";
							//When Account Setting link clicked, 
							ServletFunctions.dispatchStatsInfo(request, response);
							RequestDispatcher rd = request.getRequestDispatcher(uri);
							rd.forward(request, response);
						}else if(action.equalsIgnoreCase("logs")){
							System.out.println(action);
							uri = "logs.jsp";
							//When Account Setting link clicked, 
							ServletFunctions.dispatchLogsInfo(request, response);
							RequestDispatcher rd = request.getRequestDispatcher(uri);
							rd.forward(request, response);
						}
				}else if(request.getParameter("profile")!=null)
				{	
					String profile = request.getParameter("profile");
					if(profile.equalsIgnoreCase("profile")){
						uri = "edit-admin-profile.jsp";
						//When Account Setting link clicked, 
						ServletFunctions.dispatchAdminInfo(request, response, user_id);
						RequestDispatcher rd = request.getRequestDispatcher(uri);
						rd.forward(request, response);
					}
				}

				
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		String user_id = session.getAttribute("Admin-User-ID").toString();
		if(action.equalsIgnoreCase("login")){
			//System.out.println(action);
			uri = "admin-page.jsp";
			//When login , 
			ServletFunctions.dispatchAdminInfo(request, response, user_id);
			RequestDispatcher rd = request.getRequestDispatcher(uri);
			rd.forward(request, response);
		}else if(action.equalsIgnoreCase("profile")){
			//System.out.println(action);
			uri = "edit-admin-profile.jsp";
			//When Account Setting link clicked, 
			ServletFunctions.dispatchClientInfo(request, response, user_id);
			RequestDispatcher rd = request.getRequestDispatcher(uri);
			rd.forward(request, response);
			//FROM LOGIN CONTROLLER
		}else if(action.equalsIgnoreCase("updcli")){
			//System.out.println(action);		
			UserBean uBean = new UserBean();
			
			uBean.setFirstname(request.getParameter("firstname"));
			uBean.setLastname(request.getParameter("lastname"));
			uBean.setEmail(request.getParameter("email"));
			uBean.setUser_id(user_id);
			//System.out.println(uBean.toString());
			int numOfRows = 0;
			numOfRows = QueryFactory.getUserQueries().adminUpdateQuery(uBean);
			if(numOfRows==1){
				uri = "edit-admin-profile.jsp?updateCode=1";
				//When Account Setting link clicked, 
				ServletFunctions.dispatchClientInfo(request, response, user_id);
			}
			//When login , 
			ServletFunctions.dispatchClientInfo(request, response, user_id);
			RequestDispatcher rd = request.getRequestDispatcher(uri);
			rd.forward(request, response);
		}
	}

}
