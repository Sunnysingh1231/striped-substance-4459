package com.masai.Dao;

import com.masai.Entity.Customer;
import com.masai.Exception.SomthingWentWrongException;

public interface CustomerDao {
	void coustmerLogin(Customer addCustomer) throws SomthingWentWrongException;
}
