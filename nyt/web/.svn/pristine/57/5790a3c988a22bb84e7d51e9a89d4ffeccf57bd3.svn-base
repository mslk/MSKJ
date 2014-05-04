package com.meibaolian.service.transportSupply.imple;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.transportSupply.ITransportSupplyDao;
import com.meibaolian.dao.userInfo.IUserInfoDao;
import com.meibaolian.dto.TransportSupplyDto;
import com.meibaolian.entity.Provider;
import com.meibaolian.entity.TransportSupply;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.service.transportSupply.ITransportSupplyService;

public class TransportSupplyService implements ITransportSupplyService {

	
	ITransportSupplyDao transportSupplyDao;
	
	private IUserInfoDao userInfoDao;
	
	public void setTransportSupplyDao(ITransportSupplyDao transportSupplyDao) {
		this.transportSupplyDao = transportSupplyDao;
	}

	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}



	@Override
	public QueryResult<TransportSupply> searchList(
			TransportSupplyDto transportSupplyDto, int page, int pageSize,
			LinkedHashMap<String, String> orders) {
		return transportSupplyDao.searchList(transportSupplyDto, page, pageSize, orders);
	}

	@Override
	public TransportSupply getTransportSupply(int id) {
		TransportSupply transportSupply = null;
		UserInfo userInfo = null;
		transportSupply = transportSupplyDao.get(id);
		
		if(null != transportSupply){
			userInfo = userInfoDao.get(transportSupply.getUserid());
			if(null != userInfo){
				transportSupply.setUsername(userInfo.getRealname());
				transportSupply.setPhone(userInfo.getPhone());
				transportSupply.setCarnumber(userInfo.getCarnumber());
			}
		}
		
		return transportSupply;
	}

	@Override
	public void deleteById(int id) {
		transportSupplyDao.delete(id);
	}

	@Override
	public int updateStatus(int id, int status) {
		int count = -1;
		TransportSupply transportSupply =transportSupplyDao.get(id);
		if(null != transportSupply){
			transportSupply.setValidstatus(status);//屏蔽状态（0 正常，1 屏蔽）
			count=1;
		}
		return count;
	}

	@Override
	public int updateSortNum(Integer id, Integer sortnumber) {
		int count = -1;
		TransportSupply transportSupply =transportSupplyDao.get(id);
		if(null != transportSupply){
			transportSupply.setSortnumber(sortnumber);
			count=1;
		}
		return count;
	}

}
