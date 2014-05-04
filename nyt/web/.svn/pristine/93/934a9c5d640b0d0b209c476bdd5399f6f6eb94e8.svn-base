package com.meibaolian.dao.log.imple;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.meibaolian.dao.base.IReader;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.log.IAccessLogLoginDao;
import com.meibaolian.dto.AccessLogLoginDto;
import com.meibaolian.entity.AccessLogLogin;
import com.meibaolian.util.UtilHelp;

public class AccessLogLoginDao extends BaseDao<AccessLogLogin> implements IAccessLogLoginDao {

	@Override
	public QueryResult<AccessLogLogin> searchList(
			AccessLogLoginDto accessLogLoginDto, int page, int pageSize,
			LinkedHashMap<String, String> orders) {
		//id,userid,addtime,phone,type,result
		String sql = "select a.id,a.userid,a.addtime,a.phone,a.type as atype,a.result,u.type ,u.realname from accesslog_login a,userinfo u ";
		String sqlCount = "select count(1) from accesslog_login a,userinfo u ";
		StringBuilder where = new StringBuilder(" and a.userid=u.id ");
		List<Object> params = new ArrayList<Object>(); 
		if(UtilHelp.isNotNullStr(accessLogLoginDto.getKeyword())){
			where.append(" and ( u.realname like ? or u.phone like ?)");
			String keyword =  UtilHelp.setSQLLikeStr(accessLogLoginDto.getKeyword());
			params.add(keyword);
			params.add(keyword);
		}
		if(UtilHelp.isNotNullStr(accessLogLoginDto.getBegindate())){
			where.append(" and a.addtime >= ? ");
			params.add(accessLogLoginDto.getBegindate());
		}
		if(UtilHelp.isNotNullStr(accessLogLoginDto.getEnddate())){
			where.append(" and a.addtime <= ? ");
			params.add(accessLogLoginDto.getEnddate());
		}
		if(null != accessLogLoginDto.getType() && accessLogLoginDto.getType() > -1){
			where.append(" and u.type = ? ");
			params.add(accessLogLoginDto.getType());
		}
		return super.searchSQLByParamter(sql, sqlCount, page, pageSize, where.toString(), params.toArray(), orders, accessLogLoginIReader);
	}

	private IReader<AccessLogLogin> accessLogLoginIReader = new IReader<AccessLogLogin>(){

		@Override
		public AccessLogLogin readerByList(Object[] objs) {
			//a.id,a.userid,a.addtime,a.phone,a.type,a.result,u.realname,u.type usertype
			AccessLogLogin accessLogLogin = new AccessLogLogin();
			accessLogLogin.setId((Integer)objs[0]);
			accessLogLogin.setUserid((Integer)objs[1]);
			accessLogLogin.setAddtime((Timestamp)objs[2]);
			accessLogLogin.setPhone((String)objs[3]);
			accessLogLogin.setType((Integer)objs[4]);
			accessLogLogin.setResult((Integer)objs[5]);
			accessLogLogin.setUsername((String)objs[7]);
			accessLogLogin.setUsertype((Integer)objs[6]);
			return accessLogLogin;
		}};
}
