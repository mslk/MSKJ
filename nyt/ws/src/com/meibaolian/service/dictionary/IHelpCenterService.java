package com.meibaolian.service.dictionary;

import java.util.List;

import com.meibaolian.entity.HelpCenterEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface IHelpCenterService 
{
	
	/**
	 * 根据类型查找找到对于的帮助信息
	 * @param type
	 * @return
	 * @throws DataManagerException 
	 */
	public List<HelpCenterEntity> searchByType(int type) throws DataManagerException;

}
