package com.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="order")
@Data
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	
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
	
	@Column(name="order_quantity")
	private Integer orderQuantity;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="delivery_date")
	private Date deliveryDate;
	
	@Column(name="delivery_address")
	private String deliveryAddress;
	
	@Column(name="message")
	private String message;
	
	@Column(name="order_status")
	private String orderStatus;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private ProductEntity product;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="vendor_id")
	private VendorManagementEntity vendor;
	
	@Column(name="order_amount")
	private Double orderAmount;
	
	@Column(name="amount_paid")
	private Double amountPaid;
	
	@Column(name="payment_status")
	private String paymentStatus;
	
	@Column(name="total_amount_to_pay")
	private Double totalAmountToPay;
	
	@Column(name="balance_amount")
	private Double balanceAmount;
	
}
