package com.stage.dev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stage.dev.models.Projects;

import com.stage.dev.serviceInterface.IProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@Api(tags = "Manage Projects")
@RequestMapping("/Projects")
public class ProjectsController {
	
	@Autowired
	IProjectService projectService;
	
	
    @PostMapping("/post")
    @ApiOperation(value = "add project")
	@ResponseBody
	public Projects add(@RequestBody Projects project) {
	        return projectService.addProject(project);
	    }
    
    
    
    @ApiOperation(value = "Update project")
	@PostMapping("updateProject/{projectID}")
	@ResponseBody
	Projects updateProject(@RequestBody Projects project,@PathVariable Long projectID){
    	return projectService.updateProject(project, projectID);
	}
    
    
    @GetMapping("/getProjects")
    @ResponseBody
    public List<Projects> findAll() {
        return projectService.findAll();
    }
    

    @DeleteMapping("/delete/{projectID}")
    public void deleteProjectById(@PathVariable Long projectID) {
    	projectService.deleteProjectById(projectID);
    
    }
}
