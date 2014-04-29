package com.meibaolian.dao.transportDemand.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.transportDemand.ITransportDemandDao;
import com.meibaolian.entity.TransportDemand;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class TransportDemandDao extends BaseDao<TransportDemand> implements
		ITransportDemandDao {

	@Override
	public int addTransportDemand(TransportDemand transportDemand) {

		String tableName = TableRules.getTransportDemandRule();

		StringBuilder sql = new StringBuilder("insert into ");
		StringBuilder val = new StringBuilder(" values(");
		List<Object> list = new ArrayList<Object>();

		sql.append(tableName).append(" (userid,addtime ");
		val.append("?,?");
		list.add(transportDemand.getUserid());
		list.add(new Date());

		if (UtilHelp.isNotNullStr(transportDemand.getUsername())) {
			sql.append(",username");
			val.append(",?");
			list.add(transportDemand.getUsername());
		}
		if (UtilHelp.isNotNullStr(transportDemand.getPhone())) {
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
		if (UtilHelp.isNotNullStr(transportDemand.getStartshortname())) {
			sql.append(",startshortname");
			val.append(",?");
			list.add(transportDemand.getStartshortname());
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
		if (UtilHelp.isNotNullStr(transportDemand.getStopshortname())) {
			sql.append(",stopshortname");
			val.append(",?");
			list.add(transportDemand.getStopshortname());
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
		if (transportDemand.getPrice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0) {
			sql.append(",price");
			val.append(",?");
			list.add(transportDemand.getPrice());
		}
		if (transportDemand.getQuantity() > 0) {
			sql.append(",quantity");
			val.append(",?");
			list.add(transportDemand.getQuantity());
		}
		if (UtilHelp.isNotNullStr(transportDemand.getSendoutdate())) {
			sql.append(",sendoutdate");
			val.append(",?");
			list.add(transportDemand.getSendoutdate());
		}
		if (UtilHelp.isNotNullStr(transportDemand.getValiddate())) {
			sql.append(",validdate");
			val.append(",?");
			list.add(transportDemand.getValiddate());
		}

		sql.append(",sortnumber");
		val.append(",?");
		list.add(transportDemand.getSortnumber());

		sql.append(",status)");
		val.append(",?)");
		list.add(transportDemand.getStatus());

		sql.append(val);

		return super.addRTID(sql.toString(), list.toArray(), tableName);
	}

	@Override
	public QueryResult<TransportDemand> searchTransportDemand(
			Integer exclusiveId, String keyword, int page, int pageSize,
			LinkedHashMap<String, String> orders) throws DataManagerException {

		String tableName = TableRules.getTransportDemandRule();
		String userTable = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(
				"select u.realname,u.phone as uphone,t.* from ");
		sql.append(tableName).append(" t,").append(userTable).append(" u ");
		sql.append(" where 1=1  and t.validstatus=0 and t.userid=u.id ");
		List<Object> params = new ArrayList<Object>(0);
		sql.append(" and t.validdate>=? ");
		params.add(UtilHelp.dateFormatStr(new Date(), "yyyy-MM-dd"));
		// 目的地
		if (UtilHelp.isNotNullStr(keyword)) {
			keyword = UtilHelp.setSQLLikeStr(keyword);
			sql.append(" and ( t.stop like ? ");  
			sql.append(" or t.stopcityname like ? ");
			sql.append(" or t.stopprvname like ? )");
			params.add(keyword);
			params.add(keyword);
			params.add(keyword);
		}
		if (exclusiveId != null && exclusiveId > 0) {
			sql.append(" and t.id <>? ");
			params.add(exclusiveId);
		}
		return super.search(sql.toString(), transportDemandRowMapper,
				tableName, page, pageSize, params.toArray(), orders);
	}

	@Override
	public QueryResult<TransportDemand> searchTransportDemand(Integer userid,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException {
		String tableName = TableRules.getTransportDemandRule();
		String userTable = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(
				"select u.realname,u.phone as uphone,t.* from ");
		sql.append(tableName).append(" t,").append(userTable).append(" u ")
				.append(" where 1=1  and t.validstatus=0 and t.userid=u.id ");
		sql.append(" and t.userid=?");
		return super.search(sql.toString(), transportDemandRowMapper2,
				tableName, page, pageSize, new Object[] { userid }, orders);
	}

	@Override
	public TransportDemand getById(int id) throws DataManagerException {
		String tableName = TableRules.getTransportDemandRule();
		String userTable = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(
				"select u.realname,u.phone as uphone,t.* from ");
		sql.append(tableName).append(" t,").append(userTable).append(" u ")
				.append(" where 1=1  and t.validstatus=0 and t.userid=u.id ");
		sql.append(" and t.id=?");
		return super.getById(sql.toString(), new Object[] { id }, tableName,
				transportDemandRowMapper2);
	}

	@Override
	public int delTransportDemand(int id) {
		String tableName = TableRules.getTransportDemandRule();
		StringBuilder sql = new StringBuilder("delete from ");
		sql.append(tableName).append(" where id=?");
		return super.deleteById(sql.toString(), new Object[]{id}, tableName);
	}

	@Override
	public int updateTransportDemand(TransportDemand transportDemand) {
		String tableName = TableRules.getTransportDemandRule();
		StringBuilder sql = new StringBuilder("update ");
		sql.append(tableName).append(" set price=?,quantity=?,sendoutdate=?,validdate=? where id=?");
		return super.update(sql.toString(), new Object[] {
				transportDemand.getPrice(), transportDemand.getQuantity(),
				transportDemand.getSendoutdate(),
				transportDemand.getValiddate(), transportDemand.getId() },
				tableName);
	}

	@Override
	public QueryResult<TransportDemand> searchTransportDemand(Integer startid,
			String start, Integer startcityid, String startcityname,
			Integer startprvid, String startprvname, Integer stopid,
			String stop, Integer stopcityid, String stopcityname,
			Integer stopprvid, String stopprvname, int page, int pageSize,
			LinkedHashMap<String, String> orders) throws DataManagerException {
		
		String tableName = TableRules.getTransportDemandRule();
		String userTable = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder("select u.realname,u.phone as uphone,t.* from ");
		sql.append(tableName).append(" t,").append(userTable).append(" u ");
		sql.append(" where 1=1  and t.validstatus=0 and t.userid=u.id ");
		List<Object> params = new ArrayList<Object>(0);
		sql.append(" and t.validdate>=? ");
		params.add(UtilHelp.dateFormatStr(new Date(), "yyyy-MM-dd"));
		
		if(UtilHelp.isNotNullStr(start)){
			sql.append(" and t.start like ? ");
			params.add(UtilHelp.setSQLLikeStr(start));
		}
		if(UtilHelp.isNotNullStr(startcityname)){
			sql.append(" and t.startcityname like ? ");
			params.add(UtilHelp.setSQLLikeStr(startcityname));
		}
		if(UtilHelp.isNotNullStr(startprvname)){
			sql.append(" and t.startprvname like ? ");
			params.add(UtilHelp.setSQLLikeStr(startprvname));
		}
		if(UtilHelp.isNotNullStr(stop)){
			sql.append(" and t.stop like ? ");
			params.add(UtilHelp.setSQLLikeStr(stop));
		}
		if(UtilHelp.isNotNullStr(stopcityname)){
			sql.append(" and t.stopcityname like ? ");
			params.add(UtilHelp.setSQLLikeStr(stopcityname));
		}
		if(UtilHelp.isNotNullStr(stopprvname)){
			sql.append(" and t.stopprvname like ? ");
			params.add(UtilHelp.setSQLLikeStr(stopprvname));
		}
		return super.search(sql.toString(), transportDemandRowMapper,
				tableName, page, pageSize, params.toArray(), orders);
	}

	private static RowMapper<TransportDemand> transportDemandRowMapper = new RowMapper<TransportDemand>() {

		@Override
		public TransportDemand mapRow(ResultSet arg0, int arg1)
				throws SQLException {
			TransportDemand transportDemand = new TransportDemand();
			transportDemand.setId(arg0.getInt("id"));
			transportDemand.setUserid(arg0.getInt("userid"));
			// transportDemand.setUsername(arg0.getString("username"));
			// transportDemand.setPhone(arg0.getString("phone"));
			transportDemand.setUsername(arg0.getString("realname"));
			transportDemand.setPhone(arg0.getString("uphone"));
			transportDemand.setAddtime(arg0.getDate("addtime").toString());
			transportDemand.setStartid(arg0.getInt("startid"));
			transportDemand.setStart(arg0.getString("start"));
			transportDemand.setStartshortname(arg0.getString("startshortname"));
			transportDemand.setStartcityid(arg0.getInt("startcityid"));
			transportDemand.setStartcityname(arg0.getString("startcityname"));
			transportDemand.setStartprvid(arg0.getInt("startprvid"));
			transportDemand.setStartprvname(arg0.getString("startprvname"));
			transportDemand.setStopid(arg0.getInt("stopid"));
			transportDemand.setStop(arg0.getString("stop"));
			transportDemand.setStopshortname(arg0.getString("stopshortname"));
			transportDemand.setStopcityid(arg0.getInt("stopcityid"));
			transportDemand.setStopcityname(arg0.getString("stopcityname"));
			transportDemand.setStopprvid(arg0.getInt("stopprvid"));
			transportDemand.setStopprvname(arg0.getString("stopprvname"));
			transportDemand.setPrice(arg0.getBigDecimal("price"));
			transportDemand.setQuantity(arg0.getInt("quantity"));
			transportDemand.setSendoutdate(arg0.getDate("sendoutdate").toString());
			transportDemand.setValiddate(String.valueOf(UtilHelp.getDayOffset(new Date(), arg0.getDate("validdate"))));
			transportDemand.setSortnumber(arg0.getInt("sortnumber"));
			transportDemand.setStatus(arg0.getInt("status"));
			if (UtilHelp.isNullStr(transportDemand.getUsername())) {
				transportDemand.setUsername(transportDemand.getPhone());
			}
			return transportDemand;
		}
	};
	
	private static RowMapper<TransportDemand> transportDemandRowMapper2 = new RowMapper<TransportDemand>() {

		@Override
		public TransportDemand mapRow(ResultSet arg0, int arg1)
				throws SQLException {
			TransportDemand transportDemand = new TransportDemand();
			transportDemand.setId(arg0.getInt("id"));
			transportDemand.setUserid(arg0.getInt("userid"));
			// transportDemand.setUsername(arg0.getString("username"));
			// transportDemand.setPhone(arg0.getString("phone"));
			transportDemand.setUsername(arg0.getString("realname"));
			transportDemand.setPhone(arg0.getString("uphone"));
			transportDemand.setAddtime(arg0.getDate("addtime").toString());
			transportDemand.setStartid(arg0.getInt("startid"));
			transportDemand.setStart(arg0.getString("start"));
			transportDemand.setStartshortname(arg0.getString("startshortname"));
			transportDemand.setStartcityid(arg0.getInt("startcityid"));
			transportDemand.setStartcityname(arg0.getString("startcityname"));
			transportDemand.setStartprvid(arg0.getInt("startprvid"));
			transportDemand.setStartprvname(arg0.getString("startprvname"));
			transportDemand.setStopid(arg0.getInt("stopid"));
			transportDemand.setStop(arg0.getString("stop"));
			transportDemand.setStopshortname(arg0.getString("stopshortname"));
			transportDemand.setStopcityid(arg0.getInt("stopcityid"));
			transportDemand.setStopcityname(arg0.getString("stopcityname"));
			transportDemand.setStopprvid(arg0.getInt("stopprvid"));
			transportDemand.setStopprvname(arg0.getString("stopprvname"));
			transportDemand.setPrice(arg0.getBigDecimal("price"));
			transportDemand.setQuantity(arg0.getInt("quantity"));
			transportDemand.setSendoutdate(arg0.getDate("sendoutdate").toString());
			transportDemand.setValiddate(arg0.getDate("validdate").toString());
			transportDemand.setSortnumber(arg0.getInt("sortnumber"));
			transportDemand.setStatus(arg0.getInt("status"));
			if (UtilHelp.isNullStr(transportDemand.getUsername())) {
				transportDemand.setUsername(transportDemand.getPhone());
			}
			return transportDemand;
		}
	};

}
