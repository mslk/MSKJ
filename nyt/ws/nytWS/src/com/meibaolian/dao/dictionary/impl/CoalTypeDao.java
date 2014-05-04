package com.meibaolian.dao.dictionary.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.dictionary.ICoalTypeDao;
import com.meibaolian.entity.CoalTypeEntity;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class CoalTypeDao extends BaseDao<CoalTypeEntity> implements ICoalTypeDao
{

	static RowMapper<CoalTypeEntity> coalTypeRow=new RowMapper<CoalTypeEntity>() {
		
		@Override
		public CoalTypeEntity mapRow(ResultSet result, int arg1) throws SQLException {
			CoalTypeEntity entity=new CoalTypeEntity();
			entity.setId(result.getInt("id"));
			entity.setCoalName(result.getString("coalname"));
			return entity;
		}
	};
	
	
	@Override
	public List<CoalTypeEntity> searchAll() throws DataManagerException {
		
		String tableName=TableRules.getCoalType();
		String sql="select id,coalname from "+tableName;
		return super.searchList(sql, coalTypeRow, tableName);
	}
	
	

}
