package com.jbk.insurancemanagement.controller;

import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.insurancemanagement.entity.Client;
import com.jbk.insurancemanagement.exception.ClientNotFoundException;
import com.jbk.insurancemanagement.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService service;

	@PostMapping(value = "/saveClient")
	public ResponseEntity<String> saveClient(@RequestBody Client client) {

		String aadhar = client.getAadharNo();
		Boolean validAadhar = isValidAadhaarNumber(aadhar);
		boolean isAdded = false;

		if (validAadhar == true) {
			isAdded = service.saveClient(client);
		}

		if (isAdded) {
			return new ResponseEntity<String>("data added successfully.....", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Invalid Aadhar", HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping(value = "/getClientById/{clientId}")
	public ResponseEntity<Client> getClientById(@PathVariable String clientId) {
		Client clnt = service.getClientByAadharNo(clientId);
		if (clnt != null) {
			return new ResponseEntity<Client>(clnt, HttpStatus.OK);
		} else {
			throw new ClientNotFoundException("Client Not Found For Id :" + clientId);
		}

	}

	@GetMapping(value = "/getAllClient")
	public ResponseEntity<List<Client>> getAllClient() {
		List<Client> allClients = service.getAllClient();
		if (!allClients.isEmpty()) {
			return new ResponseEntity<List<Client>>(allClients, HttpStatus.OK);
		} else {
			throw new ClientNotFoundException("Clients Not Found");

		}

	}

	public static boolean isValidAadhaarNumber(String str) {

		String regex = "^[2-9]{1}[0-9]{11}$";

		Pattern p = Pattern.compile(regex);

		if (str == null) {
			return false;
		}

		Matcher m = p.matcher(str);

		return m.matches();
	}
}
