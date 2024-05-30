package com.project.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.ProductEntity;
import com.project.util.EMFUtil;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private EntityManagerFactory emf = EMFUtil.getManagerFactory();

	@Override
	public boolean save(ProductEntity productEntity) {
		System.out.println("invoking the validateAndSave in productRepoImpl()");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			System.out.println("ET begin()");
			em.persist(productEntity);
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

	@Override
	public List<ProductEntity> readAll() {
		System.out.println("invoking the readAll in productRepoImpl()");
		EntityManager em = emf.createEntityManager();
		List<ProductEntity> list = new ArrayList<ProductEntity>();
		try {
			Query query = em.createNamedQuery("readAll");
			list = query.getResultList();
			return list;
		} catch (PersistenceException e) {
			System.out.println("PersistenceException " + e.getMessage());
		} finally {
			em.close();
			System.out.println("Costly resources are closed");
		}
		return list;
	}

	@Override
	public ProductEntity getAllProductsById(int productId) {
		System.out.println("invoking the getAllProductsById in productRepoImpl()");
		EntityManager em = emf.createEntityManager();
		ProductEntity entity = null;
		try {
			Query query = em.createNamedQuery("getAllProductsById");
			query.setParameter("id", productId);
			entity = (ProductEntity) query.getSingleResult();
			System.out.println(entity);
			return entity;
		} catch (PersistenceException e) {
			System.out.println("PersistenceException " + e.getMessage());
		} finally {
			em.close();
			System.out.println("Costly resources are closed");
		}
		return entity;
	}

	@Override
	public List<ProductEntity> findAllProductDetailsByVendorId(int vendorId) {
		System.out.println("invoking the findAllProductDetailsByVendorId in productRepoImpl()");
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createNamedQuery("getAllProductDetailsByVendorId");
			query.setParameter("vendorId", vendorId);
			List<ProductEntity> read = query.getResultList();
			System.out.println(read);
			return read;
		} catch (Exception e) {
		} finally {

		}
		return null;
	}
}
