package com.meibaolian.dao.transportSupply.imple;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.meibaolian.dao.base.IReader;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.transportSupply.ITransportSupplyDao;
import com.meibaolian.dto.TransportSupplyDto;
import com.meibaolian.entity.TransportSupply;
import com.meibaolian.util.UtilHelp;

public class TransportSupplyDao extends BaseDao<TransportSupply> implements ITransportSupplyDao{

	@Override
	public QueryResult<TransportSupply> searchList(
			TransportSupplyDto transportSupplyDto, int page, int pageSize,
			LinkedHashMap<String, String> orders) {
		//id, userid, username, phone, addtime, start, stop, price, quantity, sendoutdate, validdate, sortnumber, status
		String sql = "select t.id, t.userid, t.start, t.stop, t.quantity, t.validdate, u.realname, u.phone,t.startcityname,t.startprvname,t.stopcityname,t.stopprvname,t.startshortname,t.stopshortname,t.carnumber,t.validstatus,t.sortnumber from transportsupply t,userinfo u ";
		String sqlCount = "select count(1) from transportsupply t,userinfo u ";
		StringBuilder where = new StringBuilder(" and t.userid=u.id ");
		List<Object> params = new ArrayList<Object>(); 
		
//		or t.start like ? or t.stop like ?
		if(UtilHelp.isNotNullStr(transportSupplyDto.getStart()))
		{
			where.append(" and ( t.startprvname like ? ");
			where.append(" or t.startcityname like ? ");
			where.append(" or t.start like ?  )");
			params.add(UtilHelp.setSQLLikeStr(transportSupplyDto.getStart()));
			params.add(UtilHelp.setSQLLikeStr(transportSupplyDto.getStart()));
			params.add(UtilHelp.setSQLLikeStr(transportSupplyDto.getStart()));
		}
		if(UtilHelp.isNotNullStr(transportSupplyDto.getStop()))
		{
			where.append(" and  ( t.stopprvname like ? ");
			where.append(" or t.stopcityname like ? ");
			where.append(" or t.stop like ?  )");
			params.add(UtilHelp.setSQLLikeStr(transportSupplyDto.getStop()));
			params.add(UtilHelp.setSQLLikeStr(transportSupplyDto.getStop()));
			params.add(UtilHelp.setSQLLikeStr(transportSupplyDto.getStop()));
		}
		
		if(UtilHelp.isNotNullStr(transportSupplyDto.getKeyword())){
			String keyword = UtilHelp.setSQLLikeStr(transportSupplyDto.getKeyword());
			where.append(" and ( u.realname like ?  or t.carnumber like ?)");
			params.add(keyword);
			params.add(keyword);
		} 
		if(null != transportSupplyDto.getBegindate()){
			where.append(" and t.validdate >= ? ");
			params.add(UtilHelp.dateFormat(transportSupplyDto.getBegindate(), "yyyy-MM-dd")+" 23:59:59");
		}
		if(null != transportSupplyDto.getEnddate()){
			where.append(" and t.validdate <= ? ");
			params.add(UtilHelp.dateFormat(transportSupplyDto.getEnddate(), "yyyy-MM-dd")+" 23:59:59");
		}
		if(null != transportSupplyDto.getStatus() && transportSupplyDto.getStatus() > -1){
			where.append(" and t.validstatus = ? ");
			params.add(transportSupplyDto.getStatus());
		}
		return super.searchSQLByParamter(sql, sqlCount, page, pageSize, where.toString(), params.toArray(), orders, listTransportSupplyReader);
	}
	
	private IReader<TransportSupply> listTransportSupplyReader = new IReader<TransportSupply>(){

		@Override
		public TransportSupply readerByList(Object[] objs) {
			//t.id, t.userid, t.start, t.stop, t.quantity, t.validdate, u.realname, u.phone
			//t.startcityname,t.startprvname,t.stopcityname,t.stopprvname,t.startshortname,t.stopshortname,t.carnumber
			TransportSupply transportSupply = new TransportSupply();
			transportSupply.setId((Integer)objs[0]);
			transportSupply.setUserid((Integer)objs[1]);
			transportSupply.setStart((String)objs[2]);
			transportSupply.setStop((String)objs[3]);
			transportSupply.setQuantity((Integer)objs[4]);
			transportSupply.setValiddate((Timestamp)objs[5]);
			transportSupply.setUsername((String)objs[6]);
			transportSupply.setPhone((String)objs[7]);
			transportSupply.setStartcityname((String)objs[8]);
			transportSupply.setStartprvname((String)objs[9]);
			transportSupply.setStopcityname((String)objs[10]);
			transportSupply.setStopprvname((String)objs[11]);
			transportSupply.setStartshortname((String)objs[12]);
			transportSupply.setStopshortname((String)objs[13]);
			transportSupply.setCarnumber((String)objs[14]);
			transportSupply.setValidstatus((Integer)objs[15]);
			transportSupply.setSortnumber((Integer)objs[16]);
			return transportSupply;
		}};
}
