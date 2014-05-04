package com.meibaolian.entity;

public class HelpCenterEntity 
{
	
	private String title;
	
	private String  targUrl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTargUrl() {
		return targUrl;
	}

	public void setTargUrl(String targUrl) {
		this.targUrl = targUrl;
	}

	public HelpCenterEntity() {
	}

	public HelpCenterEntity(String title, String targUrl) {
		this.title = title;
		this.targUrl = targUrl;
	}
	
	
	


}
