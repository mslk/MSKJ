package com.meibaolian.dto;

/**
 * 通用jsp条件映射类.有特殊条件的可继承此类后进行扩展
 * @author Kawin
 *
 */
public class CommonConditionDto {
	
	private String keyword;//关键字
	private Integer int_valueA;
	private Integer int_valueB;
	private Integer int_valueC;
	private String str_valueA;
	private String str_valueB;
	private String str_valueC;
	private String str_valueD;
	private String str_valueE;
	private String begindate;//开始日期
	private String enddate;//结束日期
	
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getInt_valueA() {
		return int_valueA;
	}
	public void setInt_valueA(Integer int_valueA) {
		this.int_valueA = int_valueA;
	}
	public Integer getInt_valueB() {
		return int_valueB;
	}
	public void setInt_valueB(Integer int_valueB) {
		this.int_valueB = int_valueB;
	}
	public Integer getInt_valueC() {
		return int_valueC;
	}
	public void setInt_valueC(Integer int_valueC) {
		this.int_valueC = int_valueC;
	}
	public String getStr_valueA() {
		return str_valueA;
	}
	public void setStr_valueA(String str_valueA) {
		this.str_valueA = str_valueA;
	}
	public String getStr_valueB() {
		return str_valueB;
	}
	public void setStr_valueB(String str_valueB) {
		this.str_valueB = str_valueB;
	}
	public String getStr_valueC() {
		return str_valueC;
	}
	public void setStr_valueC(String str_valueC) {
		this.str_valueC = str_valueC;
	}
	public String getStr_valueD() {
		return str_valueD;
	}
	public void setStr_valueD(String str_valueD) {
		this.str_valueD = str_valueD;
	}
	public String getStr_valueE() {
		return str_valueE;
	}
	public void setStr_valueE(String str_valueE) {
		this.str_valueE = str_valueE;
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
