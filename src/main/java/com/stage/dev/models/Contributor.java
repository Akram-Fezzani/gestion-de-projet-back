package com.stage.dev.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Contributor implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contributorId;

    private String name;
    private String domain;

	 private String adress;
	 private String legalStatus;
	 private String email;
	 private int phone;

	 private Date disponibiltyStart;
	 private Date disponibiltyOver;
	 private boolean state;


	 @Enumerated(EnumType.STRING)
	 private TypeContributor TypeContributor;

	 
	 @OneToOne(cascade = CascadeType.DETACH)
	    private User userContributor;

  

}