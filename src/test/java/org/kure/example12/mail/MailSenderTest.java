package org.kure.example12.mail;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import jakarta.mail.Address;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class MailSenderTest {

    private GreenMail greenMail;

    @BeforeEach
    void setupGreenMail() {
        greenMail = new GreenMail(new ServerSetup(3025, null, "smtp"));
        greenMail.start();
    }

    @AfterEach
    void tearDownGreenMail() {
        greenMail.stop();
    }

    @Test
    void testEmailSending() throws Exception {
        //Given
        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.host", "localhost");
        mailProperties.put("mail.smtp.port", "3025");
        Session session = Session.getInstance(mailProperties);

        //When
        String from = "sender@example.com";
        String to = "receiver@example.com";
        String subject = "Test Email";
        String body = "This is a test email.";

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(body);

        Transport.send(message);

        //Then
        MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
        assertEquals(1, receivedMessages.length, "Email count should be 1");

        MimeMessage receivedMessage = receivedMessages[0];
        assertEquals(subject, receivedMessage.getSubject(), "Subject should match");
        assertEquals(body, receivedMessage.getContent(), "Body should match");
    }
}