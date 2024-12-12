package org.kure.example12.mail;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.IOException;
import java.util.Properties;

public class MailSender {
    private static final GreenMail greenMail = new GreenMail(new ServerSetup(3025, null, "smtp")); // Port 3025 for SMTP

    public static void main(String[] args) throws MessagingException, IOException {
        startMailServer();

        // Configure mail session
        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.host", "localhost");
        mailProperties.put("mail.smtp.port", "3025");

        Session session = Session.getInstance(mailProperties);

        // Send an email
        String from = "sender@example.com";
        String to = "receiver@example.com";
        String subject = "Test Email";
        String body = "Hello! This is a test email sent using GreenMail.";

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(body);

        Transport.send(message);
        System.out.println("Email sent!");

        readMails();
        stopServer();
    }

    private static void readMails() throws MessagingException, IOException {
        // Verify email was sent using GreenMail
        MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
        if (receivedMessages.length > 0) {
            MimeMessage receivedMessage = receivedMessages[0];
            System.out.println("Email received successfully!");
            System.out.println("Subject: " + receivedMessage.getSubject());
            System.out.println("Body: " + receivedMessage.getContent());
        } else {
            System.out.println("No emails received.");
        }
    }

    private static void stopServer() {
        greenMail.stop();
    }

    private static void startMailServer() {
        greenMail.start();
    }
}
