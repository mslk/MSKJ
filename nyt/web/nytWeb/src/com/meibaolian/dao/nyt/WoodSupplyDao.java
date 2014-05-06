package com.meibaolian.dao.nyt;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.entity.nyt.WoodSupplyBean;

/**
 * 淀粉/原木/胶合板 供应dao接口
 * @author zhaojian
 * @version 1.0[2014.05.05 16:24]
 */
public interface WoodSupplyDao extends IBaseDao<WoodSupplyBean>{
	
	public QueryResult<WoodSupplyBean> searchList(CommonConditionDto dto, int page, int pageSize);

}
