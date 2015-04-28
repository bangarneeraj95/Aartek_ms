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
<%@page import="java.sql.*" %>

<%@page import="dao.*" %>
<%@page import="dto.*" %>
<%@page import="java.util.*" %> 
<%@page import="service.HrService" %> 
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
#inn
{
background: transparent;
border: none;
color: white;
font-size: medium;

}
#inn1
{
background: transparent;
border: none;
color: white;
font-size: medium;

}
</style>
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
			<li><a href="regis.jsp" accesskey="2" title="">register_candidate</a></li>
			<li><a href="shedule.jsp" accesskey="3" title="">Shedule_candidate</a></li>
			<li class="active"><a href="#" accesskey="4" title="">interview_responce</a></li>
			<li><a href="Process_candi.jsp" accesskey="5" title="">process_candidate</a></li>
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
	
	
	
	<% HrDto dto = new HrDto();
   
%>
<form action="responce" method="post">
<center>
<table border="1">
<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Mobile No</th><th>City</th><th>State</th><th>Qualification</th>
<th>Date</th><th>Time</th><th>Perfection</th><th>Score</th><th>Responce</th><th>Save</th><th>Delete</th>

</tr>
<%int id=0;
String fname=null;
String lname=null;
String email=null;
String pass=null;
String pwd=null;
String cpwd=null;
String mob=null;
String nationality=null;
String state=null;
String Dist=null;
String city=null;
String gender=null;
String quali=null;
String date=null;
String time=null;
boolean status=false;
try 
{
	HrDao obj = new HrDao();
	
	ArrayList<HrDto> al=obj.Status_Retrive(dto);
	int size=al.size();
	Iterator<HrDto> itr = al.iterator();
	//response.sendRedirect("geData.html");
	
	
	while(itr.hasNext())
	{
		HrDto dto1=itr.next();
		id=dto1.getId();
		fname=dto1.getFirstname();
		lname=dto1.getLastName();
		email=dto1.getEmailId();
		mob=dto1.getMob_no();
		city=dto1.getCity();
		state=dto1.getState();
		quali=dto1.getQuali();
		date=dto1.getDate();
		time=dto1.getTime();
	   
%>
<tr>
<td><input id="inn" type="text" name="id" value="<%= id %>" readonly="readonly" size="1" /></td><td><%=fname %></td><td><%= lname %></td><td><%= email %></td><td><%= mob %></td><td><%= city %>
</td><td><%= state %></td><td><%= quali %></td><td><%= date %></td>
<td><%= time %></td><td><input id="inn" type="text" name="perfection"/></td>
<td><select name="score">
<option selected="selected" value="select">--Score--</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>

</select></td>

<td>
<select name="res">
<option selected="selected" value="select">--Select--</option>
<option value="best">Best</option>
<option value="good">Good</option>
<option value="average">Average</option>
<option value="poor">Poor</option>

</select></td>


<td>
<input type="submit" value="feed"></input></td>
<td><a href="delete_candi?id=<%=id%>">Delete</a></td>
</tr>

 <% 		
	}
}
catch (ClassNotFoundException e) 
{
	// TODO Auto-generated catch block
	e.printStackTrace();
} %>
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
