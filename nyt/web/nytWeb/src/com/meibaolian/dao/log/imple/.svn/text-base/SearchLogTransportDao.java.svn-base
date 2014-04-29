package com.meibaolian.dao.log.imple;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.meibaolian.dao.base.IReader;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.log.ISearchLogTransportDao;
import com.meibaolian.dto.SearchLogTransportDto;
import com.meibaolian.entity.SearchLogTransport;
import com.meibaolian.util.UtilHelp;

public class SearchLogTransportDao extends BaseDao<SearchLogTransport> implements
		ISearchLogTransportDao {

	@Override
	public QueryResult<SearchLogTransport> searchList(
			SearchLogTransportDto searchLogTransportDto, int page,
			int pageSize, LinkedHashMap<String, String> orders) {
		//id,userid,addtime,keyword,searchtype,stopprvname
		String sql = "select s.id,s.userid,s.addtime,s.keyword,s.searchtype,s.stopprvname,u.phone,u.type,u.realname from searchlog_transport s,userinfo u ";
		String sqlCount = "select count(1) from searchlog_transport s,userinfo u ";
		StringBuilder where = new StringBuilder(" and s.userid=u.id ");
		List<Object> params = new ArrayList<Object>(); 
		if(UtilHelp.isNotNullStr(searchLogTransportDto.getKeyword())){
			where.append(" and ( u.realname like ? or u.phone like ?)");
			String keyword =  UtilHelp.setSQLLikeStr(searchLogTransportDto.getKeyword());
			params.add(keyword);
			params.add(keyword);
		}
		if(UtilHelp.isNotNullStr(searchLogTransportDto.getBegindate())){
			where.append(" and s.addtime >= ? ");
			params.add(searchLogTransportDto.getBegindate());
		}
		if(UtilHelp.isNotNullStr(searchLogTransportDto.getEnddate())){
			where.append(" and s.addtime <= ? ");
			params.add(searchLogTransportDto.getEnddate());
		}
		if(null != searchLogTransportDto.getType() && searchLogTransportDto.getType() > -1){
			where.append(" and u.type = ? ");
			params.add(searchLogTransportDto.getType());
		}
		if(null != searchLogTransportDto.getSearchtype() && searchLogTransportDto.getSearchtype() > -1){
			where.append(" and s.searchtype = ? ");
			params.add(searchLogTransportDto.getSearchtype());
		}
		return super.searchSQLByParamter(sql, sqlCount, page, pageSize, where.toString(), params.toArray(), orders, reader);
	}
	
	private IReader<SearchLogTransport> reader = new IReader<SearchLogTransport>(){

		@Override
		public SearchLogTransport readerByList(Object[] objs) {
			//s.id,s.userid,s.addtime,s.keyword,s.searchtype,s.stopprvname,u.phone,u.type,u.realname
			SearchLogTransport searchLogTransport = new SearchLogTransport();
			searchLogTransport.setId((Integer)objs[0]);
			searchLogTransport.setUserid((Integer)objs[1]);
			searchLogTransport.setAddtime((Timestamp)objs[2]);
			searchLogTransport.setKeyword((String)objs[3]);
			searchLogTransport.setSearchtype((Integer)objs[4]);
			searchLogTransport.setStopprvname((String)objs[5]);
			searchLogTransport.setPhone((String)objs[6]);
			searchLogTransport.setUsertype((Integer)objs[7]);
			searchLogTransport.setUsername((String)objs[8]);
			return searchLogTransport;
		}};
	
}
