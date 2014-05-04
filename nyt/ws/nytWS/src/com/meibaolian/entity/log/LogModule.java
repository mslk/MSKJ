package com.meibaolian.entity.log;

public class LogModule 
{
	private String title;
	private String module;
	private String funcation;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getFuncation() {
		return funcation;
	}
	public void setFuncation(String funcation) {
		this.funcation = funcation;
	}
	public LogModule(String title, String module, String funcation) {
		super();
		this.title = title;
		this.module = module;
		this.funcation = funcation;
	}
	
	
	
	
}
