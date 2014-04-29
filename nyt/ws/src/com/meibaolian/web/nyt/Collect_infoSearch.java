package com.meibaolian.web.nyt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.dao.base.QueryResult;
import com.meibaolian.entity.Collect_infoEntity;
import com.meibaolian.entity.PurchaseInfo;
import com.meibaolian.entity.SupplyInfo;
import com.meibaolian.entity.VennerInfo;
import com.meibaolian.service.nyt.ICollect_infoService;
import com.meibaolian.service.nyt.IPurchaseInfoService;
import com.meibaolian.service.nyt.ISupplyService;
import com.meibaolian.service.nyt.IVennerInfoService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

/**
 * 我的收藏查询
 * @author Kawin
 *
 */
public class Collect_infoSearch extends BaseServlet {
 
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(Collect_infoSearch.class);

	private ICollect_infoService service;
	private IVennerInfoService vService;
	private ISupplyService sService;
	private IPurchaseInfoService pService;
	
	public void setService(ICollect_infoService service) {
		this.service = service;
	}
	
	public void setvService(IVennerInfoService vService) {
		this.vService = vService;
	}


	public void setsService(ISupplyService sService) {
		this.sService = sService;
	}


	public void setpService(IPurchaseInfoService pService) {
		this.pService = pService;
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int userid = UtilHelp.strToInt(request.getParameter("userid"));
		int page = UtilHelp.strToInt(request.getParameter("page"));
		int pageSize = UtilHelp.strToInt(request.getParameter("pageSize"));

		if (page <= 0)
			page = ConfigUtil.PAGE;
		if (pageSize <= 0)
			pageSize = ConfigUtil.PAGESIZE;

		//1供应 2求购
		int type = UtilHelp.strToInt(request.getParameter("type"));
		// 1桉木 2 胶合板 3 原木 4 淀粉
		int mtype = UtilHelp.strToInt(request.getParameter("mtype"));
	
		Collect_infoEntity vo = new Collect_infoEntity();
		vo.setUserid(userid);
		vo.setType(type);
		vo.setMtype(mtype);
	
		ResultType result = ResultType.SERVERFAIL;

		QueryResult<Collect_infoEntity> qr = null;
		try {
			//获得收藏数据的id
			qr = service.getCollect_infoBean(vo, page, pageSize);
			
			if (qr == null || qr.getList() == null
					|| qr.getList().size() == 0) {
				result = ResultType.NODATA;
			} else {//有收藏数据,根据id集合获得具体数据
				List<Collect_infoEntity> list = qr.getList(); 
				int ids[] = new int[list.size()];
				for (int i =0; i < list.size(); i++) {
					Collect_infoEntity bean = list.get(i);
					ids[i] = bean.getMid();
				} 
				
				if(1 == mtype){//1桉木, 直接根据ids查询
					List<VennerInfo> ls = vService.searchByIds(ids);
					WebUtil.outputMsgObjJson(response, ResultType.SUCCESS, page
							+ "", pageSize + "", qr.getCountNumber() + "",  ls);
					return;
				}else{ 
					if(type == 1){//供应
						List<SupplyInfo> ls = sService.searchByIds(ids);
						WebUtil.outputMsgObjJson(response, ResultType.SUCCESS, page
								+ "", pageSize + "", qr.getCountNumber() + "",  ls);
						return;
					}else{//求购
						List<PurchaseInfo> ls = pService.searchByIds(ids);
						WebUtil.outputMsgObjJson(response, ResultType.SUCCESS, page
								+ "", pageSize + "", qr.getCountNumber() + "",  ls);
						return;
					}
				}
			}
				
		} catch (DataManagerException e) {
			logger.error(e);
		}
		WebUtil.outputMsgJson(response, result);
	}

}
