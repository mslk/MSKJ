package com.meibaolian.dao.nyt.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.base.imple.BaseDao;
import com.meibaolian.dao.nyt.TypeListDao;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.entity.nyt.TypeListBean;
import com.meibaolian.util.StringHander;
import com.meibaolian.util.UtilHelp;

/**
 * 菜单选项列表dao实现类
 * @author zhaojian
 * @version 1.0[2014.05.06 11:41]
 */
public class TypeListDaoImpl extends BaseDao<TypeListBean> implements TypeListDao{

	@Override
	public QueryResult<TypeListBean> searchList(CommonConditionDto dto,
			int page, int pageSize) {
		
		StringBuilder where = new StringBuilder("");
		List<Object> params = new ArrayList<Object>(); 
		LinkedHashMap<String, String> orders = new  LinkedHashMap<String, String>();
		/*类型 1桉木, 2胶合板, 3原木, 4淀粉*/
		if(null != dto.getInt_valueA() && dto.getInt_valueA() > -1){
			where.append(" and type=? ");
			params.add(dto.getInt_valueA());
		}
	 
		/*添加时间*/
		if(UtilHelp.isNotNullStr(dto.getBegindate())){
			where.append(" and addtime >= ? ");
			params.add(dto.getBegindate());
		}
		if(UtilHelp.isNotNullStr(dto.getEnddate())){
			where.append(" and addtime <= ? ");
			params.add(dto.getEnddate());
		}
 
		if(UtilHelp.isNotNullStr(dto.getKeyword())){
			String keyword = UtilHelp.setSQLLikeStr(dto.getKeyword());
			where.append(" and (itemvalue like ? or item_describe like ? )");
			params.add(keyword);
			params.add(keyword);
		}
//		
		orders.put("type", " desc ");
		orders.put("item_type", " desc ");
		orders.put("orderid", " desc ");
		orders.put("addtime", " desc ");
		return super.search(page, pageSize, where.toString(), params.toArray(), orders);

	}

}
