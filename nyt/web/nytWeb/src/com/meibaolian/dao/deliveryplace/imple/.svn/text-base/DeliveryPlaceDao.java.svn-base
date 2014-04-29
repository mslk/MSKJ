package com.meibaolian.dao.deliveryplace.imple;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.meibaolian.dao.base.IReader;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.deliveryplace.IDeliveryPlaceDao;
import com.meibaolian.dto.DeliveryPlaceDto;
import com.meibaolian.entity.DeliveryPlace;
import com.meibaolian.util.UtilHelp;

public class DeliveryPlaceDao extends BaseDao<DeliveryPlace> implements IDeliveryPlaceDao {

	@Override
	public QueryResult<DeliveryPlace> searchList(DeliveryPlaceDto deliveryPlaceDto, int page,
			int pageSize, LinkedHashMap<String, String> orders) {

		String sql = "select d.id,d.name,d.address,d.shortname,d.countyid,d.countyname,d.cityid,d.cityname,d.provinceid,d.provincename,d.type,d.heating,d.sulphur,d.ash,d.moisture,dt.typename from deliveryplace d,deliveryplacetype dt ";
		String sqlCount = "select count(1) from deliveryplace d,deliveryplacetype dt ";
		StringBuilder where = new StringBuilder(" and d.type=dt.type ");
		List<Object> params = new ArrayList<Object>(); 
		
		if(null != deliveryPlaceDto.getType() && deliveryPlaceDto.getType() > -1){
			where.append(" and d.type=? ");
			params.add(deliveryPlaceDto.getType());
		}
		if(UtilHelp.isNotNullStr(deliveryPlaceDto.getKeyword())){
			where.append(" and ( d.name like ? or d.address like ?)");
			String keyword =  UtilHelp.setSQLLikeStr(deliveryPlaceDto.getKeyword());
			params.add(keyword);
			params.add(keyword);
		}
		
		return super.searchSQLByParamter(sql, sqlCount, page, pageSize, where.toString(), params.toArray(), orders, listDeliveryPlaceReader);
	}
	
	@Override
	public DeliveryPlace getDeliveryPlace(Integer id) {
		String sql = "select d.id,d.name,d.address,d.shortname,d.countyid,d.countyname,d.cityid,d.cityname,d.provinceid,d.provincename,d.type,d.heating,d.sulphur,d.ash,d.moisture,dt.typename from deliveryplace d,deliveryplacetype dt ";
		StringBuilder where = new StringBuilder(" and d.type=dt.type and d.id=?");
		String sqlCount = "select count(1) from deliveryplace d,deliveryplacetype dt ";
		QueryResult<DeliveryPlace> qr = super.searchSQLByParamter(sql, sqlCount, 1, 1, where.toString(), new Object[]{id}, null, listDeliveryPlaceReader);
		
		return qr.getQueryList().get(0);
	}

	private IReader<DeliveryPlace> listDeliveryPlaceReader = new IReader<DeliveryPlace>(){

		@Override
		public DeliveryPlace readerByList(Object[] objs) {
			//id,name,address,countyid,cityid,type,heating,sulphur,ash,moisture
			DeliveryPlace deliveryPlace = new DeliveryPlace();
			deliveryPlace.setId((Integer)objs[0]);
			deliveryPlace.setName((String)objs[1]);
			deliveryPlace.setAddress((String)objs[2]);
			deliveryPlace.setShortname((String)objs[3]);
			deliveryPlace.setCountyid((Integer)objs[4]);
			deliveryPlace.setCountyname((String)objs[5]);
			deliveryPlace.setCityid((Integer)objs[6]);
			deliveryPlace.setCityname((String)objs[7]);
			deliveryPlace.setProvinceid((Integer)objs[8]);
			deliveryPlace.setProvincename((String)objs[9]);
			deliveryPlace.setType((Integer)objs[10]);
			deliveryPlace.setHeating((Integer)objs[11]);
			deliveryPlace.setSulphur(null != objs[12] ? ((BigDecimal)objs[12]).doubleValue() : null);
			deliveryPlace.setAsh(null != objs[13] ? ((BigDecimal)objs[13]).doubleValue() : null);
			deliveryPlace.setMoisture(null != objs[14] ? ((BigDecimal)objs[14]).doubleValue() : null);
			deliveryPlace.setTypename((String)objs[15]);
			return deliveryPlace;
		}};


}
