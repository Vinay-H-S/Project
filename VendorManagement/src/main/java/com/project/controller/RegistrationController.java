package com.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.entity.VendorManagementEntity;
import com.project.service.VendorManagementService;

@Controller
@RequestMapping("/")
public class RegistrationController {

	@Autowired
	public VendorManagementService service;

	public RegistrationController() {
		System.out.println("Creating the RegistrationController");
	}

	@PostMapping("/vendor")
	public String save(VendorManagementEntity entity, Model model,String email) {
		System.out.println("Creating the Save method in Controlller");
		System.out.println("Vendormanagement + :" + entity);
		String error = service.isExist(entity.getOwnerName(), entity.getEmail());
		if (error != null) {
			model.addAttribute("error", error);
			return "index";
		}
		this.service.validateAndSave(entity);
		this.service.sendEmail(entity.getEmail());
		return "home";
	}

	
}
