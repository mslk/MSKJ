package com.meibaolian.dao.otheraid.imple;

import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.otheraid.IAdvertisingDao;
import com.meibaolian.entity.Advertising;

public class AdvertisingDao extends BaseDao<Advertising> implements IAdvertisingDao {

	@Override
	public void deleteSurplusAdvertising() 
	{
		String sql="  create table advertising_tmp as select t.id from advertising as t group by  type order by t.addtime  ";
		super.executeUpdateSql(sql, null);
		sql=" delete from advertising where id not in (select id from advertising_tmp) ";
		super.executeUpdateSql(sql, null);
		sql="  drop table advertising_tmp ";
		super.executeUpdateSql(sql, null);		
				
	}
	




	
}
