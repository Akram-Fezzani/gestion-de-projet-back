package com.stage.dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.stage.dev.models.User;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  @Query("SELECT c FROM User c WHERE c.email = ?1")

  public User findByEmail(String email);

  public User findByResetPasswordToken(String token);


  @Modifying
  @Transactional
  @Query(value = "DELETE FROM user_saved_posts WHERE saved_posts = ?1 && user_id = ?2", nativeQuery = true)
    void unsavePost(Long postId, Long userId);
  
  @Query(value = "select count(*) from user", nativeQuery = true)
  int numberofusers();
  
  @Query(value = "select count(*) FROM user WHERE user.state = true" , nativeQuery = true)
  int numberofactiveusers();
  
  
  public User getByusername(String username);
  
  
}
