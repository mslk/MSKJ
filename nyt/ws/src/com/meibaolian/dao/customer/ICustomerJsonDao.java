package com.meibaolian.dao.customer;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.CustomerJson;
import com.meibaolian.util.exception.DataManagerException;

public interface ICustomerJsonDao extends IBaseDao<CustomerJson>{
	
	public QueryResult<CustomerJson> getCustomerJson(int userid, int customertype, int page, int pageSize) throws DataManagerException;
}
