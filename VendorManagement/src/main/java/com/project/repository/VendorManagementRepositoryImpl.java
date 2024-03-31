package com.project.repository;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.boot.spi.InFlightMetadataCollector.EntityTableXref;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.project.entity.AdminControlEntity;
import com.project.entity.VendorManagementEntity;
import com.project.util.EMFUtil;

@Repository
public class VendorManagementRepositoryImpl implements VendorManagementRepository {

	@Autowired
	private final EntityManagerFactory emf = EMFUtil.getManagerFactory();

	@Autowired
	private AdminServiceRepository adminRepo;

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
			entity.setStatus("Pending");
			entity.setFailedAttempt(0);
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
				entity.setOtpGenratedTime(LocalTime.now());
				em.merge(entity);
				System.out.println("UpdatedOtpByEMail is updated");
			}
			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
			System.err.println("PersistenceException in updatedOtpByEmail in repoImpl" + e.getMessage());
		} finally {
			em.close();
			System.out.println("Costly resources are closed");
		}
	}

	@Override
	public void updateFailedAttemptCount(String email, Integer failedCount) {
		System.out.println("invoking the updateFailedAttemptCount() in repository");
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			System.out.println("ET begin()");
			Query query = em.createNamedQuery("updateFailedAttemptByEmail");
			query.setParameter("email", email);
			VendorManagementEntity entity = (VendorManagementEntity) query.getSingleResult();
			if (entity != null) {
				entity.setFailedAttempt(failedCount);
				em.merge(entity);
				if (entity.getFailedAttempt() == 3) {
					entity.setAccountLockTime(LocalTime.now());
					entity.setAccountLockStatus("Locked");
					em.merge(entity);
				}
				System.out.println("updateFailedAttemptCount is updtaed");
			}
			et.commit();
		} catch (PersistenceException pe) {
			et.rollback();
			System.out.println("PersistenceException in repo");
		} finally {
			em.close();
			System.out.println("Costly resoucres are closed");
		}

	}

	@Override
	public void updateAccountLockTime(String email, LocalTime accountLockTime) {
		System.out.println("invoking the updateAccountLockTime() in repository");
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			System.out.println("ET begin()");

			et.commit();
		} catch (PersistenceException pe) {
			et.rollback();
			System.out.println("PersistenceException in repo");
		} finally {
			em.close();
			System.out.println("Costly resoucres are closed");
		}

	}

	@Override
	public void expiredOtpAndAttempt(String otp, Integer failedAttempt, String email) {
		System.out.println("invoking the expiredOtpAndAttempt() in repository");
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			System.out.println("ET begin()");
			Query query = em.createNamedQuery("updateFailedAccountByEmail");
			query.setParameter("email", email);
			VendorManagementEntity entity = (VendorManagementEntity) query.getSingleResult();
			if (entity != null) {
				entity.setOtp(otp);
				entity.setFailedAttempt(failedAttempt);
				entity.setAccountLockTime(null);
				entity.setAccountLockStatus("Un-Locked");
				em.merge(entity);
				System.out.println("expiredOtpAndAttempt is updtaed");
			}
			et.commit();
		} catch (PersistenceException pe) {
			et.rollback();
			System.out.println("PersistenceException in repo");
		} finally {
			em.close();
			System.out.println("Costly resoucres are closed");
		}

	}

	@Override
	public void approvedStatus(int id) {
		System.out.println("invoking the approvedStatus() in repo");
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		VendorManagementEntity entity = null;
		try {
			et.begin();
			Query query = em.createNamedQuery("updateUpdatedByAndUpdatedDateById");
			query.setParameter("id", id);
			Object obj = query.getSingleResult();
			entity = (VendorManagementEntity) obj;
			System.out.println(entity);
			if (entity != null) {
				entity.setStatus("Approved");
				entity.setUpdatedDate(LocalDateTime.now());
				em.merge(entity);
			}
			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
			System.out.println("PersistenceException() in approved status :" + e.getMessage());
		} finally {
			em.close();
			System.out.println("Costly resources are closed");
		}

	}

	@Override
	public void rejectStatus(int id) {
		System.out.println("invoking the approvedStatus() in repo");
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		VendorManagementEntity entity = null;
		try {
			et.begin();
			Query query = em.createNamedQuery("updateUpdatedByAndUpdatedDateById");
			query.setParameter("id", id);
			Object obj = query.getSingleResult();
			entity = (VendorManagementEntity) obj;
			System.out.println(entity);
			if (entity != null) {
				entity.setStatus("Rejected");
				em.merge(entity);
			}
			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
			System.out.println("PersistenceException() in approved status :" + e.getMessage());
		} finally {
			em.close();
			System.out.println("Costly resources are closed");
		}

	}

	@Override
	public VendorManagementEntity getVendorEntityByEmail(String email) {
		System.out.println("invoking the getVendorEntityByEmail() in repo");
		EntityManager em = this.emf.createEntityManager();
		VendorManagementEntity entity = null;
		try {
			Query query = em.createNamedQuery("getEntityByEmail");
			query.setParameter("email", email);
			entity = (VendorManagementEntity) query.getSingleResult();
			return entity;
		} catch (PersistenceException e) {
			System.out.println("PersistenceException in :" + e.getMessage());
		} finally {
			em.close();
			System.out.println("Costly Resources are closed");
		}
		return entity;
	}

	@Override
	public VendorManagementEntity getVendorEntityById(int id) {
		System.out.println("invoking the getVendorEntityById() in repo");
		EntityManager em = this.emf.createEntityManager();
		VendorManagementEntity ent = null;
		try {
			System.out.println("ET begin()");
			Query query = em.createNamedQuery("getEntityById");
			query.setParameter("id", id);
			ent = (VendorManagementEntity) query.getSingleResult();
			if (ent != null) {
				em.persist(ent);
				System.out.println("Data is updated");
			}
			System.out.println(ent);
			return ent;
		} catch (PersistenceException e) {
			System.out.println("PersistenceException : " + e.getMessage());
		} finally {
			em.close();
			System.out.println("Costly resources are closed");
		}
		return ent;
	}

	@Override
	public void updateVendorEntity(int id, VendorManagementEntity ent) {
		System.out.println("invoking thr updateVendorEntity() in repo");
		EntityManager em = this.emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		VendorManagementEntity entity = null;
		try {
			et.begin();
			System.out.println("ET begin()");
			Query query = em.createNamedQuery("getEntityById");
			query.setParameter("id", id);
			entity = (VendorManagementEntity) query.getSingleResult();
			if(entity != null) {
				em.persist(ent);
			}
			et.commit();
		} catch (PersistenceException e) {
			et.rollback();
			System.out.println("PersistenceException : " + e.getMessage());
		} finally {
			em.close();
			System.out.println("Costly resources are closed");
		}

	}

}
