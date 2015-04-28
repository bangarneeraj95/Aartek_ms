package offer_letter_And_Email;

import java.io.File;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMailWithAttechment {

	public String mailing(String email, String file_name) {
	//	String recipient = null;
	//	String subject = null;
	//	String content = null;
	
/*System.out.println(recipient);System.out.println(subject);System.out.println( content );System.out.println(uploadedFiles);
StringTokenizer st=new StringTokenizer(recipient, ",");
//while(st.hasMoreTokens()){


		 String to=st.nextToken();//change accordingly  
*/		  
		  //Get the session object  
		  Properties props = new Properties();  
		  props.put("mail.smtp.host", "smtp.gmail.com");  
		  props.put("mail.smtp.socketFactory.port", "465");  
		  props.put("mail.smtp.socketFactory.class",  
		            "javax.net.ssl.SSLSocketFactory");  
		  props.put("mail.smtp.auth", "true");  
		  props.put("mail.smtp.port", "465");  
		   
		  Session session = Session.getDefaultInstance(props,  
		   new javax.mail.Authenticator() {  
		   protected PasswordAuthentication getPasswordAuthentication() {  
		   return new PasswordAuthentication("shadabahamad.619@gmail.com","Heena_619");//change accordingly  
		   }  
		  });  
		   
		  //compose message  
		  try {  
		   MimeMessage message = new MimeMessage(session);  
		   message.setFrom(new InternetAddress("shadabahamad.619@gmail.com"));//change accordingly  
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));  
		   message.setSubject("Offer_Letter");  
		 
		 //3) create MimeBodyPart object and set your message text     
		   BodyPart messageBodyPart1 = new MimeBodyPart();  
		   messageBodyPart1.setText( "Dear Candidate,\r\n \t\t\t\t\t Your Offer_Letter in Aartek Software Solution please reach here at specified date and time with requirment documents.\n\n \t\t\t" +
			   		"\t\t\t\t\t\t\t\t\t\t\t\t\tHr \n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Aartek Software Solution Indore /n");  
		   messageBodyPart1.setContent("<h1><a href='http://192.168.1.128:7070/Aartek/upload_doc.jsp?email="+email+"'>Pls Click Here for Upload dacument</a></h1> ", "text/html");
		   //4) create new MimeBodyPart object and set DataHandler object to this object      
		
		   MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
		 	   
		   
		   
		   String filename =file_name;//change accordingly  
		   System.out.println("getFile: " + filename);
		   DataSource source = new FileDataSource(filename);  
		   messageBodyPart2.setDataHandler(new DataHandler(source));  
		   messageBodyPart2.setFileName(filename);  
		 //5) create Multipart object and add MimeBodyPart objects to this object      
		   Multipart multipart = new MimeMultipart();  
		 
		   multipart.addBodyPart(messageBodyPart1);  
		  multipart.addBodyPart(messageBodyPart2);  
		   //6) set the multiplart object to the message object  
		   message.setContent(multipart );  
		    
		   //send message  
		   Transport.send(message);  
		  
		   System.out.println("message sent successfully");  
		   
		  } catch (MessagingException e) {throw new RuntimeException(e);}  
		   

		   return "Success";
	}

}
