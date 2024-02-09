package com.bankdata.securityAdmin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankdata.securityAdmin.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{
    public List<Employee> findAllByOrderByUsernameAsc();

    public Employee findByUsername(String username);

    public void deleteByUsername(String username); 
}
