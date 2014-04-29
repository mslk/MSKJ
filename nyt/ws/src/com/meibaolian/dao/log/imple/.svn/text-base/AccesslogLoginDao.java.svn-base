package com.meibaolian.dao.log.imple;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.log.IAccesslogLoginDao;
import com.meibaolian.entity.AccesslogLogin;
import com.meibaolian.util.tablehash.TableRules;

public class AccesslogLoginDao extends BaseDao<AccesslogLogin> implements IAccesslogLoginDao 
{


	@Override
	public int add(AccesslogLogin accessloglogin) 
	{
		String tableName=TableRules.getAccesslogLoginRule();
		String sql=" insert into "+tableName+"(userid,phone,type,result,addtime) values(?,?,?,?,?)";
		return super.add(sql, new Object[]{accessloglogin.getUserid(),accessloglogin.getPhone(),
				accessloglogin.getType(),accessloglogin.getResult(),accessloglogin.getAddtime()}, tableName);
	}
	
	
	
	

}
