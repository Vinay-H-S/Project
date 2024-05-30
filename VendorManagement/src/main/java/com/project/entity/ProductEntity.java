package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name="product")
@Data
@NamedQuery(name="readAll",query = "select ent from ProductEntity ent")
@NamedQuery(name="getAllProductsById",query = "select ent from ProductEntity ent where ent.productId=:id")
@NamedQuery(name="getAllProductDetailsByVendorId",query = "select ent from ProductEntity ent where ent.vendor.vendorId=:vendorId")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="vendor_id")
	private VendorManagementEntity vendor;
	
	@Column(name="category")
	private String category;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_price")
	private Double productPrice;
	
	@Column(name="delivery_charge")
	private Double deliveryCharge;	
	
	@Column(name="description")
	private String description;
	
	@Column(name="available")
	private String available;
	
	
	
	
}
