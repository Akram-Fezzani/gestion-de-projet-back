package com.stage.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.dev.models.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>{

}
