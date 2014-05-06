package com.meibaolian.service.nyt.impl;

import java.util.List;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.nyt.TypeListDao;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.entity.nyt.TypeListBean;
import com.meibaolian.service.nyt.TypeListService;

/**
 * 
 * 菜单选项列表Service实现类
 * @author zhaojian
 * @version 1.0[2014.05.06 11:49]
 *
 */
public class TypeListServiceImpl implements TypeListService{
	private TypeListDao veneer_infoDao;
	
	public void setTypeListDao(TypeListDao veneer_infoDao) {
		this.veneer_infoDao = veneer_infoDao;
	} 

	@Override
	public List<TypeListBean> searchList() {
		return veneer_infoDao.search(0, 10000).getQueryList();
	}

	@Override
	public TypeListBean searchById(Integer id) {
		return veneer_infoDao.get(id);
	}

	@Override
	public void update(TypeListBean t) {
		veneer_infoDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		veneer_infoDao.delete(id);
	}

	@Override
	public void add(TypeListBean t) {
		veneer_infoDao.add(t);
	}

	public QueryResult<TypeListBean> searchList(CommonConditionDto dto,
			int page, int pageSize) {
		return veneer_infoDao.searchList(dto, page, pageSize);
	}
}
