package com.meibaolian.dao.provider.imple;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import com.meibaolian.dao.base.IReader;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.provider.IProviderDao;
import com.meibaolian.dto.ProviderDto;
import com.meibaolian.entity.Provider;
import com.meibaolian.entity.ProviderInfo;
import com.meibaolian.util.UtilHelp;

public class ProviderDao extends BaseDao<Provider> implements IProviderDao {
	
	@Override
	public QueryResult<Provider> searchList(ProviderDto providerDto, int page,
			int pageSize, LinkedHashMap<String, String> orders) {
		/**
		 * proid,userid,addtime,coaltype,coalname,buyername,heating,coalsize,coalsizename,
		 * sulphur,ash,moisture,price,taxprice,transportype,sendoutplace,place,validdate,
		 * quantity,sortnumber,status,phone,company,placeid,startcountyid,startcountyname,
		 * startcityid,startcityname,startprvid,startprvname,startshortname
		 */
		String sql = "select p.proid,p.userid,p.coaltype,p.price,p.validdate,p.sortnumber,p.coalname,p.quantity,u.companyname,u.realname,u.phone,p.taxprice,p.coalsizename,p.heating,p.sulphur,p.ash,p.moisture,p.validstatus  from provider p,userinfo u ";
		String sqlCount = "select count(1) from provider p,userinfo u ";
		StringBuilder where = new StringBuilder(" and p.userid=u.id ");
		List<Object> params = new ArrayList<Object>(); 
		
		/*if(null != providerDto.getCoaltype() && providerDto.getCoaltype() > 0){
			where.append(" and p.coaltype=? ");
			params.add(providerDto.getCoaltype());
		}*/
		if(UtilHelp.isNotNullStr(providerDto.getCoalname())){
			where.append(" and ( p.coalname like ?)");
			String keyword =  UtilHelp.setSQLLikeStr(providerDto.getCoalname());
			params.add(keyword);
		}
		if(UtilHelp.isNotNullStr(providerDto.getCoalsizename())){
			where.append(" and ( p.coalsizename like ?)");
			params.add(UtilHelp.setSQLLikeStr(providerDto.getCoalsizename()));
		}
		if(null != providerDto.getMinheating() && providerDto.getMinheating() > 0){
			where.append(" and ( p.heating >= ?)");
			params.add(providerDto.getMinheating());
		}
		if(null != providerDto.getMaxheating() && providerDto.getMaxheating() > 0){
			where.append(" and ( p.heating <= ?)");
			params.add(providerDto.getMaxheating());
		}
		if(null != providerDto.getSulphur() && providerDto.getSulphur() > 0){
			where.append(" and ( p.sulphur <= ?)");
			params.add(providerDto.getSulphur());
		}
		if(null != providerDto.getAsh() && providerDto.getAsh() > 0){
			where.append(" and ( p.ash <= ?)");
			params.add(providerDto.getAsh());
		}
		if(null != providerDto.getMoisture() && providerDto.getMoisture() > 0){
			where.append(" and ( p.moisture <= ?)");
			params.add(providerDto.getMoisture());
		}
		if(UtilHelp.isNotNullStr(providerDto.getKeyword())){
			where.append(" and ( u.realname like ? or u.phone like ?)");
			String keyword =  UtilHelp.setSQLLikeStr(providerDto.getKeyword());
			params.add(keyword);
			params.add(keyword);
		}
		if(UtilHelp.isNotNullStr(providerDto.getBegindate())){
			where.append(" and p.validdate >= ? ");
			params.add(UtilHelp.setValiddateTime(providerDto.getBegindate()));
		}
		if(UtilHelp.isNotNullStr(providerDto.getEnddate())){
			where.append(" and p.validdate <= ? ");
			params.add(UtilHelp.setValiddateTime(providerDto.getEnddate()));
		}
		if(null != providerDto.getStatus() && providerDto.getStatus() > -1){
			where.append(" and p.validstatus = ? ");
			params.add(providerDto.getStatus());
		}
		return super.searchSQLByParamter(sql, sqlCount, page, pageSize, where.toString(), params.toArray(), orders, listProviderInfoReader);
	}
	
	private IReader<Provider> listProviderInfoReader = new IReader<Provider>(){

		@Override
		public Provider readerByList(Object[] objs) {
			//p.proid,p.userid,p.coaltype,p.price,p.validdate,p.sortnumber,p.coalname,p.quantity,u.companyname,u.realname,u.phone
			Provider provider = new Provider();
			provider.setProid((Integer)objs[0]);
			provider.setUserid((Integer)objs[1]);
			provider.setCoaltype((Integer)objs[2]);
			provider.setPrice(objs[3].toString());
			provider.setValiddate((Timestamp)objs[4]);
			provider.setSortnumber((Integer)objs[5]);
			provider.setCoalname((String)objs[6]);
			provider.setQuantity((Integer)objs[7]);
			provider.setCompany((String)objs[8]);
			provider.setBuyername((String)objs[9]);
			provider.setPhone((String)objs[10]);
			provider.setTaxprice(objs[11].toString());
			provider.setCoalsizename((String)objs[12]);
			provider.setHeating((Integer)objs[13]);
			provider.setSulphur(String.valueOf(objs[14]));
			provider.setAsh(String.valueOf(objs[15]));
			provider.setMoisture(String.valueOf(objs[16]));
			provider.setValidstatus((Integer)objs[17]);
			return provider;
		}};
}
