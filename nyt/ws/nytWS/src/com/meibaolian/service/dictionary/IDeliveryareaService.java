package com.meibaolian.service.dictionary;

import java.util.List;

import com.meibaolian.entity.DeliveryareaEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface IDeliveryareaService {

	
	public List<DeliveryareaEntity> searchAll() throws DataManagerException;
	
}
