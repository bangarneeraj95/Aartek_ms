<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name       : Natures Charm
Description: A two-column, fixed-width design.
Version    : 1.0
Released   : 20080125

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<%@ page errorPage="Error.jsp" %>  
<title>aartek software solution</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" media="screen" />
<style>
#hhff
{
color:#000000;
}
.mmll
{
min-height:250px;
}
</style>
<script src="js/Registration_Validation.js"></script>
</head>
<body>
<!-- start header -->
<div id="header">
	<div id="logo">
		<h1 id="hhff">aartek software solution</h1>
		
	</div>
	<div id="menu">
		<ul>
			<li><a href="index.jsp" accesskey="1" title="">Home</a></li>
			<li class="active"><a href="#" accesskey="2" title="">register_candidate</a></li>
			<li><a href="shedule.jsp" accesskey="3" title="">Shedule_candidate</a></li>
			<li><a href="Interview_res.jsp" accesskey="4" title="">interview_responce</a></li>
			<li><a href="aftr_response.jsp" accesskey="5" title="">process_candidate</a></li>
			<li><a href="Hired.jsp" accesskey="5" title="">current_hired</a></li>
			<li><a href="login.html" accesskey="5" title="">logout</a></li>
		</ul>
	</div>
</div>
<!-- end header -->


<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content" class="mmll">
	
	<center><h1>CANDIDATE REGISTRATION FORM</h1></center>
<form enctype="multipart/form-data" action="New_Regis" name='regis' onsubmit="return validation()" method="post">
 <center>
<table align="center" border="1" >
 
<!----- First Name ---------------------------------------------------------->
<tr>
<td>First Name</td>
<td><input type="text" name="First_Name" pattern="[A-z]+$" required="required" placeholder="Enter your first name" maxlength="30" size="33"/>

</td>

 
<!----- Last Name ---------------------------------------------------------->

<td>Last Name</td>
<td><input type="text" name="Last_Name" pattern="[A-z]+$" placeholder="Enter your last name" required="required" maxlength="30" size="30"/>

</td>
</tr>
 
 
<!----- Email Id ---------------------------------------------------------->
<tr>
<td>Email Id</td>
<td><input type="email" name="Email_Id" required="required" placeholder="Enter Email ID" maxlength="30" size="33" />

</td>

 
<!----- Mobile Number ---------------------------------------------------------->

<td>Mobile Number</td>

<td>
<input type="text" name="Mobile_Number" required="required"  placeholder="Enter Mobile no"   maxlength="10" size="30"/>
<span id="n" style="color:red;font-size:small"></span>
</td>
</tr>
 
<!----- Gender ----------------------------------------------------------->
<tr>
<td>Gender</td>
<td>
Male <input type="radio" required="required" name="Gender" value="Male" />
Female <input type="radio" required="required" name="Gender" value="Female" />
</td>
<!----- Course ----------------------------------------------------------->
<td >Applied Course </td>  
<td><select name="Qualication"  required="required" style="width: 260px">
   <option value="null">Select Course</option>
   <option value="Bsc">Bsc</option>
   <option value="Msc">Msc</option>
   <option value="MCA">MCA</option>
   <option value="BCA">BCA</option>
   <option value="BE">BE</option>
   <option value="M.Tech">M.Tech</option>
   </select></td> 
</tr>
 
<!----- Address ---------------------------------------------------------->
<tr >
<td >Address </td>
<td colspan="3"><textarea name="Address" required="required" rows="3" placeholder="Enter address" cols="78"></textarea>

</td>
</tr>
 

 
<!----- Qualification---------------------------------------------------------->
<tr>
<td>Date to interview</td>
<td><input type="date" name="interview_date" required="required" placeholder="dd/mm/yyyy" maxlength="30" size="40" />

</td>

<td>Time</td>
<td><input type="time" name="time"  placeholder="hh:mm am/pm" required="required" maxlength="10" maxlength="30" size="40" />
</td>
</tr>
<tr>
<!----- Resume upload ------------------------------------------------->
<td>Select Resume</td>
<td><input type="file" name="resume" required="required" />
</td>
<!----- Resume upload ------------------------------------------------->
<td>Select Cunseltency</td>
<td><input type="text" name="cunseltency" pattern="[A-z]+$" placeholder="Enter coseltency name" required="required" size="30"/>
</td>
<!----- Experience----------------------------------------------------------->
<tr></tr><td align="right">Experience </td>  
<td><select name="experience"  required="required"   style="width: 260px">
   <option value="null">Select Experience</option>
   <option value="Fresher">Fresher</option>
   <option value="1 to 2">1 to 2  </option>
   <option value="2 to 3 ">2 to 3 </option>
   <option value="3 to 4">3 to 4</option>
   <option value="4 to 5">4 to 5</option>
   <option value="5 to 6">5 to 6</option>
   </select></td> </tr>
</tr>
<!----- Submit and Reset ------------------------------------------------->
<tr>
<td colspan="2" align="right">

<input type="reset" value="Reset">
</td>
<td colspan="2"><input type="submit" name="submit" value="Submit" onclick="validatedate(document.regis.interview_date)"></td>

</tr>
</table>
 </center>
</form>
	
	</div>
	<!-- end content -->
	
</div>
<div style="clear: both; height: 30px">&nbsp;</div>
<!-- end page -->
<div id="footer" style="bottom:">
	<p><h2 id="hhff">&copy;2015 All Rights Reserved. &nbsp;&bull;&nbsp; aartek software solution</h2></p>
</div>
</body>
</html>
