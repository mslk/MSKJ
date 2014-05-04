package com.meibaolian.entity;

import java.util.Date;

public class UserProposal 
{
	
	private int userId;
	
	private String content;
	
	private Date addtime;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public UserProposal() {
		super();
	}

	public UserProposal(int userId, String content) {
		super();
		this.userId = userId;
		this.content = content;
	}
	
	
	
	
	
}
