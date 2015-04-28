package offer_letter_And_Email;
import java.util.*;
import java.io.*;
public class JoiningLetter {
	

	public boolean joiningLetter(String fname1, String lname, String offer_ctc,
			String offer_possition, String joining_date, String email_id) {
		String fname="Nmae :";	String fdesignation="Designation :"; 	String fctc="CTC :";	String fdate="Date of Joining :";
		String newline="\r\n"; String dear="Dear Mr."; String tab="\r\t";String fidate="Joining Date :"; String cur="Current Date :";
		try{  
			 FileInputStream fn=new FileInputStream("D:\\KK_Private_Area\\Aartek\\src\\offer_letter_And_Email\\offerletter.txt");
			 FileInputStream fh=new FileInputStream("D:\\KK_Private_Area\\Aartek\\src\\offer_letter_And_Email\\header.txt");
		     String file_name="D:\\Kepler\\"+fname1+".txt";
			 FileOutputStream fot=new FileOutputStream( file_name);    
		     
		     byte aa[]=fname1.getBytes(); 
		     byte bb[]=joining_date.getBytes();
		     byte cc[]=offer_possition.getBytes();
		     byte dd[]= offer_ctc.getBytes();
		     byte ee[]=fname.getBytes(); byte ff[]=fdesignation.getBytes(); byte gg[]=fctc.getBytes(); byte hh[]=fdate.getBytes();
		     byte ii[]=newline.getBytes(); byte jj[]=dear.getBytes(); byte kk[]=tab.getBytes(); byte ll[]=fidate.getBytes();byte nn[]=cur.getBytes();
		     fot.write(ee); fot.write(aa);fot.write(ii);fot.write(ii);
		     fot.write(ff); fot.write(cc);fot.write(ii);fot.write(ii);
		     fot.write(gg); fot.write(dd);fot.write(ii);fot.write(ii);
		     fot.write(kk); fot.write(jj);fot.write(aa);fot.write(ii);
		     int jjj=0;  
	    	    while((jjj=fh.read())!=-1){   
	    	     fot.write((byte)jjj);
	    	     } 
	    	    fot.write(cc);
		        int iii=0;  
	    	    while((iii=fn.read())!=-1){  
	    	     fot.write((byte)iii);

	    	    }
	    	    java.sql.Date dt1 = new java.sql.Date(System.currentTimeMillis());
	 		    String dtt = dt1.toString();
	 		    byte mm[]=dtt.getBytes();
	 		    fot.write(ii);fot.write(ii);fot.write(ii);fot.write(ii); fot.write(ll);
	    	    fot.write(bb);  fot.write(kk);fot.write(kk);fot.write(kk);fot.write(kk);fot.write(kk);fot.write(kk);fot.write(kk);fot.write(kk);  fot.write(kk);  fot.write(kk);  fot.write(kk);  fot.write(kk);  fot.write(nn);fot.write(mm);
	    	    fn.close();
	    	    fh.close();
		        fot.close();  
		        System.out.println("successfully write");  
		        new SendMailWithAttechment(). mailing(email_id,  file_name);
		        return true;
		    }
		catch(Exception e){
		    	System.out.println("offer file"+e);
		    	}  
		 return false;
	}  
	}


