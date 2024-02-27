package com.project.service;

import java.util.Properties;

import org.hibernate.type.LocalDateTimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.VendorManagementEntity;
import com.project.repository.VendorManagementRepository;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class VendorManagementServiceImpl implements VendorManagementService {

	@Autowired
	private VendorManagementRepository repo;

	@Override
	public boolean validateAndSave(VendorManagementEntity entity) {
		System.out.println("Creating the validateAndSave");
		this.repo.save(entity);
		return true;
	}

	@Override
	public String isExist(String ownerName, String email) {
		System.out.println("invoking the isExist in repository");
		VendorManagementEntity entity = this.repo.isExist(ownerName, email);
		if (entity != null) {
			if (entity.getOwnerName().equals(ownerName) && entity.getEmail().equals(email)) {
				return "User Already Exist";
			} else {
				System.err.println("Details not found.....save the details");
			}
		}
		return null;
	}

	@Override
	public boolean sendEmail(String email) {

		System.out.println("Sending the msg");

		String portNumber = "587";
		String hostName = "smtp.office365.com";
		String fromEmail = "vinayshudedar383@gmail.com";
		String password = "Vini@4183";
		String to = email;

		Properties prop = new Properties();

		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocol", "smtp");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				System.out.println("PasswordAuthentication");
				return new PasswordAuthentication(fromEmail, password);
			}
		});

		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject("Registration Form");
			message.setText("Registration Completed"+ "${vendorName}");

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(message);

			return true;

		}

		catch (MessagingException e) {
			e.printStackTrace();
		}

		return false;
	}


}
