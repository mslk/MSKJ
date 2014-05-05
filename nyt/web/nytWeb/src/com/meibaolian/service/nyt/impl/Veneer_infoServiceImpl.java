package com.meibaolian.service.nyt.impl;

import java.util.ArrayList;
import java.util.List;

import com.meibaolian.common.CommonContent;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.nyt.Veneer_infoDao;
import com.meibaolian.dao.userInfo.IUserInfoDao;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.dto.UserInfoDto;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.entity.nyt.Veneer_infoBean;
import com.meibaolian.service.nyt.Veneer_infoService;

public class Veneer_infoServiceImpl implements Veneer_infoService{
	private Veneer_infoDao veneer_infoDao;
	private IUserInfoDao userInfoDao;
	
	public void setVeneer_infoDao(Veneer_infoDao veneer_infoDao) {
		this.veneer_infoDao = veneer_infoDao;
	} 
	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public List<Veneer_infoBean> searchList() {
		return veneer_infoDao.search(0, 10000).getQueryList();
	}

	@Override
	public Veneer_infoBean searchById(Integer id) {
		return veneer_infoDao.get(id);
	}

	@Override
	public void update(Veneer_infoBean t) {
		veneer_infoDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		veneer_infoDao.delete(id);
	}

	@Override
	public void add(Veneer_infoBean t) {
		veneer_infoDao.add(t);
	}


	@Override
	public QueryResult<Veneer_infoBean> searchList(UserInfoDto userInfoDto, CommonConditionDto dto,
			int page, int pageSize) {
		int userType = userInfoDto.getUsermanager().getType();
		if(CommonContent.SUPER_MANAGER_USERTYPE == userType){//超级管理员
			dto.setStr_valueI("");
		}else{
			QueryResult<UserInfo> uqr = userInfoDao.searchList(userInfoDto, CommonContent.MIN_PAGE, CommonContent.MAX_PAGE_SIZE);
			if(uqr.getTotalRow() < 1){//无记录 即:该管理员没有管理的用户,直接返回空记录
				return new QueryResult<Veneer_infoBean>(new ArrayList<Veneer_infoBean>(),0);
			}
			List<UserInfo> ls = uqr.getQueryList();
			StringBuffer sb = new StringBuffer(" ");
			for (UserInfo userInfo : ls) {
				 sb.append(userInfo.getId()).append(",");
			}
			sb = sb.replace(sb.length()-1, sb.length(), " ");//将最后一个"," 替换成" "
			dto.setStr_valueI(sb.toString());
		}
		return veneer_infoDao.searchList(dto, page, pageSize);
	}

	/*public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abcdefghijklmn");
		String s = sb.substring(0,sb.length()-1).toString();
		StringBuffer s2 = sb.replace(sb.length()-1, sb.length(), "y");
		System.out.println(s2);
	}*/
}
