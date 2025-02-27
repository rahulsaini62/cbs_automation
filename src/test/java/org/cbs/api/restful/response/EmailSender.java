package org.cbs.api.restful.response;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSender {

    public static void sendEmail(String toEmail, String subject, String body) {
        System.out.println("111111111111");
//        final String fromEmail = "aakash.singh@appinventiv.com"; // sender's email
        final String fromEmail = "rahul.saini1@appinventiv.com"; // sender's email
        final String password = "Home@839"; // sender's email password

        // Set up the SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Create session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                System.out.println("222222222222222");
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        System.out.println("3333333333333");
        try {
            // Compose the email


            System.out.println("33333333333");
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject(subject);
            message.setText(body);

            // Send the email
            Transport.send(message);
            System.out.println("Email Sent Successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}