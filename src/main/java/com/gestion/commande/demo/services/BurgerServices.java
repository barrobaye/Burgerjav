package com.gestion.commande.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.commande.demo.models.Burgers;
import com.gestion.commande.demo.repositories.BurgersRepository;

import lombok.extern.java.Log;



@Service
@Log
public class BurgerServices {

    @Autowired
    private BurgersRepository burgersRepository;

    ///Ajouter Burger////
    public Burgers addBurgers( Burgers burgers){
        try {
            burgersRepository.save(burgers);
            return burgers;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
        ///Suprimer Burger////
    public boolean deleteBurgers(Burgers burgers) {
        try {
            burgersRepository.delete(burgers);
            return true;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
}
