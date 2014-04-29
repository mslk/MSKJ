package com.meibaolian.web.dictionary;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.meibaolian.entity.HelpCenterEntity;
import com.meibaolian.service.dictionary.IHelpCenterService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.exception.DataManagerException;
import com.meibaolian.web.base.BaseServlet;
import com.meibaolian.web.base.ResultType;
import com.meibaolian.web.base.WebUtil;

public class HelpCenter extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IHelpCenterService helpCenterService;

	public void setHelpCenterService(IHelpCenterService helpCenterService) {
		this.helpCenterService = helpCenterService;
	}

	Logger logger = Logger.getLogger(HelpCenter.class);

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 1 信息 2 物流 3 融资
		int type = UtilHelp.strToInt(request.getParameter("type"));

		List<HelpCenterEntity> list = null;

		if (type > 3 || type < 1) {
			type = 1;
		}

		try {
			list = helpCenterService.searchByType(type);
		} catch (DataManagerException e) {
			logger.error(e);
		}

		// if(type==1)
		// {
		// list.add(new
		// HelpCenterEntity("联系我们","http://192.168.1.66/mmbl/assets/message/contact.html"));
		// list.add(new
		// HelpCenterEntity("入市流程","http://192.168.1.66/mmbl/assets/message/market_processes.html"));
		// list.add(new
		// HelpCenterEntity("交易流程","http://192.168.1.66/mmbl/assets/message/transaction_processes.html"));
		// list.add(new
		// HelpCenterEntity("交收结算流程","http://192.168.1.66/mmbl/assets/message/settlement_processes1.html"));
		// list.add(new
		// HelpCenterEntity("融资服务","http://192.168.1.66/mmbl/assets/message/finance.html"));
		// list.add(new
		// HelpCenterEntity("榆林煤炭交易中心交易规则","http://192.168.1.66/mmbl/assets/message/transaction_rules.html"));
		//
		// }else if(type==2)
		// {
		//
		// list.add(new
		// HelpCenterEntity("BDI指数上升 因岬型船运费上涨","http://192.168.1.66/mmbl/assets/logistic/wuliu_1.html"));
		// list.add(new
		// HelpCenterEntity("南昌局积极应对电煤消耗高峰","http://192.168.1.66/mmbl/assets/logistic/wuliu_2.html"));
		// list.add(new
		// HelpCenterEntity("南宁铁路局煤炭运势逆势上涨","http://192.168.1.66/mmbl/assets/logistic/wuliu_3.html"));
		// list.add(new
		// HelpCenterEntity("太原铁路局8月1日增开","http://192.168.1.66/mmbl/assets/logistic/wuliu_4.html"));
		// list.add(new
		// HelpCenterEntity("质检服务","http://192.168.1.66/mmbl/assets/logistic/wuliu_5.html"));
		//
		// }else if(type==3)
		// {
		// list.add(new
		// HelpCenterEntity("仓库抵押融资","http://192.168.1.66/mmbl/assets/finance/rongzhi_1.html"));
		// list.add(new
		// HelpCenterEntity("结算服务","http://192.168.1.66/mmbl/assets/finance/rongzhi_2.html"));
		// list.add(new
		// HelpCenterEntity("买方实物抵押","http://192.168.1.66/mmbl/assets/finance/rongzhi_3.html"));
		// list.add(new
		// HelpCenterEntity("买方无抵押融资","http://192.168.1.66/mmbl/assets/finance/rongzhi_4.html"));
		// }
		WebUtil.outputMsgObjJson(response, ResultType.SUCCESS,ConfigUtil.IMAGEPREFIX ,list);
	}

}
