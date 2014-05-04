package com.meibaolian.web.nyt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.service.nyt.ICollect_infoService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 删除我的收藏
 * @author llm
 *
 */
public class DelCollect  extends BaseServlet {
 
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(DelCollect.class);
	private ICollect_infoService service;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int id = UtilHelp.strToInt(req.getParameter("id"));
		// 验证参数
		if (id <= 0 ) {
			WebUtil.outputMsgJson(resp, ResultType.PARAMTER);
			logger.debug("参数异常，删除我的收藏信息失败！");
			return;
		}
		// 删除数据
		int count = 0;
		count = service.del(id);
		if (count <= 0) {
			WebUtil.outputMsgJson(resp, ResultType.SERVERFAIL);
			logger.debug("id:" + id + "，数据库操作失败，删除我的收藏信息失败！");
		} else {
			WebUtil.outputMsgJson(resp, ResultType.SUCCESS);
			logger.debug("id:" + id + "，删除我的收藏信息成功！");
		}
	}

	public void setService(ICollect_infoService service) {
		this.service = service;
	}
}
