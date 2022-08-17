package com.stage.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.dev.models.ReportType;

@Repository
public interface ReportTypeRepository extends JpaRepository<ReportType, Long>{

}
