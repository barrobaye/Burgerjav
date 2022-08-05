package com.gestion.commande.demo.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Burgers {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private int prix;
    private String description;

 
    @OneToMany(mappedBy = "burgers")
    private List<CommandesBurgers> commandesBurgers = new ArrayList<>(); 


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getLibelle() {
        return libelle;
    }


    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public int getPrix() {
        return prix;
    }


    public void setPrix(int prix) {
        this.prix = prix;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public List<CommandesBurgers> getCommandeBurgers() {
        return commandesBurgers;
    }


    public void setCommandesBurgers(List<CommandesBurgers> commandesBurgers) {
        this.commandesBurgers = commandesBurgers;
    } 
    
}
