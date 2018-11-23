<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html><%@ include file="/includes/head.jsp" %>
<%@ include file="/includes/client-dash-top-nav.jsp" %>


<!--The Main Area, sidenav middle are, helpclass Container-Fluid-->
<div class="container-fluid main-area ">    
<div class="row">

<%@ include file="/includes/client_dash_nav.jsp" %>

<!--Start Middle Area -->
<div class="col-sm-10 text-left"> 
<div class="container-fluid ">
 
<%@ include file="/includes/c_dash_report.jsp" %>

</div><!--container fluid-->
</div><!--Ends Middle AREA col-sm-10-->


</div><!--Ends The Main Area Main Row-->
</div><!--Ends The Main Area, sidenav middle are, helpclass Container-Fluid-->

<%@ include file="/includes/dash-footer.jsp" %>