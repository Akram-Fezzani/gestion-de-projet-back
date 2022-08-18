package com.stage.dev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.dev.models.Projects;
import com.stage.dev.models.Tasks;
import com.stage.dev.models.User;
import com.stage.dev.repository.ProjectRepository;
import com.stage.dev.repository.TasksRepository;
import com.stage.dev.repository.UserRepository;
import com.stage.dev.serviceInterface.IRoleService;
import com.stage.dev.serviceInterface.ITasksService;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class TasksServiceImpl implements ITasksService {

	
	
	@Autowired
	TasksRepository tasksRepository;
	

	@Autowired
	ProjectRepository projectRepository;
	
	
	
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public List<Tasks> findAll() {
		return  tasksRepository.findAll();
	}
	
	
	
	@Override
	public Tasks addTask(Tasks task) {
		
	return tasksRepository.save(task);
	}
	
	@Override
	public Tasks updateTask(Tasks task, Long taskId) {
		
		task.setId(taskId);
			return tasksRepository.save(task);
	}
	
	@Override
	public void deleteTaskById(Long taskId) {
		tasksRepository.deleteById(taskId);
		
	}
	
	
	@Override
	public Tasks updateState(Long taskId, boolean state) {
		Tasks task = tasksRepository.getById(taskId);
		task.setState(state);
		
			return tasksRepository.save(task);
	}
	
	
	@Override
	public Tasks updateAdvancement(Long taskId, int advancement) {
		Tasks task = tasksRepository.getById(taskId);
		task.setAdvancement(advancement);
		return tasksRepository.save(task);
	}
	
	
	public Tasks affectTaskToProject(Long taskId, Long projectId){
		Tasks task = tasksRepository.getById(taskId);
		Projects project = projectRepository.getById(projectId);
		task.setProject(project);
		return tasksRepository.save(task);

	}
	
	
	@Override
	public void affectemployeetotask(Long employeeId, Long taskId){
		User employee= new User();
		employee = userRepository.findById(employeeId).get();
		Tasks task = new Tasks(); 
		task= tasksRepository.findById(taskId).get();
		
		if ((task.getEmployee().contains(employeeId)==false))
		{
			task.getEmployee().add(employeeId);
			tasksRepository.save(task);
		}
	}
	
	
	
	@Override
	public void removeEmployeeFromTask(Long employeeId, Long taskId){
		User employee= new User();
		employee = userRepository.findById(employeeId).get();
		Tasks task = new Tasks(); 
		task= tasksRepository.findById(taskId).get();
		if ((task.getEmployee().contains(employeeId)==true))
		{
			task.getEmployee().remove(employeeId);
			tasksRepository.save(task);
		}
	}
	
	
	public List<Tasks> tasksByEmployee(Long employeeId){
		List<Tasks> tasks =tasksRepository.findAll();
		List<Tasks> tasksByEmployee =new  ArrayList<Tasks>();
		for (Tasks task : tasks){
			if ((task.getEmployee().contains(employeeId)==true))
			{
				tasksByEmployee.add(task);
			}
		}
		return  tasksByEmployee;
	}
	
	
	
	

}
