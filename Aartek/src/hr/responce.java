package hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HrDao;
import dto.HrDto;

/**
 * Servlet implementation class responce
 */
@WebServlet("/responce")
public class responce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public responce() {
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
		PrintWriter out = response.getWriter();
		int temp;
		String responce = request.getParameter("res1");
		String id = request.getParameter("id1");
		String marks=request.getParameter("score1");
		String perfection=request.getParameter("perfection1");
		HrDto dto = new HrDto();
		System.out.println(perfection);
		System.out.println(marks);
		System.out.println(responce);
		dto.setScore(marks);
		dto.setPerfection(perfection);
		dto.setResponce(responce);
		int temp_id=Integer.parseInt(id);
		dto.setId(temp_id);
		/*HashMap hm1 = new HashMap();
		HashMap hm2 = new HashMap();
		String email=request.getParameter("email");
		int i=0;
		while(i<id.length)
		{
			hm1.put(id[i], responce[i]);
			hm2.put(perfection[i],marks[i]);
			i++;
		}*/
		
		HrDao obj = new HrDao();
		try
		{
			//temp=obj.save_responce(hm);
			temp=obj.save_responce(dto);
			if(temp>0)
			{
				out.println("<script>alert('Congrats Budy... :');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("Interview_res.jsp");
				rd.include(request, response);
				//response.sendRedirect("aftr_response.jsp");
			}
			else
			{
				System.out.println("Sorry..Somehing went wrong");
			}
		} 
		catch (SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}

}
