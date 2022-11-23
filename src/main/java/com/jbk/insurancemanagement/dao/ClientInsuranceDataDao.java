package com.jbk.insurancemanagement.dao;

import java.util.List;

import com.jbk.insurancemanagement.entity.ClientInsuranceData;

public interface ClientInsuranceDataDao {
	
	public boolean saveClientInsuranceData(ClientInsuranceData clientInsuranceData);

	public ClientInsuranceData getClientInsuranceDataById(String clientInsuranceDataId);

	public List<ClientInsuranceData> getClientInsuranceData();

	
}
