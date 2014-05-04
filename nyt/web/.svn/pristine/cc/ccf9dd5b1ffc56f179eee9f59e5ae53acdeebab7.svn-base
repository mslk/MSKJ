package com.meibaolian.dao.otheraid;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.QualityControlDto;
import com.meibaolian.entity.QualityControl;

public interface IQualityControlDao extends IBaseDao<QualityControl> {
	/**
	 * 查询质检报告
	 * @param qualityControlDto
	 * @param page
	 * @param pageSize
	 * @param orders
	 * @return
	 */
	public QueryResult<QualityControl> searchList(QualityControlDto qualityControlDto, int page,
			int pageSize, LinkedHashMap<String, String> orders);
}
