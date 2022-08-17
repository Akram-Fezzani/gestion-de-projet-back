package com.stage.dev.serviceInterface;

import java.util.List;

import com.stage.dev.models.ReportType;


public interface IReportTypeService {

	
	
	List<ReportType> findAll();

	ReportType addReportType(ReportType reportType);

	ReportType updateReportType(ReportType reportType, Long reportTypeID);

	void deleteReportTypeById(Long reportTypeID);
}
