package com.bankdata.securityAdmin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bankdata.securityAdmin.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
   /* 
   * No es necesario poner el codigo de Implementación y DAO, la propia dependencia de JPA
   * hace el trabajo por nosotros en 2do plano con los metodos basicos como findAll, save, update, delete, etc...
   */ 

   /*  Nuevo Metodo de Ordenar
   * Agregamos un methodo nuevo para decir que ordene los datos de nuestro cliente de forma alfabetica usando el second name
   * Aqui debemos de seguir la misma estructura como se ve aquí, coincidiendo el nombre de nuestras tablas con lo que 
   * estamos pidiendo en el metodo a realizar y modificamos en nuestra clase de Implementation con la nueva función
   */
   public List<Client> findAllByOrderByFirstNameAsc();
}
