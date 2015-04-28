package hr;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import service.HrService;
import dto.HrDto;

/**
 * Servlet implementation class New_Regis
 */
@WebServlet("/New_Regis")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, 	// 2MB
maxFileSize = 1024 * 1024 * 10, 		// 10MB
maxRequestSize = 1024 * 1024 * 50)		// 50MB
public class New_Regis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		      
        
			
		HrDto dto = new HrDto();
		PrintWriter out = response.getWriter();
		dto.setFirstname(request.getParameter("First_Name"));
		dto.setLastName(request.getParameter("Last_Name"));
		dto.setEmailId(request.getParameter("Email_Id"));
		dto.setMob_no(request.getParameter("Mobile_Number"));
		dto.setGender(request.getParameter("Gender"));
		dto.setAdd(request.getParameter("Address"));
		dto.setQuali(request.getParameter("Qualication"));
		dto.setDate(request.getParameter("interview_date"));
		dto.setTime(request.getParameter("time"));
		dto.setExperience(request.getParameter("experience"));
		List<File> uploadedFiles = saveUploadedFiles(request);	System.out.println( uploadedFiles);
		   File s = null;String filename=null;
		   for (File aFile :  uploadedFiles)
		   {       s=aFile;		}
		   filename=s.getAbsolutePath();
		
		
		dto.setResume_path(filename);
		HrService service_obj = new HrService();
		try 
		{
		boolean i=service_obj.save_candi(dto);
			if(i==true)
			{
				out.println("<script>alert('Candidate Registered Successsfully');</script>");
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
						rd.include(request, response);
			}
			else
			{
				out.println("<script>alert('Something went wrong');</script>");
				RequestDispatcher rd=request.getRequestDispatcher("regis.jsp");
				rd.include(request, response);
			}
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private List<File> saveUploadedFiles(HttpServletRequest request)
			throws IllegalStateException, IOException, ServletException {
		List<File> listFiles = new ArrayList<File>();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		Collection<Part> multiparts = request.getParts();
		if (multiparts.size() > 0) {
			for (Part part : request.getParts()) {
				// creates a file to be saved
				String fileName = extractFileName(part);
				if (fileName == null || fileName.equals("")) {
					// not attachment part, continue
					continue;
				}
				
				File saveFile = new File(fileName);
				System.out.println("saveFile: " + saveFile.getAbsolutePath());
				FileOutputStream outputStream = new FileOutputStream(saveFile);
				
				// saves uploaded file
				InputStream inputStream = part.getInputStream();
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				outputStream.close();
				inputStream.close();
				
				listFiles.add(saveFile);
			}
		}
		return listFiles;
	}
	/**
	 * Retrieves file name of a upload part from its HTTP header
	 */
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return null;
	}

}
