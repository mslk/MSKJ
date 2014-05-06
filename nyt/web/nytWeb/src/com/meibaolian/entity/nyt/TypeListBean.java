package com.meibaolian.entity.nyt;


/**
 * 菜单选项列表
 * @author Kawin
 * @version 1.0 [2014.05.06 11:40]
 */
public class TypeListBean{
	private int Id;
	private String itemvalue;
	private int item_type;
	private String item_describe;
	private int type;
	private int orderid;
	private String addtime;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getItemvalue() {
		return itemvalue;
	}
	public void setItemvalue(String itemvalue) {
		this.itemvalue = itemvalue;
	}
	public int getItem_type() {
		return item_type;
	}
	public void setItem_type(int item_type) {
		this.item_type = item_type;
	}
	public String getItem_describe() {
		return item_describe;
	}
	public void setItem_describe(String item_describe) {
		this.item_describe = item_describe;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	
	
}
