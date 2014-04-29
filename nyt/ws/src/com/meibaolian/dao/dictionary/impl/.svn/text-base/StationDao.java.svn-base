package com.meibaolian.dao.dictionary.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.dictionary.IStationDao;
import com.meibaolian.entity.StationEntity;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class StationDao extends BaseDao<StationEntity> implements IStationDao {

	
	static RowMapper<StationEntity> stationRow=new RowMapper<StationEntity>() {
		
		@Override
		public StationEntity mapRow(ResultSet result, int arg1) throws SQLException {
			StationEntity entity=new StationEntity();
			entity.setId(result.getInt("id"));
			entity.setStationName(result.getString("name"));
			entity.setCityId(result.getInt("cityid"));
			entity.setShortName(result.getString("shortname"));
			entity.setType(1);
			return entity;
		}
	};
	
	@Override
	public List<StationEntity> searchByCity(int city) throws DataManagerException 
	{
		//查询的是区县表， 没有查询站台表，因为没有启用 铁路
		String tableName=TableRules.getCountyRule();
		String sql=" select id,name,cityid,shortname from "+tableName+" where cityid="+city;
		
		return super.searchList(sql, stationRow, tableName);
	}

}
