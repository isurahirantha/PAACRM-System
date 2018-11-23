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
import com.prs.model.RatingBean;
import com.prs.utils.ServletFunctions;

/**
 * Servlet implementation class RateController
 */
@WebServlet("/RateController")
public class RateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    String professional_id ="";
    String client_id ="";
    String client_name ="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(request.getAttribute("User-ID")==""){
	response.sendRedirect("default.jsp");
	}else
	{
		//CODES HERE
		if(request.getParameter("prof_id")!=null && request.getParameter("client_id")!=null){
			 RatingBean ratebean = new RatingBean();
			 
			 professional_id = request.getParameter("prof_id");
			 client_id = request.getParameter("client_id");
			 
			 ratebean.setBuyer_id(client_id);
			 ratebean.setProfessionals_id(professional_id);
			 ratebean.setBuyer_name(request.getParameter("client_name"));
			 
			 request.setAttribute("raterinfo", ratebean);
			 RequestDispatcher rd = request.getRequestDispatcher("rating.jsp");
			 rd.forward(request, response);
		}
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//prof_id=${raterinfo.getProfessionals_id()}&cl_id=${raterinfo.getBuyer_id()}&cl_n=${raterinfo.getBuyer_name()}
		if(request.getParameter("prof_id")!=null && request.getParameter("cl_id")!=null && request.getParameter("cl_n")!=null){
			professional_id = request.getParameter("prof_id");
			client_id = request.getParameter("cl_id");
			client_name = request.getParameter("cl_n");
			RatingBean rBean = new RatingBean();
			rBean.setBuyer_id(client_id);
			rBean.setBuyer_name(client_name);
			rBean.setProfessionals_id(professional_id);
			rBean.setRate(Integer.parseInt(request.getParameter("rate")));
			rBean.setReview(request.getParameter("comment"));
			//System.out.println(rBean.toString());
			int numOfRows = 0;
			numOfRows = QueryFactory.getRateQueries().insertQuery(rBean);
			if(numOfRows==1){
			ServletFunctions.dispatchProfessionalInfo(request, response, rBean.getProfessionals_id());
			RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
			rd.forward(request, response);
			}
		}
	}

}
