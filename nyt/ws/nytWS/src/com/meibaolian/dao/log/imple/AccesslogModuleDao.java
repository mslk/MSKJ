package com.meibaolian.dao.log.imple;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.log.IAccesslogModuleDao;
import com.meibaolian.entity.AccesslogModule;
import com.meibaolian.util.tablehash.TableRules;

public class AccesslogModuleDao extends BaseDao<AccesslogModule> implements IAccesslogModuleDao
{

	@Override
	public int add(AccesslogModule accesslogmodule) {
		
		String tableName=TableRules.getAccesslogModuleRule();
		String sql="insert into "+ tableName +"(userid,title,module,funcation,content,addtime)"
				+ " values(?,?,?,?,?,?)";
		return super.add(sql, new Object[]{accesslogmodule.getUserid(),accesslogmodule.getTitle(),
				accesslogmodule.getModule(),accesslogmodule.getFuncation(),
				accesslogmodule.getContent(),accesslogmodule.getAddtime()
				} , tableName);
	}
	
	

}
