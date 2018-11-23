<%@ include file="includes/public/home_head.jsp" %>
<!--ENDING HEADER-->



<!--Start Login Model seller-->
<div class="modal fade" id="sellerLoginModal" role="dialog" style="margin-top:40px;">
<div class="modal-dialog">
<div class="modal-content">

        <div class="modal-header" style="text-align: center">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <img src="images/login.gif" width="100px" height="100px" >
          <h1>APPOINTMENTS MANAGEMENT SYSTEM</h1>
          <p class="lead">Seller Login here !</p>
        </div>

        <div class="modal-body" style="padding:20px 30px;">
        
        <form role="form" action="./LoginController?action=login" method="post">

            <div class="form-group">
              <label for="userid"><span class="fa fa-user"></span> Username /Email</label>
              <input type="text" name="email" class="form-control" id="userid" placeholder="user id">
            </div>
            <div class="form-group">
              <label for="password"><span class="fa fa-key"></span> Password</label>
              <input type="password" name="password" class="form-control" id="password" placeholder="user password">
            </div>
            <div class="form-group" hidden="hidden">
              <label for="usertype" ><span class="fa fa-user"></span> Username /Email</label>
              <input type="text" name="usertype" class="form-control" id="usertype" value="seller" placeholder="usertype">
            </div>
            <div class="checkbox">
              <label><input type="checkbox" value="" checked>Remember me</label>
            </div>
              <button type="submit" class="btn btn-primary btn-block"><i class="fa fa-sign-in" aria-hidden="true"></i> Login</button>
              <a href="register.jsp" class="btn btn-success btn-block"><i class="fa fa-user-plus" aria-hidden="true"></i>&nbsp;Register</a>
        </form>
        
        </div>

        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
          <span class="fa fa-remove"></span> Cancel
          </button>
          <p>Forgot <a href="reset-prop.jsp" target="_blank">Password?</a></p>
        </div>

</div>
</div>
</div><!--Ends Login Model seller--> 

<!--Start Login Model buyer-->
<div class="modal fade" id="buyerLoginModal" role="dialog" style="margin-top:40px;">
<div class="modal-dialog">
<div class="modal-content">

        <div class="modal-header" >
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <img src="images/login.gif" width="100px" height="100px">
          <h1>BOOK ANY PROFESSIONALS AT ONE PLACE</h1>
          <p class="lead">Buyer Login Here!</p>
        </div>

        <div class="modal-body" style="padding:20px 30px;">
        
        <form role="form" action="./LoginController?action=login" method="post">  
            <div class="form-group">
              <label for="userid"><span class="fa fa-user"></span> Username /Email</label>
              <input type="text" name="email" class="form-control" id="userid" placeholder="user id">
            </div>
            <div class="form-group">
              <label for="password"><span class="fa fa-key"></span> Password</label>
              <input type="password" name="password" class="form-control" id="password" placeholder="user password">
            </div>
            <div class="form-group" hidden="hidden">
              <label for="usertype" ><span class="fa fa-user"></span> Usernam /Email</label>
              <input type="text" name="usertype" class="form-control" id="usertype" value="buyer" placeholder="usertype">
            </div>
            <div class="checkbox">
              <label><input type="checkbox" value="" checked>Remember me</label>
            </div>
              <button type="submit" class="btn btn-primary btn-block"><i class="fa fa-sign-in" aria-hidden="true"></i> Login</button>
              <a href="register.jsp" class="btn btn-success btn-block"><i class="fa fa-user-plus" aria-hidden="true"></i>&nbsp;Register</a>
        </form>
        
        </div>

        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
          <span class="fa fa-remove"></span> Cancel
          </button>
          <p>Forgot <a href="reset-user.jsp" target="_blank">Password?</a></p>
        </div>

</div>
</div>
</div><!--Ends Login Model buyer--> 

<!--SERVICES-->
<div id="features" class="services">
  <div class="container">
  <h1  class="wow fadeInUp">FEATURES</h1>
  <p class="wow fadeInUp" data-wow-delay="0.4s">These are the unique features we offer!</p>
  <div class="row">
    <div class="col-lg-3 col-md-3 wow fadeInLeft" data-wow-delay="1.8s">
        <i class="fa fa-star-o" aria-hidden="true"></i>
        <h4>RATED PROFESSIONALS</h4>
        <p>Users who get the service will rate Professionals. It will be easy to find the best.!</p>
    </div>
     <div class="col-lg-3 col-md-3  wow fadeInLeft" data-wow-delay="1.4s">
        <i class="fa fa-bullhorn" aria-hidden="true"></i>
        <h4>ALERT SYSTEM</h4>
        <p>Email to remind booking</p>
     </div>
      <div class="col-lg-3 col-md-3  wow fadeInLeft" data-wow-delay="0.8s">
        <i class="fa fa-comments-o" aria-hidden="true"></i>
        <h4>MESSAGE SYSTEM</h4>
        <p>Simple message system to communicate</p>        
      </div>
       <div class="col-lg-3 col-md-3  wow fadeInLeft" data-wow-delay="0.4s">
        <i class="fa fa-users" aria-hidden="true"></i>
        <h4>ALL IN ONE</h4>
        <p>Many kind of professionnals for your service at our website</p>         
       </div>
  </div>
  </div>
</div>
<!--ENDING SERVICES-->

<!--PROCESS-->
<div id="about" class="pricing">
<div class="container">
  <div class="row">
    <h1  class="wow fadeInUp">About</h1>
    <p class="wow fadeInUp" data-wow-delay="0.4s">Let us help you to meet your own necessaries in the best possible way. With over a better experience, we have learnt what's best for your needs and what's not</p>
<div class="container">
      <div class="col-md-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="300ms" >
        <h2>About us</h2>
        <img src="images/aboutt.png" class="img-responsive"/>
        
      </div>
      
      <div class="col-md-6 wow fadeInDown" data-wow-duration="1000ms" data-wow-delay="600ms" >
        <h2>Welcome to E-Future Services</h2>
        <p> Use our in depth expertise to your advantage. 
        We have the expertise to help you to deal with your daily needs.
        We can provide you with the support that you need to deal with the challenges that
        you will encounter on the road to successfully managing your daily needs.
        Make use of our all services and we've had the pleasure of serving a variety of professionals. 
        <p>There is a better online platform available for both clients and customers which is an array
         of solutions out there and sometimes the options can be overwhelming.
          The technologies we use have been chosen based on what we have recognized
           as more powerful in terms of <mark> compatibility, scalability, performance, ease of use, and most importantly, cost effectiveness.</mark></p>
     
      </div>
    </div>

  </div>
</div>
</div>
<!--ENDING PRICE-->



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




    <script src="js/jquery.min.js"></script> 
    <script src="js/wow.min.js"></script>
    <script>
      new WOW().init();
    </script>
    <script src="js/cover.js"></script>  
    <script src="js/bootstrap.min.js"></script>
    <script>
    $(document).ready(function(){
    $("#myBtn").click(function(){
    $("#sellerLoginModal").modal();
    });
    $("#myBtn2").click(function(){
    $("#buyerLoginModal").modal();
    });    
    });
    </script>
  </body>
</html>