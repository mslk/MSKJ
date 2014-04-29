package com.meibaolian.action.otheraid;

import java.io.File;
import java.util.Date;

import org.apache.log4j.Logger;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.HelpCenter;
import com.meibaolian.service.otheraid.imple.HelpCenterService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.file.FileUpHelp;

public class HelpCenterManager extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HelpCenterService helpCenterService;

	private HelpCenter helpCenter;

	public void setHelpCenterService(HelpCenterService helpCenterService) {
		this.helpCenterService = helpCenterService;
	}

	public HelpCenter getHelpCenter() {
		return helpCenter;
	}

	public void setHelpCenter(HelpCenter helpCenter) {
		this.helpCenter = helpCenter;
	}

	/**
	 * 上传文件
	 */
	private File target;
	private String targetPath;
	private String targetContentType;
	private String targetFileName;

	public File getTarget() {
		return target;
	}

	public void setTarget(File target) {
		this.target = target;
	}

	public String getTargetPath() {
		return targetPath;
	}

	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}

	public String getTargetContentType() {
		return targetContentType;
	}

	public void setTargetContentType(String targetContentType) {
		this.targetContentType = targetContentType;
	}

	public String getTargetFileName() {
		return targetFileName;
	}

	public void setTargetFileName(String targetFileName) {
		this.targetFileName = targetFileName;
	}
	
	Logger logger=Logger.getLogger(AdvertisingManager.class);

	/**
	 * 跳转到修改页面
	 * 
	 * @return
	 */
	public String toUpdate() {
		HelpCenter helpCenterV = null;

		if (helpCenter != null && helpCenter.getId() > 0) {
			helpCenterV = helpCenterService.getById(helpCenter.getId());
		}
		String message = " 没有找到相关数据！";
		String targetUrl = "otherAid/helpCenterShow.action";
		String result = MESSAGE;

		if (helpCenter != null) {
			result = "update";
			savePageObj(helpCenterV);
		} else {
			saveMessage(message, targetUrl);
		}

		return result;
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	public String update() {
		HelpCenter helpCenterV = null;

		String message = " 修改失败！";
		String targetUrl = "otherAid/helpCenterShow.action";
		

		if (helpCenter != null && helpCenter.getId() > 0) {
			helpCenterV = helpCenterService.getById(helpCenter.getId());

			if (helpCenterV != null) {
				if (helpCenter.getTitle() != null
						&& !"".equals(helpCenter.getTitle())) {
					helpCenterV.setTitle(helpCenter.getTitle());
				}
				String targetNewUrl = "";
				if (target != null && UtilHelp.validateHtmlFile(targetContentType)) {
					targetNewUrl = FileUpHelp.upFile(target, targetFileName,
							helpCenter.getType());
					if (targetNewUrl != null && !"".equals(targetNewUrl)) {
						helpCenterV.setTargeturl(targetNewUrl);
					}
				}
				helpCenterService.update(helpCenterV);
				message = " 修改成功！";
			}

		}

		saveMessage(message, targetUrl);
		return MESSAGE;
	}

	/**
	 * 增加
	 * 
	 * @return
	 */
	public String add() {
		String message = " 增加帮助信息失败！";
		String targetUrl = "otherAid/helpCenterShow.action";
        
		
		logger.debug("targetContentType :" +targetContentType);
		if (helpCenter!=null && helpCenter.getTitle() != null && !"".equals(helpCenter.getTitle())
			&& helpCenter.getType()>=1 && helpCenter.getType()<=3 	&& target != null
			&& UtilHelp.validateHtmlFile(targetContentType)) {
			logger.debug("helpCenter.getTitle() :" +helpCenter.getTitle());
			logger.debug("helpCenter.getType :" +helpCenter.getType());
			logger.debug("target :" +target);
			String targetNewUrl = "";
			targetNewUrl = FileUpHelp.upFile(target, targetFileName,
					helpCenter.getType());
			logger.debug("targetNewUrl :" +targetNewUrl);
			if (targetNewUrl != null && !"".equals(targetNewUrl)) {
				helpCenter.setTargeturl(targetNewUrl);
				helpCenter.setAddtime(new Date());
				helpCenterService.add(helpCenter);
				message = " 增加帮助信息成功！";
			}
			

		} else {
			
			message="增加帮助信息，提交信息不完整！";
		}

		saveMessage(message, targetUrl);
		return MESSAGE;
	}
	
	/**
	 * 删除
	 * 
	 * @return
	 */
	public String delete() {
		String message = " 删除信息失败！";
		String targetUrl = "otherAid/helpCenterShow.action";
		if (helpCenter!=null && helpCenter.getId() > 0 ) {
			helpCenterService.delete(helpCenter.getId());
			message = " 删除信息成功！";
			
		} 
		saveMessage(message, targetUrl);
		return MESSAGE;
	}

}
