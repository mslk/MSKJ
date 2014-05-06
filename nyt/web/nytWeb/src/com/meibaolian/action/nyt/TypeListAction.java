package com.meibaolian.action.nyt;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.common.CommonContent;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.entity.nyt.TypeListBean;
import com.meibaolian.service.nyt.TypeListService;

/**
 * 
 * 菜单选项列表Action
 * @author Kawin.zhao
 * @version 1.0[2014.05.06 11:57]
 *
 */
public class TypeListAction  extends BaseAction{
	private static final long serialVersionUID = 1L;
	private TypeListService typeListService;
	private CommonConditionDto dto = new CommonConditionDto();
	public void setTypeListService(TypeListService typeListService) {
		this.typeListService = typeListService;
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
 		QueryResult<TypeListBean> qr = typeListService.searchList(dto, getPage(),PAGESIZE);
		savePageView(new PageView<TypeListBean>(qr, getPage(), PAGESIZE));
		WebUtil.setRequestValue("dto", dto);
		return SUCCESS;
	}

	/**
	 * 屏蔽,取消屏蔽方法
	 * @return
	 *//*
	public String shield(){
		String msg = CommonContent.MSG_OP_FAILE;
		if(null != dto.getInt_valueB() && dto.getInt_valueB() > 0 && dto.getInt_valueC() > -1) {
			TypeListBean bean = typeListService.searchById(dto.getInt_valueB());
			if(null != bean){
				bean.setStatus(dto.getInt_valueC());
				typeListService.update(bean);
				msg = CommonContent.MSG_OP_SUCCESS;
			}
		}
		super.saveMessage(msg, "nyt/typeListsearch.action?dto.int_valueA="+dto.getInt_valueA());
		return MESSAGE;
	}*/
	
	/**
	 * 前移/后移
	 * @return
	 */
	public String sortTop(){
		String msg = CommonContent.MSG_OP_FAILE;
		if(null != dto.getInt_valueB() && dto.getInt_valueB() > 0 && dto.getInt_valueC() > -1) {
			TypeListBean bean = typeListService.searchById(dto.getInt_valueB());
			if(null != bean){
				bean.setOrderid(dto.getInt_valueC());
				typeListService.update(bean);
				msg = CommonContent.MSG_OP_SUCCESS;
			}
		}
		super.saveMessage(msg, "nyt/typeListsearch.action");
		return MESSAGE;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		String msg = CommonContent.MSG_OP_FAILE;
		if(null != dto.getInt_id() && dto.getInt_id() > -1) {
			typeListService.delete(dto.getInt_id());
			msg = CommonContent.MSG_OP_SUCCESS;
		}
		super.saveMessage(msg, "nyt/typeListsearch.action");
		return MESSAGE;
	}
	
	/**
	 * 详情
	 * @return
	 */
	public String detail(){
		if(null != dto.getInt_id() && dto.getInt_id() > -1) {
			TypeListBean vo = typeListService.searchById(dto.getInt_id());
				if(null != vo){
					WebUtil.setRequestValue("vo", vo);
					return SHOWRESULT;
				}
			}
			return INPUT;
		}
	 
}
