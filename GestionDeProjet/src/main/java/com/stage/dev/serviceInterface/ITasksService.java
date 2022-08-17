package com.stage.dev.serviceInterface;

import java.util.List;

import com.stage.dev.models.Tasks;


public interface ITasksService {

	
	
	List<Tasks> findAll();

	Tasks addTask(Tasks tasks);

	Tasks updateTask(Tasks tasks, Long taskID);

	void deleteTaskById(Long taskID);
}
