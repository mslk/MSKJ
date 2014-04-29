package com.meibaolian.dao.otheraid.imple;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.otheraid.IHelpCenterDao;
import com.meibaolian.entity.HelpCenter;

public class HelpCenterDao extends BaseDao<HelpCenter> implements IHelpCenterDao {

	

	@Override
	public  QueryResult<HelpCenter> searchByType(int page,int pageSize,int type) {
		String where=" ";
		Object [] objs=null;
		if(type!=-1)
		{
			where=" and type=? ";
			objs=new Object[1];
			objs[0]=type;
		}
		LinkedHashMap<String, String> orders=new LinkedHashMap<String, String>();
		orders.put(" id ", " desc ");
		return super.search(page, pageSize, where, objs,orders);
	}

}
