package com.meibaolian.dao.userInfo.imple;

import java.util.ArrayList;
import java.util.List;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.userInfo.IUserInfoDao;
import com.meibaolian.dto.UserInfoDto;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.util.UtilHelp;

public class UserInfoDao extends BaseDao<UserInfo> implements IUserInfoDao {

	@Override
	public QueryResult<UserInfo> searchList(UserInfoDto userInfoDto, int page,
			int pageSize) {
		
		StringBuilder where = new StringBuilder("");
		List<Object> params = new ArrayList<Object>(); 
		//1超级管理员显示所有客户记录,0非超级管理员显示自己管理的用户
		if(null != userInfoDto.getUsermanager() && userInfoDto.getUsermanager().getType() != 1){
			where.append(" and usermanagerid=? ");
			params.add(userInfoDto.getUsermanager().getId());
		}
		if(null != userInfoDto.getType() && userInfoDto.getType() > -1){
			where.append(" and type=? ");
			params.add(userInfoDto.getType());
		}
		
		if(null != userInfoDto.getLevel() && userInfoDto.getLevel() > -1){
			where.append(" and level=? ");
			params.add(userInfoDto.getLevel());
		}
		if(null != userInfoDto.getStatus() && userInfoDto.getStatus() >-1){
			where.append(" and status=? ");
			params.add(userInfoDto.getStatus());
		}
		if(UtilHelp.isNotNullStr(userInfoDto.getKeyword())){
			String keyword = UtilHelp.setSQLLikeStr(userInfoDto.getKeyword());
			where.append(" and (realname like ? or companyname like ? or phone like ?)");
			params.add(keyword);
			params.add(keyword);
			params.add(keyword);
		}
		if(UtilHelp.isNotNullStr(userInfoDto.getBegindate())){
			where.append(" and registertime >= ? ");
			params.add(userInfoDto.getBegindate());
		}
		if(UtilHelp.isNotNullStr(userInfoDto.getEnddate())){
			where.append(" and registertime <= ? ");
			params.add(userInfoDto.getEnddate());
		}
		return super.search(page, pageSize, where.toString(), params.toArray());
	}

}
