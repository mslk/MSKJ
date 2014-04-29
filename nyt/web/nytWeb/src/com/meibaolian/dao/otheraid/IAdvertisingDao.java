package com.meibaolian.dao.otheraid;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.Advertising;

public interface IAdvertisingDao extends IBaseDao<Advertising> {

	
	/**
	 * 删除多于的广告信息，确保 ios android 都只有一条数据
	 */
	public void deleteSurplusAdvertising();
	
	
}
