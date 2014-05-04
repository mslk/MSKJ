package com.meibaolian.dao.dictionary.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.dictionary.IBeginStationDao;
import com.meibaolian.entity.BeginStationEntity;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class BeginStationDao extends BaseDao<BeginStationEntity> implements IBeginStationDao {

	@Override
	public List<BeginStationEntity> searchAll() throws DataManagerException 
	{
		String tableName=TableRules.getBeginStation();
		String sql=" select id,stationname,type from  " + tableName;
		
		return super.searchList(sql, beginStaRow, tableName);
	}
	
	public static RowMapper<BeginStationEntity> beginStaRow=new RowMapper<BeginStationEntity>() {
		
		@Override
		public BeginStationEntity mapRow(ResultSet result, int arg1)
				throws SQLException {
			BeginStationEntity entity =new BeginStationEntity();
			entity.setId(result.getInt("id"));
			entity.setStationName(result.getString("stationname"));
			entity.setType(result.getInt("type"));
			return entity;
		}
	};

}
