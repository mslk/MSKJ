package com.meibaolian.service.dictionary.impl;

import java.util.List;

import com.meibaolian.dao.dictionary.IDeliveryplaceDao;
import com.meibaolian.entity.DeliveryplaceEntity;
import com.meibaolian.service.dictionary.IDeliveryplaceService;
import com.meibaolian.util.exception.DataManagerException;

public class DeliveryplaceService implements IDeliveryplaceService {

	
	IDeliveryplaceDao deliveryplaceDao;
	
	public void setDeliveryplaceDao(IDeliveryplaceDao deliveryplaceDao) {
		this.deliveryplaceDao = deliveryplaceDao;
	}




	@Override
	public List<DeliveryplaceEntity> searchByCountId(int countid)
			throws DataManagerException {
		return deliveryplaceDao.searchByCountId(countid);
	}

	
	
}
