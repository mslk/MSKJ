package com.meibaolian.service.nyt;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.entity.nyt.TypeListBean;
import com.meibaolian.service.Service;

/**
 * 菜单选项列表Service接口
 * @author Kawin.zhao zhaojian
 * @version 1.0[2014.05.06 11:46]
 */
public interface TypeListService extends Service<TypeListBean>{
	/**
	 * 根据条件分页查找
	 * @param dto
	 * @param page
	 * @param pageSize
	 * @return
	 */
 	public QueryResult<TypeListBean> searchList(CommonConditionDto dto, int page, int pageSize);
}
