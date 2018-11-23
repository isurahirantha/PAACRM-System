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


<h1>EDIT OR CANCEL YOUR BOOKINGS .</h1>
<div class="row">
<div class="col-md-12 col-sm-12">

<div class="col-md-11 col-sm-11">                           
    <div class="list-group" >
     
		<table id="dattable" class="table table-striped table-bordered" cellspacing="0" width="100%" >
		<thead>
		<tr>
			<th>Professional</th>
			<th>Date</th>
			<th>From</th>
			<th>To</th>
			<th>Is Confirmed?</th>
			<th >Code</th>
			<th>Cancel</th>
		</tr>
		</thead>
		<tfoot>
            <tr>
			<th>Professional</th>
			<th>Date</th>
			<th>From</th>
			<th>To</th>
			<th>Is Confirmed?</th>
			<th>Code&nbsp;<i class="fa fa-print pull-right" aria-hidden="true"></i></th>
			<th>Cancel</th>
            </tr>
        </tfoot>
		  <tbody>
		<c:forEach items="${myBookings}" var="mybook">
		<tr>
			<td>
				<a href="ProfController?user_id=${mybook.professional_id}&by=buyer" onclick="return confirm('Confirm Booking')">
				<b></b><u>${mybook.professional_name}</u></b>
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
				${mybook.isConfirmed}
			</td>	

<c:choose>
<c:when test="${mybook.random_code != null}">
			<td>
			<a href="./ScheduleController?action=report&r_id=${mybook.random_code}">
				${mybook.random_code}
				<i class="fa fa-print pull-right" aria-hidden="true"></i>
			</a>	
			</td>			
</c:when>
<c:otherwise>
			<td><i class="fa fa-ban" aria-hidden="true"></i></td>	
</c:otherwise>
</c:choose>				  
			<td class="info" style="text-align:center">
			<a href="./ScheduleController?bk_del_id=${mybook.auto_id}" onclick="return confirm('Confirm Delete Booking')">
			<span class="label label-danger">Cancel</span>
			</a>
			</td>
		
		</tr>
		</c:forEach>
		</tbody>
		</table>		
    </div>
</div>





</div>

</div>
</div>
          

      </div><!--content-->
  </div><!--eNDS hELP aREA-->
