package com.meibaolian.dao.purchase;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.PurchaseJson;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.util.exception.DataManagerException;

public interface IPurchaseJsonDao extends IBaseDao<PurchaseJson>{
	/**
	 * 按条件查询求购单
	 * 
	 * @return
	 */
	public QueryResult<PurchaseJson> searchPurchases(SearchlogCoal searchlog,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException;
	
	/**
	 * 根据id 查询求购单详情
	 * @param id
	 * @return
	 * @throws DataManagerException 
	 */
	public PurchaseJson getById(int id) throws DataManagerException;
	
	/**
	 * 关键字查询
	 * @param keyword
	 * @param page
	 * @param pageSize
	 * @param orders
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<PurchaseJson> searchByKey(String keyword,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException;
	
	/**
	 * 按起止地查询求购单
	 * @param searchlog
	 * @param page
	 * @param pageSize
	 * @param orders
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<PurchaseJson> searchByPlace(SearchlogCoal searchlog,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException;
}
