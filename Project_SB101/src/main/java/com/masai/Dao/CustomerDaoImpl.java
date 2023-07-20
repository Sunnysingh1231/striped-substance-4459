package com.masai.Dao;

import com.masai.Entity.Customer;
import com.masai.Exception.SomthingWentWrongException;
import com.masai.Utility.Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;

public class CustomerDaoImpl implements CustomerDao {


	@Override
	public void coustmerLogin(Customer addCustomer) throws SomthingWentWrongException{
		
		EntityManager em=null;
		EntityTransaction et = null;
//
		try {
			
			em = Util.getEntityManager();
			et = em.getTransaction();
			
			et.begin();
			em.persist(addCustomer);
			et.commit();
			
			
		} catch (PersistenceException e) {
//			System.out.println(e);
			et.rollback();
			throw new SomthingWentWrongException("Unable to add Customer, try again later");
		}
	}

}

/*
 * em = Util.getEntityManager();
			et = em.getTransaction();
			
			et.begin();
			em.persist(addCustomer);
			et.commit();
 */
