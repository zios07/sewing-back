package com.sewing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sewing.domain.Account;
import com.sewing.repository.AccountRepository;
import com.sewing.service.api.IAccountService;
import com.sewing.service.exception.NotFoundException;

@Service
public class AccountService implements IAccountService {
	
	@Autowired
	private AccountRepository repo;

	@Override
	public Account addAccount(Account account) {
		return repo.save(account);
	}

	@Override
	public Account findAccount(long id) throws NotFoundException {
		if(!repo.exists(id))
			throw new NotFoundException("code", "message");
		return repo.findOne(id);
	}

	@Override
	public List<Account> findAllAccounts() {
		return repo.findAll();
	}

	@Override
	public void deleteAccount(long id) throws NotFoundException {
		if(!repo.exists(id))
			throw new NotFoundException("code", "message");
		repo.delete(id);
	}

	@Override
	public List<Account> searchAccounts(Account accountDto) throws NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account findAccountByUsername(String username) throws NotFoundException {
		Account account = repo.findByUsername(username);
		if(account == null)
			throw new NotFoundException("code", "message");
		return account;
	}

}
