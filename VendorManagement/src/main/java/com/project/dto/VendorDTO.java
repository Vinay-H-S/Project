package com.project.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendorDTO {

	@Id
	private int vendorId;
	private String vendorName;
	private String location;
	private String gstNo;
	private Date companyStartDate;
	private String ownerName;
	private String serviceType;
	private Long contactNo;
	private Long alternativeNo;
	private String email;	
	private String website;	
	private String createdBy;	
	private LocalDateTime createdDate;	
	private String updatedBy;	
	private LocalDateTime updatedDate;
	private String otp;
	private LocalTime otpGenratedTime;	
	private Integer failedAttempt;
	private String accountLockStatus;
	private LocalTime accountLockTime;
	private String status;
	private String profileImage;
	
}
