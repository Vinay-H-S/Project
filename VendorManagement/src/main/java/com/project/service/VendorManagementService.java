package com.project.service;

import com.project.entity.*;

public interface VendorManagementService {

	public boolean validateAndSave(VendorManagementEntity entity);

	public String isExist(String ownerName,String email);
	
	public boolean sendEmail(String email);
	
}
