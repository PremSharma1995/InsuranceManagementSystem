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
import com.jbk.insurancemanagement.entity.Insurance;
import com.jbk.insurancemanagement.exception.ClientNotFoundException;
import com.jbk.insurancemanagement.exception.InsuranceNotFoundException;
import com.jbk.insurancemanagement.service.InsuranceService;

@RestController
public class InsuranceController {

	@Autowired
	private InsuranceService service;

	@PostMapping(value = "/saveInsurance")
	public ResponseEntity<String> saveInsurance(@RequestBody Insurance insurance) {
		
		boolean isAdded = false;
		double price = insurance.getInsurancePrice();
		
		if(price > 0) {
			 isAdded = service.saveInsurance(insurance);
		}		

		if (isAdded) {
			return new ResponseEntity<String>("Data Added Successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Price must be greater than zero", HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping(value = "/getInsuranceById/{insuranceId}")
	public ResponseEntity<Insurance> getInsuranceById(@PathVariable int insuranceId) {
		Insurance ins = service.getInsuranceById(insuranceId);
		if (ins != null) {
			return new ResponseEntity<Insurance>(ins, HttpStatus.OK);
		} else {
			throw new InsuranceNotFoundException("Insurance Not Found For Id :" + insuranceId);
		}

	}

	@GetMapping(value = "/getAllInsurance")
	public ResponseEntity<List<Insurance>> getAllClient() {
		List<Insurance> allInsurance = service.getAllInsurance();
		if (!allInsurance.isEmpty()) {
			return new ResponseEntity<List<Insurance>>(allInsurance, HttpStatus.OK);
		} else {
			throw new InsuranceNotFoundException("Insurance Not Found");

		}

	}

}
