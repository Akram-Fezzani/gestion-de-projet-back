package com.stage.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stage.dev.models.ReportType;
import com.stage.dev.repository.ReportTypeRepository;
import com.stage.dev.serviceInterface.IReportTypeService;
import com.stage.dev.serviceInterface.IRoleService;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class ReportTypeServiceImpl implements IReportTypeService{
	
	
	
	
	@Autowired
	ReportTypeRepository reportTypeRepository;
	
	
	
	@Override
	public List<ReportType> findAll() {
		return  reportTypeRepository.findAll();
	}
	
	
	@Override
	public ReportType addReportType(ReportType reportType) {
		
	return reportTypeRepository.save(reportType);
	}
	
	@Override
	public ReportType updateReportType(ReportType reportType, Long reportTypeId) {
		
		reportType.setId(reportTypeId);
			return reportTypeRepository.save(reportType);
	}
	
	@Override
	public void deleteReportTypeById(Long reportTypeId) {
		reportTypeRepository.deleteById(reportTypeId);
		
	}
}
