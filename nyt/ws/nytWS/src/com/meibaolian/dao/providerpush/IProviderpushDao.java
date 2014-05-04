package com.meibaolian.dao.providerpush;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.Providerpush;
import com.meibaolian.entity.SearchlogCoal;

public interface IProviderpushDao extends IBaseDao<Providerpush>{
	
	/**
	 * 添加出售信息推送任务
	 * @param purchase
	 * @param status 推送有效状态 0-无效，1-有效
	 * @return
	 */
	public int addProviderpush(SearchlogCoal searchlog, int status);
	
	/**
	 * 更新出售信息推送任务
	 * @param userid 用户id
	 * @param status 推送有效状态 0-无效，1-有效
	 * @return
	 */
	public int updateProviderpush(int userid, int status);
}
