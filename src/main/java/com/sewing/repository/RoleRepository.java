package com.sewing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sewing.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleCode(String roleCode);
}
