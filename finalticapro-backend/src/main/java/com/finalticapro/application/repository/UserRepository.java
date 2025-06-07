package com.finalticapro.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.finalticapro.application.entities.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    boolean existsByUsername(String username);
    
    boolean existsByEmail(String email);
    
    User findByEmail(String email);
    User findByUsername(String username);
	
}
