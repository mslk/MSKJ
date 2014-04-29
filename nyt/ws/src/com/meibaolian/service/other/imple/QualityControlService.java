package com.meibaolian.service.other.imple;

import java.util.List;

import com.meibaolian.dao.other.IQualityControlDao;
import com.meibaolian.entity.QualityControlEntityJson;
import com.meibaolian.service.other.IQualityControlService;
import com.meibaolian.util.exception.DataManagerException;

public class QualityControlService implements IQualityControlService {

	
	
	IQualityControlDao qualityControlDao;
	
	public void setQualityControlDao(IQualityControlDao qualityControlDao) {
		this.qualityControlDao = qualityControlDao;
	}



	@Override
	public List<QualityControlEntityJson> searchByNum(String number)
			throws DataManagerException {
		return qualityControlDao.searchByNum(number);
	}

}
