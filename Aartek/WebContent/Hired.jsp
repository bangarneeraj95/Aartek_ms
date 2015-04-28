
<%@page import="java.sql.*" %>

<%@page import="dao.*" %>
<%@page import="dto.*" %>
<%@page import="java.util.*" %> 
<%@page import="service.HrService" %> 
<%@ page errorPage="Error.jsp" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>aartek software solution</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" media="screen" />
<link href="default.css"  rel="stylesheet" type="text/css" />
<style>
#hhff
{
color:#000000;
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
			<li ><a href="shedule.jsp" accesskey="3" title="">Shedule_candidate</a></li>
			<li><a href="Interview_res.jsp" accesskey="4" title="">interview_responce</a></li>
			<li><a href="aftr_response.jsp" accesskey="5" title="">process_candidate</a></li>
			<li class="active"><a href="#" accesskey="5" title="">current_hired</a></li>
			<li><a href="login.html" accesskey="5" title="">logout</a></li>
		</ul>
	</div>
</div>
<!-- end header -->


<!-- start page -->
<div id="page">
	<!-- start content -->
	<div id="content">
	
	
	
	<% HrDto dto = new HrDto();
   HrService sdto = new HrService(); 
%>
<form action="shedule" method="post">
<center>
<table border="1" id="customers">
<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Mobile No</th><th>Gender</th>
<th>Qualification</th><th>Resume</th><th>Experience</th>
<th>Date</th><th>Time</th>

</tr>
<%int id=0;

try 
{
                       HrDao  dao =new HrDao();
	ArrayList<HrDto> al=dao.HiredDataRetrive(dto);
	int size=al.size();
	Iterator<HrDto> itr = al.iterator();
	//response.sendRedirect("geData.html");
	
	
	while(itr.hasNext())
	{
		HrDto dto1=itr.next();
%>
<tr>
<td><%=dto1.getId() %></td><td><%=dto1.getFirstname() %></td><td><%=dto1.getLastName() %></td><td><%=dto1.getEmailId()%></td><td><%= dto1.getMob_no() %>
</td><td><%=dto1.getGender() %></td><td><%=dto1.getQuali() %></td>

<td>
<table width="100%" border="0" cellspacing="0" cellpadding="0"> <tr>    <td>      <div>      </br></br>
  <a href="http://localhost:7070/Aartek/DownloadServlet?filename=<%=dto1.getResume_path() %>"  style="background-color:#000000;border:1px solid #EB7035;border-radius:3px;color:#ffffff;display:inline-block;font-family:sans-serif;font-color:white;font-size:16px;line-height:15px;text-align:center;text-decoration:none;width:80px;-webkit-text-size-adjust:none;mso-hide:all;">View  &rarr;</a> </div></td></tr></table>
  </td>

<td><%= dto1.getExperience() %></td>


<td><%= dto1.getDate() %></td>
<td><%=dto1.getTime() %></td>
</tr>

<!-- <td><a href=# ?id="+id+"&fname="+fname+"&lname="+lname+"&email="+email+
&mob="+mob+"&city="+city+"&qualification="+quali+"&date="+date+"&time="+time+"><input type="checkbox" >  Shedule</a></td></tr>
 -->
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
