package com.bankdata.securityAdmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankdata.securityAdmin.dao.EmployeeRepository;
import com.bankdata.securityAdmin.entity.Employee;

@Service
public class employeeServiceImpl implements employeeService{

    public EmployeeRepository employeeRepository;

    @Autowired
    public employeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByUsernameAsc();
    }

    @Override
    public Employee findByUsername(String username) {
        Optional<Employee> result = Optional.ofNullable(employeeRepository.findByUsername(username));
        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        }else{ //En caso de no encontrar el ID del cliente
            throw new RuntimeException("Did not find client ID");
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteByUsername(String username) {
        employeeRepository.deleteByUsername(username);
    }
    
}
