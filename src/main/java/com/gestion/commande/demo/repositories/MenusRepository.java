package com.gestion.commande.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestion.commande.demo.models.Menus;
import org.springframework.stereotype.Repository;

@Repository
public interface MenusRepository extends JpaRepository <Menus , Long> {
    
}
