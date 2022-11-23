package com.jbk.insurancemanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Insurance {

	@Id
	private int insuarnceId;
	private String insuranceType;
	private double insurancePrice;

	public Insurance() {
		super();
		
	}

	public Insurance(int insuarnceId, String insuranceType, double insurancePrice) {
		super();
		this.insuarnceId = insuarnceId;
		this.insuranceType = insuranceType;
		this.insurancePrice = insurancePrice;
	}

	public int getInsuarnceId() {
		return insuarnceId;
	}

	public void setInsuarnceId(int insuarnceId) {
		this.insuarnceId = insuarnceId;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public double getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(double insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	@Override
	public String toString() {
		return "Insurance [insuarnceId=" + insuarnceId + ", insuranceType=" + insuranceType + ", insurancePrice="
				+ insurancePrice + "]";
	}

}
