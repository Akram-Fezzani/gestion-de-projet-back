package com.stage.dev.service;

import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.dev.models.Contributor;
import com.stage.dev.repository.ContributorRepository;
import com.stage.dev.repository.UserRepository;
import com.stage.dev.serviceInterface.IContributorService;

import lombok.extern.slf4j.Slf4j;




@Service
@Slf4j
public class ContributorServiceImpl implements IContributorService {
	
	
	
	@Autowired
	ContributorRepository contributerRepository;

	@Autowired
	UserRepository userRepository;
	

	
	
	
	//afficher la liste des users
	@Override
	public List<Contributor> findAll() {
		return  contributerRepository.findAll();
	}
	
	
	//ajouter un user
	@Override
	public Contributor addContributor(Contributor contributor) {
		
	return contributerRepository.save(contributor);
	}
	
	@Override
	public Contributor updateContributor(Contributor contributor, Long contributorID) {
		
		contributor.setContributorId(contributorID);
			return contributerRepository.save(contributor);
		
	}
	
	//effacer un user
	@Override
	@Transactional
	public void deleteContributorById(Long contributorID) {
		contributerRepository.deleteWithId(contributorID);
		
	}

	@Override
	public Contributor getContributorByUserId(Long userId) {
		return contributerRepository.findByUserContributor(userRepository.findById(userId).get());
	}

	@Override
   public int numberofcontributors(){
	   return contributerRepository.numberofcontributors();
    	
    }
	
	
	@Override
	@Transactional
	public Contributor approvecontributor(Long id){
		Contributor c=new Contributor();
		c=contributerRepository.getById(id);
		 c.setState(true);
			return contributerRepository.save(c);

		
	}
	
	
	@Override
	public List<Contributor> nonapprovecontributors(){	 
		 return contributerRepository.nonapprovecontributors();
	 };


}
