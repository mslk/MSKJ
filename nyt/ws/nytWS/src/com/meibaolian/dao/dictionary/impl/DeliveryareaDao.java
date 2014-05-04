package com.meibaolian.dao.dictionary.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.dictionary.IDeliveryareaDao;
import com.meibaolian.entity.DeliveryareaEntity;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class DeliveryareaDao extends BaseDao<DeliveryareaEntity> implements
		IDeliveryareaDao {

	public static RowMapper<DeliveryareaEntity> provinceCityCountyRow=new RowMapper<DeliveryareaEntity>() {
		
		@Override
		public DeliveryareaEntity mapRow(ResultSet result, int arg1)
				throws SQLException {
			
			DeliveryareaEntity entity=new DeliveryareaEntity();
			entity.setCountyid(result.getString("countyid"));
			entity.setCountyname(result.getString("countyname"));
			entity.setShortcountyname(result.getString("shortcountyname"));
			entity.setCityid(result.getString("cityid"));
			entity.setCityname(result.getString("cityname"));
			entity.setProvinceid(result.getString("provinceid"));
			entity.setProvincename(result.getString("provincename"));
			return entity;
			
		}
	};
	
	@Override
	public List<DeliveryareaEntity> searchAll() throws DataManagerException {
		String tableName=TableRules.getProvincesCityCountyRule();
		String sql=" select countyid,countyname,shortcountyname,cityid,cityname,provinceid,provincename from "+tableName 
				   +"  group by provinceid asc ,cityid asc ,countyid asc ";
		return super.searchList(sql, provinceCityCountyRow, tableName);
	}

}
