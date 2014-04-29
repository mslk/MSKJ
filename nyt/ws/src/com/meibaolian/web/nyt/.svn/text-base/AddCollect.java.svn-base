package com.meibaolian.web.nyt;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.Collect_infoEntity;
import com.meibaolian.service.nyt.ICollect_infoService;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;
/**
 * 添加我的收藏
 * @author Kawin
 *
 */
public class AddCollect extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(AddCollect.class);
	private ICollect_infoService service;
	
	public void setService(ICollect_infoService service) {
		this.service = service;
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int userid = UtilHelp.strToInt(req.getParameter("userid"));
		int mid = UtilHelp.strToInt(req.getParameter("mid"));
		int mtype = UtilHelp.strToInt(req.getParameter("mtype"));
		int type = UtilHelp.strToInt(req.getParameter("type"));
 
		Collect_infoEntity vo = new Collect_infoEntity();
		vo.setUserid(userid);
		vo.setMtype(mtype);
		vo.setType(type);
		vo.setMid(mid);
		vo.setAddtime(UtilHelp.dateFormatStr(new Date(),"yyyy-MM-dd HH:mm:ss"));
		//验证是否已存在
		int count = 0;
		try {
			boolean flag = service.isExist(vo);
			if(!flag){
				//添加到数据库
				count = service.add(vo);
			}else{
				WebUtil.outputMsgJson(resp, ResultType.DATAEXIST);
				logger.debug("收藏信息已存在！操作丢弃");
			}
		} catch (DataManagerException e) {
			logger.error("添加收藏失败！",e);
		}
		if(count > 0){
			WebUtil.outputMsgJson(resp, ResultType.SUCCESS);
			logger.debug("添加收藏成功");
		}else{
			WebUtil.outputMsgJson(resp, ResultType.SERVERFAIL);
			logger.debug("添加收藏失败！");
		}
	}
 
}
