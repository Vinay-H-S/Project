package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.VendorManagementEntity;
import com.project.repository.VendorManagementRepository;

@Service(value = "ajaxService")
public class VendorAjaxServiceImpl implements VendorAjaxService {

	@Autowired
	private VendorManagementRepository repo;

	public VendorAjaxServiceImpl() {
		System.out.println("invoking the VendorAjaxService Method");
	}

	// EmailAjax

	@Override
	public String findByEmailAjax(String email) {
		System.out.println("invoking the findByEmailAjax");
		List<VendorManagementEntity> entity = this.repo.findAll();	
		for (VendorManagementEntity ent : entity) {
			System.out.println(ent.getEmail() + " " + email);
			if (ent.getEmail().equalsIgnoreCase(email)) {
				return "*Email Already Exist";
			} else {
				System.out.println("Email Does't exist");
			}
		}
		return null;
	}

	// GstAjax

	@Override
	public String findByGst(String gstNo) {
		System.out.println("invoking the findByGst");
		List<VendorManagementEntity> entity = this.repo.findAll();
		for (VendorManagementEntity ent : entity) {
			if(ent.getGstNo().equalsIgnoreCase(gstNo)) {
				return "*Gst Number Exist";
			}else {
				System.out.println("Gst Number Does't Exsit");
			}
		}
		
		return null;
	}
	
	@Override
	public String findByContactNo(Long contactNo) {
		System.out.println("invoking the findByContactNo");
		List<VendorManagementEntity> entity =this.repo.findAll();
		for (VendorManagementEntity ent : entity) {
			if(ent.getContactNo().equals(contactNo)) {
				return "*Contact Number Already Exist";
			}else {
				System.out.println("Contact is Does't exist");
			}
		}
		return null;
	}
	
	//Website Ajax
	
	@Override
	public String findByWebsite(String website) {
		System.out.println("invoking the findByWebsite");
		List<VendorManagementEntity> entity =this.repo.findAll();
		for (VendorManagementEntity ent : entity) {
			if(ent.getWebsite().equalsIgnoreCase(website)) {
				return "*Webiste Already Exist";
			}else {
				System.out.println("Website is Does't Exist");
			}
		}
		return null;
	}

}
