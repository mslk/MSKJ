package com.meibaolian.dao.deliveryplace.imple;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.deliveryplace.IDeliveryAreaDao;
import com.meibaolian.dto.DeliveryPlaceDto;
import com.meibaolian.entity.DeliveryArea;
import com.meibaolian.util.UtilHelp;

public class DeliveryAreaDao extends BaseDao<DeliveryArea> implements IDeliveryAreaDao {

	@Override
	public QueryResult<DeliveryArea> searchAreaList(
			DeliveryPlaceDto deliveryPlaceDto, int page, int pageSize,
			LinkedHashMap<String, String> orders) {
		String where = null;
		Object[] params = null;
		if(UtilHelp.isNotNullStr(deliveryPlaceDto.getKeyword())){
			String keyword = UtilHelp.setSQLLikeStr(deliveryPlaceDto.getKeyword());
			params = new Object[]{keyword, keyword, keyword};
			where = " and (countyname like ? or cityname like ? or provincename like ?)";
		}
		return super.search(page, pageSize, where, params, orders);
	}
	
}
