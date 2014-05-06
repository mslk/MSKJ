package com.meibaolian.service.nyt.impl;

import java.util.ArrayList;
import java.util.List;

import com.meibaolian.common.CommonContent;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.nyt.WoodPurchaseDao;
import com.meibaolian.dao.userInfo.IUserInfoDao;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.dto.UserInfoDto;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.entity.nyt.WoodPurchaseBean;
import com.meibaolian.service.nyt.WoodPurchaseService;

/**
 * 
 * 淀粉/原木/胶合板 求购Service实现
 * @author Kawin.zhao zhaojian
 * @version 1.0[2014.05.05 15:22]
 * 
 */
public class WoodPurchaseServiceImpl implements WoodPurchaseService{
	private WoodPurchaseDao woodPurchaseDao;
	private IUserInfoDao userInfoDao;
	
	public void setWoodPurchaseDao(WoodPurchaseDao woodPurchaseDao) {
		this.woodPurchaseDao = woodPurchaseDao;
	} 
	public void setUserInfoDao(IUserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public List<WoodPurchaseBean> searchList() {
		return woodPurchaseDao.search(0, 10000).getQueryList();
	}

	@Override
	public WoodPurchaseBean searchById(Integer id) {
		return woodPurchaseDao.get(id);
	}

	@Override
	public void update(WoodPurchaseBean t) {
		woodPurchaseDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		woodPurchaseDao.delete(id);
	}

	@Override
	public void add(WoodPurchaseBean t) {
		woodPurchaseDao.add(t);
	}


	@Override
	public QueryResult<WoodPurchaseBean> searchList(UserInfoDto userInfoDto, CommonConditionDto dto,
			int page, int pageSize) {
		int userType = userInfoDto.getUsermanager().getType();
		if(CommonContent.SUPER_MANAGER_USERTYPE == userType){//超级管理员
			dto.setStr_valueI("");
		}else{
			QueryResult<UserInfo> uqr = userInfoDao.searchList(userInfoDto, CommonContent.MIN_PAGE, CommonContent.MAX_PAGE_SIZE);
			if(uqr.getTotalRow() < 1){//无记录 即:该管理员没有管理的用户,直接返回空记录
				return new QueryResult<WoodPurchaseBean>(new ArrayList<WoodPurchaseBean>(),0);
			}
			List<UserInfo> ls = uqr.getQueryList();
			StringBuffer sb = new StringBuffer(" ");
			for (UserInfo userInfo : ls) {
				 sb.append(userInfo.getId()).append(",");
			}
			sb = sb.replace(sb.length()-1, sb.length(), " ");//将最后一个"," 替换成" "
			dto.setStr_valueI(sb.toString());
		}
		return woodPurchaseDao.searchList(dto, page, pageSize);
	}
}
