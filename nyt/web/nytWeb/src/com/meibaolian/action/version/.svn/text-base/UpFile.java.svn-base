package com.meibaolian.action.version;

import java.io.File;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.file.FileUpHelp;

/**
 * apk上传
 * @author Administrator
 *
 */
public class UpFile extends BaseAction 
{

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
	public String execute() throws Exception 
	{
		String path="";
		if(target!=null && UtilHelp.validateImageFile(targetContentType))
		{
			path=FileUpHelp.upFile(target, targetFileName, 5);
		}
		String message="上传图片失败！";
		String targetUrl="controller/otherAid/upFile.jsp";
		if(path!=null && !"".equals(path) )
		{
			message="上传图片成功！ 图片地址为 ：   " +ConfigUtil.IMAGEPREFIX+path;
		}
		saveMessage(message, targetUrl);
		return "messageBig";
	}
	

}
