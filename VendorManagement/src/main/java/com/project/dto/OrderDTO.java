package com.project.dto;

import java.util.Date;

import javax.persistence.Id;
import com.project.entity.ProductEntity;
import com.project.entity.VendorManagementEntity;

import lombok.Data;

@Data
public class OrderDTO {
	@Id
	private int orderId;
	private int productId;
	private int vendorId;
	private String category;
	private String productName;
	private Double productPrice;
	private Double deliveryCharge;
	private String description;
	private String available;
	private Integer orderQuantity;
	private Date orderDate;
	private Date deliveryDate;
	private String deliveryAddress;
	private String message;
	private String orderStatus;
	private ProductEntity product;
	private VendorManagementEntity vendor;
	private Double orderAmount;
	private Double amountPaid;
	private String paymentStatus;
	private Double totalAmountToPay;
	private Double balanceAmount;
}
