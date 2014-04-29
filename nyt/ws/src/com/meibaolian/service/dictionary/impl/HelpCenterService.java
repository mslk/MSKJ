package com.meibaolian.service.dictionary.impl;

import java.util.List;

import com.meibaolian.dao.dictionary.IHelpCenterDao;
import com.meibaolian.entity.HelpCenterEntity;
import com.meibaolian.service.dictionary.IHelpCenterService;
import com.meibaolian.util.exception.DataManagerException;

public class HelpCenterService implements IHelpCenterService {

	
	
	IHelpCenterDao  helpCenterDao;
	
	
	public void setHelpCenterDao(IHelpCenterDao helpCenterDao) {
		this.helpCenterDao = helpCenterDao;
	}




	@Override
	public List<HelpCenterEntity> searchByType(int type) throws DataManagerException {
		return helpCenterDao.searchByType(type);
	}

}
