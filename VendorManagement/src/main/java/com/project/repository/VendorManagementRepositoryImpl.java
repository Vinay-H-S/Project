package com.project.repository;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.entity.VendorManagementEntity;
import com.project.util.OtpGenarator;

@Repository
public class VendorManagementRepositoryImpl implements VendorManagementRepository {

	@Autowired
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");

	@Override
	public boolean save(VendorManagementEntity entity) {
		System.out.println("invoking the save method");
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			System.out.println("Et begin");
			em.persist(entity);
			entity.setCreatedBy(entity.getOwnerName());
			entity.setCreatedDate(LocalDateTime.now());
			et.commit();
			System.out.println("Data is Committed");
		} catch (PersistenceException pe) {
			System.err.println("PersistenceException in Save method :" + pe.getMessage());
			et.rollback();
		} finally {
			em.close();
			System.out.println("CLosing the open resourcesss");
		}
		return true;
	}

	
	@Override
	public VendorManagementEntity isExist(String email, String otp) {
		System.out.println("invoking isExist Method");
		EntityManager em = this.emf.createEntityManager();
		System.out.println("Created Emf");

		VendorManagementEntity entity = null;
		try {
			Query query = em.createNamedQuery("isExistUser");
			query.setParameter("email", email);
			query.setParameter("otp", otp);
			entity = (VendorManagementEntity) query.getSingleResult();
			return entity;
		} catch (PersistenceException pe) {
			System.err.println("PersistenceException in isExist method :" + pe.getMessage());
		} finally {
			em.close();
			System.out.println("CLosing the open resourcesss");
		}

		return entity;
	}

	@Override
	public List<VendorManagementEntity> findAll() {
		System.out.println("invoking the findAll");
		EntityManager em = this.emf.createEntityManager();
		List<VendorManagementEntity> entity = new ArrayList<VendorManagementEntity>();
		try {
			Query query = em.createNamedQuery("findAll");
			entity = query.getResultList();
			System.out.println(entity);
		} catch (PersistenceException e) {
			System.out.println("invoking the persistence exception :" + e.getMessage());
		} finally {
			em.close();
			System.out.println("Closing the open resources");
		}
		return entity;
	}

	@Override
	public void updatedOtpByEmail(String email, String otp) {
		System.out.println("invoking the updatedOtpByEmail in repoImpl");
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			Query query = em.createNamedQuery("updatedOtpByEmail");
			query.setParameter("email", email);
			Object obj = query.getSingleResult();
			VendorManagementEntity entity = (VendorManagementEntity) obj;
			if (entity != null) {
				entity.setOtp(otp);
				entity.setOtpGenratedTime(LocalDateTime.now());
				em.merge(entity);
				et.commit();
				System.out.println("UpdatedOtpByEMail is updated");
			}
		} catch (PersistenceException e) {
			et.rollback();
			System.out.println("PersistenceException in updatedOtpByEmail in repoImpl" + e.getMessage());
		} finally {
			em.close();
			System.out.println("Costly resources are closed");
		}
	}
}
