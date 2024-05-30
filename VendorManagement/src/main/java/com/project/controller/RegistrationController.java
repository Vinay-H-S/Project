package com.project.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.dto.VendorDTO;
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
	public String save(VendorDTO dto, Model model, String email) {
		System.out.println("Creating the Save method in Controlller");
		VendorManagementEntity entity=new VendorManagementEntity();
		this.service.validateAndSave(dto);
		BeanUtils.copyProperties(dto, entity);
		this.service.sendEmail(entity.getEmail());
		return "home";
	}

}
