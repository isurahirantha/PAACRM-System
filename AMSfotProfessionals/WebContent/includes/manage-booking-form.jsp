	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
     <!-- Include Functions Tags -->
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
     <!-- Include SQL Tags -->
     <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
     
<%
HttpSession ses = request.getSession();
String u_id = ses.getAttribute("User-ID").toString();
%>
     
  <!--sTARTS  Schedule App -->
<div class="helpclass wow fadeInRight">
<div class="content">

<h1>VIEW AND CONFIRM BOOKINGS</h1>

<div class="row">
<div class="col-md-12 col-sm-12">

<div class="col-md-10 col-sm-10">                           
    <div class="list-group" >
     <!--<h4 class="list-group-item active"><i class="fa fa-edit"></i>&nbsp;Schedule Dates<span class="label label-default pull-right">Seats</span></h4>-->
		<table class="table table-striped table-bordered" cellspacing="0" width="100%" id="dattable" >
		<thead>
		<tr data-toggle="tooltip" title="Click To Edit !" data-placement="left">
			<th>Client</th>
			<th>Date</th>
			<th>From</th>
			<th>To</th>
			<th>Code</th>
			<th>Is Confirmed?</th>
		</tr>
		</thead>
		<tfoot>
		<tr data-toggle="tooltip" title="Click To Edit !" data-placement="left">
			<th>Client</th>
			<th>Date</th>
			<th>From</th>
			<th>To</th>
			<th>Code</th>
			<th>Is Confirmed?</th>
		</tr>
		</tfoot>
		  <tbody>
		<c:forEach items="${myBookings}" var="mybook">
		<tr>
			<td>			
				<a href="ClientController?uid=${mybook.client_id}&by=seller">
				<span class="label label-info"><U> ${mybook.client_name}</U></span>
				</a>
			</td>
			
			<td>
				${mybook.date_booked}
			</td>
			
			<td>
				${mybook.time_from}
			</td>
			
			<td>
				${mybook.time_to}
			</td>		
			
			<td>
				${mybook.random_code}
			</td>			
				  
			<td style="text-align:center">
			<a href="./ScheduleController?bk_upd_id=${mybook.auto_id}&c_id=${mybook.client_id}&sch_id=${mybook.schedule_id}" onclick="return confirm('Confirm Booking')">
			<span class="label label-warning"><u>CONFIRM</u></span>
			</a>
			</td>
		
		</tr>
		</c:forEach>
		</tbody>
		</table>		
    </div>
</div>

<div class="col-md-1 col-sm-1">
</div>



</div>

</div>
</div>
          

      </div><!--content-->
  </div><!--eNDS hELP aREA-->
