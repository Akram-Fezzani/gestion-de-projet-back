package com.stage.dev.serviceInterface;

import java.util.List;

import com.stage.dev.models.Roles;

public interface IRoleService {

	
	List<Roles> findAll();

	Roles addRole(Roles role);

	Roles updateRole(Roles role, Long roleID);

	void deleteRoleById(Long roleID);
}
