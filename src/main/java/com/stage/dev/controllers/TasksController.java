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

import com.stage.dev.models.Tasks;
import com.stage.dev.serviceInterface.ITasksService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Manage Tasks")
@RequestMapping("/Tasks")
public class TasksController {

	
	

	@Autowired
	ITasksService tasksService;
	
	
    @PostMapping("/post")
    @ApiOperation(value = "add Task")
	@ResponseBody
	public Tasks add(@RequestBody Tasks task) {
	        return tasksService.addTask(task);
	    }
    
    
    
    @ApiOperation(value = "Update Task")
	@PostMapping("updateTask/{taskID}")
	@ResponseBody
	Tasks updateTask(@RequestBody Tasks task,@PathVariable Long taskID){
    	return tasksService.updateTask(task, taskID);
	}
    
    
    @GetMapping("/getTask")
    @ResponseBody
    public List<Tasks> findAll() {
        return tasksService.findAll();
    }
    

    @DeleteMapping("/delete/{taskID}")
    public void deleteTaskById(@PathVariable Long taskID) {
    	tasksService.deleteTaskById(taskID);
    
    }
}
