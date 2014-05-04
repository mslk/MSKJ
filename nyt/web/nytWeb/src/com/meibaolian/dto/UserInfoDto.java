package com.meibaolian.dto;

import com.meibaolian.entity.Usermanager;

public class UserInfoDto {
	
	private String keyword;//关键字
	private Integer type;//类型
	private Integer status;//状态
	private String begindate;//开始日期
	private String enddate;//结束日期
	private Integer level;//用户消息发布权限0 默认有限制 1 无限制 2 指定日期
	private Usermanager usermanager;//管理员
	
	public Usermanager getUsermanager() {
		return usermanager;
	}
	public void setUsermanager(Usermanager usermanager) {
		this.usermanager = usermanager;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
	
}
