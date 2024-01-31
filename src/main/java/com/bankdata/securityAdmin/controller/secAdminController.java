package com.bankdata.securityAdmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class secAdminController {

    @GetMapping("/")
    public String loginPage(){
     return "homePage";
    }

}
