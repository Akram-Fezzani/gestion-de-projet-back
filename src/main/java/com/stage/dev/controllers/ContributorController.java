package com.stage.dev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stage.dev.models.Contributor;
import com.stage.dev.serviceInterface.IContributorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Manage contributors")
@RequestMapping("/contributor")

public class ContributorController {

	@Autowired
	IContributorService contributorService;


    @PostMapping("/post")
	@ApiOperation(value = "ajouter contributor")
	@ResponseBody
	    public Contributor add(@RequestBody Contributor contributor) {
	        return contributorService.addContributor(contributor);
	    }

	@GetMapping("/getContributorByUserId/{userId}")
	@ApiOperation(value = "get contributor")
	@ResponseBody
	public Contributor getContributorByUserId(@PathVariable Long userId) {
		return contributorService.getContributorByUserId(userId);
	}

    
    
    
    @ApiOperation(value = "Update Contributor")
	@PostMapping("/updateContributor/{contributorID}")
	@ResponseBody
	Contributor updateContributor(@RequestBody Contributor contributor,@PathVariable Long contributorID){
		return contributorService.updateContributor(contributor, contributorID);
	}
    
    
    @GetMapping("/getContributors")
    @ResponseBody
    public List<Contributor> findAll() {
        return contributorService.findAll();
    }
    

    @DeleteMapping("/delete/{contributorID}")
    public void deleteContributorById(@PathVariable Long contributorID) {
    	contributorService.deleteContributorById(contributorID);
    }
    
    @GetMapping("/numberofcontributors")
    @ResponseBody
    public int numberofcontributors() {
        return contributorService.numberofcontributors();
    }
 
    
    @ApiOperation(value = "approve Contributor")
	@GetMapping("/approvecontributor/{contributorID}")
	@ResponseBody
	public Contributor approvecontributor(@PathVariable Long contributorID){
    	return contributorService.approvecontributor(contributorID);
    }


    @ApiOperation(value = "get non active contributors")
    @GetMapping("/nonapprovecontributors")
	@ResponseBody
    public List<Contributor> nonapprovecontributors(){
    	return contributorService.nonapprovecontributors();
    }


}
