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
         <a href="www.twitter.com"><i class="social fa fa-twitter" area-hidden="true"></i></a>
         <a href="www.linkedin.com"><i class="social fa fa-linkedin" area-hidden="true"></i></a>
         <a href="www.youtube.com"><i class="social fa fa-youtube" area-hidden="true"></i></a>
         <a href="www.pinterest.com"><i class="social fa fa-pinterest" area-hidden="true"></i></a>
      </div>
    </div>
  </div>
</div>
<!--End Footer-->


    <script src="js/jquery.min.js"></script> 
    <script src="js/wow.min.js"></script>
      <script src="js/jquery-ui.js"></script>
	  <script src="js/pickDate.js"></script>
	  <script src="plugins/wickedpicker/js/wickedpicker.js"></script>
	  <script src="plugins/datatable/jquery.dataTables.min.js"></script>
	  <script src="plugins/datatable/dataTables.bootstrap.min.js"></script>
	  <script src="js/pickTime.js"></script>
	  <script src="plugins/htm2pdf/jspdf.js"></script>
	  <script src="plugins/htm2pdf/pdfFromHTML.js"></script>

	  
    <script>
      new WOW().init();
    </script>
    
    <script src="js/cover.js"></script> 
     
    <script src="js/bootstrap.min.js"></script>
     <script src="plugins/alertify/alertify.min.js"></script>
    
     
     
	<script>
		$(document).ready(function(){
		    $('[data-toggle="tooltip"]').tooltip();
		});
	</script>
	
	<script>
		$(document).ready(function() {
		    $('#dattable').DataTable();
		} );
	</script>

<script>
$(document).ready(function(){
	if(x==""){
	$("#myDIV").show();
	}else{
		$("#myDIV").hide();
	}
	});
</script>

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
    	
    	function Confirm_delete() {
    	 
    	    		alertify.confirm("Are You Sure You Want to Delete This", function (e) {
    	    		if (e) {
    	    	    	alertify.error("Ok");
    	    	    } else {
    	    	    	alertify.error("Cancel");
    	    	    }
    	    	    });
    	    }
    	  			
    	
</script>



</body>

</html>