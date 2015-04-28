package hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.HrService;
import connection.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connection.Demo_Connection;
import dto.HrDto;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		out.println("<tr><th>"+"welcome to servalet"+"</th><tr>");
		out.println();      
		String fname=request.getParameter("Fname");  
		String lname=request.getParameter("Lname");  
		String email=request.getParameter("email");  
		String userid=request.getParameter("user");
		String pass=request.getParameter("pass");
		String role=request.getParameter("Role");
		System.out.println(role);
		 HrDto dtoObj=new HrDto();
		dtoObj.setFirstname(fname);
		dtoObj.setLastName(lname);
		dtoObj.setEmailId(email);
		dtoObj.setUserId(userid);
		dtoObj.setPassword(pass);
		dtoObj.setRole(role);
		  
		Controller.fun();
		
		HrService serviceObj=new HrService();
		serviceObj.validation(dtoObj);
		response.sendRedirect("aftr_regis.html");
		
		
		
	}
	 public  static void fun(){
		
	}

}
