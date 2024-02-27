package com.project.repository;

import java.util.List;

import com.project.entity.VendorManagementEntity;

public interface VendorManagementRepository {

	
	public boolean save(VendorManagementEntity entity);
	
	public VendorManagementEntity isExist(String ownerName, String email);
	
	public List<VendorManagementEntity> findAll();
	
	public void updatedOtpByEmail(String email,int otp);

	
}
