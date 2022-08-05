package com.gestion.commande.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.commande.demo.models.Burgers;

public interface BurgersRepository extends JpaRepository < Burgers , Long> {
    
    // @Query("SELECT c FROM Categorie c WHERE c.nom=:nom")
    Optional<Burgers> findByNom(String nom);
}