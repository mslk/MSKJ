package com.meibaolian.dao.dictionary.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.dictionary.IHighwayrateDao;
import com.meibaolian.entity.HighwayrateEntity;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class HighwayrateDao extends BaseDao<HighwayrateEntity> implements IHighwayrateDao{

	@Override
	public List<HighwayrateEntity> getHighwayrateList(int city, String stop) throws DataManagerException {
		String tableName = TableRules.getHighwayrateRule();
		StringBuilder sql = new StringBuilder("select * from ").append(tableName);
		sql.append(" where 1=1 ");
		List<Object> list = new ArrayList<Object>();
		if(city > 0){
			sql.append(" and city=?");
			list.add(city);
		}
		if(UtilHelp.isNotNullStr(stop)){
			sql.append(" and stop=?");
			list.add(stop);
		}
		sql.append(" order by rate asc LIMIT 1 ");
		return super.searchList(sql.toString(), highwayrateRowMapper, tableName, list.toArray());
	}
	private static RowMapper<HighwayrateEntity> highwayrateRowMapper = new RowMapper<HighwayrateEntity>(){

		@Override
		public HighwayrateEntity mapRow(ResultSet arg0, int arg1) throws SQLException {
			HighwayrateEntity highwayrateEntity = new HighwayrateEntity();
			highwayrateEntity.setId(arg0.getInt("id"));
			highwayrateEntity.setStart(arg0.getString("start"));
			highwayrateEntity.setStop(arg0.getString("stop"));
			highwayrateEntity.setRate(arg0.getFloat("rate"));
			highwayrateEntity.setDistance(arg0.getFloat("distance"));
			highwayrateEntity.setCity(arg0.getInt("city"));
			highwayrateEntity.setType(ConfigUtil.TRANSPORTTYPE_HIGNWAY);
			return highwayrateEntity;
		}};
}
