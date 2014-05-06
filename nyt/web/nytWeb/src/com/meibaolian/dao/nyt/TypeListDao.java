package com.meibaolian.dao.nyt;

import com.meibaolian.dao.base.IBaseDao;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.entity.nyt.TypeListBean;

/**
 * 菜单选项列表dao接口
 * @author zhaojian
 * @version 1.0[2014.05.06 11:41]
 */
public interface TypeListDao extends IBaseDao<TypeListBean>{
	
	public QueryResult<TypeListBean> searchList(CommonConditionDto dto, int page, int pageSize);

}
