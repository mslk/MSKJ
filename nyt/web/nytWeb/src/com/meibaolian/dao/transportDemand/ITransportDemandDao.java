package com.meibaolian.dao.transportDemand;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.TransportDemandDto;
import com.meibaolian.entity.TransportDemand;

public interface ITransportDemandDao extends IBaseDao<TransportDemand>{
	
	public QueryResult<TransportDemand> searchList(
			TransportDemandDto transportDemandDto, int page, int pageSize,
			LinkedHashMap<String, String> orders);
}
