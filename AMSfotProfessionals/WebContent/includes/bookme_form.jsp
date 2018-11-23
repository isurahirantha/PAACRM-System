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
<div class="helpclass">
<div class="content">

<h1>PROFESSIONALS'S TIME SCHEDULE</h1>
<h3>SELECT A CONVENIENCE DATE FOR YOU.</h3>
<div class="row">
<div class="col-md-12 col-sm-12">

<div class="col-md-10 col-sm-10">                           
    <div class="list-group" >
     <!--<h4 class="list-group-item active"><i class="fa fa-edit"></i>&nbsp;Schedule Dates<span class="label label-default pull-right">Seats</span></h4>-->
		<table id="dattable" class="table table-striped table-bordered table-hover table-condensed table-responsive" >
		<thead>
		<tr data-toggle="tooltip" title="Click To Edit !" data-placement="left">
			<th>Phone</th>
			<th>Date</th>
			<th>From</th>
			<th>To</th>
			<th>Seats</th>
			<th>Seats Available</th>
			<th>Book Now</th>
		</tr>
		</thead>
		  <tbody style="text-align:center">
		<c:forEach items="${scheduleList}" var="sh">

			<tr>
<c:choose>
<c:when test="${sh.just_call_me == 1 }">
			<td><i class="fa fa-phone-square" aria-hidden="true"></i></td>
</c:when>
<c:otherwise>
			<td><i class="fa fa-ban" aria-hidden="true"></i></td>	
</c:otherwise>
</c:choose>
			<td>${sh.date_available}</td>
			
			<td>${sh.time_from}</td>
			
			<td>${sh.time_to}</td>
			
			<td>${sh.seats}</td>	
			
			<td>${sh.seats}</td>	
				  
			<td class="info" style="text-align:center">
			<a href="./ScheduleController?sch_id=${sh.id}&sel_id=${sh.user_id}&s_dt=${sh.date_available}&from=${sh.time_from}&to=${sh.time_to}&c_id=<%=u_id%>" onclick="return confirm('Confirm Booking')">Book
			</a>&nbsp;&nbsp;
			<span class="fa fa-shopping-cart"></span>
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
