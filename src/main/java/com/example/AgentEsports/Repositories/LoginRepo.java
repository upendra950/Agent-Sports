package com.example.AgentEsports.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AgentEsports.Entity.LoginPage;

public   interface LoginRepo extends JpaRepository<LoginPage,String> {

    Optional<LoginPage> findByUserName(String userName);
    
} 
