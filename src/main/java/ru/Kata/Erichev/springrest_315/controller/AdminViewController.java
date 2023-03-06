package ru.Kata.Erichev.springrest_315.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminViewController {

    @GetMapping("/admin")
    public String showAdminPage(){
        return "admin";
    }

    @GetMapping("/admin/user-create")
    public String newUser(){
        return "user-create";
    }

    @GetMapping("/userAdmin")
    public String getUserAdmin() {
        return "userAdmin";
    }
}