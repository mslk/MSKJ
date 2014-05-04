package com.meibaolian.dao.transportSupplyPush;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.TransportSupply;
import com.meibaolian.entity.TransportSupplyPush;

public interface ITransportSupplyPushDao extends IBaseDao<TransportSupplyPush>{
	
	public int addTransportSupplyPush(TransportSupply transportSupply, int status);
	
	public int updateTransportSupplyPush(int userid, int status);
}
