package com.sewing.service.api;

import com.sewing.domain.Account;
import com.sewing.service.exception.BadCredentialsException;
import com.sewing.service.exception.NotFoundException;

public interface IAuthenticationService {

	Account authenticate(Account account) throws NotFoundException, BadCredentialsException;
}
