package com.gestion.commande.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControlleur {
    @GetMapping({"/.", "/index"})
    public String index(Model model){
        model.addAttribute("e221", "message ici on n'a pas peur de mourir");
        return "index";
    }
}
