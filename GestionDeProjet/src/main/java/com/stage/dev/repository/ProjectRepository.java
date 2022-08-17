package com.stage.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.dev.models.Projects;

@Repository
public interface ProjectRepository extends JpaRepository<Projects, Long>{

}
