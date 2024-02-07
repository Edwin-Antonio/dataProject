package com.bankdata.securityAdmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bankdata.securityAdmin.entity.Client;
import com.bankdata.securityAdmin.service.clientService;

@Controller
public class clientController {
    
    private clientService clientService;

    @Autowired
    public clientController(clientService theClientService){
        clientService = theClientService;
    }

    //Agregamos el mapeo para nuestra lista
    @GetMapping("/list")
    public String clientList(Model model){
        List<Client> theClients = clientService.findAll();

        model.addAttribute("clientes", theClients);

        return("listPage");
    }

    @GetMapping("/formAddClient")
    public String showFormAddClient(Model model){

        Client newClient = new Client();

        model.addAttribute("addClient", newClient);
        return "addClientForm";
    }

    @PostMapping("/save")
    public String saveClient(@ModelAttribute("addClient") Client theClient){
        clientService.save(theClient);
        return "redirect:/list";
    }

}
