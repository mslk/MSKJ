package com.meibaolian.service.dictionary;

import java.util.List;

import com.meibaolian.entity.DeliveryplaceEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface IDeliveryplaceService {

	
	public List<DeliveryplaceEntity> searchByCountId(int countid) throws DataManagerException;
}
