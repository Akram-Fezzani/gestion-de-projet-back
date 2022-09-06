package com.stage.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stage.dev.models.Contributor;
import com.stage.dev.models.User;

import java.util.List;

@Repository
public interface ContributorRepository extends JpaRepository<Contributor, Long>{

    Contributor findByUserContributor(User user);
    
    @Query(value = "select count(*) from contributor", nativeQuery = true)
    int numberofcontributors();
    
    
    @Query(value = "select * FROM contributor WHERE contributor.state = false" , nativeQuery = true)
    List<Contributor> nonapprovecontributors();
    
    @Modifying
    @Transactional
    @Query(value = "delete from contributor where contributor_id = ?1", nativeQuery = true)
    void deleteWithId(Long id);
    
}
