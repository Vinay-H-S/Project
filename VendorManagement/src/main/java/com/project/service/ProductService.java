package com.project.service;

import java.util.List;

import com.project.dto.ProductDTO;

public interface ProductService {
	
	public boolean validateAndSave(ProductDTO dto);
	
	public List<ProductDTO> getAllProducts();
	
	public List<ProductDTO> getAllProductDetailsByVendorId(String email);
	
	public ProductDTO findAllProductEntityById(int productId);
	
	
	

}
