package com.meibaolian.service.nyt;

import java.util.List;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.PurchaseInfo;
import com.meibaolian.entity.PurchaseInfoExpand;
import com.meibaolian.entity.SupplyInfo;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.exception.NoParameterException;
import com.meibaolian.web.nyt.dto.PurchaseDTo;

public interface IPurchaseInfoService 
{


	
	public int add(PurchaseInfo purchaseInfo) throws NoParameterException;
	
	public int delete(Integer userid,Integer supplyId);
	
	public int update(PurchaseInfo purchaseInfo);
	
	public QueryResult<PurchaseInfo> search();
	 
	public QueryResult<PurchaseInfoExpand> search(int page,int pageSize,PurchaseDTo dto) throws DataManagerException;
	 
	public QueryResult<PurchaseInfo> search(int page,int pageSize,int userid,int type) throws DataManagerException;
//	/**
//	 * 根据id查询
//	 * @param id
//	 * @return
//	 * @throws DataManagerException
//	 */
//	public PurchaseInfo getById(int id) throws DataManagerException;
//	
	/**
	 * 根据记录id查询
	 * @param ids 集合数组
	 * @return
	 * @throws DataManagerException
	 */
	public List<PurchaseInfo> searchByIds(int[] ids) throws DataManagerException;

}
