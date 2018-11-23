<%
HttpSession u = request.getSession();
String uid = u.getAttribute("User-ID").toString();
%>
<!--Side Nav-->
    <div class="col-sm-2 sidenav leftNav">
      <p class="dash"><a href="./ProfController?profile=login">	<i class="fa fa-dashboard (alias)" area-hidden="true"></i>&nbsp;DashBoard</a></p>
     <!-- <p><a href="schedule-app.jsp">	<i class="fa fa-calendar-check-o" area-hidden="true"></i>&nbsp;Schedule Month</a></p> -->
      <p><a href="./ScheduleController?action=schedule">	<i class="fa fa-calendar-check-o" area-hidden="true"></i>&nbsp;Schedule Month</a></p>
      <p><a href="./ScheduleController?action=manage">	<i class="fa fa-calendar-plus-o" area-hidden="true"></i>&nbsp;Manage Bookings</a></p>
      <p><a href="./MsgController?action=load-msg-prof">	<i class="fa fa-inbox" area-hidden="true"></i>&nbsp;Messages</a></p>
      <!--<p><a href="stat.jsp">	<i class="fa fa-bar-chart" area-hidden="true"></i>&nbsp;Statistics</a></p>-->
	  <p><a href="ProfController?user_id=<%=uid%>&by=seller"><i class="fa fa-user" area-hidden="true"></i>&nbsp;My Profile</a></p>      
    </div>
<!--End Left Side Nav -->