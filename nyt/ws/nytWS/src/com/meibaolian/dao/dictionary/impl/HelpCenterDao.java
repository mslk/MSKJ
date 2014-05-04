package com.meibaolian.dao.dictionary.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.dictionary.IHelpCenterDao;
import com.meibaolian.entity.HelpCenterEntity;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class HelpCenterDao extends BaseDao<HelpCenterEntity> implements IHelpCenterDao {

	
	static RowMapper<HelpCenterEntity> helpCenterRow=new RowMapper<HelpCenterEntity>() {
		
		@Override
		public HelpCenterEntity mapRow(ResultSet result, int arg1)
				throws SQLException {
			HelpCenterEntity entity=new HelpCenterEntity();
			entity.setTitle(result.getString("title"));
			entity.setTargUrl(result.getString("targeturl"));
			return entity;
		}
	};
	
	@Override
	public List<HelpCenterEntity> searchByType(int type) throws DataManagerException
	{
		String tableName=TableRules.getHelpCenterRule();
	   //sortnumber 排序先不做，先按id 排序
		String sql=" select  title,targeturl  from "+ tableName +" where type=? order by id desc ";
		return super.searchList(sql, helpCenterRow, tableName, new Object[]{type});
	}

	
}
