package com.jbk.insurancemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.insurancemanagement.dao.ClientDao;
import com.jbk.insurancemanagement.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDao dao;

	@Override
	public boolean saveClient(Client client) {

		boolean isAdded = dao.saveClient(client);

		return isAdded;
	}

	@Override
	public List<Client> getAllClient() {
		List<Client> list = dao.getAllClient();
		return list;
	}

	@Override
	public Client getClientByAadharNo(String aadharNo) {
		Client client = dao.getClientByAadharNo(aadharNo);
		return client;
	}

}
