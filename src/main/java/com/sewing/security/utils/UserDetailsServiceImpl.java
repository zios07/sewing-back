package com.sewing.security.utils;

import java.util.Arrays;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sewing.domain.Account;
import com.sewing.domain.User;
import com.sewing.service.api.IUserService;
import com.sewing.service.exception.NotFoundException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private IUserService userService;

	public UserDetailsServiceImpl(IUserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = null;
		User user = null;
		try {
			user = userService.findUserByUsername(username);
			account = user.getAccount();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		
		return new org.springframework.security.core.userdetails.User(username, account.getPassword(), Arrays.asList(new SimpleGrantedAuthority(user.getRole().getRoleLabel())));

	}
}