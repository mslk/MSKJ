package com.meibaolian.dao.dictionary.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.dictionary.ICoalParticleSizeDao;
import com.meibaolian.entity.CoalParticleSize;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class CoalParticleSizeDao extends BaseDao<CoalParticleSize> implements
		ICoalParticleSizeDao {


	static RowMapper<CoalParticleSize> coalParticleSizeRow=new RowMapper<CoalParticleSize>() {
		
		@Override
		public CoalParticleSize mapRow(ResultSet result, int arg1)
				throws SQLException {
			CoalParticleSize coalParticleSize=new CoalParticleSize();
			coalParticleSize.setId(result.getInt("id"));
			coalParticleSize.setName(result.getString("typename"));
			coalParticleSize.setType(result.getInt("type"));
			coalParticleSize.setTypeName(result.getString("coalname"));
			return coalParticleSize;
		}
	};
	
	@Override
	public List<CoalParticleSize> searchAll() throws DataManagerException {
		
		String tableName=TableRules.getCoalParticleSizeRule();
//		String sql=" select id,typename,type from  "+ tableName+" order by type asc  ,id asc ";
		String sql="select  a.id,a.typename,a.type,b.coalname from " + tableName + " as  a,coaltype as  b "
				+ " where  a.type=b.id order by  a.type asc " ;
		return searchList(sql, coalParticleSizeRow, tableName);
	}

}
