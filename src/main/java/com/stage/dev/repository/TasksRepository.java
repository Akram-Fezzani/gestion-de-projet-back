package com.stage.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stage.dev.models.Tasks;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long>{

}
