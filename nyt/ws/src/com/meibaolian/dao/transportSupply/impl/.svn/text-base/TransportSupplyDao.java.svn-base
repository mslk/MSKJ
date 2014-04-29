package com.meibaolian.dao.transportSupply.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.transportSupply.ITransportSupplyDao;
import com.meibaolian.entity.TransportSupply;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class TransportSupplyDao extends BaseDao<TransportSupply> implements
		ITransportSupplyDao {

	@Override
	public int addTransportSupply(TransportSupply transportSupply) {

		String tableName = TableRules.getTransportSupplyRule();

		StringBuilder sql = new StringBuilder("insert into ");
		StringBuilder val = new StringBuilder(" values(");
		List<Object> list = new ArrayList<Object>();

		sql.append(tableName).append(" (userid,addtime ");
		val.append("?,?");
		list.add(transportSupply.getUserid());
		list.add(new Date());

		if (UtilHelp.isNotNullStr(transportSupply.getUsername())) {
			sql.append(",username");
			val.append(",?");
			list.add(transportSupply.getUsername());
		}
		if (UtilHelp.isNotNullStr(transportSupply.getPhone())) {
			sql.append(",phone");
			val.append(",?");
			list.add(transportSupply.getPhone());
		}
		if (UtilHelp.isNotNullStr(transportSupply.getCarnumber())) {
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
		if (UtilHelp.isNotNullStr(transportSupply.getStartshortname())) {
			sql.append(",startshortname");
			val.append(",?");
			list.add(transportSupply.getStartshortname());
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
		if (UtilHelp.isNotNullStr(transportSupply.getStopshortname())) {
			sql.append(",stopshortname");
			val.append(",?");
			list.add(transportSupply.getStopshortname());
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
		
		if (transportSupply.getPrice().compareTo(UtilHelp.BIGDECIMAL_ZERO) > 0) {
			sql.append(",price");
			val.append(",?");
			list.add(transportSupply.getPrice());
		}
		if (transportSupply.getQuantity() > 0) {
			sql.append(",quantity");
			val.append(",?");
			list.add(transportSupply.getQuantity());
		}
		if (UtilHelp.isNotNullStr(transportSupply.getValiddate())) {
			sql.append(",validdate");
			val.append(",?");
			list.add(transportSupply.getValiddate());
		}

		sql.append(",sortnumber");
		val.append(",?");
		list.add(transportSupply.getSortnumber());

		sql.append(",status)");
		val.append(",?)");
		list.add(transportSupply.getStatus());

		sql.append(val);

		return super.addRTID(sql.toString(), list.toArray(), tableName);
	}

	@Override
	public QueryResult<TransportSupply> searchTransportSupply(
			Integer exclusiveId, String keyword, int page, int pageSize,
			LinkedHashMap<String, String> orders) throws DataManagerException {

		String tableName = TableRules.getTransportSupplyRule();
		String userTable = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(
				"select u.realname,u.phone as uphone,u.carnumber as ucarnumber,t.* from ");
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
		return super.search(sql.toString(), transportSupplyRowMapper,
				tableName, page, pageSize, params.toArray(), orders);
	}

	@Override
	public QueryResult<TransportSupply> searchTransportSupply(Integer userid,
			int page, int pageSize, LinkedHashMap<String, String> orders)
			throws DataManagerException {
		String tableName = TableRules.getTransportSupplyRule();
		String userTable = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(
				"select u.realname,u.phone as uphone,u.carnumber as ucarnumber,t.* from ");
		sql.append(tableName).append(" t,").append(userTable).append(" u ")
				.append(" where 1=1  and t.validstatus=0 and t.userid=u.id ");
		sql.append(" and t.userid=? ");
		return super.search(sql.toString(), transportSupplyRowMapper2,
				tableName, page, pageSize, new Object[] { userid }, orders);
	}

	@Override
	public TransportSupply getById(int id) throws DataManagerException {
		String tableName = TableRules.getTransportSupplyRule();
		String userTable = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder(
				"select u.realname,u.phone as uphone,u.carnumber as ucarnumber,t.* from ");
		sql.append(tableName).append(" t,").append(userTable).append(" u ")
				.append(" where 1=1  and t.validstatus=0 and t.userid=u.id ");
		sql.append(" and t.id=? ");
		return super.getById(sql.toString(), new Object[] { id }, tableName,
				transportSupplyRowMapper2);
	}

	@Override
	public int delTransportSupply(int id) {
		String tableName = TableRules.getTransportSupplyRule();
		StringBuilder sql = new StringBuilder("delete from ");
		sql.append(tableName).append(" where id=? ");
		return super.deleteById(sql.toString(), new Object[]{id}, tableName);
	}

	@Override
	public int updateTransportSupply(TransportSupply transportSupply) {
		
		String tableName = TableRules.getTransportSupplyRule();
		StringBuilder sql = new StringBuilder("update ");
		List<Object> params = new ArrayList<Object>(0);
		sql.append(tableName).append(" set quantity=?,validdate=?");
		params.add(transportSupply.getQuantity());
		params.add(transportSupply.getValiddate());
		if(transportSupply.getPrice().compareTo(UtilHelp.BIGDECIMAL_ZERO) >= 0){
			sql.append(",price=? ");
			params.add(transportSupply.getPrice());
		}
		sql.append(" where id=? ");
		params.add(transportSupply.getId());
		return super.update(sql.toString(), params.toArray(), tableName);
	}

	@Override
	public QueryResult<TransportSupply> searchTransportSupply(Integer startid,
			String start, Integer startcityid, String startcityname,
			Integer startprvid, String startprvname, Integer stopid,
			String stop, Integer stopcityid, String stopcityname,
			Integer stopprvid, String stopprvname, int page, int pageSize,
			LinkedHashMap<String, String> orders) throws DataManagerException {
		
		String tableName = TableRules.getTransportSupplyRule();
		String userTable = TableRules.getUserInfoRule();
		StringBuilder sql = new StringBuilder("select u.realname,u.phone as uphone,u.carnumber as ucarnumber,t.* from ");
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
		
		return super.search(sql.toString(), transportSupplyRowMapper,
				tableName, page, pageSize, params.toArray(), orders);
	}

	private static RowMapper<TransportSupply> transportSupplyRowMapper = new RowMapper<TransportSupply>() {

		@Override
		public TransportSupply mapRow(ResultSet arg0, int arg1)
				throws SQLException {
			TransportSupply transportSupply = new TransportSupply();
			transportSupply.setId(arg0.getInt("id"));
			transportSupply.setUserid(arg0.getInt("userid"));
//			 transportSupply.setUsername(arg0.getString("username"));
//			 transportSupply.setPhone(arg0.getString("phone"));
//			transportSupply.setCarnumber(arg0.getString("carnumber"));
			transportSupply.setUsername(arg0.getString("realname"));
			transportSupply.setPhone(arg0.getString("uphone"));
			transportSupply.setCarnumber(arg0.getString("ucarnumber"));
			transportSupply.setAddtime(arg0.getDate("addtime").toString());
			transportSupply.setStartid(arg0.getInt("startid"));
			transportSupply.setStart(arg0.getString("start"));
			transportSupply.setStartshortname(arg0.getString("startshortname"));
			transportSupply.setStartcityid(arg0.getInt("startcityid"));
			transportSupply.setStartcityname(arg0.getString("startcityname"));
			transportSupply.setStartprvid(arg0.getInt("startprvid"));
			transportSupply.setStartprvname(arg0.getString("startprvname"));
			transportSupply.setStopid(arg0.getInt("stopid"));
			transportSupply.setStop(arg0.getString("stop"));
			transportSupply.setStopshortname(arg0.getString("stopshortname"));
			transportSupply.setStopcityid(arg0.getInt("stopcityid"));
			transportSupply.setStopcityname(arg0.getString("stopcityname"));
			transportSupply.setStopprvid(arg0.getInt("stopprvid"));
			transportSupply.setStopprvname(arg0.getString("stopprvname"));
			transportSupply.setPrice(arg0.getBigDecimal("price"));
			transportSupply.setQuantity(arg0.getInt("quantity"));
			transportSupply.setValiddate(String.valueOf(UtilHelp.getDayOffset(new Date(), arg0.getDate("validdate"))));
			transportSupply.setSortnumber(arg0.getInt("sortnumber"));
			transportSupply.setStatus(arg0.getInt("status"));
			if (UtilHelp.isNullStr(transportSupply.getUsername())) {
				transportSupply.setUsername(transportSupply.getPhone());
			}
			return transportSupply;
		}
	};
	private static RowMapper<TransportSupply> transportSupplyRowMapper2 = new RowMapper<TransportSupply>() {

		@Override
		public TransportSupply mapRow(ResultSet arg0, int arg1)
				throws SQLException {
			TransportSupply transportSupply = new TransportSupply();
			transportSupply.setId(arg0.getInt("id"));
			transportSupply.setUserid(arg0.getInt("userid"));
//			 transportSupply.setUsername(arg0.getString("username"));
//			 transportSupply.setPhone(arg0.getString("phone"));
//			transportSupply.setCarnumber(arg0.getString("carnumber"));
			transportSupply.setUsername(arg0.getString("realname"));
			transportSupply.setPhone(arg0.getString("uphone"));
			transportSupply.setCarnumber(arg0.getString("ucarnumber"));
			transportSupply.setAddtime(arg0.getDate("addtime").toString());
			transportSupply.setStartid(arg0.getInt("startid"));
			transportSupply.setStart(arg0.getString("start"));
			transportSupply.setStartshortname(arg0.getString("startshortname"));
			transportSupply.setStartcityid(arg0.getInt("startcityid"));
			transportSupply.setStartcityname(arg0.getString("startcityname"));
			transportSupply.setStartprvid(arg0.getInt("startprvid"));
			transportSupply.setStartprvname(arg0.getString("startprvname"));
			transportSupply.setStopid(arg0.getInt("stopid"));
			transportSupply.setStop(arg0.getString("stop"));
			transportSupply.setStopshortname(arg0.getString("stopshortname"));
			transportSupply.setStopcityid(arg0.getInt("stopcityid"));
			transportSupply.setStopcityname(arg0.getString("stopcityname"));
			transportSupply.setStopprvid(arg0.getInt("stopprvid"));
			transportSupply.setStopprvname(arg0.getString("stopprvname"));
			transportSupply.setPrice(arg0.getBigDecimal("price"));
			transportSupply.setQuantity(arg0.getInt("quantity"));
			transportSupply.setValiddate(arg0.getDate("validdate").toString());
			transportSupply.setSortnumber(arg0.getInt("sortnumber"));
			transportSupply.setStatus(arg0.getInt("status"));
			if (UtilHelp.isNullStr(transportSupply.getUsername())) {
				transportSupply.setUsername(transportSupply.getPhone());
			}
			return transportSupply;
		}
	};
}
