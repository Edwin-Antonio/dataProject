package com.bankdata.securityAdmin.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bankdata.securityAdmin.entity.client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class clientImpl implements clientDAO {

    //Definimos los campos para la gestion de nuestra entidad
    private EntityManager entityManager;

    //Hacemos la injeccion de nuestro constructor
    @Autowired
    private clientImpl(EntityManager client){
        entityManager = client;
    }

    @Override
    public List<client> findAll(){

        // Creamos nuestro query
        TypedQuery<client> query = entityManager.createNamedQuery("from client", client.class);

        // Mandamos a ejecutar el query
        List<client> clientes = query.getResultList(); 

        // retornamos valores
        return clientes;
    }
}
