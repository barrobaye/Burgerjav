package com.gestion.commande.demo.services;
import com.gestion.commande.demo.models.Frite;
import com.gestion.commande.demo.repositories.FriteRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log
public class FriteService {
    @Autowired
    private FriteRepository friteRepo;
    public Frite addFrites(Frite frite) {
        try {
            friteRepo.save(frite);
            return frite;
        } catch (Exception e) {
            log.severe(e.getLocalizedMessage());
            throw e;
        }
    }
}
