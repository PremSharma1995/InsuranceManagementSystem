package com.jbk.insurancemanagement.dao;

import java.util.List;

import com.jbk.insurancemanagement.entity.Client;

public interface ClientDao {

	public boolean saveClient(Client client);

	public List<Client> getAllClient();

	public Client getClientByAadharNo(String aadharNo);

}
