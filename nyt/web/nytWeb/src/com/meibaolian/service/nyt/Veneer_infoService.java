package com.meibaolian.service.nyt;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.dto.UserInfoDto;
import com.meibaolian.entity.nyt.Veneer_infoBean;
import com.meibaolian.service.Service;

/**
 * 桉木Service接口
 * @author Kawin
 * @version 1.0[2014.05.03 15:21]
 */
public interface Veneer_infoService extends Service<Veneer_infoBean>{
	/**
	 * 根据条件分页查找
	 * @param dto
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public QueryResult<Veneer_infoBean> searchList(UserInfoDto userInfoDto, CommonConditionDto dto, int page, int pageSize);
}
