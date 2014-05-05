package com.meibaolian.service.nyt;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.dto.UserInfoDto;
import com.meibaolian.entity.nyt.Veneer_infoBean;
import com.meibaolian.entity.nyt.WoodSupplyBean;
import com.meibaolian.service.Service;

/**
 * 淀粉/原木/胶合板 供应Service接口
 * @author Kawin
 * @version 1.0[2014.05.05 15:21]
 */
public interface WoodSupplyService extends Service<WoodSupplyBean>{
	/**
	 * 根据条件分页查找
	 * @param dto
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public QueryResult<WoodSupplyBean> searchList(UserInfoDto userInfoDto, CommonConditionDto dto, int page, int pageSize);
}
