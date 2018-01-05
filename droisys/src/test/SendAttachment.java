package test;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

class SendAttachment{
 public static void main(String [] args){

  String to="ayaz.hasan915@gmail.com";//change accordingly
  final String user="ayaz.hasan915@gmail.com";//change accordingly
  final String password="ghxwkqjdvxfogjig";//change accordingly
 
  //1) get the session object   
  Properties properties = System.getProperties();
  properties.put("mail.smtp.auth", "true");
  properties.put("mail.smtp.starttls.enable", "true");
  properties.put("mail.smtp.host", "smtp.gmail.com");
  properties.put("mail.smtp.port", "587");

  Session session = Session.getDefaultInstance(properties,
   new javax.mail.Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
   return new PasswordAuthentication(user,password);
   }
  });
   
  //2) compose message   
  try{
    MimeMessage message = new MimeMessage(session);
    message.setFrom(new InternetAddress(user));
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
    message.setSubject("Digital Marketing Automation Report");
    
    //3) create MimeBodyPart object and set your message content    
    BodyPart messageBodyPart1 = new MimeBodyPart();
    messageBodyPart1.setText("pfa");
    
    //4) create new MimeBodyPart object and set DataHandler object to this object    
    MimeBodyPart messageBodyPart2 = new MimeBodyPart();

    
    DataSource source = new FileDataSource(System.getProperty("user.dir")+"\\email_PDF Reports.zip");
    messageBodyPart2.setDataHandler(new DataHandler(source));
    messageBodyPart2.setFileName("email_PDF Reports.zip");
    //5) create Multipart object and add MimeBodyPart objects to this object    
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart1);
    multipart.addBodyPart(messageBodyPart2);

    //6) set the multiplart object to the message object
    message.setContent(multipart );
   
    //7) send message
    Transport.send(message);
 
   System.out.println("message sent....");
   }catch (MessagingException ex) {ex.printStackTrace();}
 }
}