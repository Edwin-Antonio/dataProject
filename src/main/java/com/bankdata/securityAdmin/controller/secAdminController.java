package com.bankdata.securityAdmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class secAdminController {

    @GetMapping("/")
    public String loginPage(){
     return "homePage";
    }

    //Mapeo para entrar a pagina de leaders o admins
    @GetMapping("/leaders")
    public String leadersAdministration(){
        return "redirect:/leaderList";
    }

    @GetMapping("/system")
    public String systemsAdministration(){
        return "redirect:/list";
    }

    //Mapeo para accessos denegados
    @GetMapping("/access-denied")
    public String accessDenied(){
        return "accessDeniedPage";
    }
}
