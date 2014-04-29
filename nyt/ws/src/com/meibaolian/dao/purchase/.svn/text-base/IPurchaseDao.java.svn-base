package com.meibaolian.dao.purchase;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.Purchase;
import com.meibaolian.util.exception.DataManagerException;

public interface IPurchaseDao extends IBaseDao<Purchase> {
	/**
	 * 发布求购信息
	 * 
	 * @param Purchase
	 * @return
	 */
	public int addPurchase(Purchase purchase);

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
	 * 直接删除数据
	 * 
	 * @param purid
	 * @return
	 */
	public int delPurchase(int purid);

	/**
	 * 更新有效期
	 * 
	 * @param purid
	 * @param validdate
	 * @return
	 */
	public int updatePurchaseValiddate(int purid, String validdate);
	
	/**
	 * 更新煤质指标
	 * @param purchase
	 * @return
	 */
	public int updatePurchase(Purchase purchase);
}
