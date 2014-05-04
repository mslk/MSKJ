package com.meibaolian.action.otheraid;

import java.io.File;
import java.util.Date;

import org.apache.log4j.Logger;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.entity.Advertising;
import com.meibaolian.service.otheraid.IAdvertisingService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.file.FileUpHelp;

public class AdvertisingManager extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IAdvertisingService advertisingService;

	public void setAdvertisingService(IAdvertisingService advertisingService) {
		this.advertisingService = advertisingService;
	}

	// 广告id
	private int advId;
	// 广告地址
	private String targetUrl;

	private File image;// 发送对象
	private String imagePath;
	private String imageContentType;
	private String imageFileName;

	public int getAdvId() {
		return advId;
	}

	public void setAdvId(int advId) {
		this.advId = advId;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	
	Logger logger=Logger.getLogger(AdvertisingManager.class);

	/**
	 * 跳转至 修改页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String toUpdate() throws Exception {
		Advertising advertising = null;
		if (advId > 0) {
			advertising = advertisingService.getById(advId);
		}

		String message = " 没有找到相关数据！";
		String targetUrl = "otherAid/advertisingShow.action";
		String result = MESSAGE;

		if (advertising != null) {
			result = "update";
			savePageObj(advertising);
		} else {
			saveMessage(message, targetUrl);
		}

		return result;
	}
	/**
	 * 导入缺失数据接口
	 * 
	 * @return
	 * @throws Exception
	 */
	public String implortDefaultData() throws Exception {
		
		advertisingService.addDefaultAdvertising();
		String message = " 导入广告数据成功！";
		String targetUrl = "otherAid/advertisingShow.action";
		String result = MESSAGE;
		saveMessage(message, targetUrl);
		
		return result;
	}

	/**
	 * 修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {

		String messageValue = " 修改失败！";
		String targetUrlValue = "otherAid/advertisingShow.action";

		if (advId > 0) {
			Advertising advertising = advertisingService.getById(advId);

			if (advertising != null) {
				
				String imageUrl = "";
				logger.debug("image imageContentType:"+imageContentType);
				if (image != null && UtilHelp.validateImageFile(imageContentType)) 
				{
					imageUrl = FileUpHelp.upFile(image,imageFileName, 4);
				}
				
				logger.debug("image url:"+imageUrl);
			   	
			  if(targetUrl!=null && !"".equals(targetUrl))
			  {
				  advertising.setTargeturl(targetUrl);
			  }
			  
			  if(imageUrl!=null && !"".equals(imageUrl))
			  {
				  advertising.setImageurl(imageUrl);
			  }
			  advertising.setAddtime(new Date());
			  advertisingService.updateAdvertising(advertising);
			  messageValue = " 修改成功！";
			}

			saveMessage(messageValue, targetUrlValue);
		}
		return MESSAGE;
	}

}
