package com.meibaolian.dao.customer;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.Customer;
import com.meibaolian.util.exception.DataManagerException;

public interface ICustomerDao extends IBaseDao<Customer>{
	
	public int addCustomer(Customer customer);
	
	public int delCustomer(int id);
	/**
	 * 是否已存在此数据
	 * @param customer
	 * @return true 已存在
	 * @throws DataManagerException
	 */
	public boolean isExistCustomer(Customer customer) throws DataManagerException;
}
