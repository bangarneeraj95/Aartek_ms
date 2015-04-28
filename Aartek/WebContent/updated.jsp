<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page errorPage="Error.jsp" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
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
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    width: 100%;
    border-collapse: collapse;
}

#customers td, #customers th {
    font-size: 1em;
    border: 1px solid #98bf21;
    padding: 3px 7px 2px 7px;  border: 1px solid black;
}

#customers th {
    font-size: 1.1em;
    text-align: left;
    padding-top: 5px;
    padding-bottom: 4px;
    background-color: black;
    color: white    ;
}

#customers tr.alt td {
    color: #000000;
    background-color: #EAF2D3;
}id="customers"
</style>
<link rel="stylesheet"       href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
 <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
 <link rel="stylesheet" href="/resources/demos/style.css">

 <script>

 $(function() {
 $( "#datepicker" ).datepicker({ minDate: -210, maxDate: -1 });
 });

 </script>
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
</ul></div></div>
<!-- end header -->


<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content" class="mmll">
	
<center><h1>CANDIDATE REGISTRATION FORM</h1></center>
<form action="New_Regis" method="post" enctype="multipart/form-data">
<body bgcolor="#001247" text="white">

 <table border="0" height="100%" align="center" id="customers">

<tr>
<td align="right">Name</td>
<td><input type="text" name="fname" required="" title="enter you first name" size="30"/></td>
</tr><tr><td align="right">Name</td>
			
<td><input type="text" name="lname" required="" title="enter you last name" size="30"/></td>
		
</tr> 
<tr>

<td align="right">Email_id</td>
<td><input type="email" name="email" size="30" required/></td>
</tr>
<td align="right">Gender </td>  
<td>
Male <input type="radio" name="gender" value="male"/>
Female <input type="radio" name="gender" value="female"/>
</td> 
</tr>
 <tr>  
  <td>Work Experience</td>  
  <td>  
  <input type="radio" name="experience" value="0">0-1 years  
  <input type="radio" name="experience" value="1-2">1-2 years  
  <input type="radio" name="experience" value="2+">2+ years  
  </td>  
    </tr>
<tr>
<td align="right">Applied Course </td>  
<td><select name="course">
   <option>Select Course</option>
   <option>Bsc</option>
   <option>Msc</option>
   <option>MCA</option>
   <option>BCA</option>
   <option>BE</option>
   <option>M.Tech</option>
   </select></td> 
</tr>
<tr>
<td align="center">Address</td>
<td><Textarea name="address" rows=4 cols=50 required=""></textarea></td>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%></tr>
<tr><td align="right">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
 <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
 
 <script>
$(function() {
 $( "#datepicker" ).datepicker({ minDate: -210, maxDate: -1 });
 });
</script><p>Date: <input type="text" name="datepicker" id="abc"></p></td> </tr>

<tr>
<td align="right">Mobile No.</td>
<td><input type="text" name="mobile" size="30" pattern="[0-9][0-9]{9}" required/></td>
</tr>
<tr>  
 <td>Upload Resume</td>  
 <td><input type="file" name="resume" size="40"/></td>  
 </tr>  
<tr>
<td colspan="2" align="right">
<input type="reset" value="Reset">
</td>
<td colspan="2"><input type="submit" value="Submit"></td>
</tr>
</table>
 </center>
</div>
</div>
<div style="clear: both; height: 30px">&nbsp;</div>
<!-- end page -->
<div id="footer" style="bottom:">
	<p><h2 id="hhff">&copy;2015 All Rights Reserved. &nbsp;&bull;&nbsp; aartek software solution</h2></p>
</div>		
<article class="col_4 pad_left2">Copyright &copy; <a href="#">Domain Name</a> All Rights Reserved<br>
</form>
</body>
</html>



