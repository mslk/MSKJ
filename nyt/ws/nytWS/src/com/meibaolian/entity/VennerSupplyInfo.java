package com.meibaolian.entity;

/**
 * 单板供应
 * @author Kawin
 *
 */ 
public class VennerSupplyInfo extends VennerInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private double sea_freight_rates;
	private double car_freight_rates;
	private double sea_to_freight_rates;
	private double car_to_freight_rates;
	/*
	 * 议价器
	 */
	private double discuss_prices[][] = new double[3][2];
	/*
	 * 店小二
	 */
	private String manager_phone;
	private String manager_realname;
	
	public String getManager_phone() {
		return manager_phone;
	}
	public void setManager_phone(String manager_phone) {
		this.manager_phone = manager_phone;
	}
	public String getManager_realname() {
		return manager_realname;
	}
	public void setManager_realname(String manager_realname) {
		this.manager_realname = manager_realname;
	}
	public double[][] getDiscuss_prices() {
		return discuss_prices;
	}
	public void setDiscuss_prices(double[][] discuss_prices) {
		this.discuss_prices = discuss_prices;
	}
	public double getSea_freight_rates() {
		return sea_freight_rates;
	}
	public void setSea_freight_rates(double sea_freight_rates) {
		this.sea_freight_rates = sea_freight_rates;
	}
	public double getCar_freight_rates() {
		return car_freight_rates;
	}
	public void setCar_freight_rates(double car_freight_rates) {
		this.car_freight_rates = car_freight_rates;
	}
	public double getSea_to_freight_rates() {
		return sea_to_freight_rates;
	}
	public void setSea_to_freight_rates(double sea_to_freight_rates) {
		this.sea_to_freight_rates = sea_to_freight_rates;
	}
	public double getCar_to_freight_rates() {
		return car_to_freight_rates;
	}
	public void setCar_to_freight_rates(double car_to_freight_rates) {
		this.car_to_freight_rates = car_to_freight_rates;
	}
	 
	
}