package com.bankdata.securityAdmin.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bankdata.securityAdmin.entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class clientImpl implements clientDAO {

    //Definimos los campos para la gestion de nuestra entidad
    private EntityManager entityManager;

    //Hacemos la injeccion de nuestro constructor
    @Autowired
    public clientImpl(EntityManager client){
        entityManager = client;
    }

    @Override
    public List<Client> findAll(){

        // Creamos nuestro query
        TypedQuery<Client> query = entityManager.createQuery("from Client", Client.class);

        // Mandamos a ejecutar el query
        List<Client> clientes = query.getResultList(); 

        // retornamos valores
        return clientes;
    }

    @Override
    public Client findClient(int id) {

        Client clientId = entityManager.find(Client.class, id);

        return clientId;
    }

    @Override
    public Client saveClient(Client client) {
        
        //Guardamos valores de un cliente, si el ID llega a ser 0 hará un insert de caso contrario 
        //sera un update en la base de datos
        Client clientDB = entityManager.merge(client); 
        
        //Retornamos los valores del cliente
        return clientDB;
    }

    @Override
    public void deleteBy(int id) {
        
        //Primero encontramos el usuario que deseamos eliminar
        Client deleteClient = entityManager.find(Client.class,id);

        //Eliminamos usuairo
        entityManager.remove(deleteClient);
    }
}
