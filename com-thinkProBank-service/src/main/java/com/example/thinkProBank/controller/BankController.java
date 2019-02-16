package com.example.thinkProBank.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.thinkProBank.domain.Bank;
import com.example.thinkProBank.serviceImpl.BankServiceImpl;
import com.example.thinkProBank.serviceImpl.Consumer;
import com.example.thinkProBank.serviceImpl.Producer;

@RestController
@RequestMapping("/banklist")
public class BankController {
	private static final Logger logger = LogManager.getLogger(BankController.class.getName());
	private static final String Topic = "test";

	@Autowired
	private BankServiceImpl bankServiceImpl;

	@Autowired
	Producer producer;

	@Autowired
	Consumer consumer;

	@RequestMapping(value = "/getBankById/{bankId}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public String getBankById(@PathVariable Integer bankId) throws JSONException {
		return bankServiceImpl.getBankById(bankId);
	}

	@RequestMapping(value = "/getBankInfo/{bankId}", method = RequestMethod.GET)
	@ResponseBody
	public Bank getBranchInfo(@PathVariable Integer bankId) {
		Bank bank = bankServiceImpl.getBankInfo(bankId);
		return bank;
	}

	@RequestMapping(value = "/getAllBanks", method = RequestMethod.GET)
	public List<Bank> getAllBanks() {
		return bankServiceImpl.getAllBanks();
	}

	@RequestMapping(value = "/insertBank", method = RequestMethod.POST)
	public HttpStatus insertBank(@RequestBody Bank bank) {
		boolean hasBankInfo = bankServiceImpl.saveBank(bank);
		
		 if (hasBankInfo) { producer.send(bank); }
		 
		return hasBankInfo ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/updateBank", method = RequestMethod.PUT)
	public HttpStatus updateBank(@RequestBody Bank bank) {
		// consumer.receive(bank);
		return bankServiceImpl.updateBank(bank) ? HttpStatus.LOCKED : HttpStatus.BAD_REQUEST;
	}

	@RequestMapping(value = "/deleteBankById/{bankId}", method = RequestMethod.DELETE)
	public HttpStatus deleteBank(@PathVariable Integer bankId) {
		bankServiceImpl.deleteBank(bankId);
		return HttpStatus.NO_CONTENT;
	}

}
