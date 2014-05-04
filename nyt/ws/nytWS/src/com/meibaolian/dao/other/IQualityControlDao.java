package com.meibaolian.dao.other;

import java.util.List;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.entity.QualityControlEntity;
import com.meibaolian.entity.QualityControlEntityJson;
import com.meibaolian.util.exception.DataManagerException;

public interface IQualityControlDao extends IBaseDao<QualityControlEntity> {
	
	
	/**
	 * 跟进序号查询 此产品信息
	 * @param number
	 * @return
	 * @throws DataManagerException 
	 */
	List<QualityControlEntityJson> searchByNum(String number) throws DataManagerException;

}
