package com.masai.Service;

import com.masai.Entity.Customer;
import com.masai.Exception.SomthingWentWrongException;

public interface CustomerService {
	void coustmerLogin(Customer addCustomer) throws SomthingWentWrongException;
}
