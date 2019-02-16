package com.service.thinkProTransaction.service;

import com.service.thinkProTransaction.domain.Transaction;

public interface TransactionService {
	
	public Transaction getTransactionById(int transactionId);

	public String withdrawlsAndDeposit(Transaction transaction);

	public String accountToAccountTransfer(Transaction transaction);
}
