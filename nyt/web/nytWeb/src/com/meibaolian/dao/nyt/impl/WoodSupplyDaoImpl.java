package com.meibaolian.dao.nyt.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.nyt.WoodSupplyDao;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.entity.nyt.WoodSupplyBean;
import com.meibaolian.util.StringHander;
import com.meibaolian.util.UtilHelp;

/**
 * 淀粉/原木/胶合板 供应dao实现类
 * @author zhaojian
 * @version 1.0[2014.05.05 17:24]
 */
public class WoodSupplyDaoImpl extends BaseDao<WoodSupplyBean> implements WoodSupplyDao{

	@Override
	public QueryResult<WoodSupplyBean> searchList(CommonConditionDto dto,
			int page, int pageSize) {
		
		StringBuilder where = new StringBuilder("");
		List<Object> params = new ArrayList<Object>(); 
		LinkedHashMap<String, String> orders = new  LinkedHashMap<String, String>();
		/*判断是否为超级管理员,如果不是,那么只能查看自己管理的用户发布的消息*/
		if(StringHander.isNotEmpty(dto.getStr_valueI())){
			String parameters[] = dto.getStr_valueI().split(",");
			where.append("and (");
			for (String parameter : parameters) {
				where.append("userid=? or ");
				params.add(parameter);
			}
			where = where.replace(where.length()-3, where.length(), ")");//将最后一个"or" 替换成" )"
			//where.append(" and ( userid=3 or userid=4 or userid=5 or userid=?)");
			//params.add(dto.getStr_valueI());
		}
		/*供应材料类型  2 胶合板 3 原木 4 淀粉*/
		if(null != dto.getInt_valueA() && dto.getInt_valueA() > -1){
			where.append(" and type=? ");
			params.add(dto.getInt_valueA());
		}
		/*类型 0为正常, 1为屏蔽*/
		if(null != dto.getInt_valueB() && dto.getInt_valueB() > -1){
			where.append(" and status=? ");
			params.add(dto.getInt_valueB());
		}
		/*发布时间*/
		if(UtilHelp.isNotNullStr(dto.getBegindate())){
			where.append(" and (addtime >= ? or valid >= ?)");
			params.add(dto.getBegindate());
			params.add(dto.getBegindate());
		}
		if(UtilHelp.isNotNullStr(dto.getEnddate())){
			where.append(" and (addtime <= ? or valid >= ?) ");
			params.add(dto.getEnddate());
			params.add(dto.getEnddate());
		}
 
//		if(UtilHelp.isNotNullStr(userInfoDto.getKeyword())){
//			String keyword = UtilHelp.setSQLLikeStr(userInfoDto.getKeyword());
//			where.append(" and (realname like ? or companyname like ? or phone like ?)");
//			params.add(keyword);
//			params.add(keyword);
//			params.add(keyword);
//		}
//		
		orders.put("orderid", " desc ");
		orders.put("addtime", " desc ");
		return super.search(page, pageSize, where.toString(), params.toArray(), orders);

	}

}
