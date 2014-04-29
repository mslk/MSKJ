package com.meibaolian.dao.searchlog.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meibaolian.dao.base.impl.BaseDao;
import com.meibaolian.dao.searchlog.ISearchlogTransportDao;
import com.meibaolian.entity.SearchlogTransport;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.tablehash.TableRules;

public class SearchlogTransportDao extends BaseDao<SearchlogTransport> implements
		ISearchlogTransportDao {

	@Override
	public int addSearchLog(SearchlogTransport searchlog) {
		
		String tableName = TableRules.getSearchlogTransportRule();
		
		StringBuilder sql = new StringBuilder("insert into ");
		StringBuilder val = new StringBuilder(" values(");
		List<Object> list = new ArrayList<Object>();
		
		sql.append(tableName).append(" (addtime");
		val.append("?");
		list.add(new Date());

		if(0 <= searchlog.getUserid()){
			sql.append(",userid");
			val.append(",?");
			list.add(searchlog.getUserid());
		}
		int count = -1;
		if(UtilHelp.isNotNullStr(searchlog.getKeyword())){
			sql.append(", keyword");
			val.append(",?");
			list.add(searchlog.getKeyword());
			count++;
		}
		if(UtilHelp.isNotNullStr(searchlog.getStopprvname())){
			sql.append(", stopprvname");
			val.append(",?");
			list.add(searchlog.getStopprvname());
			count++;
		}
		sql.append(",searchtype)");
		val.append(",?)");
		sql.append(val);
		list.add(searchlog.getSearchtype());
		
		if(count > -1){
			count = super.add(sql.toString(), list.toArray(), tableName);
		}
		return count;
	}

}
