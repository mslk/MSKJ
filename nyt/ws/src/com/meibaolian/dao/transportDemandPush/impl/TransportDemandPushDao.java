package com.meibaolian.dao.transportDemandPush.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.transportDemandPush.ITransportDemandPushDao;
import com.meibaolian.entity.TransportDemand;
import com.meibaolian.entity.TransportDemandPush;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.tablehash.TableRules;

public class TransportDemandPushDao extends BaseDao<TransportDemandPush> implements ITransportDemandPushDao{

	@Override
	public int addTransportDemandPush(TransportDemand transportDemand,
			int status) {
		
		String tableName = TableRules.getTransportDemandPushRule();
		
		StringBuilder sql = new StringBuilder("insert into ");
		StringBuilder val = new StringBuilder(" values(");
		List<Object> list = new ArrayList<Object>();
		
		sql.append(tableName).append(" (userid,addtime ");
		val.append("?,?");
		list.add(transportDemand.getUserid());
		list.add(new Date());
		
		if(UtilHelp.isNotNullStr(transportDemand.getUsername())){
			sql.append(",username");
			val.append(",?");
			list.add(transportDemand.getUsername());
		}
		if(UtilHelp.isNotNullStr(transportDemand.getPhone())){
			sql.append(",phone");
			val.append(",?");
			list.add(transportDemand.getPhone());
		}
		if(null != transportDemand.getStartid()){
			sql.append(",startid");
			val.append(",?");
			list.add(transportDemand.getStartid());
		}
		if (UtilHelp.isNotNullStr(transportDemand.getStart())) {
			sql.append(",start");
			val.append(",?");
			list.add(transportDemand.getStart());
		}
		if(null != transportDemand.getStartcityid()){
			sql.append(",startcityid");
			val.append(",?");
			list.add(transportDemand.getStartcityid());
		}
		if (UtilHelp.isNotNullStr(transportDemand.getStartcityname())) {
			sql.append(",startcityname");
			val.append(",?");
			list.add(transportDemand.getStartcityname());
		}
		if(null != transportDemand.getStartprvid()){
			sql.append(",startprvid");
			val.append(",?");
			list.add(transportDemand.getStartprvid());
		}
		if (UtilHelp.isNotNullStr(transportDemand.getStartprvname())) {
			sql.append(",startprvname");
			val.append(",?");
			list.add(transportDemand.getStartprvname());
		}
		//
		if(null != transportDemand.getStopid()){
			sql.append(",stopid");
			val.append(",?");
			list.add(transportDemand.getStopid());
		}
		if (UtilHelp.isNotNullStr(transportDemand.getStop())) {
			sql.append(",stop");
			val.append(",?");
			list.add(transportDemand.getStop());
		}
		if(null != transportDemand.getStopcityid()){
			sql.append(",stopcityid");
			val.append(",?");
			list.add(transportDemand.getStopcityid());
		}
		if (UtilHelp.isNotNullStr(transportDemand.getStopcityname())) {
			sql.append(",stopcityname");
			val.append(",?");
			list.add(transportDemand.getStopcityname());
		}
		if(null != transportDemand.getStopprvid()){
			sql.append(",stopprvid");
			val.append(",?");
			list.add(transportDemand.getStopprvid());
		}
		if (UtilHelp.isNotNullStr(transportDemand.getStopprvname())) {
			sql.append(",stopprvname");
			val.append(",?");
			list.add(transportDemand.getStopprvname());
		}
		if(transportDemand.getPrice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0){
			sql.append(",price");
			val.append(",?");
			list.add(transportDemand.getPrice());
		}
		if(transportDemand.getQuantity() > 0){
			sql.append(",quantity");
			val.append(",?");
			list.add(transportDemand.getQuantity());
		}
		if(UtilHelp.isNotNullStr(transportDemand.getValiddate())){
			sql.append(",validdate");
			val.append(",?");
			list.add(transportDemand.getValiddate());
		}
		
		sql.append(",status)");
		val.append(",?)");
		list.add(status);
		
		sql.append(val);
		
		return super.add(sql.toString(), list.toArray(), tableName);
	}

	@Override
	public int updateTransportDemandPush(int userid, int status) {
		String tableName = TableRules.getTransportDemandPushRule();
		StringBuilder sql = new StringBuilder("update ");
		sql.append(tableName).append(" set status=? where userid=?");
		return super.update(sql.toString(), new Object[]{status, userid}, tableName);
	}

}
