<%@ include file="/includes/head.jsp" %>
<%@ include file="/includes/admin-dash-top-nav.jsp" %>


<!--The Main Area, sidenav middle are, helpclass Container-Fluid-->
<div class="container-fluid main-area ">    
<div class="row">

<%@ include file="/includes/admin-dash-side-nav.jsp" %>

<!--Start Middle Area -->
<div class="col-sm-10 text-left"> 
<div class="container-fluid ">
<script>
$(document).ready(function(){
	x = "x";
	
});
</script> 
<%@ include file="/includes/seller_profile.jsp" %>

</div><!--container fluid-->
</div><!--Ends Middle AREA col-sm-10-->


</div><!--Ends The Main Area Main Row-->
</div><!--Ends The Main Area, sidenav middle are, helpclass Container-Fluid-->

<%@ include file="/includes/dash-footer.jsp" %>