package com.gestion.commande.demo.repositories;

import com.gestion.commande.demo.models.Frite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriteRepository extends JpaRepository<Frite, Long> {
    
}
