package com.meibaolian.service.deliveryplace.imple;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.deliveryplace.IDeliveryAreaDao;
import com.meibaolian.dao.deliveryplace.IDeliveryPlaceDao;
import com.meibaolian.dto.DeliveryPlaceDto;
import com.meibaolian.entity.DeliveryArea;
import com.meibaolian.entity.DeliveryPlace;
import com.meibaolian.service.deliveryplace.IDeliveryPlaceService;
import com.meibaolian.util.UtilHelp;

public class DeliveryPlaceService implements IDeliveryPlaceService {
	
	private IDeliveryAreaDao deliveryAreaDao;
	private IDeliveryPlaceDao deliveryPlaceDao;
	//
	public void setDeliveryAreaDao(IDeliveryAreaDao deliveryAreaDao) {
		this.deliveryAreaDao = deliveryAreaDao;
	}

	public void setDeliveryPlaceDao(IDeliveryPlaceDao deliveryPlaceDao) {
		this.deliveryPlaceDao = deliveryPlaceDao;
	}
	

	//
	@Override
	public QueryResult<DeliveryPlace> searchList(DeliveryPlaceDto deliveryPlaceDto, int page,
			int pageSize, LinkedHashMap<String, String> orders) {
		
		return deliveryPlaceDao.searchList(deliveryPlaceDto, page, pageSize, orders);
	}

	@Override
	public DeliveryPlace getDeliveryPlace(Integer id) {

		return deliveryPlaceDao.getDeliveryPlace(id);
	}

	@Override
	public int updateDeliveryPlace(DeliveryPlace newDeliveryPlace) {
		int count = -1;
		DeliveryPlace dbDeliveryPlace = deliveryPlaceDao.get(newDeliveryPlace.getId());
		if(null != dbDeliveryPlace){
			if(UtilHelp.isNotNullStr(newDeliveryPlace.getCountyname())){
				dbDeliveryPlace.setCountyname(newDeliveryPlace.getCountyname().trim());
			}
			if(UtilHelp.isNotNullStr(newDeliveryPlace.getName())){
				dbDeliveryPlace.setName(newDeliveryPlace.getName().trim());
			}
			if(UtilHelp.isNotNullStr(newDeliveryPlace.getShortname())){
				dbDeliveryPlace.setShortname(newDeliveryPlace.getShortname().trim());
			}
			if(UtilHelp.isNotNullStr(newDeliveryPlace.getAddress())){
				dbDeliveryPlace.setAddress(newDeliveryPlace.getAddress().trim());
			}
			if(UtilHelp.isNotNullStr(newDeliveryPlace.getAddress())){
				dbDeliveryPlace.setAddress(newDeliveryPlace.getAddress().trim());
			}
			if(null != newDeliveryPlace.getType()){
				dbDeliveryPlace.setType(newDeliveryPlace.getType());
			}
			if(null != newDeliveryPlace.getHeating()){
				dbDeliveryPlace.setHeating(newDeliveryPlace.getHeating());
			}
//			if(UtilHelp.isNotNullStr(newDeliveryPlace.getSulphur()) && UtilHelp.isFloatStr(newDeliveryPlace.getSulphur())){
//				dbDeliveryPlace.setSulphur(newDeliveryPlace.getSulphur());
//			}
//			if(UtilHelp.isNotNullStr(newDeliveryPlace.getAsh()) && UtilHelp.isFloatStr(newDeliveryPlace.getAsh())){
//				dbDeliveryPlace.setAsh(newDeliveryPlace.getAsh());
//			}
//			if(UtilHelp.isNotNullStr(newDeliveryPlace.getMoisture()) && UtilHelp.isFloatStr(newDeliveryPlace.getMoisture())){
//				dbDeliveryPlace.setMoisture(newDeliveryPlace.getMoisture());
//			}
			if(null != newDeliveryPlace.getSulphur()){
				dbDeliveryPlace.setSulphur(newDeliveryPlace.getSulphur());
			}
			if(null != newDeliveryPlace.getAsh()){
				dbDeliveryPlace.setAsh(newDeliveryPlace.getAsh());
			}
			if(null != newDeliveryPlace.getMoisture()){
				dbDeliveryPlace.setMoisture(newDeliveryPlace.getMoisture());
			}
			deliveryPlaceDao.update(dbDeliveryPlace);
			count = 1;
		}
		return count;
	}

	@Override
	public int addDeliveryPlace(DeliveryPlace deliveryPlace) {

		int result = 0;
		long count = 0;
		count = deliveryPlaceDao.searchCountByhql("select count(provincename) from DeliveryPlace where provincename like ? and cityname like ? and countyname like ? and name like ? ", 
				new Object[]{UtilHelp.setSQLLikeStr(deliveryPlace.getProvincename()), 
				UtilHelp.setSQLLikeStr(deliveryPlace.getCityname()), 
				UtilHelp.setSQLLikeStr(deliveryPlace.getCountyname()),
				UtilHelp.setSQLLikeStr(deliveryPlace.getName())});
		if(count == 0){
			deliveryPlaceDao.add(deliveryPlace);
			result++;
		}
		return result;
	}

	@Override
	public QueryResult<DeliveryArea> searchAreaList(
			DeliveryPlaceDto deliveryPlaceDto, int page, int pageSize,
			LinkedHashMap<String, String> orders) {
		
		return deliveryAreaDao.searchAreaList(deliveryPlaceDto, page, pageSize, orders);
	}

	@Override
	public int delDeliveryArea(Integer id) {
		deliveryAreaDao.delete(id);
		return 1;
	}

	@Override
	public int delDeliveryPlace(Integer id) {
		deliveryPlaceDao.delete(id);
		return 1;
	}

	@Override
	public int addDeliveryArea(DeliveryArea deliveryArea) {
		deliveryAreaDao.add(deliveryArea);
		return 1;
	}

	@Override
	public int updateDeliveryArea(DeliveryArea dbDeliveryArea,
			DeliveryArea newDeliveryArea) {
		int count = 0;
		dbDeliveryArea = getDeliveryArea(dbDeliveryArea);
		if(null != dbDeliveryArea){
			dbDeliveryArea.setProvincename(newDeliveryArea.getProvincename());
			dbDeliveryArea.setCityname(newDeliveryArea.getCityname());
			dbDeliveryArea.setCountyname(newDeliveryArea.getCountyname());
			dbDeliveryArea.setShortcountyname(newDeliveryArea.getShortcountyname());
			count++;
		}
		return count;
	}

	@Override
	public DeliveryArea getDeliveryArea(DeliveryArea deliveryArea) {
		return deliveryAreaDao.get(
				" and countyid=? and cityid=? and provinceid=?", new Object[] {
						deliveryArea.getCountyid(),
						deliveryArea.getCityid(),
						deliveryArea.getProvinceid() });
	}

	@Override
	public DeliveryArea getDeliveryArea(Integer id) {
		
		return deliveryAreaDao.get(id);
	}
	
}
