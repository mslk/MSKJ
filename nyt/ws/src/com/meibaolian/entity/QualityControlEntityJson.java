package com.meibaolian.entity;

public class QualityControlEntityJson 
{
	
	
	private String item;
	
	private String notation;
	
	private String unit;
	
	private String value;
	
	private String standard;
	
	private int  sortNumber; 

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getNotation() {
		return notation;
	}

	public void setNotation(String notation) {
		this.notation = notation;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public int getSortNumber() {
		return sortNumber;
	}

	public void setSortNumber(int sortNumber) {
		this.sortNumber = sortNumber;
	}

	public QualityControlEntityJson() {
		super();
	}

	public QualityControlEntityJson(String item, String notation, String unit,
			String value, String standard, int sortNumber) {
		super();
		this.item = item;
		this.notation = notation;
		this.unit = unit;
		this.value = value;
		this.standard = standard;
		this.sortNumber = sortNumber;
	}
	
	
	
	

}
