package com.meibaolian.action.otheraid;

import java.io.File;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.file.FileUpHelp;

/**
 * 图片上传
 * 
 * @author Administrator
 * 
 */
public class UpFile extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 上传文件
	 */
	private File target;
	private String targetPath;
	private String targetContentType;
	private String targetFileName;
	// 上传类型 默认 1 ： 1 图片 2 apk
	private int type = 1;
	//apk 版本号
	private String version;
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

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

	@Override
	public String execute() throws Exception {
		String path = "";
		String message = "上传图片失败！";
		String targetUrl = "controller/otherAid/upFile.jsp";
		
		if (target != null) {
			
			if(type==1)
			{
				if(UtilHelp.validateImageFile(targetContentType))
				{
					path = FileUpHelp.upFile(target, targetFileName, 5);
				}
			}else 
			{
				 message = "上传apk失败！";
				 targetUrl = "controller/version/upFile.jsp";
				 int index=targetFileName.lastIndexOf(".");
				 if(index!=-1 && "apk".equalsIgnoreCase(targetFileName.substring(index+1)) && !"".equals(version))
				 {
					 path=FileUpHelp.upFile(target, targetFileName,"v"+version, 6);
				 }
			}
			
		}
		
		if (type==1&&path != null && !"".equals(path)) {
			message = "上传图片成功！ 图片地址为 ：   " + ConfigUtil.IMAGEPREFIX + path;
		}else if (type==2 && path != null && !"".equals(path)){
			message = "上传apk成功！ apk地址为 ：   " + ConfigUtil.IMAGEPREFIX + path;
		}
		
		saveMessage(message, targetUrl);
		return "messageBig";
	}

}
