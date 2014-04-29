package com.meibaolian.service.customer;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.Customer;
import com.meibaolian.entity.CustomerJson;
import com.meibaolian.util.exception.DataManagerException;

public interface ICustomerService {
	/**
	 * 添加合作伙伴
	 * @param customer
	 * @return
	 */
	public int addCustomer(Customer customer);
	/**
	 * 获取自己的合作伙伴
	 * @param userid
	 * @param customertype
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<CustomerJson> getCustomerJson(int userid,
			int customertype, int page, int pageSize)
			throws DataManagerException;
	/**
	 * 删除合作伙伴
	 * @param id
	 * @return
	 */
	public int delCustomer(int id);
	/**
	 * 是否已存在此数据
	 * @param customer
	 * @return true 已存在
	 * @throws DataManagerException
	 */
	public boolean isExistCustomer(Customer customer) throws DataManagerException;
}
