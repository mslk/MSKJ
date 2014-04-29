package com.meibaolian.dao.dictionary.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.dictionary.IRailwayrateDao;
import com.meibaolian.entity.Railwayrate;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class RailwayrateDao extends BaseDao<Railwayrate> implements IRailwayrateDao{

	@Override
	public List<Railwayrate> getRailwayrateList(int city, String stop) throws DataManagerException {
		String tableName = TableRules.getRailwayrateRule();
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
		return super.searchList(sql.toString(), railwayrateRowMapper, tableName, list.toArray());
	}
	private static RowMapper<Railwayrate> railwayrateRowMapper = new RowMapper<Railwayrate>(){

		@Override
		public Railwayrate mapRow(ResultSet arg0, int arg1) throws SQLException {
			Railwayrate railwayrate = new Railwayrate();
			railwayrate.setId(arg0.getInt("id"));
			railwayrate.setStart(arg0.getString("start"));
			railwayrate.setStop(arg0.getString("stop"));
			railwayrate.setRate(arg0.getFloat("rate"));
			railwayrate.setDistance(arg0.getInt("distance"));
			railwayrate.setCity(arg0.getInt("city"));
			railwayrate.setType(ConfigUtil.TRANSPORTTYPE_RAILWAY);
			return railwayrate;
		}};
}
