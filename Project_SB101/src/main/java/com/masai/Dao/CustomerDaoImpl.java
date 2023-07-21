package com.masai.Dao;

import com.masai.Entity.Customer;
import com.masai.Exception.SomthingWentWrongException;
import com.masai.Utility.Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

public class CustomerDaoImpl implements CustomerDao {


	@Override
	public void coustmerLogin(Customer addCustomer) throws SomthingWentWrongException{
		
		EntityManager em=null;
		EntityTransaction et = null;
		try {
			
			em = Util.getEntityManager();
			et = em.getTransaction();
			
			et.begin();
			em.persist(addCustomer);
			et.commit();
			
			
		} catch (PersistenceException e) {
			et.rollback();
			throw new SomthingWentWrongException("Unable to add CustomerDetail, try again later");
		}finally {
	        if (em != null) {
	            em.close();
	        }
		}
	}

	@Override
	public void UpdateDetails(String email, String nName, String nEmail, int nMob, String nPassword) throws SomthingWentWrongException {
	    EntityManager em = null;
	    EntityTransaction et = null;

	    try {
	        em = Util.getEntityManager();
	        et = em.getTransaction();

	        et.begin();
	        Customer customer = getCustomerByEmail(email);

	        // Update customer details
	        customer.setName(nName);
	        customer.setEmail(nEmail);
	        customer.setPassWord(nPassword);
	        customer.setMobNo(nMob);

	        et.commit();
	    } catch (NoResultException e) {
	        throw new SomthingWentWrongException("Customer not found with email: " + email);
	    } catch (PersistenceException e) {
	        if (et != null && et.isActive()) {
	            et.rollback();
	        }
	        throw new SomthingWentWrongException("Unable to update Customer details, try again later");
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
	}

	
	
	@Override
	public Customer getCustomerByEmail(String email) throws SomthingWentWrongException {
	    Customer customer = null;
	    EntityManager em = null;

	    try {
	        em = Util.getEntityManager();
	        String jpqlQuery = "SELECT c FROM Customer c WHERE c.email = :email";
	        TypedQuery<Customer> query = em.createQuery(jpqlQuery, Customer.class);
	        query.setParameter("email", email);

	        customer = query.getSingleResult();
	    } catch (NoResultException e) {
	        throw new SomthingWentWrongException("Customer not found with email: " + email);
	    } catch (PersistenceException e) {
	        throw new SomthingWentWrongException("Unable to find CustomerDetail, try again later");
	    } finally {
	        if (em != null) {
	            em.close();
	        }
	    }
	    return customer;
	}

}

/*
 * em = Util.getEntityManager();
			et = em.getTransaction();
			
			et.begin();
			em.persist(addCustomer);
			et.commit();
 */
