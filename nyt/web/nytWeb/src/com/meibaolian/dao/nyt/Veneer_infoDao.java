package com.meibaolian.dao.nyt;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.entity.nyt.Veneer_infoBean;

/**
 * 桉木dao接口
 * @author zhaojian
 * @version 1.0[2014.05.03 14:24]
 */
public interface Veneer_infoDao extends IBaseDao<Veneer_infoBean>{
	
	public QueryResult<Veneer_infoBean> searchList(CommonConditionDto dto, int page, int pageSize);

}
