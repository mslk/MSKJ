package com.meibaolian.web.nyt;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.VennerInfo;
import com.meibaolian.service.nyt.IVennerInfoService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

public class AddVennerInfo extends BaseServlet{
	private static final long serialVersionUID = 1L;

	Logger logger =Logger.getLogger(AddVennerInfo.class);
	
	 IVennerInfoService vennerInfoService;


	public void setVennerInfoService(IVennerInfoService vennerInfoService) {
		this.vennerInfoService = vennerInfoService;
	}







	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int userid = UtilHelp.strToInt(req.getParameter("userid"));
		String length=UtilHelp.strNotNull(req.getParameter("length"));
		String width=UtilHelp.strNotNull(req.getParameter("width"));
		String thicknessint=UtilHelp.strNotNull(req.getParameter("thicknessint"));
		BigDecimal average_thickness = UtilHelp.strToBigDecimal(req.getParameter("average_thickness"));
		String level=UtilHelp.strNotNull(req.getParameter("level"));
		String reference=UtilHelp.strNotNull(req.getParameter("reference"));
		String panel=UtilHelp.strNotNull(req.getParameter("panel"));
		String hole_panel=UtilHelp.strNotNull(req.getParameter("hole_panel"));
		String moisture=UtilHelp.strNotNull(req.getParameter("moisture"));
		String bark=UtilHelp.strNotNull(req.getParameter("bark"));
		String mildew=UtilHelp.strNotNull(req.getParameter("mildew"));
		String lead_time=UtilHelp.strNotNull(req.getParameter("lead_time"));
		int number = UtilHelp.strToInt(req.getParameter("number"));
		BigDecimal price = UtilHelp.strToBigDecimal(req.getParameter("price"));
		String valid=UtilHelp.strNotNull(req.getParameter("valid"));
		String described=UtilHelp.strNotNull(req.getParameter("described"));
		int type = UtilHelp.strToInt(req.getParameter("type"));
	
		if("".equals(length)||"".equals(width)||"".equals(thicknessint)||average_thickness.compareTo(BigDecimal.ZERO)<=0
		       ||"".equals(level)
				||"".equals(reference)||"".equals(panel)||"".equals(hole_panel)||"".equals(moisture)||"".equals(bark)||"".equals(mildew)
				||"".equals(lead_time)||number<=0||price.compareTo(BigDecimal.ZERO)<=0||"".equals(valid))
		{
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，发布失败！");
			return;
		}
		boolean validboolen=UtilHelp.isDateValid(valid);
		// 验证参数, || UtilHelp.isNullStr(phone)
		if(validboolen==false ||type <= 0 || type < 0 ){
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，发布失败！");
			return;
		}
		
		// 封装客户数据
		VennerInfo vennerInfo = new VennerInfo(userid, length, width,
				 thicknessint, average_thickness,level,
				 reference, panel, hole_panel,
				 moisture,bark, mildew,lead_time,
				number,price,valid,described,type);
		//验证是否已存在
		int count = 0;
		//添加到数据库
		try{
		count = vennerInfoService.addVennerInfo(vennerInfo);
		if(count > 0){
			WebUtil.outputMsgJson(resp, ResultType.SUCCESS);
			logger.debug("发布按木供应信息成功");
		}else{
			WebUtil.outputMsgJson(resp, ResultType.SERVERFAIL);
			logger.debug("发布按木供应信息失败！");
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
