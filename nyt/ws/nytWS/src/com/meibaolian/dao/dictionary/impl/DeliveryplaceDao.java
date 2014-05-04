package com.meibaolian.dao.dictionary.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.dictionary.IDeliveryplaceDao;
import com.meibaolian.entity.DeliveryplaceEntity;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class DeliveryplaceDao extends BaseDao<DeliveryplaceEntity> implements IDeliveryplaceDao {

	
	static RowMapper<DeliveryplaceEntity> deliveryplaceRow=new RowMapper<DeliveryplaceEntity>() {
		@Override
		public DeliveryplaceEntity mapRow(ResultSet result, int arg1)
				throws SQLException {
			DeliveryplaceEntity entity=new DeliveryplaceEntity();
			entity.setStationid(result.getInt("id"));
			entity.setName(result.getString("name"));
			entity.setShortname(result.getString("shortname"));
			entity.setCountyid(result.getInt("countyid"));
			entity.setType(result.getInt("type"));
			entity.setTypeName(result.getString("typename"));
			entity.setAsh(result.getString("ash"));
			entity.setHeating(result.getString("heating"));
			entity.setMoisture(result.getString("moisture"));
			entity.setSulphur(result.getString("sulphur"));
			return entity;
		}
	};
	
	@Override
	public List<DeliveryplaceEntity> searchByCountId(int countid) throws DataManagerException {
		
		String tableName=TableRules.getDeliverplaceRule();
//		String sql="select id,name,shortname,countyid,type,heating,sulphur,ash,moisture from "
//				   +tableName+ " where countyid=?  order by type asc ";
		String sql=" select a.id,a.name,a.shortname,a.countyid,a.type,b.typename,a.heating,a.sulphur,a.ash,a.moisture from "+tableName+" as a,"
				   +" deliveryplacetype as b where  a.type=b.type and countyid=?  order by type " ;
		return super.searchList(sql, deliveryplaceRow, tableName, new Object[]{countid});
	}

}
