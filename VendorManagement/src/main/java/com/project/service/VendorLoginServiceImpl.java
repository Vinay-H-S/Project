package com.project.service;

import java.time.LocalTime;
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

	private static final Integer ATTEMPT_TIME = 3;

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
	public String loginOtpAjax(String otp) {
		System.out.println("invoking the loginOtpAjax in LoginImpl");
		List<VendorManagementEntity> entities = this.repository.findAll();
		for (VendorManagementEntity mail : entities) {
			if (mail.getOtp().equals(otp)) {
				return "";
			} else if (mail.getFailedAttempt() == 1) {
				return "*Wrong Otp, Remaining Attempt 2";
			} else if (mail.getFailedAttempt() == 2) {
				return "*Wrong Otp, Remaining Attempt 1";
			}
				else if(mail.getAccountLockStatus().equals("Locked")) {
				return "*Otp Expired, Reset Your OTP";
			}
		}

		return "*Otp Not Matching";
	}

	@Override
	public String loginOtpEmailMessage(String email) {
		System.out.println("invoking the loginUsingEmailAndOtp in vendorLoginServiceImpl");

		String otp = OtpGenarator.genarateOTP();

		String subject = "One Time Password";
		String text = "Your OTP for login : " + otp + " Thank You !! ";
		String to = email;
		String from = "vinayshudedar383@gmail.com";

		boolean emailOtp = this.emailSender.emailSender(to, from, subject, text);
		this.repository.updatedOtpByEmail(email, otp);
		System.out.println("Otp Updated Successfully");
		if (emailOtp) {
			return "*OTP Sent Successfully";
		}

		return null;
	}

	@Override
	public List<VendorManagementEntity> profileDetails(String email) {
		System.out.println("Invoking the profile details");
		List<VendorManagementEntity> entity = this.repository.findAll();
		for (VendorManagementEntity vendorManagementEntity : entity) {
			if (vendorManagementEntity.getEmail().equals(email)) {
				return entity;
			} else {
				System.out.println("Entity not found on Database");
			}
		}

		return entity;
	}

	@Override
	public boolean verifyOtp(String otp, String email) {
		System.out.println("invoking the verifyOtp() in loginservice");
		VendorManagementEntity entity = this.repository.getVendorEntityByEmail(email);
		if (entity != null) {
			if (entity.getEmail().equalsIgnoreCase(email)) {
				if (!entity.getOtp().equals(otp)) {
					if (entity.getFailedAttempt() < ATTEMPT_TIME - 1) {
						updateFailedAttemptCount(entity.getFailedAttempt(), entity.getEmail());
					} else if (entity.getFailedAttempt() == ATTEMPT_TIME - 1) {
						updateFailedAttemptCount(entity.getFailedAttempt(), entity.getEmail());
						accountLockTime(LocalTime.now(), email);
					}
				}
			}
		}

		return false;
	}


	@Override
	public void updateFailedAttemptCount(Integer failedAttempt, String email) {
		System.out.println("invoking the updateFailedAttemptCount() in loginService");
		if (failedAttempt != ATTEMPT_TIME) {
			this.repository.updateFailedAttemptCount(email, failedAttempt + 1);
			failedAttempt = ATTEMPT_TIME;
			System.out.println("Failed Attempt is created");
		}
		System.out.println("updateFailedAttemptCount is incresedd");
	}

	@Override
	public void accountLockTime(LocalTime accountLockTime, String email) {
		System.out.println("invoking the accountLockTime() in loginservice");
		this.repository.updateAccountLockTime(email, accountLockTime);
		System.out.println("accountLockTime is done");
	}

	@Override
	public void expireOTPAndResetAttempt(String otp, Integer failedAttempt, String email) {
		System.out.println("invking the expireOTPandResetAttempt() in loginService");
		this.repository.expiredOtpAndAttempt(otp, failedAttempt, email);
		System.out.println("expireOTPAndResetAttempt is done");

	}

}
