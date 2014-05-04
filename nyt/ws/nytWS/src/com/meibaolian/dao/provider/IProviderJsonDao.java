package com.meibaolian.dao.provider;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.ProviderJson;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.util.exception.DataManagerException;

public interface IProviderJsonDao extends IBaseDao<ProviderJson>{
	
	/**
	 * 按条件查询出售单
	 * @return
	 */
	public QueryResult<ProviderJson> searchProviders(SearchlogCoal searchlog, int page, int pageSize, LinkedHashMap<String, String> orders) throws DataManagerException;
	
	/**
	 * 买方按条件查询出售单,带运价
	 * 
	 * @return
	 */
	public QueryResult<ProviderJson> searchProvidersWithRate(SearchlogCoal searchlog,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException;
	/**
	 * 根据id 查询供应信息详情
	 * @param id
	 * @return
	 * @throws DataManagerException 
	 */
	public ProviderJson getById(int id) throws DataManagerException;
	
	/**
	 * 关键字查询
	 * @param keyword 关键字
	 * @param page
	 * @param pageSize
	 * @param orders
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<ProviderJson> searchByKey(String keyword, int page,
			int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException;
}
