package com.meibaolian.dao.dictionary.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.dictionary.IProvinceDao;
import com.meibaolian.entity.ProvinceEntity;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class ProvinceDao extends BaseDao<ProvinceEntity> implements IProvinceDao {

	
	static RowMapper<ProvinceEntity> provinceRow=new RowMapper<ProvinceEntity>() {
		
		@Override
		public ProvinceEntity mapRow(ResultSet result, int arg1) throws SQLException {
			ProvinceEntity provinceEntity=new ProvinceEntity();
			provinceEntity.setCityId(result.getInt("id"));
			provinceEntity.setCityName(result.getString("cityname"));
			provinceEntity.setProvinceId(result.getInt("provinceid"));
			provinceEntity.setProvinceName(result.getString("provincename"));
			return provinceEntity;
		}
	};

	@Override
	public List<ProvinceEntity> searchAllProvinceAndCity() throws DataManagerException 
	{
		
		String tableName=TableRules.getProvinceRule();
		
		String sql="select c.id,c.name as cityname,p.name as provincename ,c.provinceid from city c,province p" +
				" where c.provinceid=p.id";
		
		return super.searchList(sql, provinceRow, tableName);
	}

}
