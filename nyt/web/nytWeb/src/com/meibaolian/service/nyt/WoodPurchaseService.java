package com.meibaolian.service.nyt;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.dto.UserInfoDto;
import com.meibaolian.entity.nyt.WoodPurchaseBean;
import com.meibaolian.service.Service;

/**
 * 淀粉/原木/胶合板 求购Service接口
 * @author Kawin
 * @version 1.0[2014.05.05 15:21]
 */
public interface WoodPurchaseService extends Service<WoodPurchaseBean>{
	/**
	 * 根据条件分页查找
	 * @param dto
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public QueryResult<WoodPurchaseBean> searchList(UserInfoDto userInfoDto, CommonConditionDto dto, int page, int pageSize);
}
