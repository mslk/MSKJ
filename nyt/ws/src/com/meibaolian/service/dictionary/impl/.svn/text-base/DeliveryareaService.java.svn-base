package com.meibaolian.service.dictionary.impl;

import java.util.List;

import com.meibaolian.dao.dictionary.IDeliveryareaDao;
import com.meibaolian.entity.DeliveryareaEntity;
import com.meibaolian.service.dictionary.IDeliveryareaService;
import com.meibaolian.util.exception.DataManagerException;

public class DeliveryareaService implements IDeliveryareaService{

	private IDeliveryareaDao deliveryareaDao;
	

	public void setDeliveryareaDao(IDeliveryareaDao deliveryareaDao) {
		this.deliveryareaDao = deliveryareaDao;
	}

	@Override
	public List<DeliveryareaEntity> searchAll()
			throws DataManagerException {
		return deliveryareaDao.searchAll();
	}

}
