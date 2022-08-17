package com.stage.dev.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity
@AllArgsConstructor
public class Tasks {

	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private String description;
	  private Date startDate;
	  private Date estimatedEndDate;
	  private Date endDate;
	  private float maxCost;
	  private int maxNumberOfEmployees;
	  private String name;
	  private boolean state;
	  private int advancement;
	 

}
