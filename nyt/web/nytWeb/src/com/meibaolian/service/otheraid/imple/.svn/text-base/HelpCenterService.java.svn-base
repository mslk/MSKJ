package com.meibaolian.service.otheraid.imple;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.otheraid.IHelpCenterDao;
import com.meibaolian.entity.HelpCenter;
import com.meibaolian.service.otheraid.IHelpCenterService;

public class HelpCenterService implements IHelpCenterService 
{

	IHelpCenterDao helpCenterDao;
	
	
	public void setHelpCenterDao(IHelpCenterDao helpCenterDao) {
		this.helpCenterDao = helpCenterDao;
	}

	@Override
	public QueryResult<HelpCenter> searchByType(int page,int pageSize,int type) 
	{
		return helpCenterDao.searchByType(page, pageSize, type);
	}

	@Override
	public HelpCenter getById(int id) {
		return helpCenterDao.get(id);
	}
	
	@Override
	public void update(HelpCenter helpCenter) {
		helpCenterDao.update(helpCenter);
	}
	
	@Override
	public void add(HelpCenter helpCenter) {
		helpCenterDao.add(helpCenter);
	}
	
	@Override
	public void delete(int id) {
		helpCenterDao.delete(id);	
	}

	
	
}
