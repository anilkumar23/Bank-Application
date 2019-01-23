package com.example.thinkProBank.service;

import java.util.List;

import org.json.JSONException;
import org.springframework.stereotype.Service;

import com.example.thinkProBank.domain.Bank;

@Service
public interface BankService {

	public abstract String getBankById(int id) throws JSONException;
	
	public abstract Bank getBankInfo(int id);

	public abstract boolean saveBank(Bank bank);

	public abstract boolean updateBank(Bank bank);

	public abstract void deleteBank(int bankId);

	public abstract List<Bank> getAllBanks();
	
}