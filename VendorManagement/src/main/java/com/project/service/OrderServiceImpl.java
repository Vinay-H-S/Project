package com.project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.OrderDTO;
import com.project.entity.OrderEntity;
import com.project.entity.ProductEntity;
import com.project.repository.OrderRepository;
import com.project.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private OrderRepository orderRepo;

	@Override
	public boolean validateAndSave(OrderDTO dto) {
		System.out.println("invoking the validateAndSave in orderserviceimpl");
		ProductEntity productEntity = this.productRepo.getAllProductsById(dto.getProductId());
		if (productEntity != null) {
			System.err.println(productEntity);
			OrderEntity orderEntity = new OrderEntity();

			dto.setCategory(productEntity.getCategory());
			dto.setProductName(productEntity.getProductName());
			dto.setProductPrice(productEntity.getProductPrice());
			dto.setDeliveryCharge(productEntity.getDeliveryCharge());
			dto.setDescription(productEntity.getDescription());
			dto.setAvailable(productEntity.getAvailable());
			dto.setVendor(productEntity.getVendor());
			dto.setProduct(productEntity);
			dto.setOrderStatus("Ordered");

			BeanUtils.copyProperties(dto, orderEntity);
			System.err.println("Order is copy");
			boolean save = this.orderRepo.save(orderEntity);
			if (save) {
				System.err.println("Order is Saved");
				return true;
			}else {
				System.out.println("Order is not saved");
			}
		}
		return false;
	}

}
