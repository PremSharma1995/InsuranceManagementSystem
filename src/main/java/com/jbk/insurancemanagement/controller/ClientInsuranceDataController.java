package com.jbk.insurancemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.insurancemanagement.entity.Client;
import com.jbk.insurancemanagement.entity.ClientInsuranceData;
import com.jbk.insurancemanagement.entity.Insurance;
import com.jbk.insurancemanagement.exception.ClientNotFoundException;
import com.jbk.insurancemanagement.service.ClientInsuranceDataService;
import com.jbk.insurancemanagement.service.ClientService;
import com.jbk.insurancemanagement.service.InsuranceService;

@RestController
public class ClientInsuranceDataController {

	@Autowired
	private ClientInsuranceDataService service;
	@Autowired
	private ClientService clientService;
	@Autowired
	private InsuranceService insuranceService;

	@PostMapping(value = "/saveClientInsuranceData")
	public ResponseEntity<String> saveClientInsuranceData(@RequestBody ClientInsuranceData clientInsuranceData) {
																													
		Client clnt = clientService.getClientByAadharNo(clientInsuranceData.getAadharNo());
		Insurance ins = insuranceService.getInsuranceById(clientInsuranceData.getInsuranceId());
		boolean isAdded=false;
		String add="data added";
		String nAdd="clientAadharNo or insurance data not present in database";
		if (clnt!=null && ins !=null) {
		isAdded = service.saveClientInsuranceData(clientInsuranceData);
		}
		if (isAdded) {
			return new ResponseEntity<String>(add, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>(nAdd, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping(value = "/getClientInsuranceDataById/{clientInsuranceDataId}")
	public ResponseEntity<ClientInsuranceData> getClientInsuranceDataById(@PathVariable String clientInsuranceDataId) {
		ClientInsuranceData cid = service.getClientInsuranceDataById(clientInsuranceDataId);
		if (cid != null) {
			return new ResponseEntity<ClientInsuranceData>(cid, HttpStatus.OK);
		} else {
			throw new ClientNotFoundException("ClientInsuranceData Not Found For Id :" + clientInsuranceDataId);
		}

	}

	@GetMapping(value = "/getAllClientInsuranceData")
	public ResponseEntity<List<ClientInsuranceData>> getAllClientInsuranceData() {
		List<ClientInsuranceData> allCid = service.getClientInsuranceData();
		if (!allCid.isEmpty()) {
			return new ResponseEntity<List<ClientInsuranceData>>(allCid, HttpStatus.OK);
		} else {
			throw new ClientNotFoundException("ClientInsuranceData Not Found");

		}

	}

}
