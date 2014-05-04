package com.meibaolian.action.userInfo;

import java.util.List;

import com.meibaolian.action.base.BaseAction;
import com.meibaolian.action.base.WebUtil;
import com.meibaolian.entity.UserInfo;
import com.meibaolian.entity.Usermanager;
import com.meibaolian.service.user.IUserManagerService;
import com.meibaolian.service.userInfo.IUserInfoService;
import com.meibaolian.util.ConfigUtil;
import com.meibaolian.util.UtilHelp;
import com.meibaolian.util.redis.DataToRedis;

public class Update extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IUserInfoService userInfoService;
	private IUserManagerService userManagerService;

	private Integer id;

	private UserInfo userInfo;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String update() {
		String message = "修改客户信息失败！";
		if (userInfo != null){
			UserInfo vo = userInfoService.getUserInfo(userInfo.getId());
			if (vo != null) {
				vo.setPassword(userInfo.getPassword());
				vo.setRealname(userInfo.getRealname());
				vo.setCompanyname(userInfo.getCompanyname());
				vo.setAddress(userInfo.getAddress());
				vo.setLevel(userInfo.getLevel());
				vo.setStatus(userInfo.getStatus());
				Usermanager um = userInfo.getUsermanager();
				vo.setUsermanager(um);
				
				userInfoService.updateUser(vo);
				message = "修改客户信息成功！";
			}
		}
		saveMessage(message, "userInfo/search.action");
		return MESSAGE;
	}
	/**
	 * 修改 客户端用户信息
	 * 
	 * @return
	 */
/*	public String update() {
		String message = "修改客户信息失败！";
		// 1 条件满足 交易商字段 2 满足物流商
		int isSub = 0;

		if (userInfo != null && userInfo.getType() != 100) {
			UserInfo userData = userInfoService.getUserInfo(userInfo.getId());

			if (userData != null) {
				
				if (!"".equals(UtilHelp.notNullStr(userInfo.getPassword()))
						&& userInfo.getPassword().length() >= 4
						&& userInfo.getPassword().length() <= 16
						&& !"".equals(UtilHelp.notNullStr(userInfo
								.getRealname()))
						&& !"".equals(UtilHelp.notNullStr(userInfo
								.getCompanyname()))
//						&& null != userInfo.getStatus()
//						&& (userInfo.getStatus() == 0 || userInfo.getStatus() == 2)
						) {
					userData.setPassword(userInfo.getPassword().toLowerCase());
					userData.setRealname(userInfo.getRealname());
					userData.setCompanyname(userInfo.getCompanyname());
//					userData.setStatus(userInfo.getStatus());

					if (userData.getType() != 100) {
						isSub = 1;
					}
				}

				if (!"".equals(UtilHelp.notNullStr(userInfo.getAddress()))) {
					userData.setAddress(userInfo.getAddress());
				}

				if (isSub == 1 && userData.getType() == 3) {
					if (!"".equals(UtilHelp.notNullStr(userInfo.getCardid()))
							&& !"".equals(UtilHelp.notNullStr(userInfo
									.getCarnumber()))
							&& !"".equals(UtilHelp.notNullStr(userInfo
									.getEngine()))
							&& !"".equals(UtilHelp.notNullStr(userInfo
									.getFrame()))) {
						userData.setCardid(userInfo.getCardid());
						userData.setCarnumber(userInfo.getCarnumber());
						userData.setEngine(userInfo.getEngine());
						userData.setFrame(userInfo.getFrame());
						isSub = 2;
					}
				}

				if (userData.getType() != 100 && (isSub == 1 || isSub == 2)) {
					userInfoService.updateUser(userData);
					message = "修改客户信息成功！";
				}
			}
		}
		saveMessage(message, "userInfo/search.action");
		return MESSAGE;
	}*/

	public String toEdit() {
		String msg = "不存在此信息！";
		String targetUrl = MESSAGE;
		UserInfo userInfo = null;
		if (id != null) {
			userInfo = userInfoService.getUserInfo(id);
		}

		if (userInfo != null) {
			savePageObj(userInfo);
			List<Usermanager> usermanagers = userManagerService.searchAll();
			WebUtil.setRequestValue("usermanagers", usermanagers);
			WebUtil.setRequestValue("userInfo", userInfo);
			targetUrl = "edit";
		} else {
			saveMessage(msg, targetUrl);
		}
		return targetUrl;

	}

	public String disable() {
		String msg = "禁用用户失败！";
		if (id != null) {
			userInfoService.updateUserInfoStatus(id,
					ConfigUtil.USERSTATUS_INVALID);
			msg = "禁用用户成功！";
			DataToRedis.updateUserInfoStatus(id, ConfigUtil.USERSTATUS_INVALID);
		}
		super.saveMessage(msg, "userInfo/search.action");
		return MESSAGE;
	}

	public String enable() {
		String msg = "恢复用户失败！";
		if (id != null) {
			userInfoService.updateUserInfoStatus(id,
					ConfigUtil.USERSTATUS_VALID);
			msg = "恢复用户成功！";
			DataToRedis.updateUserInfoStatus(id, ConfigUtil.USERSTATUS_VALID);
		}
		super.saveMessage(msg, "userInfo/search.action");
		return MESSAGE;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public void setUserManagerService(IUserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}
	
}
