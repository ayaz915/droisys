package test;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by anirudh on 28/10/14.
 */
public class JavaGmailSendExample {

    public static void main(String args[]) {

          final String username = "ayaz.hasan915@gmail.com";
          final String password = "ghxwkqjdvxfogjig";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ayaz.hasan915@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("ayaz.hasan915@gmail.com"));
            message.setSubject("Test JCG Example");
            message.setText("Hi," +
                    "This is a Test mail for JCG Example!");

            Transport.send(message);

            System.out.println("Mail sent succesfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
