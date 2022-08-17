package com.stage.dev.models;

import java.util.Date;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity
@AllArgsConstructor
public class Report {

	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  private String description;
	  private String name;
	  private Date postDate;
	  private User postedBy;
	  
	  @ManyToOne
	  private Projects project;
	  
	  
	  @OneToOne
	  private ReportType reportType;
	  
	  
		@JsonIgnore
		@ElementCollection
		private List<String> fileName;
}
