package com.gestion.commande.demo.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.commande.demo.models.Boissons;
import org.springframework.stereotype.Repository;

@Repository
public interface BoissonRepository extends JpaRepository <Boissons , Long> {
    
}
