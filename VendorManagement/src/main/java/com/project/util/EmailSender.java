package com.project.util;

import java.util.Properties;

import org.springframework.stereotype.Controller;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Controller
public class EmailSender {

	public EmailSender() {
		System.out.println("invoking the EmailSender()");
	}

	public boolean emailSender(String to, String from, String subject, String text) {
		String portNumber = "587";
		String hostName = "smtp.office365.com";
		String fromEmail = "vinayshudedar383@gmail.com";
		String password = "Vini@4183";

		Properties prop = new Properties();

		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocol", "smtp");

		// Creating seission object

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
			
		});

		// Creating the message object

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject(subject);
			message.setText(text);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		System.out.println("Email Send Successfully");
		return false;
	}
}
