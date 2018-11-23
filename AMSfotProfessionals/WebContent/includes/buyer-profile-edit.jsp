
  <div class="row"><!--Seller Edit Row 1-->



      <!--Seller Edit Form Goes Here-->
      <!--To ProfessionalTBL-->
    <div class="col-lg-12 col-md-12 content">

     <!--To LoginTBL-->
          <div class="content">
            <h4>About Me </h4>
            <form class="form-horizontal" action="./ClientController?action=updcli" method="post">
            
            <div class="form-group">
            <label for="firstname" class="col-lg-3 col-md-3 control-label">First Name: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                      <span class="input-group-addon"><i class="fa fa-user"></i></span>
                      <input type="text" name="firstname" class="form-control input-sm" placeholder="First Name"
                       value ="${user.getFirstname()}"
                       data-toggle="tooltip" data-placement="bottom" title="Change First name" data-trigger="focus">
                </div>                                      
            </div>
            </div>

            <div class="form-group">
            <label for="lastname" class="col-lg-3 col-md-3 control-label">Last Name: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-user"></i></span>
                    <input type="text" name="lastname" class="form-control input-sm" placeholder="Last Name"
                     value ="${user.getLastname()}"
                    data-toggle="tooltip" data-placement="bottom" title="Change Last name" data-trigger="focus">
                </div>                                      
            </div>
            </div>

            <div class="form-group">
            <label for="email" class="col-lg-3 col-md-3 control-label">Email Address: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                    <input type="text" name="email" class="form-control input-sm" placeholder="Email Address"
                       value ="${user.getEmail()}"
                   data-toggle="tooltip" data-placement="bottom" title="Change Associated Email" data-trigger="focus">
                </div>                                      
            </div>
            </div> 


            <div class="form-group">
            <label for="email" class="col-lg-3 col-md-3 control-label">Address: </label>
            <div class="col-lg-9 col-md-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-road"></i></span>
                                        <textarea name="address" class="form-control" id="address" placeholder="Your Home Address"
              data-toggle="tooltip" data-placement="bottom" title="Edit Address" data-trigger="focus">${clientBean.getAddress()}</textarea>
                                    </div>                                     
            </div>
            </div> 

            <div class="form-group">
            <label for="email" class="col-lg-3 col-md-3 control-label">Phone number: </label>
            <div class="col-lg-9 col-md-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-phone"></i></span>
                                        <input type="text" name="phone" class="form-control" 
                                        value="${clientBean.getPhone()}"
                                        placeholder="Your Phone number" data-toggle="tooltip" data-placement="bottom" title="Edit Phone number" data-trigger="focus">
                                    </div>                                     
            </div>
            </div>             
<input type="submit" name="loginTbl" class="btn btn-primary btn-block" value="Save">
</form>

</div><!--ENDS To Profession-TBL-->



</div><!--ENDS Column 1 1st row to Professional TBL-->



</div><!--content ENDs To Qualifications Area-->

<!--Seller Edit Form Goes Here-->