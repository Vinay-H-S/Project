package com.project.service;

public interface VendorLoginService {

	public String emailLoginAjax(String email);
	
	public String loginUsingEmailAndOtp(String email,int otp);
	
	public boolean updatedOtpByMail(String email);
	
}
