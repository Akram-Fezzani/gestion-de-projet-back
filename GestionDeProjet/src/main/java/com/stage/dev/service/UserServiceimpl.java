package com.stage.dev.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.stage.dev.models.User;

import com.stage.dev.repository.UserRepository;
import com.stage.dev.serviceInterface.IUserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceimpl implements IUserService{

	
	@Autowired
	UserRepository userRepository;
	
	
	
	@Override
	public List<User> findAll() {
		return  userRepository.findAll();
	}
	
	@Override
	public User getuser(String username){
		return userRepository.getByusername(username);
	}

	//ajouter un user
	@Override
	public User addUser(User user) {
		user= userRepository.save(user);
        return user;
	
	}
	
	@Override
	@Transactional
	public User updateUser(User user, Long userID) {
			User oldUser = userRepository.findById(userID).get();
			oldUser.setFirstName(user.getFirstName());
			oldUser.setLastName(user.getLastName());
			oldUser.setPhone(user.getPhone());
			oldUser.setEmail(user.getEmail());
			return userRepository.save(oldUser);
		
	}
	
	//effacer un user
	@Override
	public void deleteUserById(Long userID) {
		userRepository.deleteById(userID);
		
	}


	
	@Override
	 public void updateResetPasswordToken(String token, String email) throws UserNotFoundException {
	        User user = userRepository.findByEmail(email);
	        if (user != null) {
	        	user.setResetPasswordToken(token);
	            userRepository.save(user);
	        } else {
	            throw new UserNotFoundException("Could not find any user with the email " + email);
	        }
	    }
	     
	 
	 
	 @Override
	    public User getByResetPasswordToken(String token) {
	        return userRepository.findByResetPasswordToken(token);
	    }
	     
	    
	    
	    @Override
	    public void updatePassword(User user, String newPassword) {
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String encodedPassword = passwordEncoder.encode(newPassword);
	        user.setPassword(encodedPassword);
	        user.setResetPasswordToken(null);
	        userRepository.save(user);
	    }
	    
	 
	    
	  

	    	
	    

	@Override
	public User getUserById(Long userID) {
		return this.userRepository.findById(userID).get();
	}
	
	
	@Override
	public int numberofusers(){
		return this.userRepository.numberofusers();
 }
	
	public int numberofactiveusers(){	 
		 return this.userRepository.numberofactiveusers();
	 };
	 


}
