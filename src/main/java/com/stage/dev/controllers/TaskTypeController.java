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

import com.stage.dev.models.TaskType;
import com.stage.dev.serviceInterface.ITaskTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Manage TaskTypes")
@RequestMapping("/TaskType")
public class TaskTypeController {

	
	
	
	
	

	@Autowired
	ITaskTypeService taskTypeService;
	
	
    @PostMapping("/post")
    @ApiOperation(value = "add Task")
	@ResponseBody
	public TaskType add(@RequestBody TaskType taskType) {
	        return taskTypeService.addTaskType(taskType);
	    }
    
    
    
    @ApiOperation(value = "Update Task Type")
	@PostMapping("updateTask/{taskTypeID}")
	@ResponseBody
	TaskType updateTaskType(@RequestBody TaskType taskType,@PathVariable Long taskTypeID){
    	return taskTypeService.updateTaskType(taskType, taskTypeID);
	}
    
    
    @GetMapping("/getTaskType")
    @ResponseBody
    public List<TaskType> findAll() {
        return taskTypeService.findAll();
    }
    

    @DeleteMapping("/delete/{tasTupekID}")
    public void deleteTaskTypeById(@PathVariable Long tasTupekID) {
    	taskTypeService.deleteTaskTypeById(tasTupekID);
    
    }
}
