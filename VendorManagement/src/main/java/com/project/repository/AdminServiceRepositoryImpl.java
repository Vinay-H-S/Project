package com.project.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.AdminControlEntity;
import com.project.entity.VendorManagementEntity;
import com.project.util.EMFUtil;

@Repository
public class AdminServiceRepositoryImpl implements AdminServiceRepository {

	@Autowired
	private EntityManagerFactory emf = EMFUtil.getManagerFactory();


	@Override
	public List<AdminControlEntity> findAll() {
		System.out.println("invoking the findAll() in adminserviceimpl");
		EntityManager em = this.emf.createEntityManager();
		List<AdminControlEntity> list = new ArrayList<AdminControlEntity>();
		try {
			Query query = em.createNamedQuery("findAdmins");
			list = query.getResultList();
			return list;
		} catch (PersistenceException e) {
			System.out.println("Persistence Exception :" + e.getMessage());
		} finally {
			em.close();
		}

		return list;
	}

	@Override
	public AdminControlEntity getAdminEntityById(int id) {
		System.out.println("invoking the getAdminEntityById() in adminrepo");
		EntityManager em = this.emf.createEntityManager();
		AdminControlEntity entity = null;
		try {
			Query query = em.createNamedQuery("getAdminsById");
			query.setParameter("id", id);
			entity = (AdminControlEntity) query.getSingleResult();
			System.out.println("Admin is found by id" + entity);
			return entity;
		} catch (PersistenceException e) {
			System.out.println("PersisteneceException :" + e.getMessage());
		} finally {

		}
		return entity;
	}

	@Override
	public void updateUpdateByAndUpdatedDate(int id) {
		System.out.println("invoking the updateUpadteByAndUpdatedDate() in adminrepo");
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		VendorManagementEntity entity = null;
		try {
			et.begin();
			System.out.println("ET begin()");
			Query query = em.createNamedQuery("getEntityById");
			query.setParameter("id", id);
			entity = (VendorManagementEntity) query.getSingleResult();
			AdminControlEntity adminControlEntity = this.getAdminEntityById(id);
			if (adminControlEntity != null) {
				entity.setUpdatedBy(adminControlEntity.getUserName());
				entity.setUpdatedDate(LocalDateTime.now());
				em.merge(entity);
			}
			et.commit();
			System.out.println("Data is committed");

		} catch (PersistenceException e) {
			System.out.println("PersistenceEception : " + e.getMessage());
			et.rollback();
		} finally {
			em.close();
			System.out.println("Costly resources are closed");
		}
	}

}
