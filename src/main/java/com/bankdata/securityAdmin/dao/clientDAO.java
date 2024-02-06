package com.bankdata.securityAdmin.dao;

import java.util.List;

import com.bankdata.securityAdmin.entity.client;

public interface clientDAO {

    List<client> findAll();
}
