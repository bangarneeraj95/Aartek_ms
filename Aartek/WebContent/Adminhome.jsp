<%-- 
    Document   : Adminhome
    Created on : 09-Apr-2015, 12:24:43
    Author     : MISHRA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.html" %>
<%-- <%@ include file="footer.html" %>
 --%><html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Advanced Property Guide</title>
<link rel="stylesheet" type="text/css" href="css/style_blue.css" />
<script src="js/jquery.min.js"></script>
<script src="js/jquery.tabify.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
var $ = jQuery.noConflict();
$(function() {
$('#tabsmenu').tabify();
$(".toggle_container").hide();
$(".trigger").click(function(){
	$(this).toggleClass("active").next().slideToggle("slow");
	return false;
});
});
</script>

<style>
.tcat {
	background: #079ACB;
	font: 11px verdana, geneva, lucida, 'lucida grande', arial, helvetica, sans-serif;
	color: #ffffff;
}
.tcat a:link {
	color: #ffffff;
	text-decoration: none;
}
#pic{
    height:150px;
    width:120px;
    float: left;
	font-weight: bold;
}

</style>
    </head>
<body>


											<!------------ Header Area ------------>



											<!------------ Middle Content Area ------------>

<iframe name="frame1" frameborder="0" width="65%" height="740px" style="margin-left:8%;margin-top:4%">
    </iframe>
    
 <div id="pic">
      <!--    <img src="images/img01.gif" height="30%" width="50%" style="border-radius:30px; vertical-align:top" > -->




 <!-- <div class="sidebar" id="sidebar" style="margin-top:-420px "> -->
   <table>
   <tr>
   <td>
    <h2>Basic</h2>

        <ul>
            <li><a href="" class="selected">Home</a></li>
            <li><a href="http://localhost:7070/Aartek/shedule.jsp" target="frame1">Change Password</a></li>
            <li><a href="Adminprofile.jsp" target="frame1">Edit Profile</a></li>
        </ul>

    <h2>Info</h2>

        <ul>
            <li><a href="#" target="frame1">User Info</a></li>
            <li><a href="upload_doc.jsp" target="frame1">Uploaded Documents</a></li>
            <li><a href="enquiry.jsp" target="frame1">Enquiry</a></li>
        </ul>

    <h2>jnsjfnjf</h2>

        <ul>
            <li><a href="postnow.jsp" target="frame1">Jnn Now</a></li>
            <li><a href="viewpost.jsp" target="frame1">View jkn</a></li>
        </ul>
		


	</td>
	</tr>
	</table>
   </div>
    
													<!--end of center_content-->
													<!------------ Footer Area ------------>

   


</body>
</html>