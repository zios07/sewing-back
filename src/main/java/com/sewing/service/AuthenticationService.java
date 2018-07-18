package com.sewing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sewing.domain.Account;
import com.sewing.repository.AccountRepository;
import com.sewing.service.api.IAuthenticationService;
import com.sewing.service.exception.BadCredentialsException;
import com.sewing.service.exception.NotFoundException;

@Service
public class AuthenticationService implements IAuthenticationService {

	@Autowired
	private AccountRepository accountRepo;

	@Override
	public Account authenticate(Account credentials) throws NotFoundException, BadCredentialsException {
		Account account = accountRepo.findByUsername(credentials.getUsername());
		if (account == null
				|| (account.getPassword() != null && !account.getPassword().equals(credentials.getPassword())))
			throw new BadCredentialsException("AUTHENTICATION.ERROR", "Bad credentials");
		return account;
	}

}
