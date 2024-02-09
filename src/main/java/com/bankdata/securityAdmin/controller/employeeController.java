package com.bankdata.securityAdmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bankdata.securityAdmin.entity.Employee;
import com.bankdata.securityAdmin.service.employeeService;

@Controller
public class employeeController {
    private employeeService employeeService;

    @Autowired
    public employeeController(employeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //Agregamos el mapeo para nuestra lista
    @GetMapping("/list")
    public String clientList(Model model){
        List<Employee> theClients = employeeService.findAll();

        model.addAttribute("empleados", theClients);

        return("listPage");
    }
}
