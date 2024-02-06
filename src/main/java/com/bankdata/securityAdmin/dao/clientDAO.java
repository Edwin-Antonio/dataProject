package com.bankdata.securityAdmin.dao;

import java.util.List;

import com.bankdata.securityAdmin.entity.Client;

public interface clientDAO {

    List<Client> findAll();
    
}
