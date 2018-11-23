  <!--sTARTS hELP aREA-->
    <div class="helpclass">
        
        <div class="col-md-2 col-sm-2"></div>
        
		<div class="report col-md-8 col-sm-8" id="report">
			
			<article class="card bg-info text-white container-fluid ">
			
				<header class="page-header text-center">
					<h2>Efuture.lk</h2>
					<h3>Booking Card</h3>
				</header>
				
				<div class="card-body text-justify">
				<div class ="row">
					
					
<table class="table table-striped table-bordered" cellspacing="0" width="100%">
<tr>
<td><p class="text-uppercase text-warning">Professional name:</p></td>
<td><p class="text-warning">${bookingrepot.getProfessional_name()}</p></td>
</tr>
<tr>
<td><p class="text-uppercase text-success">Client name:</p></td>
<td><p class="text-success ">${bookingrepot.getClient_name()}</p></td>
</tr>
<tr>
<td><p class=" text-uppercase text-warning">Code:</p></td>
<td><p class="text-warning">${bookingrepot.getRandom_code()}</p></td>
</tr>
<tr>
<td><p class="text-uppercase text-success">Date:</p></td>
<td><p class="text-success">${bookingrepot.getDate_booked()}</p></td>
</tr>
<tr>
<td><p class="text-uppercase text-warning">Time From:</p></td>
<td><p class="text-warning">${bookingrepot.getTime_from()}</p></td>
</tr>
<tr>
<td><p class="text-uppercase text-success">Time To:</p></td>
<td><p class="text-success">${bookingrepot.getTime_to()}</p></td>
</tr>
</table>
					
				</div>
				</div>
				<hr>
				<footer class="card-footer text-center ">
					<p class="small"><i class="fa fa-home" area-hidden="true"></i>&nbsp;114 Main Street, Kegalle, #71236</p>
			        <p class="small"><i class="fa fa-envelope" area-hidden="true"></i>&nbsp;info.ereservation@efuture.lk</p>
			        <p class="small"><i class="fa fa-phone" area-hidden="true"></i>&nbsp;+940712850590</p>
			        <p class="small"><i class="fa fa-globe" area-hidden="true"></i>&nbsp;www.efuture.lk</p>
				</footer>
			</article>
			
		</div>
		
		<div class="col-md-2 col-sm-2">
		<button onclick="pdfToHTML()" class="btn btn-warning"><h1><i class="fa fa-print" aria-hidden="true"></i></h1></button>
		
		</div>
 </div>
 <!--eNDS hELP aREA-->
 
	