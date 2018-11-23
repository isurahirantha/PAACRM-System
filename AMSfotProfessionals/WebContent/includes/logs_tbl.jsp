	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
     <!-- Include Functions Tags -->
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
     <!-- Include SQL Tags -->
     <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
     
<%
HttpSession ses = request.getSession();
String u_id = ses.getAttribute("Admin-User-ID").toString();
%>
     
  <!--sTARTS  Schedule App -->
<div class="helpclass wow fadeInRight">
<div class="content">

<h1>LIST OF ALL THE LOGINS</h1>
<h4>You can filter this table</h4>
<div class="row">

<div class="col-md-12 col-sm-12">
<div class="col-md-1 col-sm-1"></div>

<div class="col-md-10 col-sm-10">                           
	<table id="dattable" class="table table-striped table-bordered" cellspacing="0" width="100%">
		        <thead>
		            <tr>
		                <th>ID</th>
		                <th>User-ID</th>
		                <th>IP Address</th>
		                <th>Log Time</th>
		                <th>Log Date</th>
		            </tr>
		        </thead>
		        <tfoot>
		            <tr>
		                <th>ID</th>
		                <th>User-ID</th>
		                <th>IP Address</th>
		                <th>Log Time</th>
		                <th>Log Date</th>
		            </tr>
		        </tfoot>
		<tbody>
		<c:forEach items="${trackers}" var="tracker">
		
		<tr>
                <td>${tracker.auto_id}</td>
                <td>
	                <a href="#" onclick="return confirm('Confirm Booking')">
	                ${tracker.user_id}
	                </a>
                </td>
                <td>${tracker.ip}</td>
                <td>${tracker.log_time}</td>
                <td>${tracker.log_date}</td>
        </tr>	
				 
		</c:forEach>
		</tbody>
	</table>		
</div>

</div>




</div>



          
</div><!--content-->
</div><!--eNDS hELP aREA-->
