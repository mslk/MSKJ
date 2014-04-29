package com.meibaolian.action.otheraid;

import java.sql.Timestamp;
import java.util.Date;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.QualityControl;
import com.meibaolian.service.otheraid.IQualityControlService;
import com.meibaolian.util.UtilHelp;
/**
 * 删除质检报告
 * @author llm
 *
 */
public class DelQualityControl extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IQualityControlService qualityControlService;
	
	private Integer id;
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setQualityControlService(
			IQualityControlService qualityControlService) {
		this.qualityControlService = qualityControlService;
	}


	/**
	 * 删除质检报告
	 * @return
	 */
	public String execute(){
		String msg = "删除质检报告信息失败！";
		if(id != null){
			int count = qualityControlService.delQualityControl(id);
			if(count > 0){
				msg = "删除质检报告信息成功！";
			}
		}else{
			msg = "参数异常！";
		}
		super.saveMessage(msg, null);
		return MESSAGE;
	}


	
}
