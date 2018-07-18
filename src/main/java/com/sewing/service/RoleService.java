package com.sewing.service;

import static com.sewing.service.utils.UtilContants.ROLE_CODE_ADMIN;
import static com.sewing.service.utils.UtilContants.ROLE_CODE_USER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sewing.domain.Role;
import com.sewing.domain.User;
import com.sewing.repository.RoleRepository;
import com.sewing.repository.UserRepository;
import com.sewing.service.api.IRoleService;
import com.sewing.service.exception.ServiceException;

@Service
public class RoleService implements IRoleService {
	
	@Autowired
	private RoleRepository repo;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Role findRoleByUsername(String username) throws ServiceException {
		User user = userRepository.findByAccountUsername(username);
		if(user == null)
			throw new ServiceException("INVALID.USERNAME", "Invalid username");
		
		return user.getRole();
	}

	@Override
	public Role findById(Long id) {
		return repo.findOne(id);
	}

	@Override
	public List<Role> findAll() {
		return repo.findAll();
	}

	@Override
	public Role getRoleUser() {
		return repo.findByRoleCode(ROLE_CODE_USER);
	}

	@Override
	public Role getRoleAdmin() {
		return repo.findByRoleCode(ROLE_CODE_ADMIN);
	}

}
