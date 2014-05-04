package com.meibaolian.entity;

import java.util.List;


/**
 * 有车找货，供车信息
 * Transportsupply entity. @author MyEclipse Persistence Tools
 */

public class TransportSupplyJson implements java.io.Serializable {

	// Fields
	private List<County> place;
	private List<TransportSupply> transportSupply;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Constructors

	/** default constructor */
	public TransportSupplyJson() {
	}

	public TransportSupplyJson(List<County> place,
			List<TransportSupply> transportSupply) {
		super();
		this.place = place;
		this.transportSupply = transportSupply;
	}

	public List<County> getPlace() {
		return place;
	}

	public void setPlace(List<County> place) {
		this.place = place;
	}

	public List<TransportSupply> getTransportSupply() {
		return transportSupply;
	}

	public void setTransportSupply(List<TransportSupply> transportSupply) {
		this.transportSupply = transportSupply;
	}

	
}