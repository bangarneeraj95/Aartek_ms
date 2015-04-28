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
#inn
{
background: transparent;
border: none;
color: white;
font-size: small;

}
#inn1
{
background: transparent;
border: none;
color: white;
font-size: medium;

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
<style>

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
			<li><a href="Interview_res.jsp" accesskey="4" title="">interview_responce</a></li>
			<li class="active"><a href="aftr_response.jsp" accesskey="5" title="">process_candidate</a></li>
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
<table border="1" id="customers">
<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Mobile No</th><th>Qualification</th>
<th>Date</th><th>Time</th><th>Perfection</th><th>Score</th><th>Responce</th><th>Select</th><th>Reject</th>

</tr>
<%
int id=0;
String fname=null;
String lname=null;
String email=null;
String pass=null;
String pwd=null;
String cpwd=null;
String mob=null;
String nationality=null;
String responce=null;
String perfection=null;
String score=null;
String gender=null;
String quali=null;
String date=null;
String time=null;
int status=0;
int res_stat=0;
try 
{
	HrDao obj = new HrDao();
	
	ArrayList<HrDto> al=obj.Get_final_responce(dto);
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
		quali=dto1.getQuali();
		date=dto1.getDate();
		time=dto1.getTime();
		responce=dto1.getResponce();
		perfection=dto1.getPerfection();
		score=dto1.getScore();
		status=dto1.isStatus();
		res_stat=dto1.getRes_status();
		
	  
%>
<%

if(res_stat==1)
{
%>
<tr>
<td><input id="inn" type="text" name="id" value="<%= id %>" readonly="readonly" size="1" /></td>
<td><%=fname %></td><td><%= lname %></td><td><%= email %></td><td><%= mob %></td><td><%= quali %></td><td><%= date %></td>
<td><%= time %></td><td><input id="inn" type="text" name="perfection" value="<%= perfection %>" readonly="readonly" size="25" /></td>
<td><input id="inn" type="text" name="score" value="<%= score %>" readonly="readonly" size="3"/></td>
<td><input id="inn" type="text" name="responce" value="<%= responce %>" readonly="readonly" size="5"/> </td>
<td align="center"><a href="Offer_Registration.jsp?id=<%=id%>&fname=<%=fname%>&lname=<%=lname%>&email=<%=email%>&mob=<%=mob%>&quali=<%=quali%>">Confirm</a></td>
<td><a href="Remove_Candidate?id=<%=id%>">Remove</a></td>
</tr>
<% }
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
