package com.bankdata.securityAdmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankdata.securityAdmin.dao.ClientRepository;
import com.bankdata.securityAdmin.entity.Client;

@Service
public class clientServiceImpl implements clientService{

    //Hacemos la injección de nuestro objeto cliente en nuestro servicio
    public ClientRepository clientRepository;

    @Autowired
    public clientServiceImpl(ClientRepository theClientRepository){
        clientRepository = theClientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(int id) {
        Optional<Client> result = clientRepository.findById(id);
        Client theClient = null;
        if (result.isPresent()) {
            theClient = result.get();
        }else{ //En caso de no encontrar el ID del cliente
            throw new RuntimeException("Did not find client ID");
        }
        return theClient;
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }
    
}
