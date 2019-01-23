package com.service.thinkProAccount.service;

import java.util.List;

import com.service.thinkProAccount.domain.Account;

public interface AccountService {

	public abstract String createAccount(Account account);

	public abstract String getAccountById(int id);

	public abstract Account getAccountInfo(int id);

	//public Account getAccountById(int accountId);

	public abstract boolean updateAccount(Account account);

	public abstract void deleteAccount(int accountId);

	public abstract List<Account> getAllAccounts();
}
