package com.project.repository;

import java.util.List;

import com.project.entity.ProductEntity;

public interface ProductRepository {

	public boolean save(ProductEntity productEntity);
	
	public List<ProductEntity> readAll();
	
	public ProductEntity getAllProductsById(int productId);
	
	public List<ProductEntity> findAllProductDetailsByVendorId(int vendorId);
	
	
}
