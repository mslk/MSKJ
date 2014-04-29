package com.meibaolian.service.transportDemand;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.TransportDemandDto;
import com.meibaolian.entity.TransportDemand;

public interface ITransportDemandService {
	
	public QueryResult<TransportDemand> searchList(
			TransportDemandDto transportDemandDto, int page, int pageSize,
			LinkedHashMap<String, String> orders);
	
	public TransportDemand getTransportDemand(int id);
	
	public void deleteById(int id);
	
	/**
	 * 屏蔽、恢复信息
	 * @param id
	 * @param status 屏蔽状态（0 正常，1 屏蔽）
	 */
	public int updateStatus(int id, int status);
	/**
	 * 修改排序值
	 * @param id
	 * @param sortnumber
	 * @return
	 */
	public int updateSortNum(Integer id, Integer sortnumber);
}
