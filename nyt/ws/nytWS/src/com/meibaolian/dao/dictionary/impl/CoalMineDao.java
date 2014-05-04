package com.meibaolian.dao.dictionary.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.dictionary.ICoalMineDao;
import com.meibaolian.entity.CoalMine;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class CoalMineDao extends BaseDao<CoalMine> implements ICoalMineDao{

	@Override
	public List<CoalMine> getCoalMineList()
			throws DataManagerException {
		String tableName = TableRules.getDeliveryplaceRule();
		StringBuilder sql = new StringBuilder("select * from ").append(tableName);
		return super.searchList(sql.toString(), CoalMineRowMapper, tableName);
	}
	
	private static RowMapper<CoalMine> CoalMineRowMapper = new RowMapper<CoalMine>(){

		@Override
		public CoalMine mapRow(ResultSet arg0, int arg1)
				throws SQLException {
			
			//CoalMine : id,name,address,countyid,cityid,county,type,heating,sulphur,ash,moisture
			CoalMine coalMine = new CoalMine();
			coalMine.setId(arg0.getInt("id"));
			coalMine.setName(arg0.getString("name"));
			coalMine.setAddress(arg0.getString("address"));
			coalMine.setCountyid(arg0.getInt("countyid"));
			coalMine.setCityid(arg0.getInt("cityid"));
//			coalMine.setCounty(countyMap.get(coalMine.getCountyid()));
			coalMine.setCounty(arg0.getString("countyname"));
			coalMine.setType(arg0.getInt("type"));
			coalMine.setHeating(arg0.getInt("heating"));
			
			String sulphur = arg0.getString("sulphur");
			if(UtilHelp.isNotNullStr(sulphur)){
				coalMine.setSulphur(UtilHelp.strToBigDecimal(sulphur, 1).toString());
			}
			coalMine.setAsh(arg0.getInt("ash")+"");
			coalMine.setMoisture(arg0.getInt("moisture")+"");
			return coalMine;
		}};
		
	private static Map<Integer,String> countyMap = new HashMap<Integer,String>();
	static{
		countyMap.put(1, "榆阳区");
		countyMap.put(2, "神木县");
		countyMap.put(3, "府谷县");
		countyMap.put(4, "横山县");
	}
}
