package com.sunny.test.repository;

import java.util.List;

import com.sunny.test.model.Account;

public interface AccountRepository {
	public void update(Account account);
	public List<Account> findAll();
	public Account findByAccountNumber(String accountNumber);
}
