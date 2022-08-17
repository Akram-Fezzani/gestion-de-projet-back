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

import com.stage.dev.models.ReportType;
import com.stage.dev.serviceInterface.IReportTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Manage Report Type")
@RequestMapping("/ReportType")
public class ReportTypeController {

	
	
	@Autowired
	IReportTypeService reportTypeService;
	
	
    @PostMapping("/post")
    @ApiOperation(value = "add Report Type")
	@ResponseBody
	public ReportType add(@RequestBody ReportType reportType) {
	        return reportTypeService.addReportType(reportType);
	    }
    
    
    
    @ApiOperation(value = "Update Report Type")
	@PostMapping("updateReportType/{ReportTypeID}")
	@ResponseBody
	ReportType updateReportType(@RequestBody ReportType reportType,@PathVariable Long ReportTypeID){
    	return reportTypeService.updateReportType(reportType, ReportTypeID);
	}
    
    
    @GetMapping("/getReportType")
    @ResponseBody
    public List<ReportType> findAll() {
        return reportTypeService.findAll();
    }
    

    @DeleteMapping("/delete/{ReportTypeID}")
    public void deleteReportTypeById(@PathVariable Long ReportTypeID) {
    	reportTypeService.deleteReportTypeById(ReportTypeID);
    
    }
}
