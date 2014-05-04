package com.meibaolian.service.other;

import com.meibaolian.entity.AdvertisingEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface IAdvertisingService {

	
	/**
	 * 获取广告图片地址
	 * @return
	 * @throws DataManagerException 
	 */
	public AdvertisingEntity getAdvertising(int type) throws DataManagerException;
	
}
