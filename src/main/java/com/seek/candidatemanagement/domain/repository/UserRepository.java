package com.seek.candidatemanagement.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seek.candidatemanagement.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {    
    Optional<User> findByUsername(String username); 
}
