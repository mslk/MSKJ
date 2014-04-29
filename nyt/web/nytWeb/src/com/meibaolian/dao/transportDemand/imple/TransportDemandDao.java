package com.meibaolian.dao.transportDemand.imple;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.meibaolian.dao.base.IReader;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.transportDemand.ITransportDemandDao;
import com.meibaolian.dto.TransportDemandDto;
import com.meibaolian.entity.TransportDemand;
import com.meibaolian.util.UtilHelp;

public class TransportDemandDao extends BaseDao<TransportDemand> implements ITransportDemandDao{

	@Override
	public QueryResult<TransportDemand> searchList(
			TransportDemandDto transportDemandDto, int page, int pageSize,
			LinkedHashMap<String, String> orders) {
		//id, userid, username, phone, addtime, start, stop, price, quantity, sendoutdate, validdate, sortnumber, status
		String sql = "select t.id, t.userid, t.start, t.stop, t.quantity, t.validdate, u.realname, u.phone,t.startcityname,t.startprvname,t.stopcityname,t.stopprvname,t.startshortname,t.stopshortname,t.validstatus,t.sortnumber from transportdemand t,userinfo u ";
		String sqlCount = "select count(1) from transportdemand t,userinfo u ";
		StringBuilder where = new StringBuilder(" and t.userid=u.id ");
		List<Object> params = new ArrayList<Object>(); 
		
		if(UtilHelp.isNotNullStr(transportDemandDto.getKeyword())){
			String keyword = UtilHelp.setSQLLikeStr(transportDemandDto.getKeyword());
			where.append(" and  u.realname like ? ");
			params.add(keyword);
		}
//		or t.start like ? or t.stop like ?
		
		if(UtilHelp.isNotNullStr(transportDemandDto.getStart()))
		{
			where.append(" and ( t.startprvname like ? ");
			where.append(" or t.startcityname like ? ");
			where.append(" or t.start like ?  )");
			params.add(UtilHelp.setSQLLikeStr(transportDemandDto.getStart()));
			params.add(UtilHelp.setSQLLikeStr(transportDemandDto.getStart()));
			params.add(UtilHelp.setSQLLikeStr(transportDemandDto.getStart()));
		}
		
		if(UtilHelp.isNotNullStr(transportDemandDto.getStop()))
		{
			where.append(" and  ( t.stopprvname like ? ");
			where.append(" or t.stopcityname like ? ");
			where.append(" or t.stop like ?  )");
			params.add(UtilHelp.setSQLLikeStr(transportDemandDto.getStop()));
			params.add(UtilHelp.setSQLLikeStr(transportDemandDto.getStop()));
			params.add(UtilHelp.setSQLLikeStr(transportDemandDto.getStop()));
		}

		if(null != transportDemandDto.getBegindate()){
			where.append(" and t.validdate >= ? ");
			params.add(UtilHelp.dateFormat(transportDemandDto.getBegindate(), "yyyy-MM-dd")+" 23:59:59");
		}
		if(null != transportDemandDto.getEnddate()){
			where.append(" and t.validdate <= ? ");
			params.add(UtilHelp.dateFormat(transportDemandDto.getEnddate(), "yyyy-MM-dd")+" 23:59:59");
		}
		if(null != transportDemandDto.getStatus() && transportDemandDto.getStatus() > -1){
			where.append(" and t.validstatus = ? ");
			params.add(transportDemandDto.getStatus());
		}
		return super.searchSQLByParamter(sql, sqlCount, page, pageSize, where.toString(), params.toArray(), orders, listTransportDemandReader);
	}
	
	private IReader<TransportDemand> listTransportDemandReader = new IReader<TransportDemand>(){

		@Override
		public TransportDemand readerByList(Object[] objs) {
			//t.id, t.userid, t.start, t.stop, t.quantity, t.validdate, u.realname, u.phone,
			//t.startcityname,t.startprvname,t.stopcityname,t.stopprvname,t.startshortname,t.stopshortname
			TransportDemand transportDemand = new TransportDemand();
			transportDemand.setId((Integer)objs[0]);
			transportDemand.setUserid((Integer)objs[1]);
			transportDemand.setStart((String)objs[2]);
			transportDemand.setStop((String)objs[3]);
			transportDemand.setQuantity((Integer)objs[4]);
			transportDemand.setValiddate((Timestamp)objs[5]);
			transportDemand.setUsername((String)objs[6]);
			transportDemand.setPhone((String)objs[7]);
			transportDemand.setStartcityname((String)objs[8]);
			transportDemand.setStartprvname((String)objs[9]);
			transportDemand.setStopcityname((String)objs[10]);
			transportDemand.setStopprvname((String)objs[11]);
			transportDemand.setStartshortname((String)objs[12]);
			transportDemand.setStopshortname((String)objs[13]);
			transportDemand.setValidstatus((Integer)objs[14]);
			transportDemand.setSortnumber((Integer)objs[15]);
			return transportDemand;
		}};
}
