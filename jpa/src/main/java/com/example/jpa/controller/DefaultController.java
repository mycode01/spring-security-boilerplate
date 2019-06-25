package com.example.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class DefaultController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/hello")
    public String hello(Principal principal, Model model){
        model.addAttribute("name", principal.getName());
        return "hello";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/helloAdmin")
    public String helloAdmin(Principal principal, Model model){
        model.addAttribute("name", principal.getName());
        return "hello";
    }


}
