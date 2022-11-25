package com.gestion.commande.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gestion.commande.demo.models.Burgers;
import com.gestion.commande.demo.services.BurgerService;

@Controller
public class ListProduitController {
    @Autowired
    BurgerService burgerService;
    @GetMapping({"/liste-produit", "/liste-produit"})
    public String getViewListProduit(Model model) {
        List<Burgers> burgers = burgerService.getAllBurgers();
        model.addAttribute("burgers",burgers);
        return "burger/liste";
    }

    @GetMapping({"/burger/delete/{id}" , "/burger/delete/{id}"})
    public String getViewListProduit(@PathVariable Long id,Model model){
        Burgers burgers = burgerService.findBurgersById(id);
        if(){

        }
        return "burger/liste";
    }
}
