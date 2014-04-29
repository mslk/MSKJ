package com.meibaolian.service.otheraid.imple;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dao.otheraid.IQualityControlDao;
import com.meibaolian.dto.QualityControlDto;
import com.meibaolian.entity.QualityControl;
import com.meibaolian.service.otheraid.IQualityControlService;

public class QualityControlService implements IQualityControlService {
	
	private IQualityControlDao qualityControlDao;
	
	public void setQualityControlDao(IQualityControlDao qualityControlDao) {
		this.qualityControlDao = qualityControlDao;
	}

	@Override
	public int addQualityControl(QualityControl qualityControl) {
		qualityControlDao.add(qualityControl);
		return 1;
	}

	@Override
	public QueryResult<QualityControl> searchList(
			QualityControlDto qualityControlDto, int page, int pageSize,
			LinkedHashMap<String, String> orders) {
		
		return qualityControlDao.searchList(qualityControlDto, page, pageSize, orders);
	}

	@Override
	public int delQualityControl(int id) {
		qualityControlDao.delete(id);
		return 1;
	}

	@Override
	public boolean existQualityControl(String number) {
		long count = qualityControlDao.searchCountByhql(" select count(id) from QualityControl where number=?", new Object[]{number});
		return count > 0;
	}

	@Override
	public int updateQualityControl(QualityControl qualityControl) {
		QualityControl dbQC = qualityControlDao.get(qualityControl.getId());
		dbQC.setFareliang1(qualityControl.getFareliang1());
		dbQC.setFareliang2(qualityControl.getFareliang2());
		dbQC.setGudingtan(qualityControl.getGudingtan());
		dbQC.setHuiDt(qualityControl.getHuiDt());
		dbQC.setHuifafen(qualityControl.getHuifafen());
		dbQC.setHuifen(qualityControl.getHuifen());
		dbQC.setHuiFt(qualityControl.getHuiFt());
		dbQC.setHuiHt(qualityControl.getHuiHt());
		dbQC.setHuiSt(qualityControl.getHuiSt());
		dbQC.setJianhui(qualityControl.getJianhui());
		dbQC.setJiaozha(qualityControl.getJiaozha());
		dbQC.setNianjie(qualityControl.getNianjie());
		dbQC.setNumber(qualityControl.getNumber());
		dbQC.setQing(qualityControl.getQing());
		dbQC.setQuanniu(qualityControl.getQuanniu());
		dbQC.setQuanshuifen(qualityControl.getQuanshuifen());
		dbQC.setShuifen(qualityControl.getShuifen());
//		qualityControlDao.update(qualityControl);
		return 1;
	}

	@Override
	public QualityControl getById(int id) {
		 
		return qualityControlDao.get(id);
	}

}
