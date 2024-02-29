package com.project.util;

public class OtpGenarator {

	public static String genarateOTP(){
		System.out.println("Generate OTP (One Time Password)");
		int genarateOtp = (int) (Math.random() * 900000) + 100000;
		String otp = String.valueOf(genarateOtp);
		System.out.println("6 digits OTP: " + otp);
		return otp;
	}
}
