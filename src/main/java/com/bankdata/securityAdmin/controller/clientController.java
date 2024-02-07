package com.bankdata.securityAdmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/leaderList")
    public String clientLeaderList(Model model){
        List<Client> theClients = clientService.findAll();

        model.addAttribute("clientes", theClients);

        return("leadersPage");
    }

    @GetMapping("/formAddClient")
    public String showFormAddClient(Model model){

        Client newClient = new Client();

        model.addAttribute("addClient", newClient);
        return "addClientForm";
    }

    @GetMapping("/formUpdateClient")
    public String updateClient(@RequestParam("clientId") int theId, Model model){
        //Obtenemos el servicio del cliente
        Client theClient = clientService.findById(theId);
        // insertamos al cliente en el modelo **NOTA** Si se trata de actualizar forzosamente en nuestro formulario debemos poner un campo
        // con el ID de nuestro objeto de forma escondida
        model.addAttribute("addClient",theClient); // El atributo que colocamos aquí es el que usamos para nuestro metodo guardar
        // mandamos la informacion a nuestro formulario
        return "/addClientForm";
    }

    @PostMapping("/save")
    public String saveClient(@ModelAttribute("addClient") Client theClient){
        clientService.save(theClient);
        return "redirect:/leaderList";
    }

    @GetMapping("/deleteClient")
    public String deleteClient(@RequestParam("clientId") int theId){
        // Eliminamos cliente
        clientService.deleteById(theId);
        //Redirigimos a la pagina de nuestra lista
        return "redirect:/leaderList";
    }

}
