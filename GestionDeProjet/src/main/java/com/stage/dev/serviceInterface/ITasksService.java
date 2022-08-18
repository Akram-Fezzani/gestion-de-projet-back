package com.stage.dev.serviceInterface;

import java.util.List;

import com.stage.dev.models.Projects;
import com.stage.dev.models.Tasks;


public interface ITasksService {

	
	
	List<Tasks> findAll();

	Tasks addTask(Tasks tasks);

	Tasks updateTask(Tasks tasks, Long taskID);

	void deleteTaskById(Long taskID);
	
	Tasks updateState(Long taskID, boolean state);
	
	Tasks updateAdvancement(Long projectId, int advancement);

	Tasks affectTaskToProject(Long taskId, Long projectId);
	
	void removeEmployeeFromTask(Long employeeId, Long taskId);
	
	void affectemployeetotask(Long employeeId, Long taskId);
}
