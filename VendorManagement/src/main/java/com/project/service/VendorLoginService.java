package com.project.service;


import java.time.LocalTime;
import java.util.List;

import org.springframework.ui.Model;

import com.project.entity.VendorManagementEntity;

public interface VendorLoginService {
	
	public static final Integer ATTEMPT_TIME=3;

	public String emailLoginAjax(String email);

	public String loginOtpAjax(String otp);

	public String loginOtpEmailMessage(String email);

	public List<VendorManagementEntity> profileDetails(String email);
	
	public boolean verifyOtp(String otp,String email);
	
	public void  updateFailedAttemptCount(Integer failedAttempt,String email);
	
	public void accountLockTime(LocalTime accountLockTime,String email);
	
	public void expireOTPAndResetAttempt(String otp,Integer failedAttempt,String email);
	


}
