package com.stage.dev.serviceInterface;

import java.util.List;

import com.stage.dev.models.User;
import com.stage.dev.service.UserNotFoundException;

public interface IUserService {

	List<User> findAll();

	User addUser(User user);

	User updateUser(User user, Long userID);

	void deleteUserById(Long userID);
	
	void updatePassword(User user, String newPassword) ;
	
	User getByResetPasswordToken(String token);
	
	public User getuser(String username);
	
	void updateResetPasswordToken(String token, String email)throws UserNotFoundException;
		
    User getUserById(Long userID);
    
    int numberofusers();
    
    int numberofactiveusers();
    
}
