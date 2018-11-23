<!--sTARTS hELP aREA-->
<div class="helpclass">
<div class="content">

<div class="row well reviewBox mt-1 mb-1 wow fadeInRight">

 


	<div class="row">
	 <form role="form" action="./RateController?prof_id=${raterinfo.getProfessionals_id()}&cl_id=${raterinfo.getBuyer_id()}&cl_n=${raterinfo.getBuyer_name()}" method="post">
		<div class="col-sm-4">
		<h4>Please Rate Me:</h4>
		      <label>
		      <input type="radio" class="option-input radio" value="5" name="rate" checked="checked" />
		      <span class="badge badge-pill">I offer 5 <i class=" fa fa-star"></i></span>
		      </label>
		
		      <label>
		      <input type="radio" class="option-input radio" value="4" name="rate" />
		      <span class="badge badge-pill">I offer 4 <i class="fa fa-star"></i></span>
		      </label>
		
		      <label>
		      <input type="radio" class="option-input radio" value="3" name="rate" />
		      <span class="badge badge-pill">I offer 3 <i class="fa fa-star"></i></span>
		      </label>
		
		      <label>
		      <input type="radio" class="option-input radio" value="2" name="rate" />
		      <span class="badge badge-pill">I offer 2 <i class="fa fa-star"></i></span>
		      </label>
		
		      <label>
		      <input type="radio" class="option-input radio" value="1" name="rate" />
		      <span class="badge badge-pill">I offer 1 <i class="fa fa-star"></i>&nbsp;</span>
		      </label>		
		</div><!-- col-sm-4 -->
	  
		<div class="col-sm-6">
			<div class="form-group">
			 <label for="comment" style="text-align: left;">Write a Review:  
			 <i class="iconsize fa fa-commenting"></i></label>
			 <textarea class="form-control" rows="5" name="comment" id="comment" placeholder="Write a review about my services, sothat others will be able to get an idea about my services"></textarea>
			</div>	
			 <button type="submit" class="btn btn-danger btn-block">POST</button>	
		</div> <!-- col-sm-6 -->
	</form>
	</div><!-- row -->



</div><!-- review box -->

</div>


<div class="content">

  
   

</div><!--content-->
</div><!--eNDS hELP aREA-->