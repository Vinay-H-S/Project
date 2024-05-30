package com.project.repository;

import com.project.entity.OrderEntity;

public interface OrderRepository {

	public boolean save(OrderEntity orderEntity);
}
