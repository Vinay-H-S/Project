package com.project.dto;

import javax.persistence.Id;

import com.project.entity.VendorManagementEntity;

import lombok.Data;

@Data
public class ProductDTO {

	@Id
	private int productId;
	private String category;
	private String productName;
	private Double productPrice;
	private Double deliveryCharge;
	private String description;
	private String available;
	private String email;
	private VendorManagementEntity vendor;
	
}
