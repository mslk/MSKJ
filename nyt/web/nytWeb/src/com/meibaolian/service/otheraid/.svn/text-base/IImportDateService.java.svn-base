package com.meibaolian.service.otheraid;

import java.util.List;

public interface IImportDateService {
	/**
	 * 导入地区数据
	 * 步骤：插入区县表，有新省市则填补省市表，关联省市id，填补收货地站台表
	 * @param dataList
	 */
	public void importAreaData(List<String[]> dataList);
	/**
	 * 导入交货地数据
	 * 步骤：插入交货地表，根据导入数据类型，设置交货地类型值，关联省市县id
	 * @param dataList
	 * @param type
	 */
	public void importPlaceData(List<String[]> dataList, int type);
	/**
	 * 导入运价数据
	 * 步骤：根据导入数据类型，分别插入公路、铁路运价表，关联省市id
	 * @param dataList
	 * @param type
	 */
	public List<Integer> importRateData(List<String[]> dataList, int type);
	/**
	 * 导入站台数据
	 * 步骤：插入临时站台表，关联省市县id，填补到收货地站台表
	 * @param dataList
	 */
	public void importStationData(List<String[]> dataList);
}
