package com.bankdata.securityAdmin.service;

import java.util.List;

import com.bankdata.securityAdmin.entity.Employee;

public interface employeeService {
    List<Employee> findAll();

    Employee findByUsername(String username);

    Employee save(Employee employee);

    void deleteByUsername(String username);
}
