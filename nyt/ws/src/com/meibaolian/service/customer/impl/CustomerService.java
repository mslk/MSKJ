package com.meibaolian.service.customer.impl;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.customer.ICustomerDao;
import com.meibaolian.dao.customer.ICustomerJsonDao;
import com.meibaolian.entity.Customer;
import com.meibaolian.entity.CustomerJson;
import com.meibaolian.service.customer.ICustomerService;
import com.meibaolian.util.exception.DataManagerException;

public class CustomerService implements ICustomerService{
	
	private ICustomerDao customerDao;
	private ICustomerJsonDao customerJsonDao;
	
	
	
	@Override
	public int addCustomer(Customer customer) {
		
		return customerDao.addCustomer(customer);
	}

	@Override
	public QueryResult<CustomerJson> getCustomerJson(int userid, int customertype, int page,
			int pageSize) throws DataManagerException {

		return customerJsonDao.getCustomerJson(userid, customertype, page, pageSize);
	}

	@Override
	public int delCustomer(int id) {
		
		return customerDao.delCustomer(id);
	}

	
	
	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setCustomerJsonDao(ICustomerJsonDao customerJsonDao) {
		this.customerJsonDao = customerJsonDao;
	}

	@Override
	public boolean isExistCustomer(Customer customer) throws DataManagerException{
		
		return customerDao.isExistCustomer(customer);
	}
	
}
