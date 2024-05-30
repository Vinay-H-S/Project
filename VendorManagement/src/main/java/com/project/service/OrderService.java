package com.project.service;

import com.project.dto.OrderDTO;

public interface OrderService {
	
	public boolean validateAndSave(OrderDTO dto);

}
