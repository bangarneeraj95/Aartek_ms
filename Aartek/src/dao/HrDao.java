package dao;
import hr.sndmail;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



import connection.Demo_Connection;

import dto.*;

public class HrDao
{
  ////////////////////////////////////////////////////////////////////////////////
	                   //connection
	
  static java.sql.Connection utility()
   { java.sql.Connection con = null;
	   try
	   {
		Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3307/aartek_ms","root","root");
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
		return con;
   }
  ///////////////////////////////////////////////////////////////////////
                       //Hr Register insert Method
  public int insertData(HrDto dtoObj )
  {
	java.sql.Connection con=utility();
	int status =0;
	  try {System.out.println(dtoObj.getFirstname());
	  
	  

	  
		PreparedStatement stm=con.prepareStatement("insert into hr_info(Fname,Lname,username,password,role_id,email) values(?,?,?,?,?,?)");
	     stm.setString(1,dtoObj.getFirstname());
	     stm.setString(2,dtoObj.getLastName());
	     stm.setString(3,dtoObj.getUserId());
	     stm.setString(4,dtoObj.getPassword());
	     stm.setInt(5,(Integer.parseInt(dtoObj.getRole())));
	     stm.setString(6,dtoObj.getEmailId());
	      status=stm.executeUpdate();    
	    System.out.println(status);
	     }
	 catch (SQLException e) 
	{
	
		e.printStackTrace();
	}
	  return status;
  
  }
  ////////////////////////////////////////////////////////////////////////////////////////////////
                             //Fetch record in register jsp select box
 	public ArrayList<HrDto>  dataBaseFetch()
	{ 
		ArrayList<HrDto>listobj=new ArrayList<HrDto>();
		try{	java.sql.Connection con=utility();    
			java.sql.PreparedStatement smt2 = con.prepareStatement("select * from hr_role");
	
			
					ResultSet set=smt2.executeQuery();
					
				   while(set.next())
				   {
					   HrDto fetch=new HrDto();
					 
					fetch.setRole_Id(set.getString(1));
					fetch.setRole_Code(set.getString(2));
					fetch.setRole_Type(set.getString(3));
				    				    listobj.add(fetch);
				    
				   }
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
		return listobj;		    
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                         /////login fetch Hr Login Check
	public boolean loginValid(String username,String pass)
	{
		boolean status=false; 
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection con=utility();
		Statement st=(Statement) con.createStatement();
		
     ResultSet rs=st.executeQuery("select username,password from HR_Info where username='"+username+"' and password='"+pass+"'");
       status=rs.next();
       System.out.println(rs.getString(1));
       System.out.println(rs.getString(2));
       con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return status;
	}
	//////////////////// Candidate Registration////////////////////////////////////
	public boolean save_candi(HrDto dto)
	{ try{
		Demo_Connection obj = new Demo_Connection();
		Connection con=obj.connection();
		System.out.println("Here 1");
		String insrt="insert into candi_regis(fname,lname,email,mobile,gender,qualification,date,time,address,resume_path,experience) values(?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement stm=con.prepareStatement(insrt);
	     stm.setString(1,dto.getFirstname());
	     stm.setString(2,dto.getLastName());
	     stm.setString(3,dto.getEmailId());
	     stm.setString(4,dto.getMob_no());
	     stm.setString(5,dto.getGender());
	     stm.setString(6,dto.getQuali());
	     stm.setString(7,dto.getDate());
	     stm.setString(8,dto.getTime());
	     stm.setString(9,dto.getAdd());
	     stm.setString(10,dto.getResume_path());
	     stm.setString(11, dto.getExperience());
	     System.out.println("Here 2");
	      stm.executeUpdate(); 
	
	      
	      String delete="update candi_regis set status=0 where id="+dto.getEmailId()+"";
			PreparedStatement pst = con.prepareStatement(delete);
	
		return true;
	}catch(Exception e){System.out.println(e); return false;}
	}
	//////////////////// View Candidate Data to Shedule.jsp Form////////////////////////////////////////
	public ArrayList<HrDto> DataRetrive(HrDto dto) throws SQLException, ClassNotFoundException 
	{
		Demo_Connection obj1 =new Demo_Connection();
		Connection con = obj1.connection();
		
		String select="select * from candi_regis where status=0  ";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(select);
		
		ArrayList<HrDto> al = new ArrayList<>();
		while(rs.next())
		{
			HrDto dto1=new HrDto();
			//System.out.println("Here");
			dto1.setId(rs.getInt(1));
			dto1.setFirstname((rs.getString(2)));
			dto1.setLastName(rs.getString(3));
			dto1.setEmailId(rs.getString(4));
			dto1.setMob_no(rs.getString(5));
			dto1.setGender(rs.getString(6));
			dto1.setQuali(rs.getString(7));
			dto1.setDate(rs.getString(8));
			dto1.setTime(rs.getString(9));
			dto1.setAdd(rs.getString(15));
			dto1.setResume_path(rs.getString(16));
			dto1.setExperience(rs.getString(17));
		
			
			
			
		
			
			al.add(dto1);
		}
		return al;
	}
	//////////////////// View Candidate Data to Shedule.jsp Form////////////////////////////////////////
	public ArrayList<HrDto>HiredDataRetrive(HrDto dto) throws SQLException, ClassNotFoundException 
	{
		Demo_Connection obj1 =new Demo_Connection();
		Connection con = obj1.connection();
		
		String select="select * from candi_regis where status=2  ";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(select);
		
		ArrayList<HrDto> al = new ArrayList<>();
		while(rs.next())
		{
			HrDto dto1=new HrDto();
			//System.out.println("Here");
			dto1.setId(rs.getInt(1));
			dto1.setFirstname((rs.getString(2)));
			dto1.setLastName(rs.getString(3));
			dto1.setEmailId(rs.getString(4));
			dto1.setMob_no(rs.getString(5));
			dto1.setGender(rs.getString(6));
			dto1.setQuali(rs.getString(7));
			dto1.setDate(rs.getString(8));
			dto1.setTime(rs.getString(9));
			dto1.setAdd(rs.getString(15));
			dto1.setResume_path(rs.getString(16));
			dto1.setExperience(rs.getString(17));
		
			
			
			
		
			
			al.add(dto1);
		}
		return al;
	}
	
	
	public ArrayList<HrDto> Status_Retrive(HrDto dto) throws SQLException, ClassNotFoundException 
	{
		Demo_Connection obj1 =new Demo_Connection();
		Connection con = obj1.connection();
		
		String select="select * from candi_regis where status=1 ";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(select);
		
		ArrayList<HrDto> al = new ArrayList<>();
		while(rs.next())
		{
			HrDto dto1=new HrDto();
			//System.out.println("Here");
			dto1.setId(rs.getInt(1));
			dto1.setFirstname((rs.getString(2)));
			dto1.setLastName(rs.getString(3));
			dto1.setEmailId(rs.getString(4));
			dto1.setMob_no(rs.getString(5));
			dto1.setCity(rs.getString(7));
			dto1.setState(rs.getString(8));
			dto1.setQuali(rs.getString(9));
			dto1.setDate(rs.getString(10));
			dto1.setTime(rs.getString(11));
			
			al.add(dto1);
		}
		return al;
	}
	//////////////////////// view for Interview Responce/////////////////////////////////////
	public ArrayList<HrDto> final_responce_retrive(HrDto dto) throws ClassNotFoundException, SQLException
	{
		
		Demo_Connection obj1 =new Demo_Connection();
		Connection con = obj1.connection();
		
		String select="select * from candi_regis where status=1 ";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(select);
		
		ArrayList<HrDto> al = new ArrayList<>();
		while(rs.next())
		{
			HrDto dto1=new HrDto();
			//System.out.println("Here");
			dto1.setId(rs.getInt(1));
			dto1.setFirstname((rs.getString(2)));
			dto1.setLastName(rs.getString(3));
			dto1.setEmailId(rs.getString(4));
			dto1.setMob_no(rs.getString(5));
			dto1.setQuali(rs.getString(9));
			dto1.setDate(rs.getString(10));
			dto1.setTime(rs.getString(11));
			dto1.setResponce(rs.getString("responce"));
			dto1.setPerfection(rs.getString("perfection"));
			dto1.setScore(rs.getString("score"));
			dto1.setStatus(rs.getInt("status"));
			dto1.setRes_status(rs.getInt("responce_status"));
			
			al.add(dto1);
		}
		return al;
	}
	
	////////////////View for After Candidates Giving  Responce //////////////////////////
	                      // submit interview response
	public ArrayList<HrDto> Get_final_responce(HrDto dto) throws ClassNotFoundException, SQLException
	{
		
		Demo_Connection obj1 =new Demo_Connection();
		Connection con = obj1.connection();
		
		String select="select * from candi_regis where responce_status=1 ";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(select);
		
		ArrayList<HrDto> al = new ArrayList<>();
		while(rs.next())
		{
			HrDto dto1=new HrDto();
			//System.out.println("Here");
			dto1.setId(rs.getInt(1));
			dto1.setFirstname((rs.getString(2)));
			dto1.setLastName(rs.getString(3));
			dto1.setEmailId(rs.getString(4));
			dto1.setMob_no(rs.getString(5));
			dto1.setQuali(rs.getString(9));
			dto1.setDate(rs.getString(10));
			dto1.setTime(rs.getString(11));
			dto1.setResponce(rs.getString("responce"));
			dto1.setPerfection(rs.getString("perfection"));
			dto1.setScore(rs.getString("score"));
			dto1.setStatus(rs.getInt("status"));
			dto1.setRes_status(rs.getInt("responce_status"));
		
			
			al.add(dto1);
		}
		return al;
	}
	
	
	
	
                           ///////////////////////////////////////////////////////////////////////
	                           //shedule change and  status 1
	public int status_change(List<String> l) throws ClassNotFoundException, SQLException
	{
		Demo_Connection obj = new Demo_Connection();
		Connection con = obj.connection();
		int i=0;
		int stts=0;
		PreparedStatement pst = null;
		for(String row:l)
		{
			stts=Integer.parseInt(row);
			String updt= "update candi_regis set status=? where id="+stts+"";
			pst= con.prepareStatement(updt);
			pst.setInt(1, 1);
		
			Statement st =con.createStatement();
			String slct ="select email,date,time from candi_regis where id="+stts+"";
			ResultSet rs = st.executeQuery(slct);
			sndmail mail = new sndmail();
			String date=null;
			String time=null;
			String candi_email=null;
			while(rs.next())
			{
				date=rs.getString("date");
				time=rs.getString("time");
				candi_email=rs.getString("email");
			}
			
			String responce=mail.mailing(candi_email,date,time);
			System.out.println(responce);	   		   
			i = pst.executeUpdate();
			System.out.println("table sucessfully Updated");
			
		}
		return i;
	}
	public int status_change_after_conform(HrDto dto) throws ClassNotFoundException, SQLException
	{
		Demo_Connection obj = new Demo_Connection();
		Connection con = obj.connection();
		int i=0;
		int stts=0;
		PreparedStatement pst = null;
		
			
			String updt= "update candi_regis set status=? where id="+stts+"";
			pst= con.prepareStatement(updt);
			pst.setInt(1, 1);
			i = pst.executeUpdate();
			return i;
		}
/////////////////////////save Total response//////////////////////////////////
	
	public int save_responce(HrDto dto) throws ClassNotFoundException, SQLException 
	{
		Demo_Connection obj = new Demo_Connection();
		Connection con = obj.connection();
		int i=0;
		String perfection=dto.getPerfection();
		String score=dto.getScore();
		String responce=dto.getResponce();
		
		int id=dto.getId();
		PreparedStatement pst = null;
		String updt= "update candi_regis set responce=?,perfection=?,score=?,status=?,responce_status=? where id="+id+"";
		pst= con.prepareStatement(updt);
		pst.setString(1,responce);
		pst.setString(2,perfection);
		pst.setString(3,score);
		pst.setInt(4, 2);
		pst.setInt(5, 1);
		i = pst.executeUpdate();
		System.out.println("responce_status sucessfully Updated");
		return i;
		
	}
		
	
	public int delete_candi(String id) throws ClassNotFoundException, SQLException 
	{
		Demo_Connection obj = new Demo_Connection();
		Connection con = obj.connection();
		String delete="update candi_regis set status=0 where id="+id+"";
		PreparedStatement pst = con.prepareStatement(delete);
		int i = pst.executeUpdate();
		return 1;
	}
	
	public int save_total_responce(HrDto dto) throws SQLException, ClassNotFoundException
	{
		Demo_Connection obj = new Demo_Connection();
		Connection con = obj.connection();
		int i=0;
		int stts=0;
		PreparedStatement pst = null;
		String perfection=dto.getPerfection();
		String score=dto.getScore();
		String responce=dto.getResponce();
		int id=dto.getId();
			
			String updt= "update candi_regis set perfection=? score=?  where id="+stts+"";
			pst= con.prepareStatement(updt);
			pst.setInt(1, 1);
			i = pst.executeUpdate();
		
		return 0;
	}
	public int change_status(String id) throws SQLException, ClassNotFoundException
	{
		Demo_Connection obj = new Demo_Connection();
		Connection con = obj.connection();
		String delete="update candi_regis set status=0 where id="+id+"";
		PreparedStatement pst = con.prepareStatement(delete);
		int i = pst.executeUpdate();
		return i;
	}
	//  ****************** reshedule  dao**************************
	
	public ArrayList<HrDto> editData(String str1) {
		 ResultSet rs = null;
  	    ArrayList<HrDto> arraylistobj=new  ArrayList<HrDto>();
			try{
				Demo_Connection obj = new Demo_Connection();
				Connection con = obj.connection();
				  int id=Integer.parseInt(str1);
				//  System.out.println("hello");
				  System.out.println(id+10);
				   java.sql.Statement stmt = con.createStatement();
		    
				      String str2= "select * from candi_regis where id="+id+"";
		              rs= stmt.executeQuery(str2);
		              System.out.println(rs);
			/*	PreparedStatement stmt=con.prepareStatement("select * from candi_regis where id=?");  
				stmt.setInt(1, id);
		              System.out.println("after run query");
		        //    System.out.println(stmt.execute("select * from Registeruser where NAME='"+sql+"'"));
		              rs = stmt.executeQuery();*/
		          //    System.out.println(rs.next());
		              while (rs.next()) {
		            	  System.out.println(rs.getString(1));
		            	   HrDto dto=new HrDto();
			                 dto.setFirstname( rs.getString(2));
			                dto.setLastName( rs.getString(3));
			                dto.setEmailId( rs.getString(4));
			                dto.setMob_no( rs.getString(5));
			              dto.setExperience(rs.getString(15));
			                dto.setDate(rs.getString(6));
			                dto.setTime(rs.getString(7));
			                arraylistobj.add(dto);
		              }
		            
			}catch (Exception e) {System.out.println(e);  System.out.println("hello");  System.out.println(rs);
			}
				return arraylistobj; 
	}
	//  ****************** update shedule dao**************************
	public int updateData(HrDto dt)	{
		int i=0;
		try{
			Demo_Connection obj = new Demo_Connection();
			Connection con = obj.connection();
PreparedStatement ps=con.prepareStatement("update   candi_regis   SET date=?  , time=? where id=?");  
		//  java.sql.Statement stmt = con.createStatement();
	//	String query=" update  registeruser  SET NAME='"+dt.getFirstname()+"',PASS='"+dt.getUserPassword()+"',EMAIL='"+dt.getUserEmail()+"',COUNTRY='"+dt.getUserCountry()+"'  where NAME='"+dt.getUserName()+"' ";
		
	//	  int i= stmt.executeUpdate(query);
	//	  stmt.execute("commit");
		System.out.println("connection 8");
		ps.setString(1,dt.getDate());  
		ps.setString(2,dt.getTime());  
		ps.setInt(3, dt.getId());
		

		          
 i=ps.executeUpdate();
		System.out.println(i);
		return i;
		}
	
catch(Exception e){System.out.println(e);}
		return i;
	
}
//////////////////////// view  Upload   Doc   Info//////////////////////////////////
	public ArrayList<HrDto> viewUploadDocInfo(String str1) {
		 ResultSet rs = null;
 	    ArrayList<HrDto> arraylistobj=new  ArrayList<HrDto>();
			try{
				Demo_Connection obj = new Demo_Connection();
				Connection con = obj.connection();
		
				   java.sql.Statement stmt = con.createStatement();
		    
				      String str2= "select * from candi_regis where email='"+str1+"' ";
		              rs= stmt.executeQuery(str2);
		              System.out.println(rs);
			/*	PreparedStatement stmt=con.prepareStatement("select * from candi_regis where id=?");  
				stmt.setInt(1, id);
		              System.out.println("after run query");
		        //    System.out.println(stmt.execute("select * from Registeruser where NAME='"+sql+"'"));
		              rs = stmt.executeQuery();*/
		          //    System.out.println(rs.next());
		              while (rs.next()) {
		              	  System.out.println(rs.getString(1));
		            	   HrDto dto=new HrDto();
			                 dto.setFirstname( rs.getString(2));
			                dto.setLastName( rs.getString(3));
			                dto.setEmailId( rs.getString(4));
			                dto.setMob_no( rs.getString(5));
			             
			             
			                arraylistobj.add(dto);
		              }
		            
			}catch (Exception e) {System.out.println(e);  System.out.println("hello");  System.out.println(rs);
			}
				return arraylistobj; 
	}
	
	
}	
	
  
  