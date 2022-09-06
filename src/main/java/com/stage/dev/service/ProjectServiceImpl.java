package com.stage.dev.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.dev.models.Projects;
import com.stage.dev.models.Roles;
import com.stage.dev.models.User;
import com.stage.dev.repository.ProjectRepository;
import com.stage.dev.repository.RoleRepository;
import com.stage.dev.serviceInterface.IProjectService;
import com.stage.dev.serviceInterface.IRoleService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ProjectServiceImpl implements IProjectService{
	
	
	@Autowired
	ProjectRepository projectRepository;
	
	
	@Override
	public List<Projects> findAll() {
		return  projectRepository.findAll();
	}
	
	
	@Override
	public Projects getProjectById(Long projectID) {
		return this.projectRepository.findById(projectID).get();
	}
	
	@Override
	public Projects addProject(Projects project) {
		Date today = new Date();
		today.setHours(0);
		project.setStartDate(today);
	return projectRepository.save(project);
	}
	
	@Override
	public Projects updateProject(Projects project, Long projectId) {
		project.setId(projectId);
			return projectRepository.save(project);
	}
	
	@Override
	public void deleteProjectById(Long projectId) {
		projectRepository.deleteById(projectId);
		
	}
	
	
	@Override
	public Projects updateState(Long projectId, boolean state) {
		Projects project = projectRepository.getById(projectId);
		project.setState(state);
		Date today = new Date();
		today.setHours(0);
		project.setEndDate(today);
			return projectRepository.save(project);
	}
	
	
	@Override
	public Projects updateAdvancement(Long projectId, int advancement) {
		Projects project = projectRepository.getById(projectId);
		project.setAdvancement(advancement);
		return projectRepository.save(project);
	}
	
	@Override
	public Projects affectManager(Long projectId,Long managerId) {
		Projects project = projectRepository.getById(projectId);
		project.setManager(managerId);
		return projectRepository.save(project);
	}
}
