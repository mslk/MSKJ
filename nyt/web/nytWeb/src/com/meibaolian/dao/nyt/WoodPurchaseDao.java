package com.meibaolian.dao.nyt;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.entity.nyt.Veneer_infoBean;
import com.meibaolian.entity.nyt.WoodPurchaseBean;

/**
 * 淀粉/原木/胶合板 求购dao接口
 * @author zhaojian
 * @version 1.0[2014.05.05 15:24]
 */
public interface WoodPurchaseDao extends IBaseDao<WoodPurchaseBean>{
	
	public QueryResult<WoodPurchaseBean> searchList(CommonConditionDto dto, int page, int pageSize);

}
