package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.email.EmailSender;
import com.project.entity.VendorManagementEntity;
import com.project.repository.VendorManagementRepository;

@Service
public class VendorLoginServiceImpl implements VendorLoginService {

	@Autowired
	private VendorManagementRepository repository;

	@Autowired
	private EmailSender emailSender;

	public VendorLoginServiceImpl() {
		System.out.println("invoking the Login Service");
	}

	@Override
	public String emailLoginAjax(String email) {
		System.out.println("invoking emailLoginAjax in LoginServiceImpl");
		List<VendorManagementEntity> entity = this.repository.findAll();
		for (VendorManagementEntity ent : entity) {
			if (ent.getEmail().equalsIgnoreCase(email)) {
				return "";
			} else {
				return "User Exsit, login with your email";
			}
		}
		return null;
	}

	@Override
	public String loginUsingEmailAndOtp(String email, int otp) {
		System.out.println("invoking the loginUsingEmailAndOtp in vendorLoginServiceImpl");

		String subject = "One Time Password";
		String text = "Your OTP for login";
		String to = email;
		String from = "vinayshudedar383@gmail.com";

		this.emailSender.emailSender(to, from, subject, text);

		return null;
	}

	@Override
	public boolean updatedOtpByMail(String email) {
		System.out.println("invoking the updatedOtpByEmail in loginSeriveImpl");
		System.out.println("Generate OTP (One Time Password),");
		int otp = (int) (Math.random() * 900000) + 100000;
		System.out.println("4 digits OTP: " + otp);
		
		List<VendorManagementEntity> entity=this.repository.findAll();
		for (VendorManagementEntity en : entity) {
			if(en.getOtp().equals(otp)){
				this.repository.updatedOtpByEmail(email, otp);
				return true;
			}
		}
		return true;
	}
}


