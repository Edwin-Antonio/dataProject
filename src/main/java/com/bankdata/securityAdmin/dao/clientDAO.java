package com.bankdata.securityAdmin.dao;

import java.util.List;

import com.bankdata.securityAdmin.entity.Client;

//Creamos una interfaz para nuestro modelo MVC
public interface clientDAO {

    //Mandamos llamar un metodo para mostrar una lista de tipo clientes
    List<Client> findAll();
    
    //Mandamos llamar un metodo para encontrar un cliente
    Client findClient(int id);

    //Mandamos llamar un metodo para guardar un cliente
    Client saveClient(Client client);

    //Mandamos llamar un metodo para eliminar cliente
    void deleteBy(int id);
}
