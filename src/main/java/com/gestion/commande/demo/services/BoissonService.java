package com.gestion.commande.demo.services;

import com.gestion.commande.demo.models.Boissons;
import com.gestion.commande.demo.repositories.BoissonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
public class BoissonService {
    @Autowired
    private BoissonRepository boissonRepo;
    public Boissons addBoissons(Boissons boisson) {
        try {
            boissonRepo.save(boisson);
            return boisson;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
    
}
