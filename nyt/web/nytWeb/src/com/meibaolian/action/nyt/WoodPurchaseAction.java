package com.meibaolian.action.nyt;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.PageView;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.common.CommonContent;
import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.dto.CommonConditionDto;
import com.meibaolian.dto.UserInfoDto;
import com.meibaolian.entity.Usermanager;
import com.meibaolian.entity.nyt.WoodPurchaseBean;
import com.meibaolian.service.nyt.WoodPurchaseService;

/**
 * 
 * 淀粉/原木/胶合板 求购 Action
 * @author Kawin
 * @version 1.0[2014.05.05 15:34]
 * 
 */
public class WoodPurchaseAction  extends BaseAction{
	private static final long serialVersionUID = 1L;
	private WoodPurchaseService woodPurchaseService;
	private CommonConditionDto dto = new CommonConditionDto();
	public void setWoodPurchaseService(WoodPurchaseService woodPurchaseService) {
		this.woodPurchaseService = woodPurchaseService;
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
		Usermanager usermanager = WebUtil.getAdmin(null);
		 //dto.setInt_valueI(usermanager.getType());
		UserInfoDto udto = new  UserInfoDto();
		udto.setUsermanager(usermanager);
 		QueryResult<WoodPurchaseBean> qr = woodPurchaseService.searchList(udto ,dto, getPage(),PAGESIZE);
		savePageView(new PageView<WoodPurchaseBean>(qr, getPage(), PAGESIZE));
		WebUtil.setRequestValue("dto", dto);
		return SUCCESS;
	}

	/**
	 * 屏蔽,取消屏蔽方法
	 * @return
	 */
	public String shield(){
		String msg = CommonContent.MSG_OP_FAILE;
		if(null != dto.getInt_valueB() && dto.getInt_valueB() > 0 && dto.getInt_valueC() > -1) {
			WoodPurchaseBean bean = woodPurchaseService.searchById(dto.getInt_valueB());
			if(null != bean){
				bean.setStatus(dto.getInt_valueC());
				woodPurchaseService.update(bean);
				msg = CommonContent.MSG_OP_SUCCESS;
			}
		}
		super.saveMessage(msg, "nyt/woodPurchasesearch.action?dto.int_valueA="+dto.getInt_valueA());
		return MESSAGE;
	}
	
	/**
	 * 置顶,取消置顶
	 * @return
	 */
	public String sortTop(){
		String msg = CommonContent.MSG_OP_FAILE;
		if(null != dto.getInt_valueB() && dto.getInt_valueB() > 0 && dto.getInt_valueC() > -1) {
			WoodPurchaseBean bean = woodPurchaseService.searchById(dto.getInt_valueB());
			if(null != bean){
				bean.setOrderid(dto.getInt_valueC());
				woodPurchaseService.update(bean);
				msg = CommonContent.MSG_OP_SUCCESS;
			}
		}
		super.saveMessage(msg, "nyt/woodPurchasesearch.action?dto.int_valueA="+dto.getInt_valueA());
		return MESSAGE;
	}
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		String msg = CommonContent.MSG_OP_FAILE;
		if(null != dto.getInt_id() && dto.getInt_id() > -1) {
			woodPurchaseService.delete(dto.getInt_id());
			msg = CommonContent.MSG_OP_SUCCESS;
		}
		super.saveMessage(msg, "nyt/woodPurchasesearch.action?dto.int_valueA="+dto.getInt_valueA());
		return MESSAGE;
	}
	
	/**
	 * 详情
	 * @return
	 */
	public String detail(){
		if(null != dto.getInt_id() && dto.getInt_id() > -1) {
			WoodPurchaseBean vo = woodPurchaseService.searchById(dto.getInt_id());
				if(null != vo){
					WebUtil.setRequestValue("vo", vo);
					return SHOWRESULT;
				}
			}
			return INPUT;
		}
	 
}
