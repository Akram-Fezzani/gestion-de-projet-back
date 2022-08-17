package com.stage.dev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stage.dev.models.Roles;
import com.stage.dev.models.User;
import com.stage.dev.serviceInterface.IRoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Manage roles")
@RequestMapping("/role")
public class RoleController {

	@Autowired
	IRoleService roleService;
	
	
    @PostMapping("/post")
    @ApiOperation(value = "ajouter role")
	@ResponseBody
	public Roles add(@RequestBody Roles role) {
	        return roleService.addRole(role);
	    }
    
    
    
    @ApiOperation(value = "Update role")
	@PostMapping("updateRole/{roleID}")
	@ResponseBody
	Roles updateRole(@RequestBody Roles role,@PathVariable Long roleID){
    	return roleService.updateRole(role, roleID);
	}
    
    
    @GetMapping("/getRole")
    @ResponseBody
    public List<Roles> findAll() {
        return roleService.findAll();
    }
    

    @DeleteMapping("/delete/{roleID}")
    public void deleteContributorById(@PathVariable Long roleID) {
    	roleService.deleteRoleById(roleID);
    
    }
}
