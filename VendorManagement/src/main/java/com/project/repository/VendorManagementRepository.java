package com.project.repository;

import java.time.LocalTime;
import java.util.List;

import com.project.entity.VendorManagementEntity;

public interface VendorManagementRepository {

	public static final Integer ATTEMPT_TIME = 3;

	public boolean save(VendorManagementEntity entity);

	public VendorManagementEntity isExist(String email, String otp);

	public List<VendorManagementEntity> findAll();

	public void updatedOtpByEmail(String email, String otp);

	public void updateFailedAttemptCount(String email, Integer failedCount);

	public void updateAccountLockTime(String email, LocalTime accountLockTime);

	public void expiredOtpAndAttempt(String otp, Integer failedAttempt, String email);

	public void approvedStatus(int id);

	public void rejectStatus(int id);

	public VendorManagementEntity getVendorEntityByEmail(String email);

	public VendorManagementEntity getVendorEntityById(int id);

	public void updateVendorEntity(int id,VendorManagementEntity ent);
}
