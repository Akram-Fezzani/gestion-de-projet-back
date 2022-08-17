package com.stage.dev.serviceInterface;

import java.util.List;

import com.stage.dev.models.TaskType;


public interface ITaskTypeService {

	
	
	List<TaskType> findAll();

	TaskType addTaskType(TaskType taskType);

	TaskType updateTaskType(TaskType taskType, Long taskTypeID);

	void deleteTaskTypeById(Long taskTypeID);
}
