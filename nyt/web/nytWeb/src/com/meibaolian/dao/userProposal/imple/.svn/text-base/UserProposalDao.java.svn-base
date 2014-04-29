package com.meibaolian.dao.userProposal.imple;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.meibaolian.dao.base.IReader;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.userProposal.IUserProposalDao;
import com.meibaolian.dto.UserProposalDto;
import com.meibaolian.entity.UserProposal;
import com.meibaolian.util.UtilHelp;

public class UserProposalDao extends BaseDao<UserProposal> implements IUserProposalDao {

	@Override
	public QueryResult<UserProposal> searchList(
			UserProposalDto userProposalDto, int page, int pageSize,
			LinkedHashMap<String, String> orders) {
		
		String sql = "select p.id,p.userid,p.content,p.addtime,p.status,u.realname,u.phone  from user_proposal p,userinfo u ";
		String sqlCount = "select count(1) from user_proposal p,userinfo u ";
		StringBuilder where = new StringBuilder(" and p.userid=u.id ");
		List<Object> params = new ArrayList<Object>(); 
		if(UtilHelp.isNotNullStr(userProposalDto.getKeyword())){
			where.append(" and ( u.realname like ? or u.phone like ?)");
			String keyword =  UtilHelp.setSQLLikeStr(userProposalDto.getKeyword());
			params.add(keyword);
			params.add(keyword);
		}
		if(UtilHelp.isNotNullStr(userProposalDto.getBegindate())){
			where.append(" and p.addtime >= ? ");
			params.add(userProposalDto.getBegindate());
		}
		if(UtilHelp.isNotNullStr(userProposalDto.getEnddate())){
			where.append(" and p.addtime <= ? ");
			params.add(userProposalDto.getEnddate());
		}
		if(null != userProposalDto.getStatus() && userProposalDto.getStatus() > -1){
			where.append(" and p.status = ? ");
			params.add(userProposalDto.getStatus());
		}
		return super.searchSQLByParamter(sql, sqlCount, page, pageSize, where.toString(), params.toArray(), orders, userProposalReader);
	}
	
	
	private IReader<UserProposal> userProposalReader = new IReader<UserProposal>(){

		@Override
		public UserProposal readerByList(Object[] objs) {
			UserProposal userProposal = new UserProposal();
			//p.id,p.userid,p.content,p.addtime,p.status,u.realname,u.phone
			userProposal.setId((Integer)objs[0]);
			userProposal.setUserid((Integer)objs[1]);
			userProposal.setContent((String)objs[2]);
			userProposal.setAddtime((Timestamp)objs[3]);
			userProposal.setStatus((Integer)objs[4]);
			userProposal.setUsername((String)objs[5]);
			userProposal.setPhone((String)objs[6]);
			return userProposal;
		}};
}
