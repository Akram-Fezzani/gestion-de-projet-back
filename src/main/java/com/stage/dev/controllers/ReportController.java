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

import com.stage.dev.models.Report;
import com.stage.dev.serviceInterface.IReportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Manage Report")
@RequestMapping("/Report")
public class ReportController {

	
	
	@Autowired
	IReportService reportService;
	
	
    @PostMapping("/post")
    @ApiOperation(value = "add Report")
	@ResponseBody
	public Report add(@RequestBody Report report) {
	        return reportService.addReport(report);
	    }
    
    
    
    @ApiOperation(value = "Update Report")
	@PostMapping("updateProject/{ReportID}")
	@ResponseBody
	Report updateReport(@RequestBody Report report,@PathVariable Long ReportID){
    	return reportService.updateReport(report, ReportID);
	}
    
    
    @GetMapping("/getReports")
    @ResponseBody
    public List<Report> findAll() {
        return reportService.findAll();
    }
    

    @DeleteMapping("/delete/{ReportID}")
    public void deleteReportById(@PathVariable Long ReportID) {
    	reportService.deleteReportById(ReportID);
    
    }
}
