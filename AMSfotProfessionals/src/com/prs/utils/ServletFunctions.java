package com.prs.utils;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.prs.dao.QueryFactory;
import com.prs.model.AchievmentBean;
import com.prs.model.BookingBean;
import com.prs.model.ClientBean;
import com.prs.model.EducationBean;
import com.prs.model.ImageBean;
import com.prs.model.MsgBean;
import com.prs.model.PExperienceBean;
import com.prs.model.ProfessionalBean;
import com.prs.model.RatingBean;
import com.prs.model.SchedulerBean;
import com.prs.model.TrackingBean;
import com.prs.model.UserBean;


/**
 * 
 * @author Isura
 *	Some Methods needed by Servlet
 */
public class ServletFunctions {

	/**
	 * Convert User type into Integer value
	 * if para = 1 return int 1, else return int 0
	 * @param para
	 * @return integer
	 */
    public static int getUserTypeInt(String para){
    	int r = 0;
    	if(para.equals("buyer")){
			r = 1;
		}else if(para.equals("seller")){
			r = 2;
		}else if(para.equals("admin")){
			r = 3;
		}
    	
    	return r;
    }
    
    /**
	 * Convert radio button input of ratings into Integer value
	 * if para = 1 return int 1, else return int 0
	 * @param para
	 * @return integer
	 */
    public static int getRateInt(String para){
    	if(para.equals("1")){
			return 1;
		}else if(para.equals("2")){
			return 2;
		}else if(para.equals("3")){
			return 3;
		}else if(para.equals("4")){
			return 4;
		}else{
			return 5;
		}
    }    
    
    /**
     * Convert Date to java.sql.Date
     * @param dateString
     * @return java.sql.Date date
     */
    public static java.sql.Date getSqlDate(String dateString){
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dob;
		try{
		dob = formatter.parse(dateString);
		return new java.sql.Date(dob.getTime());
		}catch(Exception e){
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * Convert TimeString to Sql.Time Object
     * @param timeString
     * @return Sql.Time Object
     */
    public static java.sql.Time strToTime(String timeString){

    	DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    	java.sql.Time timeValue = null;
		//String ti = "22:12:22";
		try {
			timeValue = new java.sql.Time(formatter.parse(timeString).getTime());
			return timeValue;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timeValue;
    	
    }
    
    /**
     * Base on the String method parameters return the integer
     * @param gender
     * @return integer(gender)
     */
    public static int getGender(String gender){
    	if(gender.equals("male")){
    		return 1;
    	}else if(gender.equals("female")){
    		return 2;
    	}
    	return 0;
    }
    
    /**
     * seperate date into day , month, year
     * @param dateString (format yyyy-MM-dd )
     * @param text (month, day, year)
     * @return int
     */
    public static int seperateDayMonthYear(String dateString,String text){
    	Date dateEntered;
    	dateEntered = ServletFunctions.getSqlDate(dateString);
    	Calendar cal = Calendar.getInstance();
    	int dmy=0;
		try{
			cal.setTime(dateEntered);
	    	if(text.equalsIgnoreCase("month")){
	    		dmy = cal.get(Calendar.MONTH);
	    		return dmy+=1;
	    	}else if(text.equalsIgnoreCase("year")){
	    		dmy = cal.get(Calendar.YEAR);
	    		return dmy;
	    	}else if(text.equalsIgnoreCase("day")){
	    		dmy = cal.get(Calendar.DATE);
	    		return dmy;
	    	}
		}catch(Exception e){
			e.printStackTrace();
		}
    	return dmy;
    }    
    
    /**
     * Generate User ID based on user type 
     * Get the index of last row in the login table and increment by 1
     * @param usertype
     * @return String[user_id]
     */
    public static String generateUserID(String usertype){
	    int dbIndex = QueryFactory.getUserQueries().getLastUserId();
	    int index=++dbIndex;
	    int year = Calendar.getInstance().get(Calendar.YEAR);
	    //int year = 17;
	    String preText =null;
	    String autoGenId=null;
	    if(usertype.equals("seller")){
		    	preText = "ams/seller/"; 
		    }else if(usertype.equals("buyer")){
		    	preText = "ams/buyer/"; 	
		    }
		
		if(index<10){
			String lowindex = "0"+index;
			autoGenId= new StringBuffer().append(preText).append(year).append("/").append(lowindex).toString();
	    }else{
	        autoGenId= new StringBuffer().append(preText).append(year).append("/").append(index).toString();
		}
	    return autoGenId;
    }
    
    /**
     * Generate Random Booking ID
     * @param user_id
     * @return BookingBean
     */
    public static String generate_Random_Booking_ID(BookingBean bookingBean){
	    BookingBean bean = new BookingBean();
	    bean = QueryFactory.getBookingQueries().selectQuery(bookingBean.getSchedule_id());//From DB
	    System.out.println(bean.toString());
	    String seller = bean.getProfessional_id();
	    int booking_auto_id  = bean.getAuto_id();
	    int index=++booking_auto_id;
	    int year = Calendar.getInstance().get(Calendar.YEAR);
	     
	    String preText ="book-id/";
	    String Random_Booking_ID=null;
	    //String loindex = index<10 ? "0"+loindex : index;
		if(index<10){
			String lowindex = "0"+index;
			Random_Booking_ID= new StringBuffer().append(preText).append(year).append("/").append(lowindex).append("/").append(seller).append("/").toString();
			//bean.setRandom_code(Random_Booking_ID); 
			return Random_Booking_ID;
		}else{
	    	Random_Booking_ID= new StringBuffer().append(preText).append(year).append("/").append(index).append("/").append(seller).append("/").toString();
	    	//bean.setRandom_code(Random_Booking_ID); 
			return Random_Booking_ID;
		}
		
    }
    
    public static String extractFileName(Part part) {//This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
    
    /**
	 * Get the IP address of the user.
	 * @param HttpServletRequest
	 * @param HttpServletResponse
	 * @return ip
	 */
	public static String getIP(HttpServletRequest request, HttpServletResponse res){
		String ip = request.getHeader("x-forwarded-for");
		
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("Proxy-Client-IP");
		}
		
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getHeader("WL-Proxy-Client-IP");
		}
		
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		ip = request.getRemoteAddr();
		}
		
		return ip;
	}
	
	public static String getToday(){
		Calendar now = Calendar.getInstance();   // Gets the current date and time
		String today="";
		int year = now.get(Calendar.YEAR); 
		int moth = now.get(Calendar.MONTH)+1;
		int date = now.get(Calendar.DATE);
		today = year+"-"+moth+"-"+date;
		return today;
	}
	
	public static Time getNowTime(){
		Calendar now = Calendar.getInstance();   // Gets the current date and time
		String time ="";
		int h = now.get(Calendar.HOUR);
		int m = now.get(Calendar.MINUTE);
		int s = now.get(Calendar.SECOND);
		//int p = now.get(Calendar.AM_PM);
		time = h+":"+m+":"+s;
		return ServletFunctions.strToTime(time);
	}
	
	/**
     * Get Professionals Info Objects to calling page
     * professionalBean , experienceBean , achievmentBean
     * @param request
     * @param response
     * @param user_id
     */
    public static void dispatchProfessionalInfo(HttpServletRequest request, HttpServletResponse response, String user_id){
    	
		UserBean user = new UserBean();
		user = QueryFactory.getUserQueries().selectquery(user_id);
		request.setAttribute("user", user);
		int sex = user.getGender();
		HashMap<Integer, String> hMap = new HashMap<Integer, String>();
        hMap.put(1, "Male");
        hMap.put(2, "Female");
        request.setAttribute("hMap", hMap);
    	
    	ProfessionalBean pBean = new ProfessionalBean();
		pBean = QueryFactory.getProfessionalQueries().selectQuery(user_id);
		request.setAttribute("professionalBean", pBean);
		
		PExperienceBean pExperienceBean = new PExperienceBean();
		pExperienceBean = QueryFactory.getExperienceQueries().selectQuery(user_id);
		request.setAttribute("experienceBean", pExperienceBean);
		//System.out.println(pExperienceBean.toString());
		
		AchievmentBean acBean = new AchievmentBean();
		acBean = QueryFactory.getAchievmentQueries().selectQuery(user_id);
		request.setAttribute("achievmentBean", acBean);
		
		EducationBean edBean = new EducationBean();
		edBean = QueryFactory.getEducationQueries().selectQuery(user_id);
		request.setAttribute("uniBean", edBean);
		
		ImageBean iBean = new ImageBean();
		iBean.setFilename(QueryFactory.getImageQueries().selectQuery(user_id));
		request.setAttribute("imageBean", iBean);
		
		List<RatingBean> ratebeans = new ArrayList<RatingBean>();
		System.out.println(user_id);
		ratebeans = QueryFactory.getRateQueries().selectQuery(user_id);
		request.setAttribute("rateList", ratebeans);
		System.out.println(ratebeans.toString());
    }

    /**
     * Dispatch Admin info :: logintbl 
     * @param request
     * @param response
     * @param user_id
     */
	public static void dispatchAdminInfo(HttpServletRequest request, HttpServletResponse response, String user_id) {
		UserBean user = new UserBean();
		user = QueryFactory.getUserQueries().selectquery(user_id);
		request.setAttribute("user", user);
	}    
    
    /**
     * Dispatch Client info :: logintbl & Clientstbl
     * @param request
     * @param response
     * @param user_id
     */
	public static void dispatchClientInfo(HttpServletRequest request, HttpServletResponse response, String user_id) {
		UserBean user = new UserBean();
		user = QueryFactory.getUserQueries().selectquery(user_id);
		request.setAttribute("user", user);
		
		ClientBean cBean = new ClientBean();
		cBean = QueryFactory.getClientQueries().selectQuery(user_id);	
		request.setAttribute("clientBean", cBean);
	} 
	
    /**
     * request.setAttribute(sList, List<SchedulerBean>);
     * use the sList to iterate through Schedules related to particular user_id 
     * @param request
     * @param response
     * @param user_id
     */
 public static void dispatchScheduleInfo(HttpServletRequest request, HttpServletResponse response, String user_id){
    	
		UserBean user = new UserBean();
		user = QueryFactory.getUserQueries().selectquery(user_id);
		request.setAttribute("user", user);
		
		
		
		SchedulerBean sBean = new SchedulerBean();
		sBean.setUser_id(user_id);
		sBean.setMonth(ServletFunctions.seperateDayMonthYear(getToday(),"month"));
		sBean.setYear(ServletFunctions.seperateDayMonthYear(getToday(),"year"));
		
		//DELETE SCHEDULES AND BOOKING DATA
		//WHICH ARE EXPIRED
		//<CURRENT_DATE
		QueryFactory.getSchedulerQueries().deleteQuery();
		QueryFactory.getBookingQueries().deleteQuery();
		
		List<SchedulerBean> sList = new ArrayList<SchedulerBean>();
		sList = QueryFactory.getSchedulerQueries().selectQuery(sBean);
		sList.toString();
		//for(SchedulerBean s:sList){
			//System.out.println(s.getUser_id());
			//System.out.println(s.getYear());
			//System.out.println(s.getTime_from());
		//}
		request.setAttribute("scheduleList", sList);
		
    }

 public static void dispatchBookingReport(HttpServletRequest request, HttpServletResponse response, String book_id){
	 BookingBean bkbn = new BookingBean();
	 bkbn = QueryFactory.getBookingQueries().selectQuery(book_id);
	 System.out.println(book_id);
	 System.out.println(bkbn.toString());
	 request.setAttribute("bookingrepot", bkbn);
 }
 
    public static void dispatchBookingInfo(HttpServletRequest request, HttpServletResponse response, String user_id){
    	ClientBean cBean =new ClientBean();
		cBean.setUser_id(user_id);
		//System.out.println(cBean.getUser_id());
		//uri = "mybooking.jsp";
		List<BookingBean> myBookings = new ArrayList<BookingBean>();
		myBookings = QueryFactory.getBookingQueries().selectQuery(cBean);
		///System.out.println("list");
		System.out.println(myBookings.toString());
		request.setAttribute("myBookings", myBookings);
		//RequestDispatcher rd = request.getRequestDispatcher(uri);
		//rd.forward(request, response);    	
    }

    public static void dispatchBookingInfoOfProfefessionals(HttpServletRequest request, HttpServletResponse response, String user_id){
    	ProfessionalBean pBean =new ProfessionalBean();
    	pBean.setUser_id(user_id);
		System.out.println(pBean.getUser_id());
		//uri = "mybooking.jsp";
		List<BookingBean> myBookings = new ArrayList<BookingBean>();
		myBookings = QueryFactory.getBookingQueries().selectQuery(pBean);
		//System.out.println("list" + myBookings.toString());
		System.out.println(myBookings.toString());
		request.setAttribute("myBookings", myBookings);
		//RequestDispatcher rd = request.getRequestDispatcher(uri);
		//rd.forward(request, response);    	
    }

	public static void dispatchLogsInfo(HttpServletRequest request, HttpServletResponse response) {
		
		List<TrackingBean> trackers = new ArrayList<TrackingBean>();
		trackers = QueryFactory.getTrackerQueries().selectQuery();
		//for(TrackingBean t:trackers){
		//	System.out.println(t.getUser_id());
		//	System.out.println(t.getIp());
		//}
		request.setAttribute("trackers", trackers);
		
	}

	public static void dispatchStatsInfo(HttpServletRequest request, HttpServletResponse response) {
		List<BookingBean> bBeans = new ArrayList<BookingBean>();
		bBeans = QueryFactory.getBookingQueries().selectQuery();
		//for(TrackingBean t:trackers){
		//	System.out.println(t.getUser_id());
		//	System.out.println(t.getIp());
		//}
		request.setAttribute("bookingBeans", bBeans);
	}   
	
	/**
	 * Dispatch ChatList relevent to professional_id and client_id FROM chattbl
	 * @param request
	 * @param response
	 */
	public static void dispatchChatList(HttpServletRequest request, HttpServletResponse response) {
		String professional_id ="";
		String client_id = "";
		professional_id = request.getParameter("prof_id");
		client_id = request.getParameter("client_id");
		//System.out.println(professional_id);System.out.println(client_id);
		MsgBean msgB = new MsgBean();
		msgB.setClient_id(client_id);
		msgB.setProfessional_id(professional_id);
		request.setAttribute("msgB", msgB);
		
		List<MsgBean> chatList = new ArrayList<MsgBean>();
		chatList = QueryFactory.getMsgQueries().selectQuery(professional_id, client_id);
		request.setAttribute("chatList", chatList);
	}  

	
	public static void dispatchChatListofProfessional(HttpServletRequest request, HttpServletResponse response) {
		String professional_id ="";
		String client_id = "";
		professional_id = request.getParameter("p_prof_id");
		client_id = request.getParameter("p_client_id");
		System.out.println(professional_id);System.out.println(client_id);
		MsgBean msgB = new MsgBean();
		msgB.setClient_id(client_id);
		msgB.setProfessional_id(professional_id);
		request.setAttribute("msgB", msgB);
		
		List<MsgBean> chatList = new ArrayList<MsgBean>();
		chatList = QueryFactory.getMsgQueries().selectQuery(professional_id, client_id);
		request.setAttribute("chatList", chatList);
	}	
	
	public static void dispatchchatJoinsForClient(HttpServletRequest request, HttpServletResponse response,String client_id){
		List<BookingBean> bookingBns = new ArrayList<BookingBean>();
		bookingBns = QueryFactory.getBookingQueries().selectChatJoinsForClients(client_id);
		request.setAttribute("chatJoiner", bookingBns);
	}
	
	public static void dispatchchatJoinsForProfessional(HttpServletRequest request, HttpServletResponse response,String professional_id){
		List<BookingBean> bookingBns = new ArrayList<BookingBean>();
		bookingBns = QueryFactory.getBookingQueries().selectChatJoinsForProfessionals(professional_id);
		//System.out.println(bookingBns.toString());
		request.setAttribute("chatJoiner", bookingBns);
	}
}
