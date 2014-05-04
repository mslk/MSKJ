package com.meibaolian.dao.purchasepush;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.Purchasepush;
import com.meibaolian.entity.SearchlogCoal;

public interface IPurchasepushDao extends IBaseDao<Purchasepush>{
	
	/**
	 * 添加求购单推送任务
	 * @param purchase
	 * @param status 推送有效状态 0-无效，1-有效
	 * @return
	 */
	public int addPurchasepush(SearchlogCoal searchlog, int status);
	
	/**
	 * 更新求购单推送任务
	 * @param userid 用户id
	 * @param status 推送有效状态 0-无效，1-有效
	 * @return
	 */
	public int updatePurchasepush(int userid, int status);
}
