package hr;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
  
public class sndmail
{  
 public String mailing(String email, String date, String time)
 {  
  
	 String to=email;//change accordingly  
  
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
   message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
   message.setSubject("Interview Shedule");  
   message.setText("Dear Candidate,\r\n \t\t\t\t\t Your interview is shedule in Aartek Software Solution on" +date+" at "+time+".please reach here at specified date and time with requirment documents.\n\n \t\t\t" +
   		"\t\t\t\t\t\t\t\t\t\t\t\t\tHr \n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Aartek Software Solution Indore /n");
   //send message  
   Transport.send(message);  
  
   System.out.println("message sent successfully");  
   
  } catch (MessagingException e) {throw new RuntimeException(e);}  
   return "Success";
 }  
}
