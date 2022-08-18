package com.stage.dev.serviceInterface;

import java.util.List;

import com.stage.dev.models.Projects;

public interface IProjectService {

	
	List<Projects> findAll();

	Projects addProject(Projects project);

	Projects updateProject(Projects project, Long projectID);

	void deleteProjectById(Long projectID);
	
	 Projects updateAdvancement(Long projectId, int advancement);
	 
	 Projects updateState(Long projectId, boolean state);
	 
	 Projects affectManager(Long projectId,Long managerId);
}
