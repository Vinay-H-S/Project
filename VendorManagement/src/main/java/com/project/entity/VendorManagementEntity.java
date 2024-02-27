package com.project.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "vendormanagement")
@Data
@NamedQuery(name = "isExistUser", query = "select ent from VendorManagementEntity ent where ent.ownerName=:owner or ent.email=:email")
@NamedQuery(name = "findAll",query = "select ent from VendorManagementEntity ent")
@NamedQuery(name="updatedOtpByEmail",query = "select ent from VendorManagementEntity ent where ent.email=:email")
@NoArgsConstructor
public class VendorManagementEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "v_id")
	private int id;

	@Column(name = "v_name")
	private String vendorName;

	@Column(name = "v_location")
	private String location;


	@Column(name = "v_gst_no")
	private String gstNo;

	@Column(name = "v_company_startdate")
	private Date companyStartDate;

	@Column(name = "v_ownername")
	private String ownerName;

	
	@Column(name = "v_service_type")
	private String serviceType;
	
	@Column(name = "v_contact_no")
	private Long contactNo;


	@Column(name = "v_alternative_no")
	private Long alternativeNo;

	
	@Column(name = "v_email")
	private String email;

	@Column(name = "v_website")
	private String website;

	@Column(name = "v_created_by")
	private String createdBy;

	@Column(name = "v_created_date")
	private LocalDate createdDate;

	@Column(name = "v_updated_by")
	private String updatedBy;

	@Column(name = "v_updated_date")
	private LocalDate updatedDate;

	@Column(name="v_otp")
	private Integer otp;
//	
////	private boolean active;// for active the user
////	
//	private LocalDateTime otpGenratedTime;
}
