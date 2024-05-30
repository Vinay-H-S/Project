package com.project.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.project.entity.VendorManagementEntity;
import com.project.repository.VendorManagementRepository;
import com.project.service.VendorLoginService;

@EnableWebMvc
@Controller
@RequestMapping("/")
@MultipartConfig
public class LoginController {

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

	@RequestMapping(path = "/login")
	public String login(Model model, @PathVariable int vendorId) {
		VendorManagementEntity entity = this.repository.getVendorEntityById(vendorId);
		model.addAttribute("entites", entity);
		return "login";
	}

	@RequestMapping(path = "/editvendorentity/{vendorId}")
	public String editVendor(@PathVariable int vendorId, Model model) {
		System.out.println("invoking the editVendor() inloginController");
		VendorManagementEntity entity = this.repository.getVendorEntityById(vendorId);
		if (entity.getVendorId() == vendorId) {
			model.addAttribute("entites", entity);
			return "editvendor";
		}
		return "login";
	}

	@RequestMapping(value = "/uploadprofile/{vendorId}", method = RequestMethod.POST)
	public String imageUpload(@RequestParam("profileImage") MultipartFile file, @PathVariable int vendorId, Model model,
			HttpServletRequest req) throws IOException {
		String originalFileName = file.getOriginalFilename();
		VendorManagementEntity entity = new VendorManagementEntity();
		entity.setProfileImage(originalFileName);
		this.repository.saveImage(vendorId, originalFileName);
		System.out.println("Image is Saved");
		String path = "D:\\Project\\VendorManagement\\src\\main\\resources\\images\\" + originalFileName;

		byte[] bytes = file.getBytes();

		FileOutputStream fileOutputStream = new FileOutputStream(path);
		System.out.println("Image is Saved");
		fileOutputStream.write(bytes);
		fileOutputStream.close();
		System.out.println(originalFileName);
		return "redirect:/login";
	}

	@GetMapping(value = "/displayImages")
	public void displayImages(@RequestParam int vendorId, HttpServletResponse response) throws IOException {
		System.out.println("invoking the displayImages() in loginCotroller");
		List<VendorManagementEntity> entites = this.repository.findAll();
		for (VendorManagementEntity entity : entites) {
			if (entity.getVendorId() == vendorId) {
				String image = entity.getProfileImage();
				File file = new File("D:\\Project\\VendorManagement\\src\\main\\resources\\images\\" + image);
				System.out.println(file);
				InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
				ServletOutputStream outputStream = response.getOutputStream();
				IOUtils.copy(inputStream, outputStream);
				response.flushBuffer();
			}

		}

	}

	@RequestMapping(path = "/updatevendor/{vendorId}")
	public String updateVendor(@PathVariable int vendorId, @ModelAttribute VendorManagementEntity entity, Model model) {
		System.out.println("invoking the updateVendor() in logincontroller");
		this.repository.updateVendorEntityById(vendorId, entity);
		model.addAttribute("entites", entity);
		return "redirect:/login";
	}

}
