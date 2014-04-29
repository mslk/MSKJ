package com.meibaolian.dao.provider.imple;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.meibaolian.dao.base.IReader;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.provider.IProviderInfoDao;
import com.meibaolian.dto.ProviderDto;
import com.meibaolian.entity.ProviderInfo;
import com.meibaolian.util.UtilHelp;

public class ProviderInfoDao extends BaseDao<ProviderInfo> implements IProviderInfoDao {

	@Override
	public QueryResult<ProviderInfo> searchList(ProviderDto providerDto, int page,
			int pageSize, LinkedHashMap<String, String> orders) {
		
		String sql = "select p.proid,p.userid,p.coaltype,p.price,p.validdate,p.sortnumber,p.coalname,p.quantity,u.companyname,u.realname,u.phone from provider p,userinfo u ";
		String sqlCount = "select count(1) from provider p,userinfo u ";
		StringBuilder where = new StringBuilder(" and p.userid=u.id ");
		List<Object> params = new ArrayList<Object>(); 
		
		if(null != providerDto.getCoaltype() && providerDto.getCoaltype() > 0){
			where.append(" and p.coaltype=? ");
			params.add(providerDto.getCoaltype());
		}
		if(UtilHelp.isNotNullStr(providerDto.getKeyword())){
			where.append(" and ( u.realname like ? or u.phone like ?)");
			String keyword =  UtilHelp.setSQLLikeStr(providerDto.getKeyword());
			params.add(keyword);
			params.add(keyword);
		}
		if(null != providerDto.getBegindate()){
			where.append(" and p.validdate > ? ");
			params.add(providerDto.getBegindate());
		}
		if(null != providerDto.getEnddate()){
			where.append(" and p.validdate < ? ");
			params.add(providerDto.getEnddate());
		}
		
		return super.searchSQLByParamter(sql, sqlCount, page, pageSize, where.toString(), params.toArray(), orders, listProviderInfoReader);
	}
	
	private IReader<ProviderInfo> listProviderInfoReader = new IReader<ProviderInfo>(){

		@Override
		public ProviderInfo readerByList(Object[] objs) {
			//p.proid,p.userid,p.coaltype,p.price,p.validdate,p.sortnumber,p.coalname,p.quantity,u.companyname,u.realname,u.phone
			ProviderInfo providerInfo = new ProviderInfo();
			providerInfo.setProid((Integer)objs[0]);
			providerInfo.setUserid((Integer)objs[1]);
			providerInfo.setCoaltype((Integer)objs[2]);
			providerInfo.setPrice(objs[3].toString());
			providerInfo.setValiddate((Timestamp)objs[4]);
			providerInfo.setSortnumber((Integer)objs[5]);
			providerInfo.setCoalname((String)objs[6]);
			providerInfo.setQuantity((Integer)objs[7]);
			providerInfo.setCompany((String)objs[8]);
			providerInfo.setBuyername((String)objs[9]);
			providerInfo.setPhone((String)objs[10]);
			return providerInfo;
		}};


}
