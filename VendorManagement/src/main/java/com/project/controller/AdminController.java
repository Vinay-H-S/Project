package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.project.entity.AdminControlEntity;
import com.project.entity.VendorManagementEntity;
import com.project.repository.AdminServiceRepository;
import com.project.repository.VendorManagementRepository;


@EnableWebMvc
@Controller
@RequestMapping("/")
public class AdminController {

	@Autowired
	private AdminServiceRepository repository;

	@Autowired
	private VendorManagementRepository vendorRepository;


	public AdminController() {
		System.out.println("Creating the admincontroller");
	}

	@PostMapping("/admincontrol")
	public String adminLogin(String userName, String password, Model model) {
		System.out.println("invoking the adminLogin in in admincontroller");
		List<AdminControlEntity> entity = this.repository.findAll();
		for (AdminControlEntity adminControlEntity : entity) {
			if (adminControlEntity.getUserName().equals(userName)
					&& adminControlEntity.getPassword().equals(password)) {
				System.out.println("User Found");
				List<VendorManagementEntity> vendorEntity = this.vendorRepository.findAll();
				if (vendorEntity != null) {
					model.addAttribute("ent", vendorEntity);
					return "admin";
				}
			}
		}

		return "adminlogin";
	}

	@RequestMapping(path = "/admin")
	public String adminPage(Model model) {
		System.out.println("adminPage() in adminController");
		List<VendorManagementEntity> vendorEntity = this.vendorRepository.findAll();
		for (VendorManagementEntity vendorManagementEntity : vendorEntity) {
			if (vendorEntity != null) {
				model.addAttribute("ent", vendorManagementEntity);
			}
		}

		return "admin";
	}

	@RequestMapping(value = "/approveStatus/{id}")
	public String approveStatus(@PathVariable int id, Model model) {
		System.out.println("invoking the approveStatus() in adminController");
		this.vendorRepository.approvedStatus(id);
		this.repository.updateUpdateByAndUpdatedDate(id);
		List<VendorManagementEntity> vendorEntity = this.vendorRepository.findAll();
		if (vendorEntity != null) {
			model.addAttribute("ent", vendorEntity);
		}
		return "redirect:/admin";
	}

	@RequestMapping(value = "/rejectStatus/{id}")
	public String rejectStatus(@PathVariable int id, Model model) {
		System.out.println("invoking the approveStatus() in adminController");
		model.addAttribute("entites", id);
		this.vendorRepository.rejectStatus(id);
		this.repository.updateUpdateByAndUpdatedDate(id);
		List<VendorManagementEntity> vendorEntity = this.vendorRepository.findAll();
		if (vendorEntity != null) {
			model.addAttribute("ent", vendorEntity);
		}
		return "redirect:/admin";
	}

	
}
