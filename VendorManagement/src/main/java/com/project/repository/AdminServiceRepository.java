package com.project.repository;

import java.util.List;

import com.project.entity.AdminControlEntity;

public interface AdminServiceRepository {

	public List<AdminControlEntity> findAll();
	
	public AdminControlEntity getAdminEntityById(int id);
	
	public void updateUpdateByAndUpdatedDate(int id);

	
}
