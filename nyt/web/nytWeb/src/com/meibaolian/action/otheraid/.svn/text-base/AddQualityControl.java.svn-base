package com.meibaolian.action.otheraid;

import java.sql.Timestamp;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.QualityControl;
import com.meibaolian.service.otheraid.IQualityControlService;
import com.meibaolian.util.UtilHelp;
/**
 * 添加质检报告
 * @author llm
 *
 */
public class AddQualityControl extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IQualityControlService qualityControlService;
	
	private QualityControl qualityControl;
	
	
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


	/**
	 * 添加质检报告
	 * @return
	 */
	public String add(){
		String msg = "添加质检报告信息失败！";

		if(qualityControl != null && UtilHelp.isNotNullStr(qualityControl.getNumber())){
			
			boolean exist = qualityControlService.existQualityControl(qualityControl.getNumber());
			if(!exist){
				qualityControl.setNumber(UtilHelp.trimStr(qualityControl.getNumber()));
				qualityControl.setAddtime(new Timestamp(System.currentTimeMillis()));
				
				int count = qualityControlService.addQualityControl(qualityControl);
				if(count> 0){
					msg = "添加质检报告信息成功！";
				}
			}else{
				msg = "此质检报告信息已存在！";
			}
		}else{
			msg = "参数异常！";
		}
		super.saveMessage(msg, null);
		return MESSAGE;
	}


	
}
