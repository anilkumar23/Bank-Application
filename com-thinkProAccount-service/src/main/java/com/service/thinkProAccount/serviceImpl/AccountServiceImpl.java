package com.service.thinkProAccount.serviceImpl;


import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.thinkProAccount.domain.Account;
import com.service.thinkProAccount.repository.AccountRepository;
import com.service.thinkProAccount.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepo;

	@Transactional
	public String createAccount(Account account) {
		String status="";
		// TODO Auto-generated method stub
		String s = String.valueOf(accountRepo.findExistingAccountType(account.getCustomer().getCustomerId()));
		if (!s.contains(account.getType())){
			accountRepo.save(account);
			status = "Success";
		}else{
			status ="Account type for the cusstomer already exists in the same branch..";
		}
		System.out.println(s);
		return status;
	}

	@Transactional
	public String getAccountById(int accountId) {
		String str = accountRepo.getOne(accountId).toString();
		//String trimmed = str.trim();
		JsonParser jsonParser = new JsonParser();
		JsonObject objectFromString = jsonParser.parse(str).getAsJsonObject();
		System.out.println("AccountDetails---->" + objectFromString);

		/*Gson gson = new Gson();
		Reader reader = new StringReader(str);
		String str1 = gson.fromJson(reader, (Type) JsonObject.class);*/

		return String.valueOf(objectFromString);
	}

	@Transactional
	public Account getAccountInfo(int accountId) {
		return accountRepo.getOne(accountId);
	}

	@Transactional
	public boolean updateAccount(Account account) {
		// TODO Auto-generated method stub
		return accountRepo.save(account) != null;
	}

	@Transactional
	public void deleteAccount(int accountId) {
		// TODO Auto-generated method stub
		accountRepo.deleteById(accountId);;
	}

	@Transactional
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountRepo.findAll();
	}
	
	

}
