package com.meibaolian.service.other.imple;

import com.meibaolian.dao.other.IAdvertisingDao;
import com.meibaolian.entity.AdvertisingEntity;
import com.meibaolian.service.other.IAdvertisingService;
import com.meibaolian.util.exception.DataManagerException;

public class AdvertisingService implements IAdvertisingService {

	
	IAdvertisingDao advertisingDao;
	
	public void setAdvertisingDao(IAdvertisingDao advertisingDao) {
		this.advertisingDao = advertisingDao;
	}




	@Override
	public AdvertisingEntity getAdvertising(int type) throws DataManagerException {
		return advertisingDao.getAdvertising(type);
	}

}
