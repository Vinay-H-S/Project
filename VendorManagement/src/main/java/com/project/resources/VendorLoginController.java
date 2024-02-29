package com.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import com.project.service.VendorLoginService;

@RestController
@RequestMapping("/")
@EnableWebMvc
public class VendorLoginController {

	@Autowired
	@Qualifier(value = "loginService")
	private VendorLoginService service;

	public VendorLoginController() {
		System.out.println("Creating the VendorLoginController");
	}

	@GetMapping(value = "/loginMailAjax/{email}")
	public String loginEmailAjax(@PathVariable String email) {
		System.out.println("invoking the ajaxEmailLogin");
		return this.service.emailLoginAjax(email);

	}

	@GetMapping(value = "/loginOtpEmailMsg/{email}")
	public String loginOtpMsg(@PathVariable String email) {
		System.out.println("invoking the loginOtpMsg in vendorLoginController");
		System.out.println("Login Details SEend SuccessFully");//Otp email sender;
		return this.service.loginOtpEmailMessage(email);
	}	
	
	@GetMapping(value = "/loginOtpAjax/{otp}")
	public String loginOtpAjax(@PathVariable String otp) {
		System.out.println("invoking the loginOtpAjax() in vendorLoginController");
		return this.service.loginOtpAjax(otp);
	}
	
}
