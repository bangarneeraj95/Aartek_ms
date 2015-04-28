
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
			<li class="active"><a href="#" accesskey="3" title="">Reshedule_candidate</a></li>
			<li><a href="Interview_res.jsp" accesskey="4" title="">interview_responce</a></li>
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
	<div id="content">
	
	
	
	<% HrDto dto = new HrDto();
   HrService sdto = new HrService(); 
   	   String str2=request.getParameter("uname");
                     int id2=Integer.parseInt(str2);
                     System.out.println(id2);
                     
%>

<form action='http://localhost:7070/Aartek/Updateshedule?uname='<%=id2%>' " method="get">
<center><input type="hidden" name="uname" value="<%= id2%>"></input> 
<table border="1" id="customers">
<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Mobile No</th><th>Gender</th>
<th>Qualification</th><th>Resume</th><th>Experience</th>
<th>Date</th><th>Time</th><th><input type="submit" value="shedule"></th><th>Update</th>
</tr>
<%int id=0;
try 
{	ArrayList<HrDto> al=sdto.validRetrive(dto);
	int size=al.size();
	Iterator<HrDto> itr = al.iterator();
	   String str1=request.getParameter("uname");
                     int id1=Integer.parseInt(str1);
		while(itr.hasNext())
	{
		HrDto dto1=itr.next();%>
<tr>
<td><%=dto1.getId() %></td><td><%=dto1.getFirstname() %></td><td><%=dto1.getLastName() %></td><td><%=dto1.getEmailId()%></td><td><%= dto1.getMob_no() %>
</td><td><%=dto1.getGender() %></td><td><%=dto1.getQuali() %></td>
<td><%=dto1.getResume_path() %></td><td><%=dto1.getExperience() %></td>
<%if(id1==dto1.getId()){ %>
<td><input type='date' width='100' name='Date'  /></td><td><input type='time' width='100' name='Time'  /></td>
<%}  else { %>
   <td><%= dto1.getDate() %></td><td><%=dto1.getTime() %></td> <% }%>
<td> &nbsp;&nbsp; <input type="checkbox" name="shedule" value="<%=dto1.getId()%>" ></td>
<td> <div> <input type="submit" value="upadte"></input><a href='http://localhost:7070/Aartek/Updateshedule?uname=<%=dto1.getId()%> '></a> </div> </td>
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
