	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
     <!-- Include Functions Tags -->
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
     <!-- Include SQL Tags -->
     <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
  <!--sTARTS  Schedule App -->
<div class="helpclass wow fadeInRight">
<div class="content">

<h1>APPOINTMENTS MANAGEMENT SYSTEM</h1>
<h3>Schedule Your Works</h3>
<div class="row">
<div class="col-md-12 col-sm-12">

<div class="col-md-6 col-sm-6" id="scheduleform">
  <form class="form-horizontal" action="./ScheduleController?action=adsch" method="post" onsubmit="return Validate_scheduling()">

    <div class="form-group">
    <label for="lastname" class="col-lg-4 col-md-4 control-label">SELECT A DATE: </label>
    <div class="col-lg-8 col-md-8">
    <div class="input-group">
    <span class="input-group-addon"><i class="fa fa-calendar-plus-o"></i></span>
    <input type="text" value="${schedulerBean.getDate_available()}" name="rel_date" class="pickDate form-control input-sm" id="date">
    </div>                                      
    </div>
    </div>

    <div class="form-group">
    <label for="lastname" class="col-lg-4 col-md-4 control-label">SEATS: </label>
    <div class="col-lg-8 col-md-8">
    <div class="input-group">
    <span class="input-group-addon"><i class="fa fa-handshake-o"></i></span>
    <input type="text" name="seats" value="${schedulerBean.getSeats()}" class="form-control input-sm" id="seat">
    </div>                                      
    </div>
    </div>

    <div class="form-group">
    <label for="lastname" class="col-lg-4 col-md-4 control-label">TIME FROM: </label>
    <div class="col-lg-8 col-md-8">
    <div class="input-group">
    <span class="input-group-addon"><i class="fa fa-hourglass"></i></span>
    <input type="time" name="timefrom" value="${schedulerBean.getTime_from()}" class=" form-control input-sm" id="from_time">
    </div>                                      
    </div>
    </div>

  <div class="form-group">
  <label for="lastname" class="col-lg-4 col-md-4 control-label">TIME TO:  </label>
  <div class="col-lg-8 col-md-8">
  <div class="input-group">
  <span class="input-group-addon"><i class="fa fa-hourglass"></i></span>
  <input type="time" name="timeto" value="${schedulerBean.getTime_to()}" class=" form-control input-sm" id="to_time">
  </div>                                      
  </div>
  </div>

  <div class="form-group">
  <label for="lastname" class="col-lg-4 col-md-4 control-label">JUST CALL ME: </label>
  <div class="col-lg-8 col-md-8 ">
  <div class="input-group">
  <div class="checkbox">
  <label><input type="checkbox" name="callme" id="callme" value="1" >Put a Tick</label>
  </div>
  </div>                                      
  </div>
  </div>


  <div class="form-group">
  <label for="lastname" class="col-lg-4 col-md-4 control-label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  </label>
  <div class="col-lg-8 col-md-8">
  <div class="input-group">
  <div class="form-group">
  <input type="submit" name="submit" class="btn btn-primary form-control" value="SAVE" >
  </div>
  </div>                                      
  </div>
  </div>



  </form>         
</div>


<div class="col-md-6 col-sm-6">                           
    <div class="list-group" >
   
		<table   class="table table-striped table-bordered" cellspacing="0" width="100%" id="dattable" >
		<thead>
			<tr data-toggle="tooltip" title="Click To Edit !" data-placement="left">
			<th >Edit Date<span class="badge pull-right">Seats</span></th>
			<th style="text-align:center">Delete Date</th>
			</tr>
		</thead>
		<tfoot>
			<tr data-toggle="tooltip" title="Click To Edit !" data-placement="left">
				<th >Edit Date<span class="badge pull-right">Seats</span></th>
				<th style="text-align:center">Delete Date</th>
			</tr>
		</tfoot>
		<tbody>
			<c:forEach items="${scheduleList}" var="sh">
			<tr>
			  <td>
			  <a href="./ScheduleController?id=${sh.id}">
			  <span class="label label-info"><u> ${sh.date_available}</u> </span>
			  <span class="badge pull-right">${sh.seats}</span>
			  </a>
			  </td>
			  <td class="warning" style="text-align:center" data-toggle="tooltip" title="Click To Delete !" data-placement="top">
			   <a href="./ScheduleController?del_id=${sh.id}" onclick="return confirm('Are You Sure?')"> 
			   <span class="label label-danger">Delete</span>
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
  
<script type="text/javascript">
function Validate_scheduling(){
	
	var errors = ["date","seat","from_time","to_time"];
	var occuredErrorArray=[];	
	var i;	
	for (i = 0;i<errors.length; i++){ 
		var errval = errors[i];
		var text = document.getElementById(errval).value;
		if(text=="" || text ==null){
			document.getElementById(errval).style.borderColor="red";
			occuredErrorArray.push(errval);
	    }	    
	}	

	if(occuredErrorArray.length){
		alertify.alert("Please Fill Below Information "+occuredErrorArray.toString());
		return false;
	}
}
</script>
