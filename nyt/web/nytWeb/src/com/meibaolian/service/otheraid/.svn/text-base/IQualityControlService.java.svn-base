package com.meibaolian.service.otheraid;

import java.util.LinkedHashMap;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.QualityControlDto;
import com.meibaolian.entity.QualityControl;

public interface IQualityControlService {
	/**
	 * 添加质检报告
	 * @param qualityControl
	 * @return
	 */
	public int addQualityControl(QualityControl qualityControl);
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
	/**
	 * 序列号是否存在
	 * @param number
	 * @return true 存在
	 */
	public boolean existQualityControl(String number);
	/**
	 * 删除对象
	 * @param id
	 * @return
	 */
	public int delQualityControl(int id);
	/**
	 * 修改对象
	 * @param qualityControl
	 * @return
	 */
	public int updateQualityControl(QualityControl qualityControl);
	/**
	 * 获取对象
	 * @param id
	 * @return
	 */
	public QualityControl getById(int id);
}
