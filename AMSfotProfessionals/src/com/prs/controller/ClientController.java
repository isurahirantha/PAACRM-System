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
import com.prs.model.ProfessionalBean;
import com.prs.model.UserBean;
import com.prs.utils.ServletFunctions;

/**
 * Servlet implementation class ClientController
 */
@WebServlet("/ClientController")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    String uri="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(request.getAttribute("User-ID")=="" || request.getAttribute("Admin-User-ID")==""){
	response.sendRedirect("default.jsp");
	}
		else
		{	
			HttpSession session = request.getSession();
			if(session.getAttribute("User-ID")==null && session.getAttribute("Admin-User-ID")==null){
				response.sendRedirect("default.jsp");
			}
			
			if(request.getParameter("profile")!=null && request.getParameter("profile")!=""){
				String profile = request.getParameter("profile");
				String user_id;
				user_id = session.getAttribute("User-ID").toString();
				if(profile.equalsIgnoreCase("profile")){
					uri = "edit-buyer-profile.jsp";
					//When Account Setting link clicked, 
					ServletFunctions.dispatchClientInfo(request, response, user_id);
					RequestDispatcher rd = request.getRequestDispatcher(uri);
					rd.forward(request, response);
				}
			}else if(request.getParameter("uid")!=null || request.getParameter("uid")!=""){
				String r_by = request.getParameter("by");
				String c_user_id = request.getParameter("uid");
				if(r_by.equalsIgnoreCase("admin")){
					uri = "admin_cl_view.jsp";
					//When Admin click on user id, 
					ServletFunctions.dispatchClientInfo(request, response, c_user_id);
					RequestDispatcher rd = request.getRequestDispatcher(uri);
					rd.forward(request, response);
				}else if(r_by.equalsIgnoreCase("seller")){
					uri = "seller_cl_view.jsp";
					//When Seller click on user id, 
					ServletFunctions.dispatchClientInfo(request, response, c_user_id);
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
		String user_id = session.getAttribute("User-ID").toString();
		//When Account Setting link clicked, 
		if(action.equalsIgnoreCase("profile")){
			System.out.println(action);
			uri = "edit-buyer-profile.jsp";
			//When Account Setting link clicked, 
			ServletFunctions.dispatchClientInfo(request, response, user_id);
			RequestDispatcher rd = request.getRequestDispatcher(uri);
			rd.forward(request, response);
			//FROM LOGIN CONTROLLER
		}else if(action.equalsIgnoreCase("updcli")){
			System.out.println(action);		
			UserBean uBean = new UserBean();
			ClientBean cBean = new ClientBean();
			
			uBean.setFirstname(request.getParameter("firstname"));
			uBean.setLastname(request.getParameter("lastname"));
			uBean.setEmail(request.getParameter("email"));
			uBean.setUser_id(user_id);
			cBean.setAddress(request.getParameter("address"));
			cBean.setPhone(request.getParameter("phone"));
			cBean.setUser_id(user_id);
			//System.out.println(uBean.toString());
			//System.out.println(cBean.toString());
			int numOfRows = 0;
			numOfRows = QueryFactory.getUserQueries().updateQuery(uBean);
			numOfRows += QueryFactory.getClientQueries().updateQuey(cBean);
			if(numOfRows==2){
				uri = "edit-buyer-profile.jsp?updateCode=1";
				//When Account Setting link clicked, 
				ServletFunctions.dispatchClientInfo(request, response, user_id);
			}else{
				uri = "edit-buyer-profile.jsp?updateCode=2";
				//When Account Setting link clicked, 
				ServletFunctions.dispatchClientInfo(request, response, user_id);
			}
			//When login , 
			ServletFunctions.dispatchClientInfo(request, response, user_id);
			RequestDispatcher rd = request.getRequestDispatcher(uri);
			rd.forward(request, response);
		}else if(action.equalsIgnoreCase("login")){
			System.out.println(action);
			uri = "c_dashboard.jsp";
			//When login , 
			ServletFunctions.dispatchClientInfo(request, response, user_id);
			RequestDispatcher rd = request.getRequestDispatcher(uri);
			rd.forward(request, response);
		}
	}
}
