package com.meibaolian.service.nyt.impl;

import java.util.List;

import com.meibaolian.dao.nyt.IFreight_ratesDao;
import com.meibaolian.entity.Freight_ratesEntity;
import com.meibaolian.rowmapper.Freight_ratesRowMapper;
import com.meibaolian.service.nyt.IFreight_ratesService;
import com.meibaolian.util.exception.DataManagerException;

public class Freight_ratesService implements IFreight_ratesService{
	private IFreight_ratesDao dao = null;
	
	@Override
	public List<Freight_ratesEntity> search()
			throws DataManagerException {
		String sql = "SELECT * FROM nyt.freight_rates;";
		return dao.searchList(sql, new Freight_ratesRowMapper(), "");
	}

	public IFreight_ratesDao getDao() {
		return dao;
	}

	public void setDao(IFreight_ratesDao dao) {
		this.dao = dao;
	}
	
}
