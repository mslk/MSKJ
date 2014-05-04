package com.meibaolian.dao.nyt.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.nyt.Veneer_infoDao;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.entity.nyt.Veneer_infoBean;

/**
 * 桉木dao实现类
 * @author Kawin
 * @version 1.0[2014.05.03 14:24]
 */
public class Veneer_infoDaoImpl extends BaseDao<Veneer_infoBean> implements Veneer_infoDao{

	@Override
	public QueryResult<Veneer_infoBean> searchList(CommonConditionDto dto,
			int page, int pageSize) {
		
		StringBuilder where = new StringBuilder("");
		List<Object> params = new ArrayList<Object>(); 
		LinkedHashMap<String, String> orders = new  LinkedHashMap<String, String>();
		
		/*类型 1为供应, 2为求购*/
		if(null != dto.getInt_valueA() && dto.getInt_valueA() > -1){
			where.append(" and type=? ");
			params.add(dto.getInt_valueA());
		}
//		if(null != userInfoDto.getStatus() && userInfoDto.getStatus() >-1){
//			where.append(" and status=? ");
//			params.add(userInfoDto.getStatus());
//		}
//		if(UtilHelp.isNotNullStr(userInfoDto.getKeyword())){
//			String keyword = UtilHelp.setSQLLikeStr(userInfoDto.getKeyword());
//			where.append(" and (realname like ? or companyname like ? or phone like ?)");
//			params.add(keyword);
//			params.add(keyword);
//			params.add(keyword);
//		}
//		if(UtilHelp.isNotNullStr(userInfoDto.getBegindate())){
//			where.append(" and registertime >= ? ");
//			params.add(userInfoDto.getBegindate());
//		}
//		if(UtilHelp.isNotNullStr(userInfoDto.getEnddate())){
//			where.append(" and registertime <= ? ");
//			params.add(userInfoDto.getEnddate());
//		}
		orders.put("orderid", " desc ");
		orders.put("addtime", " desc ");
		return super.search(page, pageSize, where.toString(), params.toArray(), orders);

	}

}
