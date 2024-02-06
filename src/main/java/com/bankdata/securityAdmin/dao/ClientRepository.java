package com.bankdata.securityAdmin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bankdata.securityAdmin.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
    
}
