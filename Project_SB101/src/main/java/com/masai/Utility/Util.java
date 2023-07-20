package com.masai.Utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Util {

	static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("OnlineShopping");
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
