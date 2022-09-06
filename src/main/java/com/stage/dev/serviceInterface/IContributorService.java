package com.stage.dev.serviceInterface;

import java.util.List;

import com.stage.dev.models.Contributor;


public interface IContributorService {

	
	List<Contributor> findAll();

	Contributor addContributor(Contributor contributor);

	Contributor approvecontributor(Long id);
	
	Contributor updateContributor(Contributor contributor, Long contributorID) ;
	
	void deleteContributorById(Long contributorID);

    int numberofcontributors();

    Contributor getContributorByUserId(Long userId);
    
    List<Contributor> nonapprovecontributors();
}

