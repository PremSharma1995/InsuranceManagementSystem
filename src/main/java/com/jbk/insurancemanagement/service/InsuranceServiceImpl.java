package com.jbk.insurancemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.insurancemanagement.dao.InsuranceDao;
import com.jbk.insurancemanagement.entity.Insurance;

@Service
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	private InsuranceDao dao;

	@Override
	public boolean saveInsurance(Insurance insurance) {
		boolean isAdded = dao.saveInsurance(insurance);

		return isAdded;
	}

	@Override
	public List<Insurance> getAllInsurance() {
		List<Insurance> list = dao.getAllInsurance();
		return list;
	}

	@Override
	public Insurance getInsuranceById(int insuarnceId) {
		Insurance insurance = dao.getInsuranceById(insuarnceId);
		return insurance;
	}

}
