	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
     <!-- Include Functions Tags -->
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
     <!-- Include SQL Tags -->
     <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page import="com.prs.utils.JspFunctions" %>

<%
/*
JspFunctions jspf = JspFunctions.getJspFunctionsClassInstance();
String user_id ="";
String client_name ="";

if(jspf.getSession(request, response)!=null  && jspf.showName(request, response)!=null && jspf.getSession(request, response)!=""  && jspf.showName(request, response)!=""){
 user_id = jspf.getSession(request, response);
 client_name = jspf.showName(request, response);
}
*/
%>

  <!--sTARTS hELP aREA-->
    <script src="js/jquery.min.js"></script> 
    <div class="helpclass">

<div class="content">
	<h1>Client Information</h1>
<!-- Container (Contact Infomation Section) -->
  <div class=" well well-sm ">      
	
      <div class="row ">
      <div class="col-sm-4"><p><span><i  class="fa fa-user"></i></span>&nbsp;Firstname:</p></div>
      <div class="col-md-6"><p>${user.getFirstname()}</p></div>
      </div>
      <hr>
      <div class="row">
      <div class="col-sm-4"><p><span><i  class="fa fa-user"></i></span>&nbsp;Lastname:</p></div>
      <div class="col-md-6"><p>${user.getLastname()}</p></div>
      </div>
      <hr>
      <div class="row">
      <div class="col-md-4"><p><span><i  class="fa fa-briefcase"></i></span>&nbsp;Address:</p></div>
      <div class="col-md-6"><p>${clientBean.getAddress()}</p></div>
      </div>
      <hr>
      <div class="row">
      <div class="col-md-4"><p><span><i  class="fa fa-phone"></i></span>&nbsp;Phone:</p></div>
      <div class="col-md-6"><p>${clientBean.getPhone()}</p></div>
      </div>
      <hr>
   </div>
   
   </div>
   
</div>
      