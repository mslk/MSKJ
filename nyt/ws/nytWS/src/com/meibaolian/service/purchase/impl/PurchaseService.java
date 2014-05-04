package com.meibaolian.service.purchase.impl;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.purchase.IPurchaseDao;
import com.meibaolian.dao.purchase.IPurchaseJsonDao;
import com.meibaolian.dao.purchasepush.IPurchasepushDao;
import com.meibaolian.dao.user.IUserDao;
import com.meibaolian.entity.Purchase;
import com.meibaolian.entity.PurchaseJson;
import com.meibaolian.entity.SearchlogCoal;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.service.purchase.IPurchaseService;
import com.meibaolian.util.exception.DataManagerException;

public class PurchaseService implements IPurchaseService {


	private IPurchaseDao purchaseDao;
	private IPurchasepushDao purchasepushDao;
	private IPurchaseJsonDao purchaseJsonDao;
	private IUserDao userDao;

	@Override
	public QueryResult<Purchase> searchPurchases(int userid, int page,
			int pageSize, LinkedHashMap<String, String> orders) throws DataManagerException {
		return purchaseDao.searchPurchases(userid, page, pageSize, orders);
	}

	@Override
	public int addPurchaseAndPushTask(Purchase purchase, SearchlogCoal searchlog, int pushtype)  throws DataManagerException {
		int id = 0;
//		UserInfo user = userDao.getById(purchase.getUserid());
//		if(user != null){
//			purchase.setBuyername(user.getRealname());
			id = purchaseDao.addPurchase(purchase);
			if(pushtype == 1){
				purchasepushDao.updatePurchasepush(purchase.getUserid(), 0);
				purchasepushDao.addPurchasepush(searchlog, 1);
			}
//		}
		return id;
	}

	@Override
	public QueryResult<PurchaseJson> searchPurchases(SearchlogCoal searchlog,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException {
		
		return purchaseJsonDao.searchPurchases(searchlog, page, pageSize, orders);
	}

	@Override
	public int delPurchase(int purid) {
		return purchaseDao.delPurchase(purid);
	}

	@Override
	public int updatePurchaseValiddate(int purid, String validdate) {

		return purchaseDao.updatePurchaseValiddate(purid, validdate);
	}

	public void setPurchaseDao(IPurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}

	public void setPurchasepushDao(IPurchasepushDao purchasepushDao) {
		this.purchasepushDao = purchasepushDao;
	}

	public void setPurchaseJsonDao(IPurchaseJsonDao purchaseJsonDao) {
		this.purchaseJsonDao = purchaseJsonDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public PurchaseJson getById(int id) throws DataManagerException {
		return purchaseJsonDao.getById(id);
	}

	@Override
	public QueryResult<PurchaseJson> searchByKey(String keyword, int page,
			int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException {
		
		return purchaseJsonDao.searchByKey(keyword, page, pageSize, orders);
	}

	@Override
	public int updatePurchase(Purchase purchase) {
		return purchaseDao.updatePurchase(purchase);
	}

	@Override
	public QueryResult<PurchaseJson> searchByPlace(SearchlogCoal searchlog,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException {
		
		return purchaseJsonDao.searchByPlace(searchlog, page, pageSize, orders);
	}

}
