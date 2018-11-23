	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
     <!-- Include Functions Tags -->
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
     <!-- Include SQL Tags -->
     <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page import="com.prs.utils.JspFunctions" %>

<%
JspFunctions jspf = JspFunctions.getJspFunctionsClassInstance();
String user_id ="";
String client_name ="";

if(jspf.getSession(request, response)!=null  && jspf.showName(request, response)!=null && jspf.getSession(request, response)!=""  && jspf.showName(request, response)!=""){
 user_id = jspf.getSession(request, response);
 client_name = jspf.showName(request, response);
}
%>

  <!--sTARTS hELP aREA-->
    <script src="js/jquery.min.js"></script> 
    <div class="helpclass">

<div class="content">

<div class="container-fliud wow fadeInUp">
<!-- 
Jubotron profile with picture name description
--> 
  <div class="jumbotron text-center">
    <img src=".\//${imageBean.getFilename()}" class="img-circle" alt="${imageBean.getFilename()}">
    <p>My Name Is</p>
    <h2>${professionalBean.getFirstname()}  ${professionalBean.getLastname()}</h2>
    <blockquote>
  	 ${professionalBean.getHeadLine()}        
    </blockquote>
  </div><!--Ends Jumbotron-->

<!--
RateMe Button Area Starts
-->


<div class="well well-sm">
  <div class="row" id="myDIV">    
   	  <div class="col-sm-1"></div>
      <div class="col-sm-5">
      <a href="./ScheduleController?u_id=${professionalBean.getUser_id()}" class="btn btn-danger btn-block" id="disable_link"> Book Me</a>
      </div>
      <div class="col-sm-5">
      <a href="./RateController?prof_id=${professionalBean.getUser_id()}&client_name=<%=client_name%>&client_id=<%=user_id%>" class="btn btn-primary btn-block" > Rate Me</a>
      </div>
  </div><!--Rateme Button area Ends-->
</div>

<!-- Container (Contact Infomation Section) -->
  <div class=" well well-sm ">      

      <div class="row ">
      <div class="col-sm-4"><p><span><i  class="fa fa-user"></i></span>Firstname:</p></div>
      <div class="col-md-6"><p>${professionalBean.getFirstname()}</p></div>
      </div>
      <div class="row">
      <div class="col-sm-4"><p><span><i  class="fa fa-user"></i></span>Lastname:</p></div>
      <div class="col-md-6"><p>${professionalBean.getLastname()}</p></div>
      </div>
      <div class="row">
      <div class="col-md-4"><p><span><i  class="fa fa-briefcase"></i></span>Profession:</p></div>
      <div class="col-md-6"><p>${professionalBean.getProfession()}</p></div>
      </div>
      <div class="row">
      <div class="col-sm-4"><p><span><i  class="fa fa-tags"></i></span>Experience:</p></div>
	      <div class="col-md-6">
	      <p><b>Experienced Aria :- </b>${experienceBean.getAria()} </p>
	      <p><b>Experienced Place :- </b>${experienceBean.getPlace()} </p>
	      <p><b>Experienced From :- </b>${experienceBean.getFrom_date()} </p>
	      <p><b>Experienced To :- </b>${experienceBean.getTo_date()} </p>
	      </div>
      </div>
      <div class="row">
      <div class="col-sm-4"><p><span><i  class="fa fa-university"></i></span>Education:</p></div>
	      <div class="col-md-6">
	      <p><b>Degree :- </b>${uniBean.getDegree()}</p>
	      <p><b>University :- </b>${uniBean.getName()}</p>
	      <p><b>From :- </b>${uniBean.getFromTime()} </p>
	      <p><b>To :- </b>${uniBean.getToTime()} </p>
	      </div>
      </div>
      <div class="row">
      <div class="col-sm-4"><p><span><i  class="fa fa-trophy"></i></span>Accomplishments:</p></div>
	      <div class="col-md-6">
	      	  <p><b>Institute :- </b>${achievmentBean.getInstitute()}</p>
		      <p><b>Title :- </b>${achievmentBean.getTitle()}</p>
		      <p><b>From :- </b>${achievmentBean.getDuedate()}</p>
	      </div>
      </div>
      <div class="row">
      <div class="col-sm-4"><p><span><i  class="fa fa-phone"></i></span>Phone:</p></div>
      <div class="col-md-6"><p>${professionalBean.getPhone()}</p></div>
      </div>
      <div class="row">
      <div class="col-sm-4"><p><span><i  class="fa fa-envelope"></i></span>Email Address:</p></div>
      <div class="col-md-6"><p>${user.getEmail()}</p></div>
      </div>
      <div class="row">
      <div class="col-sm-4"><p><span><i  class="fa fa-road"></i></span>Address:</p></div>
	      <div class="col-md-6">
		      <address>
		      ${professionalBean.getAddress()}
		      </address>   
	      </div>
    </div>
  </div><!--Contact information area Ends-->
  </div>


</div>
         
         
<div class="content">

<div class=" well well-sm">
<h1>Customer Testimonials & Ratings</h1>
<hr>
<c:forEach items="${rateList}" var="rating">
<!-- 
		this.auto_id = auto_id;
		this.professionals_id = professionals_id;
		this.buyer_id = buyer_id;
		this.buyer_name = buyer_name;
		this.rate = rate;
		this.review = review;
 -->
 
<div class="media">
  <div class="media-left">
    <img src="./images/user.png" class="media-object" style="width:45px;height: 45px;">
  </div>
<div class="media-body">
  <h4 class="media-heading">${rating.buyer_name}</h4>
 
    <p>
    <b>${rating.review}</b>
    </p>
 
<c:choose>
<c:when test="${rating.rate == 1}">
			 <span class="badge badge-pill">I offered ${rating.rate}&nbsp;<i class="fa fa-star"></i></span>
</c:when>
<c:when test="${rating.rate == 2}">
			 <span class="badge badge-pill">I offered ${rating.rate}&nbsp;<i class="fa fa-star"></i><i class="fa fa-star"></i></span>
</c:when>
<c:when test="${rating.rate == 3}">
			 <span class="badge badge-pill">I offered ${rating.rate}&nbsp;<i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></span>
</c:when>
<c:when test="${rating.rate == 4}">
			 <span class="badge badge-pill">I offered ${rating.rate}&nbsp;<i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></span>
</c:when>
<c:when test="${rating.rate == 5}">
			 <span class="badge badge-pill">I offered ${rating.rate}&nbsp;<i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></span>
</c:when>
</c:choose>
    
    
</div>
</div> 
    <hr/>

</c:forEach>

</div><!--Ends Media container-->
     
</div><!--content-->
  </div><!--eNDS hELP aREA-->
  