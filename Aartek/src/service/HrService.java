package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.HrDao;
import dto.HrDto;

public class HrService
{
   public int validation(HrDto dtoObj)
   
   {
	 if(dtoObj.getFirstname()!= "" && dtoObj.getLastName()!= "" && dtoObj.getEmailId()!= "" && dtoObj.getUserId()!= "" && dtoObj.getRole()!= "")

	   {
////////////////////////////////////////////////
		HrDao DaoObj=new HrDao();
	int status=	DaoObj.insertData(dtoObj);
	if(status==1)
	{
		System.out.println("Successfully registred");
	}
	else
	{
		System.out.println("value entry faled");
	}
////////////////////////////////////////////////////////////
	    return 1;
	   }
	   else
	  {
		return 0; 
	  }
   }

public boolean save_candi(HrDto dto) throws ClassNotFoundException, SQLException 
{
boolean  status=false;
	if(dto.getFirstname()!= "" && dto.getLastName()!= "" && dto.getEmailId()!= "" && dto.getMob_no()!="" && dto.getGender()!=""
			&& dto.getCity()!="" && dto.getState()!="" && dto.getQuali()!="" && dto.getDate()!="" && dto.getTime()!="")

	   {
		
		/*String Fname="^[a-zA-Z]{3,10}$";
		String Lname="^[a-zA-Z]{3,10}$";
		String Email="^[a-zA-Z0-9]{5,10}@[a-zA-Z0-9]{4,10}].[a-z]{2,4}$";
		String Mob_no="^[0-9]{11}$";
		String gender;
		String City="^[a-zA-Z]{3,10}$";
		String State="^[a-zA-Z]{3,10}$";
		String Quali="^[a-zA-Z]{3,10}$";
		//String date="^[1-9]{1,10}";
		//String time="^[1-9]{1,10}:[1-9]{10}$";
		Pattern pfname = Pattern.compile(Fname);
		Pattern plname = Pattern.compile(Lname);
		Pattern pemail = Pattern.compile(Email);
		Pattern pmob = Pattern.compile(Mob_no);
		Pattern pcity = Pattern.compile(City);
		Pattern pstate = Pattern.compile(State);
		Pattern pquali = Pattern.compile(Quali);
		//Pattern pdate = Pattern.compile(date);
		//Pattern ptime = Pattern.compile(time);
		
		Matcher mfname = pfname.matcher(dto.getFirstname());
		Matcher mlname = plname.matcher(dto.getLastName());
		Matcher memail = pemail.matcher(dto.getEmailId());
		Matcher mmob = pmob.matcher(dto.getMob_no());
		//Matcher mgender = pmob.matcher(dto.getGender());
		Matcher mcity = pmob.matcher(dto.getCity());
		Matcher mstate = pmob.matcher(dto.getState());
		Matcher mquali = pmob.matcher(dto.getQuali());
		//Matcher mdate = pmob.matcher(dto.getDate());
		//Matcher mtime = pmob.matcher(dto.getTime());
		
		if(mfname.matches() && mlname.matches() && memail.matches() && mmob.matches() && mcity.matches()
				&& mstate.matches() && mquali.matches())
		{*/
			
			HrDao DaoObj=new HrDao();
			status=	DaoObj.save_candi(dto);
			if(status==true)
			{
				System.out.println("Successfully registred");
				return true;
				
			}
			else
			{
				System.out.println("value entry faled");
				return false;
			}
	
	   }
	else
	   {
		   System.out.println("Data is not Valid"); 
		   
	   }
	
	return status;
}  
public ArrayList<HrDto> validRetrive(HrDto dto) throws ClassNotFoundException, SQLException, IOException
{
	HrDao dao = new HrDao();
	
	ArrayList<HrDto> al = dao.DataRetrive(dto);
	if(al.size()!=0)
	{
		//System.out.println("Data of Array List is here");
	}
	else
	{
		System.out.println("Array List is Empty here");
	}
	return al;
}
		
}
	   
   
  
 
 
