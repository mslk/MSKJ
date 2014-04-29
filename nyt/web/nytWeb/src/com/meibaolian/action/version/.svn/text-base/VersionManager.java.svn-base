package com.meibaolian.action.version;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.log4j.Logger;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;

public class VersionManager extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	// 类型   1 android  2 ios
	private int type;
	
	//是否强制更新  0 否  1 是 
	private int isforce;
	
	private String version;
	
	private  String downurl;
	
	private String title;
	
	private String desc;
	
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

	public int getIsforce() {
		return isforce;
	}

	public void setIsforce(int isforce) {
		this.isforce = isforce;
	}

	public String getDownurl() {
		return downurl;
	}

	public void setDownurl(String downurl) {
		this.downurl = downurl;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	Logger logger=Logger.getLogger(VersionManager.class);
	
	
	public String update()
	{
		
		boolean isOk =false;
		String message="更新版本信息失败！";
		if((type==1 || type==2) && (isforce==0 ||isforce==1))
		{
			// ios 不能强制更新 所以 isforce=0
			if(type==2)
			{
				isforce=0;
			}
			StringBuilder builder=null;
			if(!"".equals(UtilHelp.notNullStr(version))
					&& !"".equals(UtilHelp.notNullStr(downurl))
					&& !"".equals(UtilHelp.notNullStr(title))
					&& !"".equals(UtilHelp.notNullStr(desc)))
			{
				builder=new StringBuilder();
				builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
				builder.append("<mythlink>");
				builder.append("<version>").append(version.trim()).append("</version>");
				builder.append("<isforce>").append(isforce).append("</isforce>");
				builder.append("<downurl><![CDATA[").append(downurl.trim()).append("]]></downurl>");
				builder.append("<title><![CDATA[").append(title.trim()).append("]]></title>");
				builder.append("<desc><![CDATA[").append(desc.trim()).append("]]></desc>");
				builder.append("</mythlink>");
			}
			
			
			if(builder!=null)
			{
				OutputStream output=null;
				try {
					File filePath=new File(ConfigUtil.FILEROOTPATH+"/manual/version/");
					if(!filePath.exists()){ filePath.mkdirs();}
					File  file=null;
					if(type==1)
					{ 
						file=new File(filePath,"android.xml");
					}else{
						file=new File(filePath,"ios.xml");
					}
					if(file!=null)
					{
						output=new BufferedOutputStream(new FileOutputStream(file));
						output.write(builder.toString().getBytes());
						isOk=true;
					}
				} catch (FileNotFoundException e) {
					logger.error("更新版本xml错误！" ,e);
				} catch (IOException e) {
					logger.error("更新版本xml错误！" ,e);
				}finally{
					
					try {
						if(output!=null)
						{
						output.close();	
						}
					} catch (IOException e) {
						logger.error("关闭输出流错误！" ,e);
					}
				}
			}
		}
		
		if(isOk)
		{
			message="更新版本信息成功！";
		}
		saveMessage(message, "controller/version/list.jsp");
	 return MESSAGE;	
	}

}
