package com.meibaolian.web.base;

import java.io.IOException;
import java.util.Map;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.meibaolian.entity.log.LogModule;
import com.meibaolian.entity.log.LogModuleUtil;
import com.meibaolian.service.log.ILogService;
import com.meibaolian.util.UtilHelp;

/**
 * servlet 代理类
 * 
 * @author Administrator
 * 
 */
public class ServletProxy extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String targetBean;

	private Servlet proxy;

	static ILogService logService;

	@Override
	public void init() throws ServletException {
		this.targetBean = getInitParameter("targetBean");
		getServletBean();
		proxy.init(getServletConfig());

	}

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		proxy.service(request, response);

		try {
			addLog((HttpServletRequest) request);
		} catch (Exception e) {

		}

	}

	public static void addLog(HttpServletRequest request) {
		int userid = UtilHelp.strToInt(request.getParameter("userid"));
		String requestURI = request.getRequestURI();

		if (requestURI == null || "".equals(requestURI)) {
			return;
		}

		LogModule logModule = null;
		if (requestURI.indexOf("/userLogin") != -1) {
			logModule = LogModuleUtil.USER_LOGIN;
		} else if (requestURI.indexOf("/app/userPerfectInfo") != -1) {
			// 用户完善信息接口
			logModule = LogModuleUtil.USER_COMPLETE;
		} else if (requestURI.indexOf("/userUpdatePwd") != -1) {
			// 用户修改密码接口
			logModule = LogModuleUtil.USER_UPDATEPWD;
		} else if (requestURI.indexOf("/app/user/userUpdateContects") != -1) {
			// 修改用户信息接口
			logModule = LogModuleUtil.USER_UPDATE;
		} else if (requestURI.indexOf("/dict/helpCenter") != -1) {
			int type = UtilHelp.strToInt(request.getParameter("type"));
			if (type == 1) {
				// 新闻
				logModule = LogModuleUtil.NEW_SEARCH;
			} else if (type == 2) {
				// 服务
				logModule = LogModuleUtil.SERVICE_SEARCH;
			}

		}

		else if (requestURI.indexOf("/purchase") != -1) {

			if (requestURI.indexOf("/purchase/searchPurchase") != -1
					|| requestURI.indexOf("/purchase/searchByKey") != -1
					|| requestURI.indexOf("/purchase/searchByPlace") != -1) {
				// 查询求购单
				logModule = LogModuleUtil.PURCHASE_SEARCH;
			} else if (requestURI.indexOf("/app/purchase/delPurchase") != -1) {
				// 删除求购单
				logModule = LogModuleUtil.PURCHASE_DELETE;
			} else if (requestURI.indexOf("/app/purchase/renewPurchase") != -1) {
				// 重新发布求购单
				logModule = LogModuleUtil.PURCHASE_UPDATE;
			} else if (requestURI.indexOf("/app/purchase/newPurchase") != -1) {
				// 发布求购单
				logModule = LogModuleUtil.PURCHASE_ADD;
			}

		} else if (requestURI.indexOf("/app/userProposal") != -1) {
			// 用户投诉接口
			logModule = LogModuleUtil.USER_ROPOSAL;
		} else if (requestURI.indexOf("/dict/qualityControl") != -1) {
			// 煤炭检测查询接口
			logModule = LogModuleUtil.QUALITY_SEARCH;
		} else if (requestURI.indexOf("/provider") != -1) {

			if (requestURI.indexOf("/provider/searchProvider") != -1
					|| requestURI.indexOf("/provider/searchByKey") != -1) {
				// 查询供应单
				logModule = LogModuleUtil.PROVIDER_SEARCH;
			} else if (requestURI.indexOf("/app/provider/delProvider") != -1) {
				// 删除供应单
				logModule = LogModuleUtil.PROVIDER_DELETE;
			} else if (requestURI.indexOf("/app/provider/renewProvider") != -1) {
				// 重新发布供应单
				logModule = LogModuleUtil.PROVIDER_UPDATE;
			} else if (requestURI.indexOf("/app/provider/newProvider") != -1) {
				// 发布供应单
				logModule = LogModuleUtil.PROVIDER_ADD;
			}

		} else if (requestURI.indexOf("/transportSupply") != -1) {
			if (requestURI.indexOf("/transportSupply/searchByKey") != -1
					|| requestURI.indexOf("/transportSupply/searchByPlace") != -1) {
				// 关键字查询车讯
				logModule = LogModuleUtil.TRANSPORTSUPPLY_SEARCH;

			} else if (requestURI
					.indexOf("/app/transportSupply/delTransportSupply") != -1) {
				// 删除车讯
				logModule = LogModuleUtil.TRANSPORTSUPPLY_DELETE;
			} else if (requestURI
					.indexOf("/app/transportSupply/renewTransportSupply") != -1) {
				// 重新发布车讯
				logModule = LogModuleUtil.TRANSPORTSUPPLY_UPDATE;
			} else if (requestURI
					.indexOf("/app/transportSupply/newTransportSupply") != -1) {
				// 发布车讯
				logModule = LogModuleUtil.TRANSPORTSUPPLY_ADD;
			}

		} else if (requestURI.indexOf("/transportDemand") != -1) {
			if (requestURI.indexOf("/transportDemand/searchByKey") != -1
					|| requestURI.indexOf("/transportDemand/searchByPlace") != -1) {
				// 关键字查询货讯
				logModule = LogModuleUtil.TRANSPORTDEMAND_SEARCH;
			} else if (requestURI
					.indexOf("/app/transportDemand/delTransportDemand") != -1) {
				// 删除货讯
				logModule = LogModuleUtil.TRANSPORTDEMAND_DELETE;
			} else if (requestURI
					.indexOf("/app/transportDemand/renewTransportDemand") != -1) {
				// 重新发布货讯
				logModule = LogModuleUtil.TRANSPORTDEMAND_UPDATE;
			} else if (requestURI
					.indexOf("/app/transportDemand/newTransportDemand") != -1) {
				// 发布货讯
				logModule = LogModuleUtil.TRANSPORTDEMAND_ADD;
			}

		} else if (requestURI.indexOf("/customer") != -1) {
			int customertype = UtilHelp.strToInt(request
					.getParameter("customertype"));

			if (requestURI.indexOf("/customer/getCustomer") != -1) {
				// 获取我的客户列表
				// 0 供应商
				// 1 采购商
				// 3 物流商

				if (customertype == 0) {
					logModule = LogModuleUtil.MYSUPPLIER_SEARCH;
				} else if (customertype == 1) {
					logModule = LogModuleUtil.MYBUYERS_SEARCH;
				} else if (customertype == 3) {
					logModule = LogModuleUtil.MYLOGISTICS_SEARCH;
				}

			} else if (requestURI.indexOf("/app/customer/delCustomer") != -1) {
				// 删除我的客户信息
				if (customertype == 0) {
					logModule = LogModuleUtil.MYSUPPLIER_DELETE;
				} else if (customertype == 1) {
					logModule = LogModuleUtil.MYBUYERS_DELETE;
				} else if (customertype == 3) {
					logModule = LogModuleUtil.MYLOGISTICS_DELETE;
				}
			} else if (requestURI.indexOf("/app/customer/addCustomer") != -1) {
				// 添加我的客户
				if (customertype == 0) {
					logModule = LogModuleUtil.MYSUPPLIER_ADD;
				} else if (customertype == 1) {
					logModule = LogModuleUtil.MYBUYERS_ADD;
				} else if (customertype == 3) {
					logModule = LogModuleUtil.MYLOGISTICS_ADD;
				}
			}
		}

		if (logModule != null) {
			String content = getAllParament(request);
			logService.addModuleLog(userid, content, logModule);
		}

	}

	private static String getAllParament(HttpServletRequest request) {

		StringBuilder builder = new StringBuilder();
		;
		try {
			Map<String, String[]> map = request.getParameterMap();

			for (String key : map.keySet()) {
				String[] values = map.get(key);
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						builder.append(key + "-" + i + " : " + values[i])
								.append(";");
					}
				}
			}
		} catch (RuntimeException e) {
		}
		return builder.toString();
	}

	private void getServletBean() {
		WebApplicationContext wac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletContext());
		this.proxy = (Servlet) wac.getBean(targetBean);
		if (logService == null) {
			logService = (ILogService) wac.getBean("logService");
		}
	}

}
