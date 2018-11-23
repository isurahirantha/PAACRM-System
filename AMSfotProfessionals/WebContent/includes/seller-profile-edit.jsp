
  <div class="row"><!--Seller Edit Row 1-->



      <!--Seller Edit Form Goes Here-->
      <!--To ProfessionalTBL-->
    <div class="col-lg-6 col-md-6 content  ">

<!--Proile Picture-->
          <div class="content ">
            <h4>Profile Picture</h4>
            <form class="form-horizontal " action="./UploadController" method="post" enctype="multipart/form-data">
            
            <div class="form-group">
            <label for="Picture" class="col-lg-3 col-md-3 control-label">Picture: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-file"></i></span>
                    <input type="file" name="pic_path" class="form-control input-sm">
                </div>                                      
            </div>
            </div>

            <input type="submit" name="submit" class="btn btn-primary btn-block " value="Upload">
             
            </form>

          </div><!--ENDS Profile Picture to --> 


      <!--To LoginTBL-->
          <div class="content">
            <h4>About Profession </h4>
            <form class="form-horizontal" action="./ProfController?action=updprf" method="post">
            
            <div class="form-group">
            <label for="firstname" class="col-lg-3 col-md-3 control-label">First Name: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                      <span class="input-group-addon"><i class="fa fa-user"></i></span>
                      <input type="text" name="firstname" class="form-control input-sm" placeholder="First Name"
                       value ="${professionalBean.getFirstname()}"
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
            <label for="email" class="col-lg-3 col-md-3 control-label">Gender: </label>
            <div class="col-lg-9 col-md-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-venus-mars"></i></span>
                                        <select name="gender" class="form-control input-sm">
									        <option value="male">Male</option>
									        <option value="female">Female</option>
                                        </select>
                                    </div>                                     
            </div>
            </div>



            <div class="form-group">
            <label for="profession" class="col-lg-3 col-md-3 control-label">Profession: </label>
            <div class="col-lg-9 col-md-9">
            <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-briefcase"></i></span>
                                        <input type="text" name="profession" class="form-control input-sm" 
                                        value="${professionalBean.getProfession()}"
                                        placeholder="website developing & designing"
            data-toggle="tooltip" data-placement="bottom" title="Edit Profession" data-trigger="focus">
                                        
                                    </div>                                      
            </div>
            </div>

            <div class="form-group">
            <label for="specify" class="col-lg-3 col-md-3 control-label">Specify: </label>
            <div class="col-lg-9 col-md-9">
            <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-info"></i></span>
                                        <input type="text" name="specify" class="form-control input-sm" 
                                         value="${professionalBean.getSpecify()}"
                                        placeholder="Business Websites"
           data-toggle="tooltip" data-placement="bottom" title="Edit What you are specialized in" data-trigger="focus">
                                    </div>                                      
            </div>
            </div>

            <div class="form-group">
            <label for="other" class="col-lg-3 col-md-3 control-label">Other Info: </label>
            <div class="col-lg-9 col-md-9">
            <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-lightbulb-o"></i></span>
                                        <input type="text" name="other" class="form-control input-sm" 
                                         value="${professionalBean.getOther_info()}"
                                        placeholder="www.profile.com"
            data-toggle="tooltip" data-placement="bottom" title="Edit Other information, about your profession such as URLs" data-trigger="focus">
                                    </div>                                      
            </div>
            </div>            

            <div class="form-group">
            <label for="tags" class="col-lg-3 col-md-3 control-label">Tags: </label>
            <div class="col-lg-9 col-md-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-tags"></i></span>
                                        <textarea name="taglist" class="form-control input-sm"
                                         value="${professionalBean.getTags()}" 
                                        placeholder="put some keywords relavent to your profession scope seperated by coma. Ex website,blogs,wordpress,php,java,asp.net"
                                        data-toggle="tooltip" data-placement="bottom" title="Edit Tags, about your profession" data-trigger="focus">${professionalBean.getTags()}</textarea>
                                    </div>                                     
            </div>
            </div>

            <div class="form-group">
            <label for="firstname" class="col-lg-3 col-md-3 control-label">Head Line: </label>
            <div class="col-lg-9 col-md-9">
            <div class="input-group">
                                      <span class="input-group-addon"><i class="fa fa-file-text" style="margin-top: 0px;"></i></span>
                                      <textarea name="headline" class="form-control" 
                                      value="${professionalBean.getHeadLine()}" 
                                      placeholder="short description of you & profession" rows="2" maxlength="170"
             data-toggle="tooltip" data-placement="bottom" title="Edit short description of you & profession" data-trigger="focus">${professionalBean.getHeadLine()}</textarea>
                                      </div>                                              
            </div>
            </div>

            <div class="form-group"> 
            <label for="email" class="col-lg-3 col-md-3 control-label">Company: </label>
            <div class="col-lg-9 col-md-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-briefcase"></i></span>
                                        <input type="text" name="companyname" class="form-control" 
                                         value="${professionalBean.getCompany()}"
                                        placeholder="put a professional name for your business" 
                                        data-toggle="tooltip" data-placement="bottom" title="Edit Company Name" data-trigger="focus">
                                    </div>                                     
            </div>
            </div> 

            <div class="form-group">
            <label for="email" class="col-lg-3 col-md-3 control-label">Address: </label>
            <div class="col-lg-9 col-md-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-road"></i></span>
                                        <textarea name="address" class="form-control" id="address"  
                                        value="${professionalBean.getAddress()}"
                                        placeholder="Your Home Address"
              data-toggle="tooltip" data-placement="bottom" title="Edit Address" data-trigger="focus">${professionalBean.getAddress()}</textarea>
                                    </div>                                     
            </div>
            </div> 

            <div class="form-group">
            <label for="email" class="col-lg-3 col-md-3 control-label">Phone number: </label>
            <div class="col-lg-9 col-md-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-phone"></i></span>
                                        <input type="text" name="phone" class="form-control" 
                                        value="${professionalBean.getPhone()}"
                                        placeholder="Your Phone number" data-toggle="tooltip" data-placement="bottom" title="Edit Phone number" data-trigger="focus">
                                    </div>                                     
            </div>
            </div>             
<input type="submit" name="loginTbl" class="btn btn-primary btn-block" value="Save">
</form>

</div><!--ENDS To Profession-TBL-->



</div><!--ENDS Column 1 1st row to Professional TBL-->


      <!-- Starts column2 , 1st Row , To LoginTBL & QualificationTBL-->
      <div class="col-lg-6 col-md-6 content">

<!-- Qualifications Are-->               
<div class="content">
<h4>QUALIFICATION</h4>
<!--To Experiences TBL-->
          <div class="content">
            <h4>EXPERIECES</h4>
            <form class="form-horizontal" action="./ProfController?action=updexp" method="POST">
            
            <div class="form-group">
            <label for="experience" class="col-lg-3 col-md-3 control-label">Aria: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-hand-o-right"></i></span>
                    <input type="text" name="aria" class="form-control" 
                     value="${experienceBean.getAria()}"
                    placeholder="experience in"
                    data-toggle="tooltip" data-placement="bottom" title="About Experiences you got from through out your working times" data-trigger="focus">
                </div>                                      
            </div>
            </div>

            <div class="form-group">
            <label for="lastname" class="col-lg-3 col-md-3 control-label">Place: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-home"></i></span>
                    <input type="text" name="place" class="form-control" 
                    value="${experienceBean.getPlace()}"
                    placeholder="Experiences"
                    data-toggle="tooltip" data-placement="bottom" title="Mention From Where Did You get experienced in this?" data-trigger="focus">
                </div>                                      
            </div>
            </div>

            <div class="form-group">
            <label for="email" class="col-lg-3 col-md-3 control-label">Time Period From: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-hourglass"></i></span>
                    <input type="date" name="from_date" class="form-control" 
                    value="${experienceBean.getFrom_date()}"
                    placeholder="2011-2014"
                    data-toggle="tooltip" data-placement="bottom" title="Mention the time Period" data-trigger="focus">
                </div>                                      
            </div>
            </div> 

            <div class="form-group">
            <label for="email" class="col-lg-3 col-md-3 control-label">Time Period To: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-hourglass"></i></span>
                    <input type="date" name="to_date" class="form-control" 
                    value="${experienceBean.getTo_date()}"
                    data-toggle="tooltip" data-placement="bottom" title="Mention the time Period" data-trigger="focus">
                </div>                                      
            </div>
            </div> 

            <input type="submit" name="submit" class="btn btn-primary btn-block " value="Save">
             
            </form>
          </div><!--ENDs To Qualifications TBL-->

<!--To School Higher Education TBL-->
<div class="content">
            <h4>Achivements</h4>
            <form class="form-horizontal" action="./ProfController?action=updach" method="POST">
            
            <div class="form-group">
            <label for="Institute" class="col-lg-3 col-md-3 control-label">Institute: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-home"></i></span>
                    <input type="text" name="institute" class="form-control" 
                    value="${achievmentBean.getInstitute()}"
                    placeholder="Institute"
                    data-toggle="tooltip" data-placement="bottom" title="Name of the School or Training institute" data-trigger="focus">
                </div>                                      
            </div>
            </div>

            <div class="form-group">
            <label for="Subject" class="col-lg-3 col-md-3 control-label">Title: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-certificate"></i></span>
                    <input type="text" name="title" class="form-control" 
                    value="${achievmentBean.getTitle()}"
                    placeholder="Subject Scope"
                     data-toggle="tooltip" data-placement="bottom" title="What did you learn?" data-trigger="focus">
                </div>                                      
            </div>
            </div>

            <div class="form-group">
            <label for="Time Period" class="col-lg-3 col-md-3 control-label">Date: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-hourglass"></i></span>
                    <input type="date" name="duedate" class="form-control"  
                    value="${achievmentBean.getDuedate()}"
                    data-toggle="tooltip" data-placement="bottom" title="Edit Time period" data-trigger="focus">
                </div>                                      
            </div>
            </div>
             
            <input type="submit" name="submit" class="btn btn-primary btn-block " value="Save">
             
            </form>
          </div><!--ENDs To School Higher Education TBL-->

<!--To UniversityTBL-->
<div class="content">
            <h4>University Education</h4>
            <form class="form-horizontal" action="./ProfController?action=upduni" method="POST">
            
            <div class="form-group">
            <label for="University" class="col-lg-3 col-md-3 control-label">University: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-university"></i></span>
                    <input type="text" name="university" class="form-control" 
                    value="${uniBean.getName()}"
                    placeholder="University"
                    data-toggle="tooltip" data-placement="bottom" title="Name of the University" data-trigger="focus">
                </div>                                      
            </div>
            </div>

            <div class="form-group">
            <label for="degree" class="col-lg-3 col-md-3 control-label">Degree: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-graduation-cap"></i></span>
                    <input type="text" name="degree" class="form-control" 
                    value="${uniBean.getDegree()}"
                    placeholder="Degree BA BSC BCOM MA MSC MBA"
                    data-toggle="tooltip" data-placement="bottom" title="What is your degree scope?" data-trigger="focus">
                </div>                                      
            </div>
            </div>

            <div class="form-group">
            <label for="Time Period" class="col-lg-3 col-md-3 control-label">From Time: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-hourglass"></i></span>
                    <input type="date" name="fromtime" class="form-control"  
                    value="${uniBean.getFromTime()}" 
                    placeholder="Time Period"
                    data-toggle="tooltip" data-placement="bottom" title="Say Time Period" data-trigger="focus">
                </div>                                      
            </div>
            </div> 

            <div class="form-group">
            <label for="Time Period" class="col-lg-3 col-md-3 control-label">To Time: </label>
            <div class="col-lg-9 col-md-9">
                <div class="input-group">
                    <span class="input-group-addon"><i class="fa fa-hourglass"></i></span>
                    <input type="date" name="totime" class="form-control"  
                    value="${uniBean.getToTime()}" 
                    placeholder="Time Period"
                    data-toggle="tooltip" data-placement="bottom" title="Say Time Period" data-trigger="focus">
                </div>                                      
            </div>
            </div>             

            <input type="submit" name="submit" class="btn btn-primary btn-block " value="Save">
             
            </form>
          </div><!--ENDs To University TBL-->

</div><!--content ENDs To Qualifications Area-->

</div><!--ENDS column 2--> 

</div><!--End 1st Row Seller Edit -->
<!--Seller Edit Form Goes Here-->