package com.example.repository;

import com.example.model.UserRegister;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRegister, Long> {
    UserRegister findByEmail(String email);
//    UserRegister findByUsername(String username);
//    UserRegister findBypassword(String password);
    
    Optional<UserRegister> findByusername(String username);
    
    Optional<UserRegister> findByUsername(String username);

    
    Optional<UserRegister> findByPassword(String password);
    
    
    
    
    
    
    
    
    
    
    
}
