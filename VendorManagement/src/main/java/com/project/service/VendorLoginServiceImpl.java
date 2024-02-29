package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.VendorManagementEntity;
import com.project.repository.VendorManagementRepository;
import com.project.util.EmailSender;
import com.project.util.OtpGenarator;

@Service(value = "loginService")
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
				System.out.println("Email is Verified");
				return "";
			}
		}
		return "*Please Register Account";
	}

	@Override
	public String loginOtpEmailMessage(String email) {
		System.out.println("invoking the loginUsingEmailAndOtp in vendorLoginServiceImpl");

		String otp = OtpGenarator.genarateOTP();

		String subject = "One Time Password";
		String text = "Your OTP for login : " + otp;
		String to = email;
		String from = "vinayshudedar383@gmail.com";

		boolean emailOtp = this.emailSender.emailSender(to, from, subject, text);
		this.repository.updatedOtpByEmail(email, otp);
		if (emailOtp) {
			return "*OTP Sent Successfully";
		}

		return null;
	}

	@Override
	public String loginOtpAjax(String otp) {
		System.out.println("invoking the loginOtpAjax in LoginImpl");
		List<VendorManagementEntity> entity = this.repository.findAll();
		for (VendorManagementEntity ent : entity) {
			if (ent.getOtp().equals(otp)) {
				return "*OTP Matched";
			} else {
				return "*OTP is not matching";
			}
		}
		return null;
	}

}
