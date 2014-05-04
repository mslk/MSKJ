package com.meibaolian.service.nyt.impl;

import java.util.List;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.nyt.Veneer_infoDao;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.entity.nyt.Veneer_infoBean;
import com.meibaolian.service.nyt.Veneer_infoService;

public class Veneer_infoServiceImpl implements Veneer_infoService{
	private Veneer_infoDao veneer_infoDao;
	
	public void setVeneer_infoDao(Veneer_infoDao veneer_infoDao) {
		this.veneer_infoDao = veneer_infoDao;
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
	public int update(Veneer_infoBean t) {
		veneer_infoDao.update(t);
		return 1;
	}

	@Override
	public int delete(Integer id) {
		veneer_infoDao.delete(id);
		return 0;
	}

	@Override
	public int add(Veneer_infoBean t) {
		veneer_infoDao.add(t);
		return 0;
	}


	@Override
	public QueryResult<Veneer_infoBean> searchList(CommonConditionDto dto,
			int page, int pageSize) {
		return veneer_infoDao.searchList(dto, page, pageSize);
	}

}
