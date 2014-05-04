package com.meibaolian.dao.transportDemandPush;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.TransportDemand;
import com.meibaolian.entity.TransportDemandPush;

public interface ITransportDemandPushDao extends IBaseDao<TransportDemandPush>{
	
	public int addTransportDemandPush(TransportDemand transportDemand, int status);
	
	public int updateTransportDemandPush(int userid, int status);
}
