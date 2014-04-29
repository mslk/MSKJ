package com.meibaolian.entity;

/**
 * 海汽运价
 * @author Kawin
 *
 */
public class Freight_ratesEntity {
	
	private int id;
	private float sea_freight_rates;
	private float car_freight_rates;
	private String start;
	private String to;
	
	/*
	 * 2地址之间的分隔符
	 */
	private static final String prefix = "&";
	
	public Freight_ratesEntity(int id, float sea_freight_rates,
			float car_freight_rates, float sea_to_freight_rates,
			float car_to_freight_rates, String start, String to) {
		this.id = id;
		this.sea_freight_rates = sea_freight_rates;
		this.car_freight_rates = car_freight_rates;
		this.start = start;
		this.to = to;
	}

	/**
	 * 根据买卖双方地址生成组合键
	 * @param buyerAddress
	 * @param sellAddress
	 */
	public static String creatCompositionAddress(String buyerAddress, String sellAddress){
		return buyerAddress + prefix + sellAddress;
	}
	
	public Freight_ratesEntity() {
	}

	public void setId(int id) {
		this.id = id;
	}
 

	public int getId() {
		return id;
	}

	
	public float getSea_freight_rates() {
		return sea_freight_rates;
	}

	public void setSea_freight_rates(float sea_freight_rates) {
		this.sea_freight_rates = sea_freight_rates;
	}

	public float getCar_freight_rates() {
		return car_freight_rates;
	}

	public void setCar_freight_rates(float car_freight_rates) {
		this.car_freight_rates = car_freight_rates;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getStart() {
		return start;
	}

	public String getTo() {
		return to;
	}
}
