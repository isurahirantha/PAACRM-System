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
import com.prs.model.AchievmentBean;
import com.prs.model.EducationBean;
import com.prs.model.PExperienceBean;
import com.prs.model.ProfessionalBean;
import com.prs.model.UserBean;
import com.prs.utils.ServletFunctions;

/**
 * Servlet implementation class ProfController
 */
@WebServlet("/ProfController")
public class ProfController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	String uri ="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(request.getAttribute("User-ID")==""){
	response.sendRedirect("default.jsp");
	}else
	{	
		
		HttpSession session = request.getSession();
		//String user_id = session.getAttribute("Admin-User-ID").toString();
		String user_id = "";
		if(session.getAttribute("User-ID")!=null){
			user_id = session.getAttribute("User-ID").toString();
		}else if(session.getAttribute("Admin-User-ID")!=null){
			user_id = session.getAttribute("Admin-User-ID").toString();
		}
		
		if(request.getParameter("profile")!=null)
		{
				String action = request.getParameter("profile");
				///When Account Setting link clicked, 
				if(action.equalsIgnoreCase("profile")){
					//System.out.println(action);
					uri = "edit-seller-profile.jsp";
					//When Account Setting link clicked, 
					ServletFunctions.dispatchProfessionalInfo(request, response, user_id);
					RequestDispatcher rd = request.getRequestDispatcher(uri);
					rd.forward(request, response);
				}else if(action.equalsIgnoreCase("login")){
					//System.out.println(action);
					uri = "dashboard.jsp";
					//When Account Setting link clicked, 
					ServletFunctions.dispatchProfessionalInfo(request, response, user_id);
					RequestDispatcher rd = request.getRequestDispatcher(uri);
					rd.forward(request, response);
				}
		}
		else if(request.getParameter("user_id")!=null)
		{
			//VIEW PROFILE
			String requested_by ="";
			if(request.getParameter("by")!=null){
				requested_by = request.getParameter("by");
				if(requested_by.equalsIgnoreCase("admin")){
					uri = "a_profile.jsp";
				}else if(requested_by.equalsIgnoreCase("seller")){
					
					uri = "p_profile.jsp";
				}else if(requested_by.equalsIgnoreCase("buyer")){
					uri ="profile.jsp";
				}
				//System.out.println(uri);
			}
			
			String searched_selected_user_id = request.getParameter("user_id");
			//When Account Setting link clicked, 
			ServletFunctions.dispatchProfessionalInfo(request, response, searched_selected_user_id);
			RequestDispatcher rd = request.getRequestDispatcher(uri);
			rd.forward(request, response);
		}
	}	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//When login is  ok, 
		//LoginController dispatch this uri = "./ProfController?action=login"
		//this dispatch info to dashboard.jsp
		try{
			String action = request.getParameter("action");
			HttpSession session = request.getSession();
			String user_id = session.getAttribute("User-ID").toString();	
			ProfessionalBean pBean = new ProfessionalBean();
			PExperienceBean exBean = new PExperienceBean();
			if(action.equalsIgnoreCase("login")){	
				//System.out.println(action);
				uri = "dashboard.jsp";	//Dashboard - professional's home page.	
				pBean = QueryFactory.getProfessionalQueries().selectQuery(user_id);
				//System.out.println(pBean.toString());
				request.setAttribute("professionalBean", pBean);
				RequestDispatcher rd = request.getRequestDispatcher(uri);
				rd.forward(request, response);
			}else if(action.equalsIgnoreCase("updprf")){
				//Update aboutprofesssionaltbl
				//Update logintbl
				UserBean user = new UserBean();
				int numOfRows = 0;
				pBean.setUser_id(user_id);
				pBean.setProfession(request.getParameter("profession"));
				pBean.setSpecify(request.getParameter("specify"));
				pBean.setOther_info(request.getParameter("other"));
				pBean.setTags(request.getParameter("taglist"));
				pBean.setHeadLine(request.getParameter("headline"));
				pBean.setCompany(request.getParameter("companyname"));
				pBean.setAddress(request.getParameter("address"));
				pBean.setPhone(request.getParameter("phone"));
				pBean.setFirstname(request.getParameter("firstname"));
				pBean.setLastname(request.getParameter("lastname"));
				//System.out.println(pBean.toString());
				user.setFirstname(request.getParameter("firstname"));
				user.setLastname(request.getParameter("lastname"));
				user.setEmail(request.getParameter("email"));
				//user.setBirthday(ServletFunctions.getSqlDate(request.getParameter("birthday")));
				user.setGender(ServletFunctions.getGender(request.getParameter("gender")));
				user.setUser_id(user_id);
				//System.out.println(user.toString());
				numOfRows = QueryFactory.getProfessionalQueries().updateQuery(pBean);
				numOfRows += QueryFactory.getUserQueries().updateQuery(user);
				//System.out.println(numOfRows);
				if(numOfRows ==2){
					uri = "edit-seller-profile.jsp?update_code=1";
					
					ServletFunctions.dispatchProfessionalInfo(request, response, user_id);
					RequestDispatcher rd = request.getRequestDispatcher(uri);
					rd.forward(request, response);
					
				}else{
					uri = "edit-seller-profile.jsp?update_code=2";
					ServletFunctions.dispatchProfessionalInfo(request, response, user_id);
					RequestDispatcher rd = request.getRequestDispatcher(uri);
					rd.forward(request, response);
				}
			}else if(action.equalsIgnoreCase("updexp")){
				//Update experiencetbl
				int numOfRows = 0;
				exBean.setAria(request.getParameter("aria"));
				exBean.setPlace(request.getParameter("place"));
				exBean.setFrom_date(ServletFunctions.getSqlDate(request.getParameter("from_date")));
				exBean.setTo_date(ServletFunctions.getSqlDate(request.getParameter("to_date")));
				exBean.setUser_id(user_id);
				numOfRows = QueryFactory.getExperienceQueries().updateQuery(exBean);
				if(numOfRows ==1){
					uri = "edit-seller-profile.jsp?update_code=1";
					ServletFunctions.dispatchProfessionalInfo(request, response, user_id);
					RequestDispatcher rd = request.getRequestDispatcher(uri);
					rd.forward(request, response);
				}else{
					uri = "edit-seller-profile.jsp?update_code=2";
					ServletFunctions.dispatchProfessionalInfo(request, response, user_id);
					RequestDispatcher rd = request.getRequestDispatcher(uri);
					rd.forward(request, response);
				}
			}else if(action.equalsIgnoreCase("upduni")){
				//UPDATE universitytbl
				int numOfRows = 0;
				EducationBean eBean = new EducationBean();
				eBean.setName(request.getParameter("university"));
				eBean.setDegree(request.getParameter("degree"));
				eBean.setFromTime(ServletFunctions.getSqlDate(request.getParameter("fromtime")));
				eBean.setToTime(ServletFunctions.getSqlDate(request.getParameter("totime")));
				eBean.setUser_id(user_id);
				numOfRows = QueryFactory.getEducationQueries().updateQuery(eBean);
				if(numOfRows ==1){
					uri = "edit-seller-profile.jsp?update_code=1";
					ServletFunctions.dispatchProfessionalInfo(request, response, user_id);
					RequestDispatcher rd = request.getRequestDispatcher(uri);
					rd.forward(request, response);
				}else{
					uri = "edit-seller-profile.jsp?update_code=2";
					ServletFunctions.dispatchProfessionalInfo(request, response, user_id);
					RequestDispatcher rd = request.getRequestDispatcher(uri);
					rd.forward(request, response);
				}
			}else if(action.equalsIgnoreCase("updach")){
				// Update AchivementTbl
				//System.out.println(action);
				int numOfRows = 0;
				AchievmentBean aBean = new AchievmentBean();
				aBean.setTitle(request.getParameter("title"));
				aBean.setInstitute(request.getParameter("institute"));
				aBean.setDuedate(ServletFunctions.getSqlDate(request.getParameter("duedate")));
				aBean.setUser_id(user_id);
				numOfRows = QueryFactory.getAchievmentQueries().updateQuery(aBean);
				//System.out.println(aBean.toString());
				if(numOfRows ==1){
					uri = "edit-seller-profile.jsp?update_code=1";
					ServletFunctions.dispatchProfessionalInfo(request, response, user_id);
					RequestDispatcher rd = request.getRequestDispatcher(uri);
					rd.forward(request, response);
				}else{
					uri = "edit-seller-profile.jsp?update_code=2";
					ServletFunctions.dispatchProfessionalInfo(request, response, user_id);
					RequestDispatcher rd = request.getRequestDispatcher(uri);
					rd.forward(request, response);
				}				
			}else if(action.equalsIgnoreCase("srchprf")){
				uri = "find_professional.jsp";
				String district = request.getParameter("district");
				String profession = request.getParameter("profession");
				List<ProfessionalBean> prfBean = new ArrayList<ProfessionalBean>();
				prfBean = QueryFactory.getProfessionalQueries().selectQuery(district, profession);
				request.setAttribute("searchedBean", prfBean);
				RequestDispatcher rd = request.getRequestDispatcher(uri);
				rd.forward(request, response);
			}else{
			//IF "action" DOES NOT HAVE VALID VALUE
				//THEN REDIRECT TO Default.jsp
				response.sendRedirect("default.jsp");
			}
			//System.out.println(uri);
			
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}

}
