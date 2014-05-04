package com.meibaolian.dao.deliveryplace;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.DeliveryPlaceDto;
import com.meibaolian.entity.DeliveryPlace;

public interface IDeliveryPlaceDao extends IBaseDao<DeliveryPlace>{
	
	public QueryResult<DeliveryPlace> searchList(DeliveryPlaceDto deliveryPlaceDto, int page, int pageSize, LinkedHashMap<String, String> orders);
	
	public DeliveryPlace getDeliveryPlace(Integer id);
}
