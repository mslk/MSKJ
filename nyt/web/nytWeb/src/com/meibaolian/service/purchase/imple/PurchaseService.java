package com.meibaolian.service.purchase.imple;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.purchase.IPurchaseDao;
import com.meibaolian.dao.purchase.IPurchaseInfoDao;
import com.meibaolian.dao.userInfo.IUserInfoDao;
import com.meibaolian.dto.PurchaseDto;
import com.meibaolian.entity.Provider;
import com.meibaolian.entity.Purchase;
import com.meibaolian.entity.PurchaseInfo;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.service.purchase.IPurchaseService;

public class PurchaseService implements IPurchaseService {
	
	private IPurchaseInfoDao purchaseInfoDao;
	private IPurchaseDao purchaseDao;
	private IUserInfoDao userInfoDao;
	
	
	@Override
	public QueryResult<Purchase> searchList(PurchaseDto purchaseDto, int page,
			int pageSize, LinkedHashMap<String, String> orders) {
		
//		return purchaseInfoDao.searchList(purchaseDto, page, pageSize, orders);
		return purchaseDao.searchList(purchaseDto, page, pageSize, orders);
	}

	@Override
	public Purchase getPurchase(Integer id) {
		
		Purchase purchase = null;
		UserInfo userInfo = null;
		Purchase purchaseInfo = null;
		
		purchase = purchaseDao.get(id);
		if(null != purchase){
			userInfo = userInfoDao.get(purchase.getUserid());
			if(null != userInfo){
//				purchaseInfo = new Purchase(purchase, userInfo);
				purchase.setBuyername(userInfo.getRealname());
				purchase.setCompany(userInfo.getCompanyname());
				purchase.setPhone(userInfo.getPhone());
			}else{
				purchase = null;
			}
		}
//		return purchaseInfo;
		return purchase;
	}
	
	@Override
	public void updatePurchase(Purchase purchase) {
		
		
	}
	
	@Override
	public int updatePurchase(Integer id, Integer sortnumber) {
		
		int count = -1;
		Purchase purchase = purchaseDao.get(id);
		if(null != purchase){
			purchase.setSortnumber(sortnumber);
//			purchaseDao.update(purchase);
			count = 1;
		}
		return count;
	}

	@Override
	public int updateStatus(int id, int status) {
		int count = -1;
		Purchase purchase = purchaseDao.get(id);
		if(null != purchase){
			purchase.setValidstatus(status);//屏蔽状态（0 正常，1 屏蔽）
			count=1;
		}
		return count;
	}

	public void setPurchaseInfoDao(IPurchaseInfoDao purchaseInfoDao) {
		this.purchaseInfoDao = purchaseInfoDao;
	}

	public void setPurchaseDao(IPurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
	}

	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public void deletePurchaseById(int id) {
		purchaseDao.delete(id);
	}

	


	

}
