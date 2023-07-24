package com.masai.Service;

import com.masai.Entity.Csr;
import com.masai.Entity.Customer;
import com.masai.Exception.SomthingWentWrongException;

public interface CustomerService {
	void coustmerLogin(Customer addCustomer) throws SomthingWentWrongException;
	public void UpdateDetails(String email,String nName,String nEmail,int nMob,String nPassword)throws SomthingWentWrongException;
	public Customer getCustomerByEmail(String email)throws SomthingWentWrongException ;
	
	void CsrLogin(Csr addCustomer) throws SomthingWentWrongException;

}
