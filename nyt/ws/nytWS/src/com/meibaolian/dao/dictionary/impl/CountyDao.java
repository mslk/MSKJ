package com.meibaolian.dao.dictionary.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.dictionary.ICountyDao;
import com.meibaolian.entity.County;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class CountyDao extends BaseDao<County> implements ICountyDao {

	@Override
	public QueryResult<County> searchCounty(String keyword) throws DataManagerException {
		String tableName = TableRules.getCountyRule();
		StringBuilder sql = new StringBuilder("select * from ");
		sql.append(tableName);
		sql.append(" where name like ? or cityname like ? or provincename like ? group by provincename");
		keyword = UtilHelp.setSQLLikeStr(keyword);
		return super.search(sql.toString(), countyRowMapper, tableName, -1, -1, new Object[]{keyword, keyword, keyword});
	}
	
	private static RowMapper<County> countyRowMapper = new RowMapper<County>(){

		@Override
		public County mapRow(ResultSet arg0, int arg1) throws SQLException {
			County county = new County();
			county.setId(arg0.getInt("id"));
			county.setName(arg0.getString("name") );
			county.setCityid(arg0.getInt("cityid"));
			county.setCityname(arg0.getString("cityname"));
			county.setProvinceid(arg0.getInt("provinceid"));
			county.setProvincename(arg0.getString("provincename"));
			return county;
		}};
}
