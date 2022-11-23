package com.jbk.insurancemanagement.dao;

import java.util.List;

import com.jbk.insurancemanagement.entity.Insurance;


public interface InsuranceDao {
	
	public boolean saveInsurance(Insurance insurance);

	public List<Insurance> getAllInsurance();

	public Insurance getInsuranceById(int insuarnceId);

}
