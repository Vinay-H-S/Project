package com.project.service;

import com.project.dto.VendorDTO;


public interface VendorManagementService {

	public boolean validateAndSave(VendorDTO dto);

	public String isExist(String ownerName,String email);
	
	public boolean sendEmail(String email);
	
	
	
}
