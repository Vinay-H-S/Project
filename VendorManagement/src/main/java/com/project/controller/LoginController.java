package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.project.entity.VendorManagementEntity;
import com.project.repository.VendorManagementRepository;
import com.project.service.VendorLoginService;
import com.project.service.VendorManagementService;
import com.project.util.OtpGenarator;

@EnableWebMvc
@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private VendorManagementService service;

	@Autowired
	private VendorManagementRepository repository;

	public LoginController() {
		System.out.println("Creating the LoginController()");
	}

	@RequestMapping("/welcome")
	public String loginusingEmailAndOtp(VendorManagementEntity entity, String email, String otp, Model model) {
		System.out.println("Creating the loginUsingEmailAndOtp() in loginController");
		System.out.println("Entity is not null");
		model.addAttribute("ent", entity);
		String userExist = this.service.isExist(email, otp);
		if (userExist != null) {
			model.addAttribute("msg", userExist);
			this.repository.updatedOtpByEmail(email, OtpGenarator.genarateOTP());
			return "login";
		} else {
			this.repository.updatedOtpByEmail(email, OtpGenarator.genarateOTP());
		}
		return "signin";
	}
}
