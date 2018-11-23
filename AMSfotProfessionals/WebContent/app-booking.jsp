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
    </head>
<body>

<nav class="navbar navbar-inverse">
<div class="container-fluid">

    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
        </button>
      <a class="navbar-brand" href="dashboard-p.html">E-FUTURE.LK</a>
    </div>

    <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
            <li><a href="sellersapp.html" data-toggle="tooltip" data-placement="bottom" title="Home"><span><i class="fa fa-home"></i></span></a></li>
            
            <li><a href="scheduleapp.html" data-toggle="tooltip" data-placement="bottom" title="Schedule"><span><i class="fa fa-pencil-square-o"></i></span></a></li>

            <li><a href="#" data-toggle="tooltip" data-placement="bottom" title="Notification"><span><i class="fa fa-bell"></i></span></a></li>
            
            <li><a href="#" data-toggle="tooltip" data-placement="bottom" title="Messages" ><span><i  class="fa fa-inbox"></i></span></a></li>

            <li><a href="search.html" data-toggle="tooltip" data-placement="bottom" title="Booking"  ><span><i  class="fa fa-calendar-plus-o"></i></span></a></li>
            <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">User <span class="caret"></span></a>
                <ul class="dropdown-menu">
                <li><a href="seller-profile-edit.html"><span class="fa fa-cog"></span>&nbsp;&nbsp;Account settting</a></li>
                <li><a href="#"><span class="fa fa-sign-out"></span>&nbsp;&nbsp;Logout</a></li>
                </ul>
            </li>
            </ul>
    </div>
</div><!--End container fluid-->
</nav><!--End navbar-->

<!--The Main Area, sidenav middle are, helpclass Container-Fluid-->
<div class="container-fluid main-area ">    
<div class="row">

<!--Side Nav-->
    <div class="col-sm-2 sidenav leftNav">
      <p class="dash"><a href="#"><i class="fa fa-dashboard (alias)" area-hidden="true"></i>&nbsp;DashBoard</a></p>
      <p><a href="#"><i class="fa fa-calendar-check-o" area-hidden="true"></i>&nbsp;Schedule Month</a></p>
      <p><a href="#"><i class="fa fa-calendar-plus-o" area-hidden="true"></i>&nbsp;Manage Bookings</a></p>
      <p><a href="#"><i class="fa fa-inbox" area-hidden="true"></i>&nbsp;Messages</a></p>
      <p><a href="#"><i class="fa fa-bar-chart" area-hidden="true"></i>&nbsp;Statistics</a></p>
    </div>
<!--End Left Side Nav -->

<!--Start Middle Area -->
<div class="col-sm-10 text-left"> 
<div class="container-fluid ">

  <!--sTARTS hELP aREA-->
    <div class="helpclass">
        <div class="content">
          <h1>APPOINTMENTS MANAGEMENT SYSTEM</h1>
          <h3>Schedule Your Works</h3>
          <div class="row">
            <div class="col-md-8 col-sm-8">  
            <form action="./Sapp" method="post">                       
            <table class="table table-striped">
                <thead>
                  <tr>
                    <th>Date</th>
                    <th>From</th>
                    <th>To</th>
                    <th>Seats</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td><label class="checkbox-inline"><input type="checkbox" value="">2018-01-01</label></td>
                    <td><input type="time" name="date"></td>
                    <td><input type="time" name="date"></td>
                    <td><input type="text" name="seats"></td>
                  </tr>
                  <tr>
                    <td><label class="checkbox-inline"><input type="checkbox" value="">2018-01-02</label></td>
                    <td><input type="time" name="date"></td>
                    <td><input type="time" name="date"></td>
                    <td><input type="text" name="seats"></td>
                  </tr>
                  <tr>
                    <td><label class="checkbox-inline"><input type="checkbox" value="">2018-01-03</label></td>
                    <td><input type="time" name="date"></td>
                    <td><input type="time" name="date"></td>
                    <td><input type="text" name="seats"></td>
                  </tr>
                </tbody>
              </table>
              <input type="submit" name="save" value="Save" class="btn">
              </form>
            </div>
            <div class="col-md-4 col-sm-4"></div>
          </div>

          

      </div><!--content-->
  </div><!--eNDS hELP aREA-->

</div><!--container fluid-->
</div><!--Ends Middle AREA col-sm-10-->


</div><!--Ends The Main Area Main Row-->
</div><!--Ends The Main Area, sidenav middle are, helpclass Container-Fluid-->

<!--Footer-->
<div id="footer" class="footer">
  <div id="" class="container">
    <div id="row" class="row">
      <div id="" class="col-lg-4 col-md-4">
        <h4>Contact Us</h4>
        <p><i class="fa fa-home" area-hidden="true"></i>&nbsp;114 Main Street, Kegalle, #71236</p>
        <p><i class="fa fa-envelope" area-hidden="true"></i>&nbsp;info.ereservation@efuture.lk</p>
        <p><i class="fa fa-phone" area-hidden="true"></i>&nbsp;+940712850590</p>
        <p><i class="fa fa-globe" area-hidden="true"></i>&nbsp;www.efuture.lk</p>
      </div>
      <div id="" class="col-lg-4 col-md-4">
        <h4>About</h4>
        <p><i class="fa fa-square-o" area-hidden="true"></i>&nbsp;About Us</p>
        <p><i class="fa fa-square-o" area-hidden="true"></i>&nbsp;Privacy</p>
        <p><i class="fa fa-square-o" area-hidden="true"></i>&nbsp;Terms & Conditions</p>
      </div>
      <div id="" class="col-lg-4 col-md-4">
        <h4>Stay in Touch</h4>
        <a href="www.facebook.com"><i class="social fa fa-facebook" area-hidden="true"></i></a>
        <i class="social fa fa-twitter" area-hidden="true"></i>
        <i class="social fa fa-linkedin" area-hidden="true"></i>
        <i class="social fa fa-youtube" area-hidden="true"></i>
        <i class="social fa fa-pinterest" area-hidden="true"></i>
      </div>
    </div>
  </div>
</div>
<!--End Footer-->


    <script src="js/jquery.min.js"></script> 
    <script src="js/wow.min.js"></script>
    <script>
      new WOW().init();
    </script>
    <script src="js/cover.js"></script>  
    <script src="js/bootstrap.min.js"></script>
</body>

</html>
