package com.meibaolian.service.purchase;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.PurchaseDto;
import com.meibaolian.entity.Purchase;

public interface IPurchaseService {
	
	public QueryResult<Purchase> searchList(PurchaseDto userInfoDto, int page, int pageSize, LinkedHashMap<String, String> orders);
	
	public Purchase getPurchase(Integer id);
	
	public void updatePurchase(Purchase purchase);
	
	public int updatePurchase(Integer id, Integer sortnumber);
	
	public void deletePurchaseById(int id);
	/**
	 * 屏蔽、恢复信息
	 * @param id
	 * @param status 屏蔽状态（0 正常，1 屏蔽）
	 */
	public int updateStatus(int id, int status);
}
