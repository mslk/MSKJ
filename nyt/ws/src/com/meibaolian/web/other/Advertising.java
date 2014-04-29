package com.meibaolian.web.other;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.AdvertisingEntity;
import com.meibaolian.service.other.IAdvertisingService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

public class Advertising extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	IAdvertisingService advertisingService;

	public void setAdvertisingService(IAdvertisingService advertisingService) {
		this.advertisingService = advertisingService;
	}

	Logger logger=Logger.getLogger(Advertising.class);


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int type=UtilHelp.strToInt(request.getParameter("type"));
		
		if(type!=1 && type!=2)
		{
			type=1;
		}
		
		ResultType resultType=ResultType.SERVERFAIL;
		String imageUrl=null;
		String targetUrl=null;
		try {
			AdvertisingEntity  entity=advertisingService.getAdvertising(type);
			if(entity!=null)
			{
				imageUrl=ConfigUtil.IMAGEPREFIX+entity.getImageurl().trim();
				targetUrl=entity.getTargeturl().trim();
				resultType=ResultType.SUCCESS;
			}
			 
		} catch (DataManagerException e) {
          logger.error(e);
		}
		WebUtil.outputMsgObjJson(response, resultType,imageUrl, targetUrl,"","");
	}
	
	
	
	

}
