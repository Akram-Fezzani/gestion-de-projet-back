package com.stage.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.dev.models.Report;
import com.stage.dev.repository.ReportRepository;
import com.stage.dev.serviceInterface.IReportService;
import com.stage.dev.serviceInterface.IRoleService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ReportServiceImpl implements IReportService{
	

	
	@Autowired
	ReportRepository reportRepository;
	
	
	
	
	@Override
	public List<Report> findAll() {
		return  reportRepository.findAll();
	}
	
	
	
	@Override
	public Report addReport(Report role) {
		
	return reportRepository.save(role);
	}
	
	@Override
	public Report updateReport(Report report, Long reportID) {
			report.setId(reportID);
			return reportRepository.save(report);
	}
	
	@Override
	public void deleteReportById(Long roleID) {
		reportRepository.deleteById(roleID);
		
	}
}
