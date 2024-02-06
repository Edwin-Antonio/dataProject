package com.bankdata.securityAdmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankdata.securityAdmin.dao.clientDAO;
import com.bankdata.securityAdmin.entity.Client;

import jakarta.transaction.Transactional;

@Service
public class clientServiceImpl implements clientService{

    //Hacemos la injección de nuestro objeto cliente en nuestro servicio
    public clientDAO clientDAO;

    @Autowired
    public clientServiceImpl(clientDAO theClientDAO){
        clientDAO = theClientDAO;
    }

    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
    }

    @Override
    public Client findClient(int id) {
        return clientDAO.findClient(id);
    }

    @Transactional //Cada vez que nosotros realicemos una modificación a la DB ocuparemos la notación Transactional
    @Override
    public Client saveClient(Client client) {
        return clientDAO.saveClient(client);
    }

    @Transactional //Cada vez que nosotros realicemos una modificación a la DB ocuparemos la notación Transactional
    @Override
    public void deleteBy(int id) {
        clientDAO.deleteBy(id);
    }
    
}
