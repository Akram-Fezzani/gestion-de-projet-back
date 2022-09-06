package com.stage.dev.controllers;

import java.util.List;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


import com.stage.dev.models.User;
import com.stage.dev.serviceInterface.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Manage users")
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService userService;
	

 

    @PostMapping("/post")
    @ApiOperation(value = "ajouter user")
	@ResponseBody
	public User add(@RequestBody User user) {
	        return userService.addUser(user);
	    }


	@ApiOperation(value = "get user")
	@GetMapping("getUserById/{userID}")
	@ResponseBody
	User getUserById(@PathVariable Long userID){
		return userService.getUserById(userID);
	}

	
	@ApiOperation(value = "get user")
	@GetMapping("getUserByusername/{username}")
	@ResponseBody
	User getUserById(@PathVariable String username){
		return userService.getuser(username);
	}




    @ApiOperation(value = "Update user")
	@PostMapping("/updateUser/{userID}")
	@ResponseBody
	User updateUser(@RequestBody User user, @PathVariable Long userID){
		return userService.updateUser(user, userID);
	}

    @GetMapping("/getAllUsers")
    @ResponseBody
    public List<User> findAll() {
        return userService.findAll();
    }


    @DeleteMapping("/delete/{userID}")
    public void deleteUserById(@PathVariable Long userID) {
    	userService.deleteUserById(userID);

    }

    
    @ApiOperation(value = "number of user")
    @GetMapping("/numberofusers")
	@ResponseBody
    public int numberofusers(){	
    	return userService.numberofusers();
    }
    
    
    @ApiOperation(value = "number of active user")
    @GetMapping("/numberofactiveusers")
	@ResponseBody
    public int numberofactiveusers(){	
    	return userService.numberofactiveusers();
    }
 
    
    
}
