package com.meibaolian.service.deliveryplace.imple;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.deliveryplace.IDeliveryplaceTypeDao;
import com.meibaolian.entity.DeliveryplaceType;
import com.meibaolian.service.deliveryplace.IDeliveryplaceTypeService;
import com.meibaolian.util.UtilHelp;

public class DeliveryplaceTypeService implements IDeliveryplaceTypeService {

	
	
	IDeliveryplaceTypeDao deliveryplaceTypeDao;
	
	public void setDeliveryplaceTypeDao(IDeliveryplaceTypeDao deliveryplaceTypeDao) {
		this.deliveryplaceTypeDao = deliveryplaceTypeDao;
	}



	@Override
	public QueryResult<DeliveryplaceType> search(int page, int pageSize) {
		return deliveryplaceTypeDao.search(page, pageSize);
	}

	@Override
	public int addDeliveryPlaceType(DeliveryplaceType deliveryplaceType) {
		long count = deliveryplaceTypeDao.searchCountByhql("select count(id) from DeliveryplaceType where type=? or typeName like ?", 
				new Object[]{deliveryplaceType.getType(), UtilHelp.setSQLLikeStr(deliveryplaceType.getTypeName())});
		if(count > 0){
			return 0;
		}
		deliveryplaceTypeDao.add(deliveryplaceType);
		return 1;
	}



	@Override
	public int delDeliveryPlaceType(int id) {
		deliveryplaceTypeDao.delete(id);
		return 1;
	}

}
