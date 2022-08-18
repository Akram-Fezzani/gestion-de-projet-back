package com.stage.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.dev.models.Projects;
import com.stage.dev.models.Tasks;
import com.stage.dev.repository.TasksRepository;
import com.stage.dev.serviceInterface.IRoleService;
import com.stage.dev.serviceInterface.ITasksService;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class TasksServiceImpl implements ITasksService {

	
	
	@Autowired
	TasksRepository tasksRepository;
	
	
	
	
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
	
}
