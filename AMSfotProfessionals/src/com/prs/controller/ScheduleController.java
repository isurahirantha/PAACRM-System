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
import com.prs.model.ClientBean;
import com.prs.model.ProfessionalBean;
import com.prs.model.SchedulerBean;
import com.prs.utils.JspFunctions;
import com.prs.utils.ServletFunctions;

/**
 * Servlet implementation class ScheduleController
 */
@WebServlet("/ScheduleController")
public class ScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleController() {
        super();
       
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
		String user_id = "";
		if(session.getAttribute("User-ID")!=null){
		user_id = session.getAttribute("User-ID").toString();
		}
		
		if(request.getParameter("action")!=null)
		{
			String action = request.getParameter("action");
			System.out.println(action);
			
				if(action.equalsIgnoreCase("schedule"))
				{	
					uri="schedule-app.jsp";
					ServletFunctions.dispatchScheduleInfo(request, response, user_id);
					RequestDispatcher rd = request.getRequestDispatcher(uri);
					rd.forward(request, response);
					
				}
				else if(action.equalsIgnoreCase("bookings")){	//View Booking by client ID WHEN CLICK ON NAV BAR LINK
					//GOTO MYBOOKING.JSP
					uri = "mybooking.jsp";
					ServletFunctions.dispatchBookingInfo(request, response, user_id);
					RequestDispatcher rd = request.getRequestDispatcher(uri);
					rd.forward(request, response);
				}
				else if(action.equalsIgnoreCase("manage")){	//View Booking by client ID WHEN CLICK ON NAV BAR LINK
					//GOTO MYBOOKING.JSP
					uri = "manage-booking.jsp";
					ServletFunctions.dispatchBookingInfoOfProfefessionals(request, response, user_id);
					RequestDispatcher rd = request.getRequestDispatcher(uri);
					rd.forward(request, response);
				}else if(action.equalsIgnoreCase("report")){	//View Booking by client ID WHEN CLICK ON NAV BAR LINK
					//GOTO MYBOOKING.JSP
					uri = "report.jsp";
					String r_id = request.getParameter("r_id"); 
					ServletFunctions.dispatchBookingReport(request, response, r_id);
					RequestDispatcher rd = request.getRequestDispatcher(uri);
					rd.forward(request, response);
				}
				
		}
		else if(request.getParameter("id")!=null){
			/*--GET SCHEDULE TO UPDATE FORM BASED ON AUTO_ID*/	
			int id = Integer.parseInt(request.getParameter("id"));
			if(id!=0){
				uri="schedule-app.jsp";
				SchedulerBean schBean = new SchedulerBean();
				schBean = QueryFactory.getSchedulerQueries().selectQuery(id);
				request.setAttribute("schedulerBean", schBean);
				RequestDispatcher rd = request.getRequestDispatcher(uri);
				rd.forward(request, response);
			}
			/*--END  GET SCHEDULE TO UPDATE FORM BASED ON AUTO_ID*/
			
			
		}else if(request.getParameter("del_id")!=null){
			/*--DELETE SCHEDULE DATE BY AUTO ID--*/
			int del_id = Integer.parseInt(request.getParameter("del_id"));
		//	System.out.println(del_id);
			if(del_id!=0){
				uri="schedule-app.jsp";
				QueryFactory.getSchedulerQueries().deleteQuery(del_id);
				ServletFunctions.dispatchScheduleInfo(request, response, user_id);
				RequestDispatcher rd = request.getRequestDispatcher(uri);
				rd.forward(request, response);
			}
			
			
		}else if(request.getParameter("u_id")!=null){
			/*--GET SCHEDULE TO Bookme Page BASED ON USER_ID */	
			String u_id = request.getParameter("u_id");
			if(u_id!=""){
				uri = "bookme.jsp";
				ServletFunctions.dispatchScheduleInfo(request, response, u_id);
				RequestDispatcher rd = request.getRequestDispatcher(uri);
				rd.forward(request, response);
			}
			/*--END  GET SCHEDULE TO Bookme Page BASED ON USER_ID */
			
			
		}else if(request.getParameter("sch_id")!=null && request.getParameter("sel_id")!=null){
			JspFunctions jsp = JspFunctions.getJspFunctionsClassInstance();
			String c_name = jsp.showName(request, response);
			/*-- INSERT BOOKING TO BOOKINGTBL AND
			 * GET SCHEDULE TO Bookme Page BASED ON USER_ID */	
			BookingBean bkBean = new BookingBean();
			
			bkBean.setSchedule_id(Integer.parseInt(request.getParameter("sch_id")));
			bkBean.setDate_booked(ServletFunctions.getSqlDate(request.getParameter("s_dt")));
			bkBean.setTime_from(request.getParameter("from"));
			bkBean.setTime_to(request.getParameter("to"));
			bkBean.setProfessional_id(request.getParameter("sel_id"));
			bkBean.setClient_id(request.getParameter("c_id"));
			bkBean.setClient_name(c_name);
			bkBean.setIsConfirmed(false);
					ProfessionalBean pbean = new ProfessionalBean();
					pbean= QueryFactory.getProfessionalQueries().selectQuery(bkBean.getProfessional_id());
			bkBean.setProfessional_name(pbean.getFirstname()+" "+pbean.getLastname());
			//System.out.println(bkBean.toString());
			ClientBean cBean = new ClientBean();
			cBean.setUser_id(request.getParameter("c_id"));
			//System.out.println(bkBean.toString());
			uri = "mybooking.jsp";
			int numOfRows = 0,check_ = 0;
			//CHECK WETHER ALREDY SCHEDULED
			check_ = QueryFactory.getBookingQueries().check(bkBean);
			//System.out.println("Check"+check_);
					if(check_==0)
					{
					numOfRows = QueryFactory.getBookingQueries().insertQuery(bkBean);
						if(numOfRows ==1)
						{
							//GOTO MYBOOKING.JSP
							uri = "mybooking.jsp";
							List<BookingBean> myBookings = new ArrayList<BookingBean>();
							System.out.println(cBean.getUser_id());
							myBookings = QueryFactory.getBookingQueries().selectQuery(cBean);
							request.setAttribute("myBookings", myBookings);
							RequestDispatcher rd = request.getRequestDispatcher(uri);
							rd.forward(request, response);
						}else{
							response.sendRedirect("default.jsp");
						}
					}else{
						//GOTO MYBOOKING.JSP
						uri = "mybooking.jsp";
						List<BookingBean> myBookings = new ArrayList<BookingBean>();
				//		System.out.println(cBean.getUser_id());
						myBookings = QueryFactory.getBookingQueries().selectQuery(cBean);
						request.setAttribute("mybookings", myBookings);
						RequestDispatcher rd = request.getRequestDispatcher(uri);
						rd.forward(request, response);
					}	
					/*--END  GET SCHEDULE TO Bookme Page BASED ON USER_ID */
		}//END INSERT BOOKING
		else if(request.getParameter("bk_del_id")!=null){
			int bk_del_id = Integer.parseInt(request.getParameter("bk_del_id"));
			int numOfRows = 0;
			numOfRows = QueryFactory.getBookingQueries().deleteQuery(bk_del_id);
			if(numOfRows==1){
				uri = "mybooking.jsp";
				ServletFunctions.dispatchBookingInfo(request, response, user_id);
				RequestDispatcher rd = request.getRequestDispatcher(uri);
				rd.forward(request, response);
			}
		}
		else if(request.getParameter("bk_upd_id")!=null){	//View Booking by client ID WHEN CLICK ON NAV BAR LINK
			//GOTO MYBOOKING.JSP
			BookingBean bookBn = new BookingBean();
			int bk_upd_id = Integer.parseInt(request.getParameter("bk_upd_id"));
			int schedule_id = Integer.parseInt(request.getParameter("sch_id"));
			String client_id = request.getParameter("c_id");
			
			bookBn.setIsConfirmed(true);
			bookBn.setAuto_id(bk_upd_id);
			bookBn.setSchedule_id(schedule_id);
			bookBn.setClient_id(client_id);
			String bookID = ServletFunctions.generate_Random_Booking_ID(bookBn);
			bookBn.setRandom_code(bookID);
			
			int numOfRows = 0;
			numOfRows = QueryFactory.getBookingQueries().updateQuery(bookBn);
			//System.out.println(numOfRows);
			if(numOfRows==1){
			uri = "manage-booking.jsp";
			ServletFunctions.dispatchBookingInfoOfProfefessionals(request, response, user_id);
			RequestDispatcher rd = request.getRequestDispatcher(uri);
			rd.forward(request, response);
			}else{
				uri = "manage-booking.jsp";
				ServletFunctions.dispatchBookingInfoOfProfefessionals(request, response, user_id);
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
		SchedulerBean schBean = new SchedulerBean();
		if(action.equalsIgnoreCase("adsch"))
		{	
			
			schBean.setUser_id(user_id);
			schBean.setDate_available(ServletFunctions.getSqlDate(request.getParameter("rel_date")));
			schBean.setDay(ServletFunctions.seperateDayMonthYear(request.getParameter("rel_date"), "day"));
			schBean.setMonth(ServletFunctions.seperateDayMonthYear(request.getParameter("rel_date"), "month"));
			schBean.setYear(ServletFunctions.seperateDayMonthYear(request.getParameter("rel_date"), "year"));
			schBean.setTime_from(request.getParameter("timefrom"));
			schBean.setTime_to(request.getParameter("timeto"));
			schBean.setJust_call_me(Integer.parseInt(request.getParameter("callme")));
			schBean.setSeats(Integer.parseInt(request.getParameter("seats")));
			
			
			
				if(schBean.getUser_id()!=""){
						Boolean isAvailable = QueryFactory.getSchedulerQueries().checkAvailability(schBean);
						//IF THAT DAY IS NOT YET SCHEDULED BY THE USER
						
						if(isAvailable!=true)
						{
							System.out.println("NOT INSERT"+isAvailable);
							int numOfRows = QueryFactory.getSchedulerQueries().insertQuery(schBean);
							if(numOfRows==1)
							{
								//IF THE INSERTION SUCCESS
								uri = "schedule-app.jsp?code=1";
								ServletFunctions.dispatchScheduleInfo(request, response, user_id);
								RequestDispatcher rd = request.getRequestDispatcher(uri);
								rd.forward(request, response);
							}else
							{
								//IF THE INSERTION NOT SUCCESS
								uri = "schedule-app.jsp?code=2";
								ServletFunctions.dispatchScheduleInfo(request, response, user_id);
								RequestDispatcher rd = request.getRequestDispatcher(uri);
								rd.forward(request, response);
							}
						//IF THE DAY IS ALREADY SCHEDULED, THEN UPDATE	
						}
						else
						{
							System.out.println("UPDATE"+isAvailable);
							int numOfRows = QueryFactory.getSchedulerQueries().updateQuery(schBean);
							System.out.println("Success   "+numOfRows);
							if(numOfRows==1)
							{
								uri = "schedule-app.jsp?code=3";
								ServletFunctions.dispatchScheduleInfo(request, response, user_id);
								RequestDispatcher rd = request.getRequestDispatcher(uri);
								rd.forward(request, response);
							}
							else
							{
								uri = "schedule-app.jsp?code=4";
								ServletFunctions.dispatchScheduleInfo(request, response, user_id);
								RequestDispatcher rd = request.getRequestDispatcher(uri);
								rd.forward(request, response);
							}
						}
				}
		  }
		  
	}

}
