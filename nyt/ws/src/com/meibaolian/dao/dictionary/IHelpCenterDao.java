package com.meibaolian.dao.dictionary;

import java.util.List;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.HelpCenterEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface IHelpCenterDao extends IBaseDao<HelpCenterEntity> 
{
	
	/**
	 * 根据类型查找找到对于的帮助信息
	 * @param type
	 * @return
	 * @throws DataManagerException 
	 */
	public List<HelpCenterEntity> searchByType(int type) throws DataManagerException;

}
