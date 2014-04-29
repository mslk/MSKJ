package com.meibaolian.dao.log.imple;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.meibaolian.dao.base.IReader;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.log.IAccessLogModuleDao;
import com.meibaolian.dto.AccessLogModuleDto;
import com.meibaolian.entity.AccessLogLogin;
import com.meibaolian.entity.AccessLogModule;
import com.meibaolian.util.UtilHelp;

public class AccessLogModuleDao extends BaseDao<AccessLogModule> implements
		IAccessLogModuleDao {

	@Override
	public QueryResult<AccessLogModule> searchList(
			AccessLogModuleDto accessLogModuleDto, int page, int pageSize,
			LinkedHashMap<String, String> orders) {
		
		//
		String sql = "select a.id,a.userid,a.title,a.module,a.funcation,a.addtime,u.phone,u.type,u.realname from accesslog_module a,userinfo u ";
		String sqlCount = "select count(1) from accesslog_module a,userinfo u ";
		StringBuilder where = new StringBuilder(" and a.userid=u.id ");
		List<Object> params = new ArrayList<Object>(); 
		if(UtilHelp.isNotNullStr(accessLogModuleDto.getKeyword())){
			where.append(" and ( u.realname like ? or u.phone like ?)");
			String keyword =  UtilHelp.setSQLLikeStr(accessLogModuleDto.getKeyword());
			params.add(keyword);
			params.add(keyword);
		}
		if(UtilHelp.isNotNullStr(accessLogModuleDto.getBegindate())){
			where.append(" and a.addtime >= ? ");
			params.add(accessLogModuleDto.getBegindate());
		}
		if(UtilHelp.isNotNullStr(accessLogModuleDto.getEnddate())){
			where.append(" and a.addtime <= ? ");
			params.add(accessLogModuleDto.getEnddate());
		}
		if(UtilHelp.isNotNullStr(accessLogModuleDto.getModule())){
			where.append(" and a.module = ? ");
			params.add(accessLogModuleDto.getModule());
		}
		if(UtilHelp.isNotNullStr(accessLogModuleDto.getFuncation())){
			where.append(" and a.funcation = ? ");
			params.add(accessLogModuleDto.getFuncation());
		}
		if(null != accessLogModuleDto.getType() && accessLogModuleDto.getType() > -1){
			where.append(" and u.type = ? ");
			params.add(accessLogModuleDto.getType());
		}
		return super.searchSQLByParamter(sql, sqlCount, page, pageSize, where.toString(), params.toArray(), orders, accessLogModuleReader);
	}

	private IReader<AccessLogModule> accessLogModuleReader = new IReader<AccessLogModule>(){

		@Override
		public AccessLogModule readerByList(Object[] objs) {
			//a.id,a.userid,a.title,a.module,a.funcation,a.addtime,u.phone,u.type,u.realname
			AccessLogModule accessLogModule = new AccessLogModule();
			accessLogModule.setId((Integer)objs[0]);
			accessLogModule.setUserid((Integer)objs[1]);
			accessLogModule.setTitle((String)objs[2]);
			accessLogModule.setModule((String)objs[3]);
			accessLogModule.setFuncation((String)objs[4]);
			accessLogModule.setAddtime((Timestamp)objs[5]);
			accessLogModule.setPhone((String)objs[6]);
			accessLogModule.setUsertype((Integer)objs[7]);
			accessLogModule.setUsername((String)objs[8]);
			return accessLogModule;
		}};

}
