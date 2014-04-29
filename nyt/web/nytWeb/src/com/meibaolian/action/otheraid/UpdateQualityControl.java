package com.meibaolian.action.otheraid;

import java.sql.Timestamp;
import java.util.Date;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.entity.QualityControl;
import com.meibaolian.service.otheraid.IQualityControlService;
import com.meibaolian.util.UtilHelp;
/**
 * 修改质检报告
 * @author llm
 *
 */
public class UpdateQualityControl extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IQualityControlService qualityControlService;
	private Integer id;
	private QualityControl qualityControl;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public QualityControl getQualityControl() {
		return qualityControl;
	}


	public void setQualityControl(QualityControl qualityControl) {
		this.qualityControl = qualityControl;
	}


	public void setQualityControlService(
			IQualityControlService qualityControlService) {
		this.qualityControlService = qualityControlService;
	}
	
	public String initUpdate(){
		String msg = "参数异常！";
		if(id != null){
			QualityControl dbQC = qualityControlService.getById(id);
			if(dbQC != null){
				WebUtil.setRequestValue("qualityControl", dbQC);
				return SUCCESS;
			}else{
				msg = "此质检报告信息可能已被删除！";
			}
		}
		super.saveMessage(msg, null);
		return MESSAGE;
		
	}

	/**
	 * 修改质检报告
	 * @return
	 */
	public String execute(){
		String msg = "修改质检报告信息失败！";

		if(qualityControl != null && qualityControl.getId() != null && UtilHelp.isNotNullStr(qualityControl.getNumber())){
			
			qualityControl.setNumber(UtilHelp.trimStr(qualityControl.getNumber()));
//			qualityControl.setAddtime(new Timestamp(System.currentTimeMillis()));
			
			QualityControl dbQC = qualityControlService.getById(qualityControl.getId());
			if(dbQC != null ){
				boolean exist = false;
				if(!dbQC.getNumber().equals(qualityControl.getNumber())){
					exist = qualityControlService.existQualityControl(qualityControl.getNumber());
				}
				if(!exist){
					int count = qualityControlService.updateQualityControl(qualityControl);
					if(count > 0){
						msg = "修改质检报告信息成功！";
					}
				}else{
					msg = "此质检报告信息已存在！";
				}
			}else{
				msg = "此质检报告信息可能已被删除！";
			}
		}else{
			msg = "参数异常！";
		}
		super.saveMessage(msg, null);
		return MESSAGE;
	}


	
}
