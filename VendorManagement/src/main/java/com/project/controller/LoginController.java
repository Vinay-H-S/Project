package com.project.controller;

import java.time.Duration;

import java.time.LocalTime;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.project.entity.VendorManagementEntity;
import com.project.repository.VendorManagementRepository;
import com.project.service.VendorLoginService;
import com.project.service.VendorManagementService;
import com.project.util.OtpGenarator;

@EnableWebMvc
@Controller
@RequestMapping("/")
@MultipartConfig
public class LoginController {

	@Autowired
	private VendorManagementService service;

	@Autowired
	private VendorLoginService loginService;

	@Autowired
	private VendorManagementRepository repository;

	public LoginController() {
		System.out.println("Creating the LoginController()");
	}

	@RequestMapping("/welcome")
	public String loginusingEmailAndOtp(@RequestParam String email, Model model) {
		System.out.println("Creating the loginUsingEmailAndOtp() in loginController");
		List<VendorManagementEntity> entities = this.repository.findAll();
		for (VendorManagementEntity vendorManagementEntity : entities) {
			if (vendorManagementEntity.getEmail().equals(email)) {
				model.addAttribute("ent", vendorManagementEntity);
				return "otpverification";
			}
		}
		return "signin";
	}

	@RequestMapping(value = "/otpverification")
	public String otpVerification(Model model) {
		List<VendorManagementEntity> entity = this.repository.findAll();
		for (VendorManagementEntity vendorManagementEntity : entity) {
			model.addAttribute("ent", vendorManagementEntity);
			model.addAttribute("otpErrmsg", "*OTP Expired");
			model.addAttribute("otpErrmsg", "*OTP RESETED");
		}
		return "otpverification";
	}

	@RequestMapping("/verifyotp")
	public String verifyOtp(@RequestParam String email, @RequestParam String otp, Model model) {
		System.out.println("invoking the verifyOtp() in logincontroller");
		VendorManagementEntity mail = this.repository.getVendorEntityByEmail(email);
		model.addAttribute("ent", mail);
		LocalTime otpGenaratedTime = mail.getOtpGenratedTime();
		LocalTime currentTime = LocalTime.now();
		if (mail != null) {
			if (mail.getEmail().equals(email) && mail.getOtp().equals(otp)) {
				if (Duration.between(otpGenaratedTime, currentTime).getSeconds() < (1 * 60)) {
					System.out.println("OTP Valid");
					model.addAttribute("entites", mail);
					this.loginService.expireOTPAndResetAttempt("032100", 0, email);
					return "login";
				} else if (Duration.between(otpGenaratedTime, currentTime).getSeconds() > (1 * 60)) {
					System.out.println("OTP in-Valid");
					model.addAttribute("otpErrmsg", "*OTP Expired");
					this.loginService.expireOTPAndResetAttempt("032100", 0, email);
					return "redirect:/otpverification";
				}
			} else {
				this.loginService.verifyOtp(otp, email);
				if (Duration.between(otpGenaratedTime, currentTime).getSeconds() > (2 * 60)) {
					System.out.println("OTP reseted");
					model.addAttribute("otpErrmsg", "*OTP RESETED");
					this.loginService.expireOTPAndResetAttempt("032100", 0, email);
					return "redirect:/otpverification";
				}
			}
		}
		return "otpverification";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		List<VendorManagementEntity> entities = this.repository.findAll();
		for (VendorManagementEntity entity : entities) {
			model.addAttribute("entites", entity);
		}
		return "login";
	}

	@RequestMapping(value = "/editvendor")
	public String edit(Model model) {
		System.out.println("invoking the edit() inloginController");
		List<VendorManagementEntity> entities = this.repository.findAll();
		for (VendorManagementEntity entity : entities) {
			model.addAttribute("entites", entity);
		}
		return "editvendor";
	}

	@RequestMapping(path = "/editvendor/{id}")
	public String editVendor(@PathVariable int id, Model model) {
		System.out.println("invoking the editVendor() inloginController");
		VendorManagementEntity entity = this.repository.getVendorEntityById(id);
		if (entity.getId() == id) {
			model.addAttribute("entites", entity);
			return "editvendor";
		}
		return "redirect:/login";
	}

	@RequestMapping(path = "/updateVendor", method = RequestMethod.POST)
	public String updateVendor(@PathVariable int id, VendorManagementEntity ent) {
		System.out.println("invoking the updateVendor() in logincontroller");
		this.repository.updateVendorEntity(id, ent);
		System.out.println("Data is updated");

		return "redirect:/login";
	}

	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
	public String imageUpload(MultipartFile profileImage) {
		System.err.println(profileImage.getOriginalFilename());
		return "editvendor";
	}

}
