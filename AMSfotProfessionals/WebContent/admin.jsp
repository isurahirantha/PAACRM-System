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

	  <!--<link rel="stylesheet" type="text/css" href="plugins/alertify/alertify.bootstrap.css"> -->  
    <link rel="stylesheet" type="text/css" href="plugins/alertify/alertify.core.css"> 
    <link rel="stylesheet" type="text/css" href="plugins/alertify/alertify.default.css">
      
  
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
    <a href="default.jsp" class="navbar-brand">E-Future.lk</a>
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

          <div class="col-lg-1 col-md-1">
           
          </div>

<div class="col-lg-10 col-md-10">
        <div class="pass-reset-box">
              <h2>Administrator Login</h2>
                <form role="form" action="./LoginController?action=admin" method="post" id="admin-login">

                    <div class="form-group">
                      <label for="email"><span class="fa fa-user"></span> Email</label>
                      <input type="email" class="form-control"  name="email" id="email" placeholder="email associates with this account" required>
                    </div>
                    <div class="form-group">
                      <label for="password"><span class="fa fa-key"></span>Password</label>
                      <input type="password" class="form-control" id="password" name="password" required>
                    </div>
                      <button type="submit" id="submit" class="btn btn-primary btn-block" onclick="return validateForm()"><i class="fa fa-sign-in" aria-hidden="true"></i> Login </button>
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
    <script src="js/cover.js"></script>  
    <script src="js/bootstrap.min.js"></script>
    <script src="plugins/alertify/alertify.min.js"></script>
    <script type="text/javascript">
    	function validateForm() {
    	    var x = document.forms["admin-login"]["email"].value;
    	    var y = document.forms["admin-login"]["password"].value;
    	    var msg=null;
    	    var atpos = x.indexOf("@");
    	    var dotpos = x.lastIndexOf(".");
    	    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length || y == "") {
    	    	alertify.alert("Email address or the password field is incorrect..!");
    	    	//return false;
    	    		//alertify.confirm("Email address or the password field is incorrect..!", function (e) {
    	    		//if (e) {
    	    	    //	alertify.error("Enter Valid Info");
    	    	    // } else {
    	    	    //	alertify.error("Enter Valid Info");
    	    	    //}
    	    	    //});
    	    }
    	}	
    </script>
  </body>
</html>