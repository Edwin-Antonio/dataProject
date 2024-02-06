package com.bankdata.securityAdmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankdata.securityAdmin.dao.clientDAO;
import com.bankdata.securityAdmin.entity.Client;

@Service
public class clienServiceImpl implements clientService{

    //Hacemos la injección de nuestro objeto cliente en nuestro servicio
    public clientDAO clientDAO;

    @Autowired
    public clienServiceImpl(clientDAO theClientDAO){
        clientDAO = theClientDAO;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }
    
}
