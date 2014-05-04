package com.meibaolian.web.nyt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.PurchaseInfo;
import com.meibaolian.service.nyt.impl.PurchaseInfoService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.NoParameterException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

public class AddPurchase extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	PurchaseInfoService purchaseInfoService;
	
	public void setPurchaseInfoService(PurchaseInfoService purchaseInfoService) {
		this.purchaseInfoService = purchaseInfoService;
	}

	Logger logger=Logger.getLogger(AddPurchase.class); 

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int userid = UtilHelp.strToInt(request.getParameter("userid"));

		int number = UtilHelp.strToInt(request.getParameter("number"));
		int price = UtilHelp.strToInt(request.getParameter("price"));
		// 2 胶合板 3 原木 4 淀粉
		int type = UtilHelp.strToInt(request.getParameter("type"));
		String valid = UtilHelp.strNotNull(request.getParameter("valid"));
		String description = UtilHelp.strNotNull(request.getParameter("description"));

		PurchaseInfo purchaseInfo=null;
		if (number > 0
				&& price > 0
				&& UtilHelp.isDateValid(valid)
				&& (description == null || (description != null && description.length() <= 500))) {

			purchaseInfo=new PurchaseInfo();
			purchaseInfo.setUserid(userid);
			purchaseInfo.setPrice(price);;
			purchaseInfo.setNumber(number);
			purchaseInfo.setType(type);
			purchaseInfo.setDescription(UtilHelp.strNotNull(description));
			
			purchaseInfo.setValid(valid);
			
			if (type == 2) {
				// 胶合板
				String length = UtilHelp.strNotNull(request
						.getParameter("length"));
				String width = UtilHelp.strNotNull(request
						.getParameter("width"));
				String thickness = UtilHelp.strNotNull(request
						.getParameter("thickness"));
				if (!"".equals(length) && !"".equals(width)
						&& !"".equals(thickness)) {

					purchaseInfo.setWidth(width);
					purchaseInfo.setLength(length);
					purchaseInfo.setThickness(thickness);
					
				}else
				{
					purchaseInfo=null;
				}

			} else if (type == 3) {
				// 原木
				String length = UtilHelp.strNotNull(request
						.getParameter("length"));
				String cultivated = UtilHelp.strNotNull(request
						.getParameter("cultivated"));
				String tail_directly = UtilHelp.strNotNull(request
						.getParameter("tail_directly"));
				int unit = UtilHelp.strToInt(request.getParameter("unit"));
				
				if(!"".equals(cultivated)&& !"".equals(length)  && !"".equals(tail_directly) && (unit==1 ||unit==2) )
				{
					purchaseInfo.setLength(length);
					purchaseInfo.setCultivated(cultivated);
					purchaseInfo.setTailDirectly(tail_directly);
					purchaseInfo.setUnit(unit);
					
				}else
				{
					purchaseInfo=null;
				}
				

			} else if (type == 4) {
				// 淀粉
				String brand = UtilHelp.strNotNull(request
						.getParameter("brand"));
				Integer level = UtilHelp.strToInt(request
						.getParameter("level"));
				String producer = UtilHelp.strNotNull(request
						.getParameter("producer"));
				
				if(!"".equals(brand) && level>=1 && level<=3 && !"".equals(producer) )
				{
					purchaseInfo.setBrand(brand);
					purchaseInfo.setLevel(level);
					purchaseInfo.setProducer(producer);
					
				}else
				{
					purchaseInfo=null;
				}
				
			}

		}

		ResultType result = ResultType.SERVERFAIL;
		
		if(purchaseInfo!=null)
		{
			try {
				if(purchaseInfoService.add(purchaseInfo)==1)
				{
					result=ResultType.SUCCESS;
				}
			} catch (NoParameterException e) {
				logger.error(e);
			}
		
			
		}else
		{
		result = ResultType.PARAMTER;
		}

		
		WebUtil.outputMsgJson(response, result);
	}

}
