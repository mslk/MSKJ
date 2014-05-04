package com.meibaolian.action.nyt;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.common.ActionContent;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.entity.nyt.Veneer_infoBean;
import com.meibaolian.service.nyt.Veneer_infoService;

/**
 * 桉木
 * @author Kawin
 * @version 1.0[2014.05.03 21:02]
 *
 */
public class Veneer_infoAction  extends BaseAction{
	private static final long serialVersionUID = 1L;
	private Veneer_infoService veneer_infoService;
	private CommonConditionDto dto = new CommonConditionDto();
	public void setVeneer_infoService(Veneer_infoService veneer_infoService) {
		this.veneer_infoService = veneer_infoService;
	}
	public CommonConditionDto getDto() {
		return dto;
	}
	public void setDto(CommonConditionDto dto) {
		this.dto = dto;
	}
	 
	/**
	 * 列表查询
	 * @return
	 */
	public String search(){
		dto.setKeyword( dto.getKeyword() != null ? dto.getKeyword().trim() : null );	
	//	Usermanager usermanager = WebUtil.getAdmin(null);
//		if(null != usermanager)
//			userInfoDto.setUsermanager(usermanager);
 		QueryResult<Veneer_infoBean> qr = veneer_infoService.searchList(dto, getPage(),PAGESIZE);
		savePageView(new PageView<Veneer_infoBean>(qr, getPage(), PAGESIZE));
		WebUtil.setRequestValue("dto", dto);
		return SUCCESS;
	}

	/**
	 * 屏蔽,取消屏蔽方法
	 * @return
	 */
	public String shield(){
		String msg = ActionContent.MSG_OP_FAILE;
		if(null != dto.getInt_valueB() && dto.getInt_valueB() > 0 && dto.getInt_valueC() > -1) {
			Veneer_infoBean bean = veneer_infoService.searchById(dto.getInt_valueB());
			if(null != bean){
				bean.setStatus(dto.getInt_valueC());
				veneer_infoService.update(bean);
				msg = ActionContent.MSG_OP_SUCCESS;
			}
		}
		super.saveMessage(msg, "nyt/veneer_infosearch.action?dto.int_valueA="+dto.getInt_valueA());
		return MESSAGE;
	}

	 
}
