package com.meibaolian.web.nyt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.SupplyInfo;
import com.meibaolian.service.nyt.impl.SupplyService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

/**
 * 个人胶合板、原木、淀粉的供应修改
 * @author Kawin
 *
 */
public class UpdateNytMySupply extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	SupplyService supplyService;
	
	public void setSupplyService(SupplyService supplyService) {
		this.supplyService = supplyService;
	}

	Logger logger=Logger.getLogger(UpdateNytMySupply.class); 

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int userid = UtilHelp.strToInt(request.getParameter("userid"));
		int id = UtilHelp.strToInt(request.getParameter("id"));

		int number = UtilHelp.strToInt(request.getParameter("number"));
		int price = UtilHelp.strToInt(request.getParameter("price"));
		// 2 胶合板 3 原木 4 淀粉
		int type = UtilHelp.strToInt(request.getParameter("type"));
		String valid = UtilHelp.strNotNull(request.getParameter("valid"));
		String description = UtilHelp.strNotNull(request.getParameter("description"));

		SupplyInfo supply=null;
		if (number > 0
				&& price > 0
				&& UtilHelp.isDateValid(valid)
				&& (description == null || (description != null && description.length() <= 500))) {

			supply=new SupplyInfo();
			supply.setId(id);
			supply.setUserid(userid);
			supply.setPrice(price);;
			supply.setNumber(number);
			supply.setType(type);
			supply.setDescription(UtilHelp.strNotNull(description));
			
			supply.setValid(valid);
			
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

					supply.setWidth(width);
					supply.setLength(length);
					supply.setThickness(thickness);
					
				}else
				{
					supply=null;
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
					supply.setLength(length);
					supply.setCultivated(cultivated);
					supply.setTailDirectly(tail_directly);
					supply.setUnit(unit);
					
				}else
				{
					supply=null;
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
					supply.setBrand(brand);
					supply.setLevel(level);
					supply.setProducer(producer);
					
				}else
				{
					supply=null;
				}
				
			}

		}

		ResultType result = ResultType.SERVERFAIL;
		
		if(supply!=null)
		{
			try {
				if(supplyService.update(supply)==1)
				{
					result=ResultType.SUCCESS;
				}
			} catch (Exception e) {
				logger.error(e);
			}
		
			
		}else
		{
		result = ResultType.PARAMTER;
		}

		
		WebUtil.outputMsgJson(response, result);
	}

}
