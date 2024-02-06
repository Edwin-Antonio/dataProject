package com.bankdata.securityAdmin.service;

import java.util.List;

import com.bankdata.securityAdmin.entity.Client;

public interface clientService {
    List<Client> findAll();

    //Mandamos llamar un metodo para encontrar un cliente
    Client findClient(int id);

    //Mandamos llamar un metodo para guardar un cliente
    Client saveClient(Client client);

    //Mandamos llamar un metodo para eliminar cliente
    void deleteBy(int id);
}
