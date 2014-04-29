package com.meibaolian.entity;

import java.util.Date;

public class Advertising 
{
	
	private int id;
	
	private String imageurl;
	
	private String targeturl;
	
	private int type;
	
	private Date addtime;


	public Advertising() {
		
	}
	
	
	public Advertising(String imageurl, String targeturl) {
		super();
		this.imageurl = imageurl;
		this.targeturl = targeturl;
	}




	public Advertising(int id, String imageurl, String targeturl,
			int type, Date addtime) {
		super();
		this.id = id;
		this.imageurl = imageurl;
		this.targeturl = targeturl;
		this.type = type;
		this.addtime = addtime;
	}




	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getTargeturl() {
		return targeturl;
	}

	public void setTargeturl(String targeturl) {
		this.targeturl = targeturl;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public Date getAddtime() {
		return addtime;
	}


	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	
	

}
