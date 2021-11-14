package com.wolken.bank.controller;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.bank.dto.EmployeeDTO;
import com.wolken.bank.service.EmployeeService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class BalanceController {
	private Logger logger=LoggerFactory.getLogger(getClass());
	@Autowired
	EmployeeService service;
	@GetMapping("get")
	List<EmployeeDTO> getBalance() {
		logger.info("inside getBalance method" );
		List<EmployeeDTO> list=service.validateAndGetAll();
		logger.info(""+list);
	return list;
	}
	@GetMapping("getBankAddress")
	String getBankAddress() {
		logger.info("inside getBankAddress method" );
	return"CANARA BANK, Benjanpadavu Bantwal Taluk";
	}
	@GetMapping("getCustomerName")
	String getCustomerName() {
		logger.info("inside getCustomerName method" );
	return"Madhushree Ganiga";
	
}
	@GetMapping("getCustomerAcountNumber")
	String getCustomerAcountNumbe() {
		logger.info("inside getCustomerAcountNumber method" );
	return"10987654327001";
		
}
}
