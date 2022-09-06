package com.stage.dev.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Data
@Entity
@AllArgsConstructor
public class User implements Serializable{
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @NotBlank
	  @Size(max = 20)
	  private String username;

	  @NotBlank
	  @Size(max = 50)
	  @Email
	  private String email;

	  @NotBlank
	  @Size(max = 120)
	  private String password;
	  private String firstName;
	  private String lastName;
	  private int phone;
	  private boolean state;


	  private String resetPasswordToken;






	  public boolean getState() {
		    return state;
		  }




	  @ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(	name = "user_roles", 
					joinColumns = @JoinColumn(name = "user_id"), 
					inverseJoinColumns = @JoinColumn(name = "role_id"))
		private Set<Roles> roles = new HashSet<>();

	  public User() {
	  }

	  public User(String username, String email, String password, boolean state) {
	    this.username = username;
	    this.email = email;
	    this.password = password;
	    this.state = state;
	  }

	  public User(String username, String email, String password, String firstName,String lastName,int phone) {
		    this.username = username;
		    this.email = email;
		    this.password = password;
		    this.firstName = firstName;
		    this.lastName = lastName;
		    this.phone = phone;

		  }



	  public User(String username,String firstName,String lastName ,String email,int phone, String password) {
		    this.username = username;
		    this.firstName=firstName;
		    this.lastName=lastName;
		    this.email = email;
		    this.phone=phone;
		    this.password = password;
	  }




	  public User(String username, String email, String password, boolean state,String firstName,String lastName, int phone) {
		    this.username = username;
		    this.email = email;
		    this.password = password;
		    this.state = state;
		    this.firstName=firstName;
		    this.lastName=lastName;
		    this.phone=phone;

		  }


	  public User(String username, String email, String password) {
		    this.username = username;
		    this.email = email;
		    this.password = password;
		  }
		

}