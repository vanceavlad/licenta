package com.licenta.Utils;


import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

    private static final String EMAIL_ADDRESS = "vanceavladsupp@gmail.com";
    private static final String PASSWORD = "adminpass";
    private static final String USERNAME = "vanceavladsupp";
    private static final String HOST = "localhost";


    private String sendTo;
    private String subject;
    private String text;


    public SendEmail() {
    }


    public SendEmail(String sendTo, String subject, String text) {
        this.sendTo = sendTo;
        this.subject = subject;
        this.text = text;
    }


    public String sendEmail(String toEmail) {
        String result = "";

        Properties properties = new Properties();
      properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587");

        Session session = Session.getInstance(properties);

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(EMAIL_ADDRESS));

            // Set To: header field of the header.
            InternetAddress[] address = {new InternetAddress(toEmail)};
            message.setRecipients(Message.RecipientType.TO, address);


            // Set Subject: header field
            message.setSubject(subject);
            message.setContent("<p> This doctor want acces to your account:<p><br><p>" + text + "</p>","text/html");

            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", USERNAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());


            result = "Email sent with success! Please check your inbox at " + sendTo;

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


        return result;

    }
}
