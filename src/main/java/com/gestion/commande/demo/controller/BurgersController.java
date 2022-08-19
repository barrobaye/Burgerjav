package com.gestion.commande.demo.controller;

import com.gestion.commande.demo.models.Burgers;
import com.gestion.commande.demo.services.BurgerService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.annotation.Target;

@Controller
public class BurgersController {
    @Autowired
    BurgerService burgerService;

    @GetMapping({"/burger", "/burger"})
    public String getViewAddBurger(Model model) {
        Burgers burgers = new Burgers();
        model.addAttribute("burgers",burgers);
        return "burger/index";
    }
  @PostMapping("/addBurger")
    public String addBurgers(@ModelAttribute("Burgers") Burgers burgers, Model model , Integer nbr) {
        if(burgers == null || burgers.getLibelle() == null || burgers.getLibelle().equals("")) {
            model.addAttribute("errorNom", "Champ obligatoire");
            return "burger/index.html";
        }
            for (int i=0; i<burgers.getNbr(); ++i){
                      burgerService.addBurgers(burgers);
                      i =+1;
            }

        if (burgers.getId() != null) {
            return "index";
        } else {
            model.addAttribute("error", "Echec de l'operation");
            return "burger/index";
        }

    }
    

}
