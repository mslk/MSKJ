package com.meibaolian.dao.other.imple;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.other.IAdvertisingDao;
import com.meibaolian.entity.AdvertisingEntity;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class AdvertisingDao extends BaseDao<AdvertisingEntity> implements IAdvertisingDao {

	
	
	 static RowMapper<AdvertisingEntity> advertisingRow=new RowMapper<AdvertisingEntity>() {

		@Override
		public AdvertisingEntity mapRow(ResultSet result, int arg1) throws SQLException {
			return new AdvertisingEntity(result.getString("imageurl"),result.getString("targeturl"));
		}
		
	};
	
	
	@Override
	public AdvertisingEntity getAdvertising(int type) throws DataManagerException 
	{
		String tableName=TableRules.getAdvertisingRule();
		String sql=" select imageurl,targeturl from "+ tableName +" where type=? limit 0,1 ";
		return super.getById(sql, new Object[]{type}, tableName, advertisingRow);
	}

	
}
