package com.meibaolian.service.deliveryplace;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.DeliveryplaceType;


public interface IDeliveryplaceTypeService
{
	
	public QueryResult<DeliveryplaceType> search(int page,int pageSize);
	
	public int addDeliveryPlaceType(DeliveryplaceType deliveryplaceType);  
	
	public int delDeliveryPlaceType(int id);
}
