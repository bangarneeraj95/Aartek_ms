package hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HrDao;

/**
 * Servlet implementation class responce
 */
@WebServlet("/shedule")
public class shedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int status=0;
		PrintWriter out = response.getWriter();
		
		String chcked[] = request.getParameterValues("shedule");
		List<String> l = Arrays.asList(chcked);
		
		HrDao hrd = new HrDao();
		try
		{
			status = hrd.status_change(l);
			
			if(status>0)
			{
				
				response.sendRedirect("Interview_res.jsp");
			}
			else
			{
				out.println("alert('candidate not properly sheduled!')");
				RequestDispatcher rd = request.getRequestDispatcher("shedule.jsp");
				rd.include(request, response);
			}
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}

}
