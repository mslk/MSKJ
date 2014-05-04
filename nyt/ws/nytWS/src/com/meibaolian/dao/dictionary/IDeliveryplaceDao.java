package com.meibaolian.dao.dictionary;

import java.util.List;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.DeliveryplaceEntity;
import com.meibaolian.util.exception.DataManagerException;

public interface IDeliveryplaceDao  extends IBaseDao<DeliveryplaceEntity>{
	
	
	public List<DeliveryplaceEntity> searchByCountId(int countid) throws DataManagerException;

}
