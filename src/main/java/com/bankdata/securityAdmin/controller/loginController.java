package com.bankdata.securityAdmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @GetMapping("/personalLoginPage")
    public String loginPage(){
        return "personalLoginPage";
    }
}
