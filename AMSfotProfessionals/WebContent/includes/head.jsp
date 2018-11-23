	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
     <!-- Include Functions Tags -->
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
     <!-- Include SQL Tags -->
     <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
     <%@page import="com.prs.utils.JspFunctions" %>
     <%
     JspFunctions singlejsp = JspFunctions.getJspFunctionsClassInstance();
     singlejsp.validateSession(request, response);
     %>
<!doctype html>
<html lang="en">
  <head>
    <title>Efuture.lk</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico">
<!-- Bootstrap CSS -->

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/dashboard.css">
<link rel="stylesheet" type="text/css" href="css/animate.css"> 
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="plugins/wickedpicker/styles/wickedpicker.css" />
<link rel="stylesheet" type="text/css" href="datatable/dataTables.bootstrap.min.css" />
<script src="js/jquery.min.js"></script> 
 <!--<link rel="stylesheet" type="text/css" href="plugins/alertify/alertify.bootstrap.css"> -->  
 <link rel="stylesheet" type="text/css" href="plugins/alertify/alertify.core.css"> 
 <link rel="stylesheet" type="text/css" href="plugins/alertify/alertify.default.css">
<!-- 
This var x is defined,
when showing seller profile,
if(x ="") its mean seller_profile is viewed by the client profile.jsp
if(x="x") its mean seller profile is viewed by other users, admin or professional.
in a_profile.jsp and p_profile.jsp pages, i set the value of x to "x".
 -->	
<script>
$(document).ready(function(){
	var x = "";
});
</script>    
	
    </head>
<body>