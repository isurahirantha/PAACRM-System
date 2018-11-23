<!doctype html>
<html lang="en">
  <head>
    <title>Hello, world!</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/dashboard.css">
    <link rel="stylesheet" type="text/css" href="css/animate.css"> 
    <link rel="stylesheet" type="text/css" href="css/inputcss.css"> 
    </head>
<body>
<%@ include file="/includes/dash-top-nav.jsp" %>


<!--The Main Area, sidenav middle are, helpclass Container-Fluid-->
<div class="container-fluid main-area ">    
<div class="row">

<%@ include file="/includes/client_dash_nav.jsp" %>

<!--Start Middle Area -->
<div class="col-sm-10 text-left"> 
<div class="container-fluid ">
 
<%@ include file="/includes/c_dash_rating.jsp" %>

</div><!--container fluid-->
</div><!--Ends Middle AREA col-sm-10-->


</div><!--Ends The Main Area Main Row-->
</div><!--Ends The Main Area, sidenav middle are, helpclass Container-Fluid-->

<%@ include file="/includes/dash-footer.jsp" %>