package com.bankdata.securityAdmin.service;

import java.util.List;

import com.bankdata.securityAdmin.entity.Client;

public interface clientService {
    List<Client> findAll();

    //Mandamos llamar un metodo para encontrar un cliente
    //mediante su ID
    Client findById(int id);

    //Mandamos llamar un metodo para guardar un cliente
    Client save(Client client);

    //Mandamos llamar un metodo para eliminar cliente
    //meidante su ID
    void deleteById(int id);
}
