package com.jbk.insurancemanagement.service;

import java.util.List;

import com.jbk.insurancemanagement.entity.Client;

public interface ClientService {

	public boolean saveClient(Client client);

	public List<Client> getAllClient();

	public Client getClientByAadharNo(String aadharNo);

}
