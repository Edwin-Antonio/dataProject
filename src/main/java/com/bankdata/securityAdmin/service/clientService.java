package com.bankdata.securityAdmin.service;

import java.util.List;

import com.bankdata.securityAdmin.entity.Client;

public interface clientService {
    List<Client> findAll();
}
