<%@ page import="com.prs.utils.*" %>
<%
String message=null;
JspFunctions jspFunc = JspFunctions.getJspFunctionsClassInstance();
if(request.getParameter("update_code")!=null){
	message = jspFunc.updateError(Integer.parseInt(request.getParameter("update_code").toString()));
}
%>
<%@ include file="/includes/head.jsp" %>
<%@ include file="/includes/client-dash-top-nav.jsp" %>


<!--The Main Area, sidenav middle are, helpclass Container-Fluid-->
<div class="container-fluid main-area ">    
<div class="row">

<%@ include file="/includes/client_dash_nav.jsp" %>

<!--Start Middle Area -->
<div class="col-sm-10 text-left"> 
<div class="container-fluid ">

        <!--   start Login Error Model -->
<% if(message!=null){ %>
    <div class="col-lg-12 col-md-12 alert alert-info wow bounceInTop text-center" 
    style="margin-top:2px;margin-bottom:0px;background-color:rgb(254, 236, 44);"
    >
    		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	    	<strong>Hi! </strong> <%=message %>
	</div>
	<br>
<%} %>
  <!--   End Login Error Model -->
<%@ include file="/includes/buyer-profile-edit.jsp" %>


</div><!--container fluid-->
</div><!--Ends Middle AREA, Content Area col-sm-10-->


</div><!--Ends The Main Area Main Row-->
</div><!--Ends The Main Area, sidenav middle are, Everything Container-Fluid-->



<%@ include file="/includes/dash-footer.jsp" %>
