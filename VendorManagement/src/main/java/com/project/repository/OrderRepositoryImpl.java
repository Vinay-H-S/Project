package com.project.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.OrderEntity;
import com.project.util.EMFUtil;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	@Autowired
	private EntityManagerFactory emf = EMFUtil.getManagerFactory();
	
	
	@Override
	public boolean save(OrderEntity orderEntity) {
		System.out.println("invoking the save in orderrepoimpl");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			System.out.println("ET begin()");
			em.persist(orderEntity);
			et.commit();
			System.out.println("Data is saved successfully");
		} catch (PersistenceException e) {
			System.out.println("PersistenceException " + e.getMessage());
			et.rollback();
		} finally {
			em.close();
			System.out.println("Costly resources are closed");
		}
		return true;
	}

}
