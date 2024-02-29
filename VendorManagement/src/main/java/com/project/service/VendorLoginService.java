package com.project.service;

public interface VendorLoginService {

	public String emailLoginAjax(String email);
	
	public String loginOtpEmailMessage(String email);
	
	public String loginOtpAjax(String otp);
	
}
