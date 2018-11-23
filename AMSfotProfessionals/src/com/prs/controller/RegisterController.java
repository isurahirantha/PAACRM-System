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
import com.prs.model.ClientBean;
import com.prs.model.EducationBean;
import com.prs.model.PExperienceBean;
import com.prs.model.ProfessionalBean;
import com.prs.model.UserBean;

import com.prs.utils.ServletFunctions;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterController() {
        super();
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

    //OK
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				//CODES HERE
				
		//Abstract Query userQueries = QueryFactory.getUserQueries();
		String uri="";
		String user_id=null;
		HttpSession session = request.getSession();
		
		UserBean regUser = new UserBean();
		ProfessionalBean pBean = new ProfessionalBean();
		PExperienceBean pExBean = new PExperienceBean();
		AchievmentBean  achBean = new AchievmentBean();
		EducationBean eBean = new EducationBean();
		
		ClientBean cBean = new ClientBean();
		int insertResult =0,updateResult=0;
		
		
		try 
		{	
		if(request.getParameter("firstname")!="" || request.getParameter("lastname")!="" || request.getParameter("email")!="" || request.getParameter("password")!="")
		{
				regUser.setFirstname(request.getParameter("firstname"));
				regUser.setLastname(request.getParameter("lastname"));
				regUser.setEmail(request.getParameter("email"));
				regUser.setPassword(request.getParameter("password"));
				regUser.setUsertype(ServletFunctions.getUserTypeInt(request.getParameter("usertype")));
				regUser.setUser_id(ServletFunctions.generateUserID(request.getParameter("usertype")));
				
				//System.out.println(regUser.getUsertype());
				
				pBean.setFirstname(request.getParameter("firstname"));
				pBean.setLastname(request.getParameter("lastname"));
				pBean.setUser_id(regUser.getUser_id());
				cBean.setUser_id(regUser.getUser_id());
				/*
				 * IN REGISTRATION I USED regUser.getUser_id() to get User_ID
				 * Because no session is set at this stage
				 */
				pExBean.setUser_id(regUser.getUser_id());
				achBean.setUser_id(regUser.getUser_id());
				eBean.setUser_id(regUser.getUser_id());
				
				//Execute Update commands Login table, if session is set 
				if(session.getAttribute("User-ID")!=null)
				{
					user_id = session.getAttribute("User-ID").toString();
					if(user_id!="")
					{
					updateResult = QueryFactory.getUserQueries().updateQuery(regUser);
						if(updateResult==1)
						{
							response.sendRedirect("./dashboard.jsp?code=1");
						}else
						{
							response.sendRedirect("./dashboard.jsp?code=2");
						}
					}
				}else
				{
					//Else Check email already registered? and 
					Boolean eXemail = QueryFactory.getUserQueries().selectQuery(request.getParameter("email"));
						if(eXemail==false)
						{
						//REGISTER SELLER 
							if(regUser.getUsertype()==2){
								int insertResults = 0;
								int profResult = 0;
								int expResults = 0;
								int achResults = 0;
								int eduResults = 0;
								int imgResults = 0;
								//System.out.println(eBean.toString());
								//System.out.println(pExBean.toString());
								//System.out.println(achBean.toString());
					//			System.out.println("PROBLEM+ "+user_id);
								insertResults = QueryFactory.getUserQueries().insertQuery(regUser);
								profResult = QueryFactory.getProfessionalQueries().insertQuery(pBean);
								imgResults = QueryFactory.getImageQueries().insertQuery(regUser.getUser_id());
								expResults = QueryFactory.getExperienceQueries().insertQuery(regUser.getUser_id());
								achResults = QueryFactory.getAchievmentQueries().insertQuery(regUser.getUser_id());
								eduResults = QueryFactory.getEducationQueries().insertQuery(regUser.getUser_id());
									if((insertResults+profResult+expResults+achResults+eduResults+imgResults)==6)
									{
										response.sendRedirect("./register.jsp?code=3");	
									}else
									{
										response.sendRedirect("./register.jsp?code=6");
									}	
							}else if(regUser.getUsertype()==1)
							{
								//REGISTER BUYER
								int insertResults = 0;
								int clientResult = 0;
								insertResults = QueryFactory.getUserQueries().insertQuery(regUser);
								clientResult = QueryFactory.getClientQueries().insertQuery(cBean);
								if((insertResults+clientResult)==2)
								{
									response.sendRedirect("./register.jsp?code=3");	
								}else
								{
									response.sendRedirect("./register.jsp?code=6");
								}
							}
						
						}else
						{
						//email already exists
							response.sendRedirect("./register.jsp?code=4");
						}
				}//session else	
		}else
		{
			//NULL REQUESTS.GETPARAMETERS
			response.sendRedirect("./register.jsp?code=6");
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}

	}//do
}