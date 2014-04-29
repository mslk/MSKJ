package com.meibaolian.dao.nyt.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.nyt.ITypeListDao;
import com.meibaolian.entity.TypeListEntity;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.util.tablehash.TableRules;

public class TypeListDao extends BaseDao<TypeListEntity> implements ITypeListDao{


	
static RowMapper<TypeListEntity> typeListRow=new RowMapper<TypeListEntity>() {
		
		@Override
		public TypeListEntity mapRow(ResultSet result, int arg1) throws SQLException {
			TypeListEntity entity=new TypeListEntity();
			entity.setItemvalue(result.getString("itemvalue"));
			entity.setItem_type(result.getInt("item_type"));
			entity.setType(result.getInt("type"));
			return entity;
		}
	};

@Override
public List<TypeListEntity> searchAll() throws DataManagerException {
		String tableName=TableRules.getTypeList();
		String sql="select id,itemvalue,item_type,type,addtime from "+tableName +" order by item_type ";
		return super.searchList(sql, typeListRow, tableName);
	
}
	

}
