package com.stage.dev.serviceInterface;

import java.util.List;

import com.stage.dev.models.Report;

public interface IReportService {

	
	
	List<Report> findAll();

	Report addReport(Report report);

	Report updateReport(Report report, Long reportID);

	void deleteReportById(Long reportID);
}
