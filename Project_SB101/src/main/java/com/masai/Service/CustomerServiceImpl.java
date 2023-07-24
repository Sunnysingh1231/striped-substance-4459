package com.masai.Service;

import com.masai.Dao.CustomerDao;
import com.masai.Dao.CustomerDaoImpl;
import com.masai.Entity.Csr;
import com.masai.Entity.Customer;
import com.masai.Exception.SomthingWentWrongException;

public class CustomerServiceImpl implements CustomerService {

	public CustomerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void coustmerLogin(Customer addCustomer) throws SomthingWentWrongException{
		
		CustomerDao customerDao = new CustomerDaoImpl();
		customerDao.coustmerLogin(addCustomer);

	}

	@Override
	public void UpdateDetails(String email, String nName, String nEmail, int nMob, String nPassword)
			throws SomthingWentWrongException {
		CustomerDao customerDao = new CustomerDaoImpl();
		customerDao.UpdateDetails(email, nName, nEmail, nMob, nPassword);
		
	}

	@Override
	public Customer getCustomerByEmail(String email) throws SomthingWentWrongException {
		CustomerDao customerDao = new CustomerDaoImpl();
		return customerDao.getCustomerByEmail(email);
		
	}

//	@Override
//	public void CsrLogin(Csr addCustomer) throws SomthingWentWrongException {
//		
//		
//	}

	@Override
	public void CsrLogin(Csr addCsr) throws SomthingWentWrongException {
		CustomerDao customerDao = new CustomerDaoImpl();
		customerDao.CsrLogin(addCsr);
		
	}

}
