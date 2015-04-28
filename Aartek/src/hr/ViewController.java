package hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import service.HrService;

import dto.HrDto;



/**
 * Servlet implementation class DemoView
 */
@WebServlet("/ViewController")
public class ViewController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewController() 
    {
        super();
       //System.out.println("Hii");
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out =response.getWriter();
		HttpSession session = request.getSession();
		session.getAttribute("uname");
		out.println("Welcome"+session.getAttribute("uname"));
		HrDto dto = new HrDto();
		HrService sdto = new HrService();
		out.println("<html><body>");
		out.println("<table border=2");
		out.println("<tr>");
		out.println("<th>Id</th>");
		out.println("<th>FirstName</th>");
		out.println("<th>SecondName</th>");
		out.println("<th>Email</th>");
		out.println("<th>Password</th>");
		out.println("<th>ConfirmPass</th>");
		out.println("<th>MobNo</th>");
		out.println("<th>Nationality</th>");
		out.println("<th>State</th>");
		out.println("<th>District</th>");
		out.println("<th>City</th>");
		out.println("<th>Gender</th>");
		
		
		out.println("<th>Operation</th>");
		out.println("</tr>");
		
		
		try 
		{
			ArrayList<HrDto> al=sdto.validRetrive(dto);
			int size=al.size();
			Iterator<HrDto> itr = al.iterator();
			//response.sendRedirect("geData.html");
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
			int id;
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
				out.println("<tr><td>"+id+"</td>");
				out.println("<td>"+fname+"</td><td>"+lname+"</td><td>"+email+"</td>");
				out.println("<td>"+pwd+"</td><td>"+cpwd+"</td><td>"+mob+"</td>");
				out.println("<td>"+nationality+"</td><td>"+state+"</td><td>"+Dist+"</td>");
				out.println("<td>"+city+"</td><td>"+gender+"</td>");
				
				
				out.println("<td><a href=Update.jsp?id="+id+"&fname="+fname+"&lname="+lname+"&email="+email+"&pwd="+pwd+"&cpwd="+cpwd+"&mob="+mob+"&naionality="+nationality+"&state="+state+"&dist="+Dist+"&city="+city+"&gender="+gender+">Update</a></td></tr>");
				
			}		
		
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</table>");
		
		out.println("</body></html>");
		
	}
	
	

}
