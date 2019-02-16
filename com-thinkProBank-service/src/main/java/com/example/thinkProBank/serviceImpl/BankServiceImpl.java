package com.example.thinkProBank.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.thinkProBank.domain.Bank;
import com.example.thinkProBank.repository.BankRepository;
import com.example.thinkProBank.repository.BranchRepository;
import com.example.thinkProBank.service.BankService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component
public class BankServiceImpl implements BankService {

	@Autowired
	private BankRepository bankRepo;

	@SuppressWarnings("unused")
	@Autowired
	private BranchRepository branchRepository;

	@Transactional
	public Bank getBankInfo(int bankId) {
		Bank bank = bankRepo.getOne(bankId);
		return bank;
	}

	@Transactional
	public String getBankById(int bankId) throws JSONException {
		String str = bankRepo.getOne(bankId).toString();
		JsonParser jsonParser = new JsonParser();
		JsonObject objectFromString = jsonParser.parse(str).getAsJsonObject();
		System.out.println("BankDetails---->" + objectFromString);
		return String.valueOf(objectFromString);
	}

	@Transactional
	public boolean saveBank(Bank bank) {
		return bankRepo.save(bank) != null;
	}

	@Transactional
	public boolean updateBank(Bank bank) {
		return bankRepo.save(bank) != null;
	}

	@Transactional
	public void deleteBank(int bankId) {
		bankRepo.deleteById(bankId);
	}

	@Transactional
	public List<Bank> getAllBanks() {
		return (List<Bank>) bankRepo.findAll();
	}

}
