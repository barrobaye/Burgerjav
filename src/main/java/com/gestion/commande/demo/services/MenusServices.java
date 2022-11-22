package com.gestion.commande.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import com.gestion.commande.demo.repositories.MenusRepository;
import com.gestion.commande.demo.models.Menus;

import org.springframework.stereotype.Service;
import lombok.extern.java.Log;


@Service
@Log
public class MenusServices {
    @Autowired
    private MenusRepository menusRepository;

    ///Ajouter Menus////
    public Menus addBurgers( Menus menus){
        try {
            menusRepository.save(menus);
            return menus;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
    
        ///Suprimer Menus////
    public boolean deleteBurgers(Menus menus) {
        try {
            menusRepository.delete(menus);
            return true;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
    
}
