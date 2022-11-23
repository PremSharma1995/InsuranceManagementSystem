package com.jbk.insurancemanagement.service;

import java.util.List;

import com.jbk.insurancemanagement.entity.ClientInsuranceData;

public interface ClientInsuranceDataService {

	public boolean saveClientInsuranceData(ClientInsuranceData clientInsuranceData);

	public ClientInsuranceData getClientInsuranceDataById(String clientInsuranceDataId);

	public List<ClientInsuranceData> getClientInsuranceData();
}
