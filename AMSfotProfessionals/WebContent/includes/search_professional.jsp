  	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
     <!-- Include Functions Tags -->
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
     <!-- Include SQL Tags -->
     <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
  $( function() {
    var availableTags = [
    	"Architect",
    	"Barber",
    	"Cosmetologist",
    	"Hair Stylist",
    	"Biologist",
    	"Cashier",
    	"Chemist",
    	"Chiropractor",
    	"Clergy",
    	"Industrial Designers",
    	"Counselor",
    	"Dentist",
    	"Economists",
    	"Fashion Designer",
    	"Flight Attendant",
    	"Floral Designer",
    	"Fundraisers",
    	"Ghostwriter",
    	"Graphic Designer",
    	"Government Manager",
    	"Insurance Agent",
    	"Interior Designer",
    	"Landscape Architect",
    	"Librarian",
    	"Massage Therapist",
    	"Medical Assistant",
    	"Doctor",
    	"Photographer",
    	"Psychologist",
    	"Psychology",
    	"Writer / Editor",
    	"Veterinarian",
    	"Zoologist",
    	"blogger",
    	 "Software Engineer",
    	 "Software Developer",
    	 "Web Designer",
    	 "Web Developer",
    	 "archiologist",
    	 "teacher",
    	 "tutor",
    	 "plumber",
    	 "carpenter",
    	 "English Teacher",
    	 "Sinhala Techer",
    	 "Tamil Teacher",
    	 "Math Teacher",
    	 "Science Teacher",
    	 "florist",
    	 "journalist",
    	 "Lawyer"
    ];
    $( "#tags" ).autocomplete({
      source: availableTags
    });
  } );
  </script>

  
  <!--sTARTS hELP aREA-->
    <div class="helpclass wow fadeInRight">
        <div class="content">
			<div class="text-center">
				<h1 >Professionals Reservation System</h1>
				<div class="lead">Whom Do You Need to Hire?</div>
				<h5>Type Search Reserve!</h5><!--header Texts-->
				
				<form class="form-inline" role="form" action="./ProfController?action=srchprf" method="post">
				    <div class="form-group row">
				          <div class="form-group">
				            <input type="text" id="district" name="district" class="form-control" placeholder="Type District">
				          </div>
				          <div class="form-group">
				              <input type="text" name="profession" class="form-control" id="tags" placeholder="Search Professionals">
				          </div>
				          <script src="js/autocomp_districs.js"></script>
				
				          <button type="submit" class="btn btn-default">Search</button>
				    </div>
				</form>  <!--header search form-->
			</div> 
         </div>
      <div class="content">
          <h4>Results</h4>
<div class="container">    
    <div class="row">
     			
		    	<div class="col-sm-11 col=md-11">
		    		<c:forEach items="${searchedBean}" var="sh">
			        <div class="col-sm-3 col-md-3">
			          <div class="panel panel-primary">
			            <div class="panel-heading">Profession:-<b>${sh.profession}</b></div>
			            <div class="panel-body">
			            <p>Name:-<b> ${sh.firstname} &nbsp; ${sh.lastname} </b></p>
			            <p>Address:-<b>${sh.address}</b></p>
			            </div>
			            <a href="./ProfController?user_id=${sh.user_id}&by=buyer"><div class="panel-footer btn btn-block">Hire me!</div></a>
			          </div>
			        </div>
			        </c:forEach>
				<div class="col-sm-1 col=md-1"></div>
				</div>
    </div>
</div>
<br>          

          

      </div><!--content-->
  </div><!--eNDS hELP aREA-->