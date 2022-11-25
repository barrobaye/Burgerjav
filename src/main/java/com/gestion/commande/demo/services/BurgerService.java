package com.gestion.commande.demo.services;

import com.gestion.commande.demo.models.Burgers;
import com.gestion.commande.demo.repositories.BurgersRepository;
import lombok.extern.java.Log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log
public class BurgerService {
    @Autowired
    private BurgersRepository burgerRepo;
    public Burgers addBurgers(Burgers burgers) {
        try {
            burgerRepo.save(burgers);
            return burgers;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
    public List<Burgers> getAllBurgers(){
        return burgerRepo.findAll();
    }
    public Burgers findBurgersById(Long id){
        return burgerRepo.findById(id).orElse(null);
    }
    public boolean deleteBurgers(Burgers burgers){
        try {
            burgerRepo.delete(burgers);
            return true;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
}
