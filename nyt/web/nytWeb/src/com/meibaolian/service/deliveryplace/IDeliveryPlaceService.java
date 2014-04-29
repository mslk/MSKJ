package com.meibaolian.service.deliveryplace;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.DeliveryPlaceDto;
import com.meibaolian.entity.DeliveryArea;
import com.meibaolian.entity.DeliveryPlace;

public interface IDeliveryPlaceService {
	/**
	 * 
	 * @param deliveryPlaceDto
	 * @param page
	 * @param pageSize
	 * @param orders
	 * @return
	 */
	public QueryResult<DeliveryPlace> searchList(DeliveryPlaceDto deliveryPlaceDto, int page, int pageSize, LinkedHashMap<String, String> orders);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public DeliveryPlace getDeliveryPlace(Integer id);
	/**
	 *  
	 * @param newDeliveryPlace
	 * @return
	 */
	public int updateDeliveryPlace(DeliveryPlace newDeliveryPlace);
	/**
	 * 
	 * @param deliveryPlaceInfo
	 * @return
	 */
	public int addDeliveryPlace(DeliveryPlace deliveryPlace);
	/**
	 * 
	 * @param deliveryPlaceDto
	 * @param page
	 * @param pageSize
	 * @param orders
	 * @return
	 */
	public QueryResult<DeliveryArea> searchAreaList(DeliveryPlaceDto deliveryPlaceDto, int page, int pageSize, LinkedHashMap<String, String> orders);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public int delDeliveryArea(Integer id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public int delDeliveryPlace(Integer id);
	/**
	 * 
	 * @param county
	 * @return
	 */
	public int addDeliveryArea(DeliveryArea deliveryArea);
	/**
	 * 
	 * @param dbDeliveryArea
	 * @param newDeliveryArea
	 * @return
	 */
	public int updateDeliveryArea(DeliveryArea dbDeliveryArea, DeliveryArea newDeliveryArea);
	/**
	 * 
	 * @param DeliveryArea
	 * @return
	 */
	public DeliveryArea getDeliveryArea(DeliveryArea deliveryArea);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public DeliveryArea getDeliveryArea(Integer id);
}
