package com.jbk.insurancemanagement.service;

import java.util.List;

import com.jbk.insurancemanagement.entity.Insurance;

public interface InsuranceService {

	public boolean saveInsurance(Insurance insurance);

	public List<Insurance> getAllInsurance();

	public Insurance getInsuranceById(int insuarnceId);
}
