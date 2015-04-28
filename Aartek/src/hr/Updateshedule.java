package hr;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HrDao;
import dto.HrDto;

/**
 * Servlet implementation class Updateshedule
 */
@WebServlet("/Updateshedule")
public class Updateshedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  PrintWriter out = response.getWriter();
	         response.setContentType("text/html");
	        
	   //      HttpSession ht=request.getSession();          String flag1=(String) ht.getAttribute("loginuser");          out.println(flag1);
	     String d= request.getParameter("Date");
	     String t= request.getParameter("Time");
	     out.print(d);   out.print(t);
	     
	            HrDto dt=new HrDto();
	            String str1=request.getParameter("uname");
                int id1=Integer.parseInt(str1);
              
	            out.print(str1);
             dt.setId(id1);
	           dt.setDate(request.getParameter("Date"));
	           dt.setTime(request.getParameter("Time"));
  // 
      HrDao dao=new HrDao();
      int flag= dao.updateData(dt);
    //  out.println(flag);
	        //	 RequestDispatcher rd=request.getRequestDispatcher("/View.html");
	             // 	    rd.include(request, response);  
	         if(flag>=1){
	    	       RequestDispatcher rd=request.getRequestDispatcher("shedule.jsp");   	    rd.forward(request, response);  
	         }
	          else
	        	 out.println("<html><body><h1>Unsuccesfull update");
      
        /*  else{
      		out.println("Pleaze Login First Then after Update Data ");
    //  		RequestDispatcher rd=request.getRequestDispatcher("login.html");          rd.include(request, response);  
      	}*/
	}


}