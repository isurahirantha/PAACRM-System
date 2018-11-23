<%@ page import="com.prs.utils.*" %>
<%
String message=null;
JspFunctions jspFunc = JspFunctions.getJspFunctionsClassInstance();
if(request.getParameter("code")!=null){
	message = jspFunc.loginError(Integer.parseInt(request.getParameter("code").toString()));
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
    <style type="text/css">
    .ok{
    display:none;
    }
    </style>   
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
      <li><a href="default.jsp#about.html">About</a></li>
      <li><a href="register.jsp">Sign-Up</a></li>      
    </ul>
  </div>
</div>
</div>
 
<!--HEADER-->

<div id="header" class="header">

<div class="homepage-hero-module">

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

          <div class="col-lg-1 col-md-1">
           
          </div>

<div class="col-lg-10 col-md-10">
        <div class="register-box">
          <h1>Register Here</h1>
          <form class="form-horizontal" action="./RegisterController" method="POST">

            <div class="form-group">
            <label for="firstname" class="col-lg-3 col-md-3 control-label">First Name: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                      <span class="input-group-addon"><i class="fa fa-user"></i></span>
                      <input type="text" name="firstname" class="form-control" placeholder="First Name" id="fname"
                      title="First Name" data-toggle="pop" data-content="Important" data-placement="top" data-trigger="focus"
                      >
                </div>                                      
            </div>
            </div>

            <div class="form-group">
            <label for="lastname" class="col-lg-3 col-md-3 control-label">Last Name: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" name="lastname" class="form-control" placeholder="Last Name" id="lname"
                    title="Last Name" data-toggle="pop" data-content="Important" data-placement="top" data-trigger="focus">
                </div>                                      
            </div>
            </div>          

            <div class="form-group">
            <label for="email" class="col-lg-3 col-md-3 control-label">Email Address: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                    <input type="text" name="email" class="form-control" placeholder="Email Address" id="email"
                    title="Email" data-toggle="pop" data-content="Email will use as Username" data-placement="top" data-trigger="focus">
                </div>                                      
            </div>
            </div> 

            <div class="form-group">
            <label for="password" class="col-lg-3 col-md-3 control-label">Password: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-key"></i></span>
                    <input type="password" name="password" class="form-control" id="password"
                    title="Password" data-toggle="pop" data-content="Strong password with less than 8 characters long" data-placement="top" data-trigger="focus">
                </div>                                      
            </div>
            </div> 

            <div class="form-group">
            <label for="usertype" class="col-lg-3 col-md-3 control-label">User Type: </label>
            <div class="col-lg-9 col-md-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <select class="form-control" name="usertype" title="User Type!" data-toggle="pop" data-content="If you here to book a professional then select I am a Buyer.
                                        If You here to Manage your Appointments and Sell your Services then select I am a Seller" data-placement="top" data-trigger="focus">
                                        <option value="seller">I am a Seller</option>
                                        <option value="buyer">I am a Buyer</option>
                                        </select>
                                    </div> 
            <span id="note" class ="ok"></span>                                                           
            </div>
            </div>


            <input type="submit" id="submit" name="Register-user" class="btn btn-primary btn-block" value="REGISTER">
          </form>
        </div>        
</div>

          <div class="col-lg-1 col-md-1">
            
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



</div>
<!--ENDING HEADER-->




    <script src="js/jquery.min.js"></script> 
    <script src="js/wow.min.js"></script>
    <script>
      new WOW().init();
    </script>
    <script src="js/cover.js"></script>  
    <script src="js/bootstrap.min.js"></script>

  <script>
  $(document).ready(function(){
      $('[data-toggle="pop"]').popover();   
  });
  </script>

<script>
$(document).ready(function(){
	
	
	
});
	

</script>

  </body>
</html>