package com.meibaolian.service.otheraid;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.HelpCenter;

public interface IHelpCenterService
{
	

	
	/**
	 * 根据类型 查询
	 * @param type
	 * @return
	 */
	public QueryResult<HelpCenter> searchByType(int page,int pageSize,int type);
	
	/***
	 * 根据id 获取
	 * @param id
	 * @return
	 */
	public HelpCenter getById(int id);
	
	/**
	 * 更新 帮助信息
	 * @param helpCenterV
	 */
	public void update(HelpCenter helpCenterV);
	
	/**
	 * 增加帮助信息
	 * @param helpCenter
	 */
	public void add(HelpCenter helpCenter);
	
	/**
	 * 删除帮助信息
	 * @param id
	 */
	public void delete(int id);

}
