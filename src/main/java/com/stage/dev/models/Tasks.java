package com.stage.dev.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	  private String name;
	  private boolean state;
	  private int advancement;
	  
	  
	  public Tasks() {
	  }
	  
	  
	  @JsonIgnore
	  @ManyToOne
	  private Projects project;
	  
	  @OneToOne
	  private TaskType TaskType;
	  
	  
		@JsonIgnore
		@ElementCollection
		private List<String> fileName;
		
		@JsonIgnore
		@ElementCollection
		private List<Long> employee;


}
