package hr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HrDao;
import dto.HrDto;
import offer_letter_And_Email.JoiningLetter;

/**
 * Servlet implementation class OfferLetterGeneter
 */
@WebServlet("/OfferLetterGeneter")
public class OfferLetterGeneter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		  String fname1=request.getParameter("First_Name");
		  String lname=request.getParameter("Last_Name");
		  String offer_ctc=request.getParameter("Offer_Ctc");
		  String offer_possition=request.getParameter("Offer_Possition");
		  String joining_date=request.getParameter("Joining_Date");
		  String email_id=request.getParameter("Email_Id");
		  JoiningLetter join_letter=new JoiningLetter();
	//	  out.println( fname1);	  out.println( lname);out.println(offer_ctc);out.println(offer_possition);out.println( joining_date);
	//	  out.println( email_id);
		boolean flag=join_letter.joiningLetter(fname1,lname,offer_ctc, offer_possition,joining_date, email_id) ;
		  HrDto dto=new HrDto();
		  HrDao dao=new HrDao();
		try {
			dao.status_change_after_conform(dto);
		}
	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  if( flag=true)
	  {out.println("send");
out.println("<script>alert('Sucessful generate offer Letter:');</script>");
RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	  }
	  else out.println("<script>alert('offer Letter is not Sucessful generate :');</script>");
		RequestDispatcher rd = request.getRequestDispatcher("aftr_response.jsp");
		rd.include(request, response);
	  }
	}


