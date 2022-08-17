package com.stage.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.dev.models.TaskType;
import com.stage.dev.repository.TaskTypeRepository;
import com.stage.dev.serviceInterface.ITaskTypeService;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class TaskTypeServiceImpl implements ITaskTypeService{

	
	
	@Autowired
	TaskTypeRepository taskTypeRepository;
	
	
	
	
	@Override
	public List<TaskType> findAll() {
		return  taskTypeRepository.findAll();
	}
	
	
	
	@Override
	public TaskType addTaskType(TaskType role) {
		
	return taskTypeRepository.save(role);
	}
	
	@Override
	public TaskType updateTaskType(TaskType taskType, Long taskTypeId) {
		
		taskType.setId(taskTypeId);
			return taskTypeRepository.save(taskType);
	}
	
	@Override
	public void deleteTaskTypeById(Long taskTypeId) {
		taskTypeRepository.deleteById(taskTypeId);
		
	}
}
