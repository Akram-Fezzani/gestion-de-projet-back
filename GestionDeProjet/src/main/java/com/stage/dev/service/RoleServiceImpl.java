package com.stage.dev.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.dev.models.Roles;
import com.stage.dev.repository.RoleRepository;
import com.stage.dev.serviceInterface.IRoleService;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class RoleServiceImpl implements IRoleService {

	
	@Autowired
	RoleRepository roleRepository;
	
	
	
	
	@Override
	public List<Roles> findAll() {
		return  roleRepository.findAll();
	}
	
	
	
	@Override
	public Roles addRole(Roles role) {
		
	return roleRepository.save(role);
	}
	
	@Override
	public Roles updateRole(Roles role, Long postId) {
		
			role.setId(postId);
			return roleRepository.save(role);
	}
	
	@Override
	public void deleteRoleById(Long roleID) {
		roleRepository.deleteById(roleID);
		
	}
	
	
}
