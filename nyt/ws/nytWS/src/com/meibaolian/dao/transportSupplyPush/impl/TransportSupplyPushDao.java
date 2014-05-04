package com.meibaolian.dao.transportSupplyPush.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.transportSupplyPush.ITransportSupplyPushDao;
import com.meibaolian.entity.TransportSupply;
import com.meibaolian.entity.TransportSupplyPush;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.tablehash.TableRules;

public class TransportSupplyPushDao extends BaseDao<TransportSupplyPush> implements ITransportSupplyPushDao{

	@Override
	public int addTransportSupplyPush(TransportSupply transportSupply,
			int status) {
		
		String tableName = TableRules.getTransportSupplyPushRule();
		
		StringBuilder sql = new StringBuilder("insert into ");
		StringBuilder val = new StringBuilder(" values(");
		List<Object> list = new ArrayList<Object>();
		
		sql.append(tableName).append(" (userid,addtime ");
		val.append("?,?");
		list.add(transportSupply.getUserid());
		list.add(new Date());
		
		if(UtilHelp.isNotNullStr(transportSupply.getUsername())){
			sql.append(",username");
			val.append(",?");
			list.add(transportSupply.getUsername());
		}
		if(UtilHelp.isNotNullStr(transportSupply.getPhone())){
			sql.append(",phone");
			val.append(",?");
			list.add(transportSupply.getPhone());
		}
		if(UtilHelp.isNotNullStr(transportSupply.getCarnumber())){
			sql.append(",carnumber");
			val.append(",?");
			list.add(transportSupply.getCarnumber());
		}
		if(null != transportSupply.getStartid()){
			sql.append(",startid");
			val.append(",?");
			list.add(transportSupply.getStartid());
		}
		if (UtilHelp.isNotNullStr(transportSupply.getStart())) {
			sql.append(",start");
			val.append(",?");
			list.add(transportSupply.getStart());
		}
		if(null != transportSupply.getStartcityid()){
			sql.append(",startcityid");
			val.append(",?");
			list.add(transportSupply.getStartcityid());
		}
		if (UtilHelp.isNotNullStr(transportSupply.getStartcityname())) {
			sql.append(",startcityname");
			val.append(",?");
			list.add(transportSupply.getStartcityname());
		}
		if(null != transportSupply.getStartprvid()){
			sql.append(",startprvid");
			val.append(",?");
			list.add(transportSupply.getStartprvid());
		}
		if (UtilHelp.isNotNullStr(transportSupply.getStartprvname())) {
			sql.append(",startprvname");
			val.append(",?");
			list.add(transportSupply.getStartprvname());
		}
		//
		if(null != transportSupply.getStopid()){
			sql.append(",stopid");
			val.append(",?");
			list.add(transportSupply.getStopid());
		}
		if (UtilHelp.isNotNullStr(transportSupply.getStop())) {
			sql.append(",stop");
			val.append(",?");
			list.add(transportSupply.getStop());
		}
		if(null != transportSupply.getStopcityid()){
			sql.append(",stopcityid");
			val.append(",?");
			list.add(transportSupply.getStopcityid());
		}
		if (UtilHelp.isNotNullStr(transportSupply.getStopcityname())) {
			sql.append(",stopcityname");
			val.append(",?");
			list.add(transportSupply.getStopcityname());
		}
		if(null != transportSupply.getStopprvid()){
			sql.append(",stopprvid");
			val.append(",?");
			list.add(transportSupply.getStopprvid());
		}
		if (UtilHelp.isNotNullStr(transportSupply.getStopprvname())) {
			sql.append(",stopprvname");
			val.append(",?");
			list.add(transportSupply.getStopprvname());
		}
		if(transportSupply.getPrice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",price");
			val.append(",?");
			list.add(transportSupply.getPrice());
		}
		if(transportSupply.getQuantity() > 0){
			sql.append(",quantity");
			val.append(",?");
			list.add(transportSupply.getQuantity());
		}
		if(UtilHelp.isNotNullStr(transportSupply.getValiddate())){
			sql.append(",validdate");
			val.append(",?");
			list.add(transportSupply.getValiddate());
		}
		
		sql.append(",status)");
		val.append(",?)");
		list.add(status);
		
		sql.append(val);
		
		return super.add(sql.toString(), list.toArray(), tableName);
	}

	@Override
	public int updateTransportSupplyPush(int userid, int status) {
		String tableName = TableRules.getTransportSupplyPushRule();
		StringBuilder sql = new StringBuilder("update ");
		sql.append(tableName).append(" set status=? where userid=?");
		return super.update(sql.toString(), new Object[]{status, userid}, tableName);
	}

}
