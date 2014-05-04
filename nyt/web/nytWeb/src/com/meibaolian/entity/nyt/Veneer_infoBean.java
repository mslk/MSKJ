package com.meibaolian.entity.nyt;

import java.sql.Timestamp;

import com.meibaolian.entity.UserInfo;

/**
 * 桉木
 * @author Kawin
 * @version 1.0 [2014.05.03 11:56]
 */
public class Veneer_infoBean{
	private int Id;
//	private int userid;
	private String length;
	private String width;
	private String thicknessint;
	private String average_thickness;
	private String level;
	private String reference;
	private String panel;
	private String hole_panel;
	private String moisture;
	private String bark;
	private String mildew;
	private String lead_time;
	private int number;
	private double price;
	private String valid;
	private String described;
	private int type;
	private String addtime;
	private int orderid;
	private int status;
	private UserInfo userinfo;
	
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public int getId(){
		return Id;
	}
	public void setId(int Id){
		this.Id = Id;
	}

//	public int getUserid(){
//		return userid;
//	}
//	public void setUserid(int userid){
//		this.userid = userid;
//	}

	public String getLength(){
		return length;
	}
	public void setLength(String length){
		this.length = length;
	}

	public String getWidth(){
		return width;
	}
	public void setWidth(String width){
		this.width = width;
	}

	public String getThicknessint(){
		return thicknessint;
	}
	public void setThicknessint(String thicknessint){
		this.thicknessint = thicknessint;
	}

	public String getAverage_thickness(){
		return average_thickness;
	}
	public void setAverage_thickness(String average_thickness){
		this.average_thickness = average_thickness;
	}

	public String getLevel(){
		return level;
	}
	public void setLevel(String level){
		this.level = level;
	}

	public String getReference(){
		return reference;
	}
	public void setReference(String reference){
		this.reference = reference;
	}

	public String getPanel(){
		return panel;
	}
	public void setPanel(String panel){
		this.panel = panel;
	}

	public String getHole_panel(){
		return hole_panel;
	}
	public void setHole_panel(String hole_panel){
		this.hole_panel = hole_panel;
	}

	public String getMoisture(){
		return moisture;
	}
	public void setMoisture(String moisture){
		this.moisture = moisture;
	}

	public String getBark(){
		return bark;
	}
	public void setBark(String bark){
		this.bark = bark;
	}

	public String getMildew(){
		return mildew;
	}
	public void setMildew(String mildew){
		this.mildew = mildew;
	}

	public String getLead_time(){
		return lead_time;
	}
	public void setLead_time(String lead_time){
		this.lead_time = lead_time;
	}

	public int getNumber(){
		return number;
	}
	public void setNumber(int number){
		this.number = number;
	}

	public double getPrice(){
		return price;
	}
	public void setPrice(double price){
		this.price = price;
	}

	public String getValid(){
		return valid;
	}
	public void setValid(String valid){
		this.valid = valid;
	}

	public String getDescribed(){
		return described;
	}
	public void setDescribed(String described){
		this.described = described;
	}

	public int getType(){
		return type;
	}
	public void setType(int type){
		this.type = type;
	}
	 
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public int getOrderid(){
		return orderid;
	}
	public void setOrderid(int orderid){
		this.orderid = orderid;
	}

	public int getStatus(){
		return status;
	}
	public void setStatus(int status){
		this.status = status;
	}
}
