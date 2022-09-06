package com.stage.dev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stage.dev.models.Projects;
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
    
    
    @ApiOperation(value = "Update State")
    @RequestMapping(value = "/updateState/{taskID}/{state}", method = RequestMethod.POST)
   	@ResponseBody
   	Tasks updateState(@PathVariable Long taskID,@PathVariable boolean state ){
       	return tasksService.updateState(taskID, state);
   	}
    
    
    
    @ApiOperation(value = "Update advancement")
    @RequestMapping(value = "/updateAdvancement/{taskID}/{advancement}", method = RequestMethod.POST)
   	@ResponseBody
   	Tasks updateAdvancement(@PathVariable Long taskID,@PathVariable int advancement){
       	return tasksService.updateAdvancement(taskID, advancement);
   	}
    
    @ApiOperation(value = "affectTaskToProject")
    @RequestMapping(value = "/affectTaskToProject/{taskID}/{projectId}", method = RequestMethod.POST)
   	@ResponseBody
   	Tasks affectTaskToProject(@PathVariable Long taskID,@PathVariable Long projectId){
       	return tasksService.affectTaskToProject(taskID, projectId);
   	}
    
    
    
    @ApiOperation(value = "Affect Employee To Task")
   	@PostMapping("affectEmployeeToTask/{employeeId}/{taskId}")
   	@ResponseBody
   	public void  affectEmployeeToTask(@PathVariable Long employeeId,@PathVariable Long taskId){
    	tasksService.affectemployeetotask(employeeId, taskId);
   	}



       @ApiOperation(value = "Remove Employee From Task")
     	@PostMapping("removefollow/{employeeId}/{taskId}")
     	@ResponseBody
     	public void  removeEmployeeFromTask(@PathVariable Long employeeId,@PathVariable Long taskId){
    	   tasksService.removeEmployeeFromTask(employeeId, taskId);
     	}
       

         
       
       @GetMapping("/getTasksByEmployee")
       @ResponseBody
       List<Tasks> tasksByEmployee(Long employeeId){
    	   return tasksService.tasksByEmployee(employeeId);
       }
}
