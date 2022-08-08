package com.gestion.commande.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gestion.commande.demo.models.Images;


public interface ImagesRepository extends JpaRepository  < Images , Long>{
 @Query("SELECT i FROM Images i WHERE i.name=:name")
 Optional<Images> findByName(String name);
    
}
