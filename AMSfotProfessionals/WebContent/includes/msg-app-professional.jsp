	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
     <!-- Include Functions Tags -->
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
     <!-- Include SQL Tags -->
     <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>  
  <!--sTARTS Message Are-->
  
    <div class="helpclass wow fadeInRight">
	
<div class="col-md-4">
<div class="content">
	<p>|Messaged Users|</p>
	<div class="list-group" data-toggle="tooltip" title="Click To Message !" data-placement="left">
	      <h4 class="list-group-item active"><i class="fa fa-edit"></i>&nbsp;User names<span class="label label-danger pull-right">Messages</span></h4>				
	
	<c:forEach items="${chatJoiner}" var="joins">
	<li class="list-group-item">
	<a href="./MsgController?p_prof_id=${joins.professional_id}&p_client_id=${joins.client_id}">
	${joins.client_name}
	</a>
	<span class="badge">12</span>
	</li>
	</c:forEach>



	
	</div>
</div>	
</div>
	
	
	
	<div class="col-md-8">
<div class="content">
<h2>Messages</h2>

<!-- auto_id	professional_id	client_id	message	isOpen	date_msg	time_msg -->
	
		<div class="main_msgcontainer">
		<c:forEach items="${chatList}" var="chats">
				<div 
				<c:choose>
				<c:when test="${chats.isClient == true}">
						class="msgcontainer"
				</c:when>
				<c:otherwise>
						class="msgcontainer darker"	
				</c:otherwise>		
				</c:choose>
				>			
				<c:choose>
					<c:when test="${chats.isClient == true}">
					<img src="./images/edit2.png" alt="Avatar" class="right" style="width:100%;">
					<span class="label label-warning">Client:-</span>
					</c:when>
					<c:otherwise>
					<img src="./images/user.png" alt="Avatar" class="right" style="width:100%;">
					<span class="label label-primary">You:-</span>
				</c:otherwise>	
				</c:choose>
				            <p class="text-right">${chats.message}</p>
				            <br></br>
				            <p class="time-right">${chats.time_msg}</p>
				            <span class="time-right">${chats.date_msg}</span>
	
				</div>
		</c:forEach>		
	    </div>      
	
</div>


      	<div class="content">
      	<!-- METHOD POST -->
			 <form class="form-horizontal" action="./MsgController?p_prof_id=${msgB.professional_id}&p_client_id=${msgB.client_id}" method="post">
			    <div class="form-group">
			      <label class="control-label col-sm-2" for="msg">Message:</label>
			      <div class="col-sm-10">
			       <textarea class="form-control" rows="3" id="msg" name="msg"></textarea>
			      </div>
			    </div>
			    <div class="form-group">        
			      <div class="col-sm-offset-2 col-sm-10">
			        <button type="submit" class="btn btn-default">SEND</button>
			      </div>
			    </div>
			  </form>           
          </div>

        

      </div><!--content-->	
	</div><!-- END MSG FORM -->
	
  </div><!--eNDS Message Are-->