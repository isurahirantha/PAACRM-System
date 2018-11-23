<%@ page import="com.prs.utils.*" %>
<%
String message=null;
JspFunctions jspFunc = JspFunctions.getJspFunctionsClassInstance();
if(request.getParameter("loginCode")!=null){
	message = jspFunc.loginError(Integer.parseInt(request.getParameter("loginCode").toString()));
}else if(request.getParameter("resetCode")!=null){
	message = jspFunc.passwordResetError(Integer.parseInt(request.getParameter("resetCode").toString()));
}
%>
<!doctype html>
<html lang="en">
  <head>
    <title>AMS E-future.lk</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/animate.css">   
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico"> 
  </head>
  <body>
<div id="publicNav" class="navbar navbar-inverse navbar-fixed-top" role="navigation">
<div class="container-fluid">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a href="#" class="navbar-brand">E-Future.lk</a>
  </div>
  <div class="navbar-collapse collapse">
    <ul class="nav navbar-nav navbar-right">
      <li><a href="default.jsp">Home</a></li>
      <li><a href="default.jsp#features">Features</a></li>
      <li><a href="default.jsp#about">About</a></li>
      <li><a href="register.jsp">Sign-Up</a></li>     
    </ul>
  </div>
</div>
</div>
 
<!--HEADER-->


<div id="home" class="homepage-hero-module">

    <div class="video-container">

      <div class="filter">

<!--vid-->
<div class="container-fluid">
        <!--   start Login Error Model -->
<% if(message!=null){ %>
    <div class="col-lg-12 col-md-12 alert alert-warning wow bounceInTop text-center">
    		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	    	<strong>Hi! </strong> <%=message %>
	</div>
	<br>
<%} %>
  <!--   End Login Error Model -->
    <!--<div class="col-lg-6 col-md-6 filterText wow bounceInLeft">-->
    <div class="col-lg-6 col-md-6 filterText wow bounceInLeft">
      <h1 class="wow fadeInUp">E-Reservation Portal</h1>
      <p class="lead wow fadeInUp" data-wow-delay="0.4s">Easily Manage Your Appointments</p>
      <p class="wow fadeInUp" data-wow-delay="0.8s">E-Future services pvt ltd</p>
      <button class="btn btn-lg btn-primary" id="myBtn">Seller SignIn&nbsp;
      <i class="fa fa-user" aria-hidden="true"></i></button>
      <button class="btn btn-lg btn-success" id="myBtn2">Buyer SignIn&nbsp;
      <i class="fa fa-user" aria-hidden="true"></i></button>
    </div>

    <div class="col-lg-6 col-md-6 haha wow bounceInRight" >

      <h1 class="wow fadeInUp">Professionals</h1>
      <p class="lead wow fadeInUp" data-wow-delay="0.4s"><i class="fa fa-square-o" area-hidden="true"></i>&nbsp;Manage Appointments online</p>
      <p class="lead wow fadeInUp" data-wow-delay="0.4s"><i class="fa fa-square-o" area-hidden="true"></i>&nbsp;Scale-up Businesses</p>
    
      <h1 class="wow fadeInUp">Clients</h1>
      <p class="lead wow fadeInUp" data-wow-delay="0.4s""><i class="fa fa-square-o" area-hidden="true"></i>&nbsp;Book any professional at one place</p>
      <p class="lead wow fadeInUp" data-wow-delay="0.4s""><i class="fa fa-square-o" area-hidden="true"></i>&nbsp;Find the Best</p>      

    </div> 

</div>
<!--Vid-->
      </div>
       <video autoplay loop class="fillWidth">
            <source src="./video/bg/MP4/Sunset-Lapse.mp4" type="video/mp4" />Your browser does not support the video tag. I suggest you upgrade your browser.
            <source src="./video/bg/WEBM/Sunset-Lapse.webm" type="video/webm" />Your browser does not support the video tag. I suggest you upgrade your browser.
        </video>
        <div class="poster hidden">
            <img src="./video/bg/snapshots/Sunset-Lapse.jpg" alt="">
        </div>

    </div>

</div>