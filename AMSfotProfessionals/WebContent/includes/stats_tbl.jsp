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

<h1>LIST OF ALL THE BOOKINGS</h1>
<h4>You can filter this table</h4>
<div class="row">

<div class="col-md-12 col-sm-12">
<div class="col-md-1 col-sm-1"></div>

<div class="col-md-10 col-sm-10 ">                           
	<table id="dattable" class="table table-striped table-bordered" cellspacing="0" width="100%">
		        <thead>
		            <tr>
		                <th>ID</th>
		                <th>Seller-Name</th>
		                <th>Buyer -Name</th>
		                <th>Schedule Date</th>
		                <th>Schedule ID</th>
		                <th>Confirm Code</th>
		            </tr>
		        </thead>
		        <tfoot>
		            <tr>
		                <th>ID</th>
		                <th>Seller-Name</th>
		                <th>Buyer -Name</th>
		                <th>Schedule Date</th>
		                <th>Schedule ID</th>
		                <th>Confirm Code</th>
		            </tr>
		        </tfoot>
		<tbody>
		<c:forEach items="${bookingBeans}" var="booking">

<!-- 
/*

	private int schedule_id;
	private String professional_id;
	private int auto_id;
	private String client_id;
	private Date date_booked;
	private String time_from;
	private String time_to;
	private String professional_name;
	private String client_name;
	private Boolean isConfirmed;
	private String random_code;
*/
 -->
		
		<tr>
                <td>${booking.auto_id}</td>
                <td>
	                <a href="ProfController?user_id=${booking.professional_id}&by=admin" onclick="return Confirm_view()">
	                ${booking.professional_name}
	                </a>
                </td>
                
 				<td>
	                <a href="ClientController?uid=${booking.client_id}&by=admin">
	                ${booking.client_name}
	                </a>
                </td>                
                <td>${booking.date_booked}</td>
                <td>${booking.schedule_id}</td>
                <td>${booking.random_code}</td>
        </tr>	
				 
		</c:forEach>
		</tbody>
	</table>		
</div>

</div>




</div>



          
</div><!--content-->
</div><!--eNDS hELP aREA-->
 <script src="plugins/alertify/alertify.min.js"></script>
     <script>
     function Confirm_view() {
    	 alertify.alert("Lets See Professional..!");
 	}     
     </script>