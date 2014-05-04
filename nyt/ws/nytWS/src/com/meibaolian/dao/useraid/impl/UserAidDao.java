package com.meibaolian.dao.useraid.impl;


import java.util.Date;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.useraid.IUserAidDao;
import com.meibaolian.entity.UserAid;
import com.meibaolian.util.tablehash.TableRules;

public class UserAidDao extends BaseDao<UserAid> implements IUserAidDao {

	@Override
	public int addCallPhoneLog(String uuid, String phone, int num) 
	{
		String tableName=TableRules.getCallPhoneLog();
		StringBuilder sql=new StringBuilder();
		sql.append(" insert into ").append(tableName);
		sql.append(" ( uuid,phone,number,addtime ) values(?,?,?,?) ");
		return super.add(sql.toString(), new Object[]{uuid,phone,num,new Date()}, tableName);
	}


	

}
