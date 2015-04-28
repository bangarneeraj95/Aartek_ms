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
<%@ page errorPage="Error.jsp" %>  
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
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
<script src="js/Registration_Validation1.js"></script>
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
	
	<center><h1> FINAL FORM</h1></center>


<form action="OfferLetterGeneter" name='regis' onsubmit="return formValidation();" method="post">
 <center>
<table align="center" border="1" >
 

<!----- First Name ---------------------------------------------------------->
<tr>
<td>First Name</td>
<td><input type="text" name="First_Name" readonly="readonly" value="${param.fname}" maxlength="30" size="30"/>
</td>
<!----- Last Name ---------------------------------------------------------->

<td>Last Name</td>
<td><input type="text" name="Last_Name" readonly="readonly" value="${param.lname}" maxlength="30" size="30"/>
</td>
</tr>

<!----- Email Id ---------------------------------------------------------->
<tr>
<td>Email Id</td>
<td><input type="email" name="Email_Id" readonly="readonly" value="${param.email}" maxlength="30" size="30" /></td>

<!----- Mobile Number ---------------------------------------------------------->

<td>Offer_Possition</td>
<td>
<input type="text" name="Offer_Possition"   size="30"/>
</td>
</tr>
 <!----- Qualification ---------------------------------------------------------->
<tr>
<td>Offer CTC</td>
<td><input type="text" name="Offer_Ctc" required="required" maxlength="10" size="30" />
</td>
 
<!----- Address ---------------------------------------------------------->

 

 
<!----- Qualification---------------------------------------------------------->

<td>Joining Date</td>
<td><input type="date" name="Joining_Date" required="required" maxlength="10" size="30" />
</td>
</tr>




<!----- Submit and Reset ------------------------------------------------->
<tr>
<td colspan="2" align="right">

<input type="reset" value="Reset">
</td>
<td colspan="2"><input type="submit" name="submit" value="Submit"></td>

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
