package com.meibaolian.entity;

import java.util.List;


/**
 * 有货找车，需求车信息
 * Transportdemand entity. @author MyEclipse Persistence Tools
 */

public class TransportDemandJson implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<County> place;
	private List<TransportDemand> transportDemand;
	// Constructors

	/** default constructor */
	public TransportDemandJson() {
	}

	public TransportDemandJson(List<County> place,
			List<TransportDemand> transportDemand) {
		super();
		this.place = place;
		this.transportDemand = transportDemand;
	}

	public List<County> getPlace() {
		return place;
	}

	public void setPlace(List<County> place) {
		this.place = place;
	}

	public List<TransportDemand> getTransportDemand() {
		return transportDemand;
	}

	public void setTransportDemand(List<TransportDemand> transportDemand) {
		this.transportDemand = transportDemand;
	}


}