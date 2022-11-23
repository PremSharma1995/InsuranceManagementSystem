package com.jbk.insurancemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.insurancemanagement.dao.ClientInsuranceDataDao;
import com.jbk.insurancemanagement.entity.ClientInsuranceData;

@Service
public class ClientInsuranceDataServiceImpl implements ClientInsuranceDataService {

	@Autowired
	private ClientInsuranceDataDao dao;

	@Override
	public boolean saveClientInsuranceData(ClientInsuranceData clientInsuranceData) {
		
		boolean isAdded = dao.saveClientInsuranceData(clientInsuranceData);

		return isAdded;
	}

	@Override
	public ClientInsuranceData getClientInsuranceDataById(String clientInsuranceDataId) {
		ClientInsuranceData cid = dao.getClientInsuranceDataById(clientInsuranceDataId);
		return cid;
	}

	@Override
	public List<ClientInsuranceData> getClientInsuranceData() {
		List<ClientInsuranceData> list = dao.getClientInsuranceData();
		return list;
	}
	
	
}
