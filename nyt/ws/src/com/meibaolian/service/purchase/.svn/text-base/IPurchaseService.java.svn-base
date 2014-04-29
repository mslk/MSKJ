package com.meibaolian.service.purchase;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.Purchase;
import com.meibaolian.entity.PurchaseJson;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.util.exception.DataManagerException;

public interface IPurchaseService {

	/**
	 * 用户查询自己已发布的求购信息
	 * 
	 * @param userid
	 *            用户id
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws DataManagerException
	 */
	public QueryResult<Purchase> searchPurchases(int userid, int page,
			int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException;

	/**
	 * 发布求购信息，添加到推送任务
	 * 
	 * @param Purchase
	 * @param pushtype
	 *            0 不推送,1 推送
	 * @return
	 */
	public int addPurchaseAndPushTask(Purchase purchase, SearchlogCoal searchlog,
			int pushtype) throws DataManagerException;

	/**
	 * 按条件查询求购单
	 * 
	 * @return
	 */
	public QueryResult<PurchaseJson> searchPurchases(SearchlogCoal searchlog,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException;

	/**
	 * 直接删除数据
	 * 
	 * @param purid
	 * @return
	 */
	public int delPurchase(int purid);

	/**
	 * 根据id 查询求购单详情
	 * 
	 * @param id
	 * @return
	 * @throws DataManagerException
	 */
	public PurchaseJson getById(int id) throws DataManagerException;

	/**
	 * 更新有效期
	 * 
	 * @param purid
	 * @param validdate
	 * @return
	 */
	public int updatePurchaseValiddate(int purid, String validdate);
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
	 * 更新煤质指标
	 * @param purchase
	 * @return
	 */
	public int updatePurchase(Purchase purchase);
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
