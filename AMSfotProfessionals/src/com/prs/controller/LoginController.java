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
import com.prs.model.AchievmentBean;
import com.prs.model.PExperienceBean;
import com.prs.model.TrackingBean;
import com.prs.model.UserBean;
import com.prs.utils.ServletFunctions;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String loginAction = request.getParameter("loginAction");
		if(loginAction.equalsIgnoreCase("logout")){
			HttpSession ses = request.getSession();
			ses.removeAttribute("User-ID");
			ses.removeAttribute("Admin-User-ID");
			ses.removeAttribute("User-Type");
			ses.invalidate();
			response.sendRedirect("default.jsp");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String action = request.getParameter("action");
			if(action.equalsIgnoreCase("change")){
				String email = request.getParameter("email");
				String password = request.getParameter("veri_password");
				int result = QueryFactory.getUserQueries().updatePasswordQuery(email, password);
				if(result==1){ response.sendRedirect("./default.jsp?code=1");}
			}else if(action.equalsIgnoreCase("login"))
			{
				UserBean loginUser = new UserBean();
				UserBean user = new UserBean();
				TrackingBean log = new TrackingBean();
					if(request.getParameter("email")!="" || request.getParameter("password")!=""){
						loginUser.setUsertype(ServletFunctions.getUserTypeInt(request.getParameter("usertype")));
						loginUser.setEmail(request.getParameter("email"));
						loginUser.setPassword(request.getParameter("password"));
						loginUser.setUsertype(ServletFunctions.getUserTypeInt(request.getParameter("usertype")));
						//Query for equal login credentials
						user = QueryFactory.getUserQueries().selectQuery(loginUser);	
						//System.out.println("user"+user.toString());
						//!make program to show login errors. using user inputs. ex:- user.getEmail() 
						if(user.getUser_id()!="" && user.getUsertype()!=0){	
							HttpSession session = request.getSession();
							String user_id = user.getUser_id();
							String uri = "";
							session.setAttribute("User-ID", user_id);
							session.setAttribute("User-Type", user.getUsertype());
							request.setAttribute("loginBean", user);
						//User Activity Tracker
							log.setIp(ServletFunctions.getIP(request, response));
							log.setUser_id(user_id);
							log.setLog_time(ServletFunctions.getNowTime());
							log.setLog_date(ServletFunctions.getSqlDate(ServletFunctions.getToday()));

							int logResults = 0;
								try{
								logResults = QueryFactory.getTrackerQueries().insertQuery(log);
								}catch(Exception e){e.printStackTrace();}
								//Provide Page Base on user type
								if(user.getUsertype()==1){
									uri = "./ClientController?action=login";
								}else if(user.getUsertype()==2){
									uri = "./ProfController?action=login";
								}
								RequestDispatcher rd = request.getRequestDispatcher(uri);
								rd.forward(request, response);
								
							}else{
								response.sendRedirect("./default.jsp?loginCode=1");
							}
					}else{
						response.sendRedirect("./default.jsp?loginCode=6");
					}
			}else if(action.equalsIgnoreCase("admin"))
			{
				UserBean loginUser = new UserBean();
				UserBean user = new UserBean();
				TrackingBean log = new TrackingBean();
					if(request.getParameter("email")!="" || request.getParameter("password")!=""){
						loginUser.setEmail(request.getParameter("email"));
						loginUser.setPassword(request.getParameter("password"));
						loginUser.setUsertype(ServletFunctions.getUserTypeInt("admin"));
						//Query for equal admin login credentials
						user = QueryFactory.getUserQueries().selectQuery(loginUser);	
						//!make program to show login errors. using user inputs. ex:- user.getEmail() 
						if(user.getUser_id()!="" && user.getUsertype()!=0){	
							HttpSession session = request.getSession();
							String user_id = user.getUser_id();
							String uri = "";
							session.setAttribute("Admin-User-ID", user_id);
							request.setAttribute("loginBean", user);
							
							//User Activity Tracker
							log.setIp(ServletFunctions.getIP(request, response));
							log.setUser_id(user_id);
							log.setLog_time(ServletFunctions.getNowTime());
							log.setLog_date(ServletFunctions.getSqlDate(ServletFunctions.getToday()));
		
							int logResults = 0;
								try{
								logResults = QueryFactory.getTrackerQueries().insertQuery(log);
			
								}catch(Exception e){
									e.printStackTrace();
								}
								//Provide Page Base on user type
								
								if(user.getUsertype()==3){
									uri = "./AdminController?action=login";
									RequestDispatcher rd = request.getRequestDispatcher(uri);
									rd.forward(request, response);
								}else{
									response.sendRedirect("default.jsp?loginCode=7");
								}
								
								
							}else{
								//System.out.println("no input");
								response.sendRedirect("./default.jsp?loginCode=7");
							}
					}else{
						//System.out.println("Errror");
						response.sendRedirect("./default.jsp?loginCode=6");
					}
			}
		}//do

	
}
