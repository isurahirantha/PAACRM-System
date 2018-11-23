     <%@page import="com.prs.utils.JspFunctions" %>
     <%
     JspFunctions jsp = JspFunctions.getJspFunctionsClassInstance();
     String fullname = jsp.showName(request, response);
    
     %>
<nav class="navbar navbar-inverse">
<div class="container-fluid">

    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
        </button>
      <a class="navbar-brand" href="dashboard-p.html">E-FUTURE.LK</a>
    </div>

    <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
            <li><a href="./ProfController?profile=login" data-toggle="tooltip" data-placement="bottom" title="Home"><span><i class="fa fa-home"></i></span></a></li>
            
            
            <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
           <%=fullname %>
            <span class="caret"></span></a>
                <ul class="dropdown-menu">
                <li><a href="./ProfController?profile=profile"><span class="fa fa-cog"></span>&nbsp;&nbsp;Account settting</a></li>
                <li><a href="./LoginController?loginAction=logout"><span class="fa fa-sign-out"></span>&nbsp;&nbsp;Logout</a></li>
                </ul>
            </li>
            </ul>
    </div>
</div><!--End container fluid-->
</nav><!--End navbar-->