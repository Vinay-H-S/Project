package com.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.project.dto.ProductDTO;
import com.project.entity.ProductEntity;
import com.project.entity.VendorManagementEntity;
import com.project.repository.ProductRepository;
import com.project.repository.VendorManagementRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private VendorManagementRepository vendorRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public boolean validateAndSave(ProductDTO dto) {
		System.out.println("invoking the validateAndSave in ProductServiceImpl()");
		ProductEntity productEntity = new ProductEntity();
		VendorManagementEntity vendorEntity = this.vendorRepository.findAllVendorEntityByEmail(dto.getEmail());
		

		if (vendorEntity == null) {
			System.out.println("entity is not found");
			return false;
		}
		dto.setVendor(vendorEntity);
		System.err.println("VendorEntity is Seted to vendor"+vendorEntity);
		BeanUtils.copyProperties(dto, productEntity);

		boolean save = this.productRepository.save(productEntity);
		if (save) {
			return true;
		}
		return false;
	}

	@Override
	public ProductDTO findAllProductEntityById(int productId) {
		System.out.println("invoking the findAllProductEntityById in serviceImpl");
		ProductDTO productDTO = new ProductDTO();
		ProductEntity productEntity = this.productRepository.getAllProductsById(productId);

		if (productEntity != null) {
			productDTO.setProductId(productEntity.getProductId());
			productDTO.setCategory(productEntity.getCategory());
			productDTO.setProductName(productEntity.getProductName());
			productDTO.setProductPrice(productEntity.getProductPrice());
			productDTO.setDeliveryCharge(productEntity.getDeliveryCharge());
			productDTO.setDescription(productEntity.getDescription());
			productDTO.setAvailable(productEntity.getAvailable());
		} else {
			throw new EntityNotFoundException("product not found for id" + productId);
		}

		return productDTO;
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		System.out.println("invoking the getAllProduct in serviceImpl");
		List<ProductEntity> productEntities = this.productRepository.readAll();
		List<ProductDTO> readAll = new ArrayList<ProductDTO>();
		for (ProductEntity entity : productEntities) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductId(entity.getProductId());
			productDTO.setCategory(entity.getCategory());
			productDTO.setProductName(entity.getProductName());
			productDTO.setProductPrice(entity.getProductPrice());
			productDTO.setDeliveryCharge(entity.getDeliveryCharge());
			productDTO.setDescription(entity.getDescription());
			productDTO.setAvailable(entity.getAvailable());
			productDTO.setVendor(entity.getVendor());

			readAll.add(productDTO);

		}
		return readAll;
	}

	@Override
	public List<ProductDTO> getAllProductDetailsByVendorId(String email) {
		System.out.println("getAllProductsDetailsById in serviceImpl");
		int vendorId = this.vendorRepository.getVendorIdbyEmail(email);

		List<ProductEntity> productEntities = this.productRepository.findAllProductDetailsByVendorId(vendorId);

		List<ProductDTO> readAllProducts = new ArrayList<ProductDTO>();
		for (ProductEntity productEntity : productEntities) {
			ProductDTO productDTO = new ProductDTO();
			BeanUtils.copyProperties(productEntity, productDTO);
			readAllProducts.add(productDTO);
		}

		return readAllProducts;
	}

}
