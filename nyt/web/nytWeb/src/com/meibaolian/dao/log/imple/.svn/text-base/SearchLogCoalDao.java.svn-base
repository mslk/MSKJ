package com.meibaolian.dao.log.imple;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.meibaolian.dao.base.IReader;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.log.ISearchLogCoalDao;
import com.meibaolian.dto.SearchLogCoalDto;
import com.meibaolian.entity.Provider;
import com.meibaolian.entity.SearchLogCoal;
import com.meibaolian.util.UtilHelp;

public class SearchLogCoalDao extends BaseDao<SearchLogCoal> implements ISearchLogCoalDao {

	@Override
	public QueryResult<SearchLogCoal> searchList(
			SearchLogCoalDto searchLogCoalDto, int page, int pageSize,
			LinkedHashMap<String, String> orders) {
		//id,userid,addtime,coalname,minheatingtype,maxheatingtype,
		//,minsulphur,maxsulphur,minash,maxash,minmoisture,maxmoisture,
		//searchtype,coalsizename,keyword
		String sql = "select s.id,s.userid,s.addtime,s.coalname,s.minheatingtype,s.maxheatingtype,s.minsulphur,s.maxsulphur,s.minash,s.maxash,s.minmoisture,s.maxmoisture,s.searchtype,s.coalsizename,s.keyword,u.realname,u.phone,u.type,s.startprvname,s.startcityname,s.startcountyname,s.place  from searchlog_coal s,userinfo u ";
		String sqlCount = "select count(1) from searchlog_coal s,userinfo u ";
		StringBuilder where = new StringBuilder(" and s.userid=u.id ");
		List<Object> params = new ArrayList<Object>(); 
		/*if(null != providerDto.getCoaltype() && providerDto.getCoaltype() > 0){
			where.append(" and s.coaltype=? ");
			params.add(providerDto.getCoaltype());
		}*/
		if(UtilHelp.isNotNullStr(searchLogCoalDto.getCoalname())){
			where.append(" and ( s.coalname like ?)");
			String keyword =  UtilHelp.setSQLLikeStr(searchLogCoalDto.getCoalname());
			params.add(keyword);
		}
		if(UtilHelp.isNotNullStr(searchLogCoalDto.getCoalsizename())){
			where.append(" and ( s.coalsizename like ?)");
			params.add(UtilHelp.setSQLLikeStr(searchLogCoalDto.getCoalsizename()));
		}
		if(null != searchLogCoalDto.getMinheating() && searchLogCoalDto.getMinheating() > 0){
			where.append(" and ( s.maxheatingtype >= ?)");
			params.add(searchLogCoalDto.getMinheating());
		}
		if(null != searchLogCoalDto.getMaxheating() && searchLogCoalDto.getMaxheating() > 0){
			where.append(" and ( s.minheatingtype <= ?)");
			params.add(searchLogCoalDto.getMaxheating());
		}
		if(null != searchLogCoalDto.getSulphur() && searchLogCoalDto.getSulphur() > 0){
			where.append(" and ( s.maxsulphur <= ?)");
			params.add(searchLogCoalDto.getSulphur());
		}
		if(null != searchLogCoalDto.getAsh() && searchLogCoalDto.getAsh() > 0){
			where.append(" and ( s.maxash <= ?)");
			params.add(searchLogCoalDto.getAsh());
		}
		if(null != searchLogCoalDto.getMoisture() && searchLogCoalDto.getMoisture() > 0){
			where.append(" and ( s.maxmoisture <= ?)");
			params.add(searchLogCoalDto.getMoisture());
		}
		if(UtilHelp.isNotNullStr(searchLogCoalDto.getKeyword())){
			where.append(" and ( u.realname like ? or u.phone like ? or s.startprvname like ? or s.startcityname like ? or s.startcountyname like ? or s.place like ? )");
			String keyword =  UtilHelp.setSQLLikeStr(searchLogCoalDto.getKeyword());
			params.add(keyword);
			params.add(keyword);
			params.add(keyword);
			params.add(keyword);
			params.add(keyword);
			params.add(keyword);
		}
		if(UtilHelp.isNotNullStr(searchLogCoalDto.getBegindate())){
			where.append(" and s.addtime >= ? ");
			params.add(searchLogCoalDto.getBegindate());
		}
		if(UtilHelp.isNotNullStr(searchLogCoalDto.getEnddate())){
			where.append(" and s.addtime <= ? ");
			params.add(searchLogCoalDto.getEnddate());
		}
		if(null != searchLogCoalDto.getType() && searchLogCoalDto.getType() > -1){
			where.append(" and u.type = ? ");
			params.add(searchLogCoalDto.getType());
		}
		if(null != searchLogCoalDto.getSearchtype() && searchLogCoalDto.getSearchtype() > -1){
			where.append(" and s.searchtype = ? ");
			params.add(searchLogCoalDto.getSearchtype());
		}
		return super.searchSQLByParamter(sql, sqlCount, page, pageSize, where.toString(), params.toArray(), orders, searchLogCoalReader);
	}

	private IReader<SearchLogCoal> searchLogCoalReader = new IReader<SearchLogCoal>(){
	
		@Override
		public SearchLogCoal readerByList(Object[] objs) {
			//s.id,s.userid,s.addtime,s.coalname,s.minheatingtype,s.maxheatingtype,s.minsulphur,
			//s.maxsulphur,s.minash,s.maxash,s.minmoisture,s.maxmoisture,s.searchtype,s.coalsizename,
			//s.keyword,u.realname,u.phone,u.type
			SearchLogCoal searchLogCoal = new SearchLogCoal();
			searchLogCoal.setId((Integer)objs[0]);
			searchLogCoal.setUserid((Integer)objs[1]);
			searchLogCoal.setAddtime((Timestamp)objs[2]);
			searchLogCoal.setCoalname((String)objs[3]);
			searchLogCoal.setMinheatingtype((Integer)objs[4]);
			searchLogCoal.setMaxheatingtype((Integer)objs[5]);
			BigDecimal tmp = (BigDecimal)objs[7];
//			searchLogCoal.setMinsulphur((Double)objs[6]);
			searchLogCoal.setMaxsulphur(tmp==null?null:tmp.doubleValue());
//			searchLogCoal.setMinash((Double)objs[8]);
			tmp = (BigDecimal)objs[9];
			searchLogCoal.setMaxash(tmp==null?null:tmp.doubleValue());
//			searchLogCoal.setMinmoisture((Double)objs[10]);
			tmp = (BigDecimal)objs[11];
			searchLogCoal.setMaxmoisture(tmp==null?null:tmp.doubleValue());
			searchLogCoal.setSearchtype((Integer)objs[12]);
			searchLogCoal.setCoalsizename((String)objs[13]);
			searchLogCoal.setKeyword((String)objs[14]);
			searchLogCoal.setUsername((String)objs[15]);
			searchLogCoal.setPhone((String)objs[16]);
			searchLogCoal.setUsertype((Integer)objs[17]);
			searchLogCoal.setStartprvname((String)objs[18]);
			searchLogCoal.setStartcityname((String)objs[19]);
			searchLogCoal.setStartcountyname((String)objs[20]);
			searchLogCoal.setPlace((String)objs[21]);
			return searchLogCoal;
		}};
}
