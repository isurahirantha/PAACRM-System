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
    <style>
    #wnote{
    color:yellow;
    font-size:20px;
  
    }
    #note{
    color:yellow;
    font-size:20px;
  
    }
    .wrong{
    display:none;
    }
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

          <div class="col-lg-1 col-md-1">
           
          </div>

<div class="col-lg-10 col-md-10">
        <div class="pass-reset-box">
              <h2>Reset Password:-Professionals</h2>
                <form role="form" action="./LoginController?action=change" method="post">

                    <div class="form-group">
                      <label for="email"><span class="fa fa-user"></span> Email</label>
                      <input type="email" class="form-control"  name="email" id="email" placeholder="email associates with this account">
                    </div>
                    <div class="form-group">
                      <label for="password"><span class="fa fa-key"></span>New Password</label>
                      <input type="password" class="form-control" id="password" name="password" placeholder="new password">
                    </div>
                    <div class="form-group">
                      <label for="password"><span class="fa fa-key"></span>Retype new Password</label>
                      <input type="password" class="form-control" id="veri_password" name="veri_password" placeholder="retype new password">
                      <span id="wnote" class="wrong">password not Matched&nbsp;<i class="fa fa-times"></i></span>
                      <span id="note" class ="ok">password Matched&nbsp;<i class="fa fa-check"></i></span>
                    </div>
                      <button type="submit" id="submit" class="btn btn-primary btn-block"><i class="fa fa-sign-in" aria-hidden="true"></i> Recover My Password</button>
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
    <script type="text/javascript">
    $(document).ready(function(){
    	
    	if($('#password').val()=='' || $('#veri_password').val()==''){
			//$('#wnote').addClass('wrong');
			//$('#note').addClass('ok');
			$("#submit").attr("disabled", "disabled");	
		}
    	
    	$("#submit").attr("disabled", "disabled");
    	$('#veri_password').keyup(function(){
    		

    		
    		var x = $('#veri_password').val();
    		var y = $('#password').val();
    		
    		//alert(x+""+y);
    		if(y==x){
    			$('#note').removeClass('ok');
    			$('#wnote').addClass('wrong');
    			$("#submit").removeAttr("disabled");
    		}else if(y!=x){
    			$('#wnote').removeClass('wrong');
    			$('#note').addClass('ok');
    			$("#submit").attr("disabled", "disabled");
    		}else{
    			$('#note').addClass('ok');
    			$('#wnote').addClass('wrong');
    			$("#submit").attr("disabled", "disabled");
    		}
    	});
    	$('#password').keyup(function(){
    		var x = $('#veri_password').val();
    		var y = $('#password').val();
    		//alert(x+""+y);
    		if(y==x){
    			$('#note').removeClass('ok');
    			$('#wnote').addClass('wrong');
    			$("#submit").removeAttr("disabled");
    		}else if(y!=x){
    			$('#wnote').removeClass('wrong');
    			$('#note').addClass('ok');
    			$("#submit").attr("disabled", "disabled");
    		}else{
    			$('#note').addClass('ok');
    			$('#wnote').addClass('wrong');
    			$("#submit").attr("disabled", "disabled");
    		}
    		
    		if(jQuery.trim($('#password').val())=='' || jQuery.trim($('#veri_password').val())==''){
    			$('#wnote').addClass('wrong');
    			$('#note').addClass('ok');
    			$("#submit").attr("disabled", "disabled");	
    		}
    		
    	});
    });
    </script>
  </body>
</html>