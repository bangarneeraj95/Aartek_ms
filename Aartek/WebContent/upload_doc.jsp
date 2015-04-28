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
<%@page import="java.util.ArrayList"%>
<%@page import="dao.HrDao"%>
<%@page import="dto.*" %>
<%@page import="java.util.*" %> 
<%@page import="service.HrService" %> 
<%@ page errorPage="Error.jsp" %>  
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>aartek software solution</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
 <link href="default.css" rel="stylesheet" type="text/css" media="screen" />

<script src="js/Registration_Validation.js"></script>
<style>
#clr
{

margin-top: 120px;
}
#head
{
margin-top:50px;
color:white;

}
</style>

</head>

<body>

	
	<div id="head">
	<center><h1>Documents Upload Form</h1></center>
	</div>
	<%
		String id=request.getParameter("email");
		out.println("Welcome on Aartek software solution"+id);
	   HrDao dao=new HrDao();

			ArrayList<HrDto> al = dao.viewUploadDocInfo(id);
	int size=al.size();
	Iterator<HrDto> itr = al.iterator();
	//response.sendRedirect("geData.html");
	
	
	while(itr.hasNext())
	{
		HrDto dto1=itr.next();
	
	%>	
<div id="clr">



<form enctype="multipart/form-data" action="New_Regis" name='regis' onsubmit="return validation()" method="post">
 <center>
 <table align="center" border="1" >
 
<!----- First Name ---------------------------------------------------------->
<tr>
<td>First Name</td>
<td><input type="text" name="First_Name"  value=<%=dto1.getFirstname() %> valupattern="[A-z]+$" required="required" placeholder="Enter your first name" maxlength="30" size="36"/>

</td>

 
<!----- Last Name ---------------------------------------------------------->

<td>Last Name</td>
<td><input type="text" name="Last_Name"  value=<%=dto1.getLastName() %> pattern="[A-z]+$" placeholder="Enter your last name" required="required" maxlength="30" size="38"/>

</td>
</tr>
 
 
<!----- Email Id ---------------------------------------------------------->
<tr>
<td>Email Id</td>
<td><input type="email" name="Email_Id"  value=<%=dto1.getEmailId()%> required="required" placeholder="Enter Email ID" maxlength="30" size="36" />

</td>

 
<!----- Mobile Number ---------------------------------------------------------->

<td>Mobile Number</td>

<td>
<input type="text" name="Mobile_Number"  value=<%=dto1.getMob_no() %> required="required" placeholder="Enter Mobile no" maxlength="10" size="38"/>
<span id="n" style="color:red;font-size:small"></span>
</td>
</tr>
 <%} %>
<!----- Gender ----------------------------------------------------------->
<tr>
<td>Gender</td>
<td>
Male <input type="radio" required="required" name="Gender" value="Male" />
Female <input type="radio" required="required" name="Gender" value="Female" />
</td>
<!----- Course ----------------------------------------------------------->
<td>DOB </td>  
<td><input type="text" name="dob" size="38"></td> 
</tr>
 
<!----- Address ---------------------------------------------------------->
<tr >
<td >Address </td>
<td colspan="3"><textarea name="Address" required="required" rows="3" placeholder="Enter address" cols="86"></textarea>

</td>
</tr>
 

 
<!----- Qualification---------------------------------------------------------->
<tr>
<th colspan="4">-------------------------Upload Edducational Certificates Here------------------------</th>

<tr>
<td>*Upload 10th Certificate</td>
<td><input type="file" name="10th" placeholder="10th marksheet" required="required" />
<td>*Upload 12th Certificate</td>
<td><input type="file" name="12th" placeholder="12th marksheet" required="required" />
<br>
</tr>
<tr>
<td>*Upload Graduation Certificates</td>
<td><input type="file" name="graduation" placeholder="Graduation marksheet" required="required" />
<td>Upload Master Certificate if any</td>
<td><input type="file" name="resume" placeholder="Post Graduation marksheet" required="required" />
<br>
</tr><br>
</tr><br>

<tr>
<th colspan="4">-------------------------Upload Basic Documents Here------------------------</th>

<tr>
<td>*Upload PanCard or Licence Certificate</td>
<td><input type="file" name="pan" placeholder="10th marksheet" required="required" />
<td>Upload Passport if</td>
<td><input type="file" name="passport" placeholder="12th marksheet" required="required" />
<br></br>
</tr>
<tr>
<td>*Upload Your Photo</td>
<td><input type="file" name="graduation" placeholder="Graduation marksheet" required="required" />
<td>Upload Your Resume</td>
<td><input type="file" name="resume" placeholder="Post Graduation marksheet" required="required" />
<br><br>
</tr>
</tr>


<tr>
<th colspan="4">-------------------------Experience Documents Upload Here------------------------</th>

<tr>
<td>Upload Joining Letter of Current Company</td>
<td><input type="file" name="pan" placeholder="10th marksheet" required="required" />
<td>Upload Salary Slip</td>
<td><input type="file" name="passport" placeholder="12th marksheet" required="required" />
<br></br>
</tr>
<tr>
<td>Upload Resign Letter</td>
<td><input type="file" name="graduation" placeholder="Graduation marksheet" required="required" />
<td>Upload any other</td>
<td><input type="file" name="resume" placeholder="Post Graduation marksheet" required="required" />
<br><br>
</tr>
</tr>


<!----- Resume upload ------------------------------------------------->
<!----- Submit and Reset ------------------------------------------------->
<tr>
<td colspan="2" align="right">

<input type="reset" value="Reset">
</td>
<td colspan="2"><input type="submit" name="submit" value="Submit"></td>

</tr>
</table>
</form>

	</div>

	<!-- end content -->



</body>
</html>
