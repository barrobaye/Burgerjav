package com.gestion.commande.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CommandesBurgers {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String numéro;


    @ManyToOne
    @JoinColumn(name = "commandes", referencedColumnName = "id")
    private Commandes commandes;

     @ManyToOne
    @JoinColumn(name = "burgers" , referencedColumnName = "id")
    private Burgers burgers; 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNuméro() {
        return numéro;
    }

    public void setNuméro(String numéro) {
        this.numéro = numéro;
    }

    public Commandes getCommande() {
        return commandes;
    }

    public void setCommande(Commandes commande) {
        this.commandes = commande;
    }

  public Burgers getBurger() {
        return burgers;
    }

    public void setBurger(Burgers burger) {
        this.burgers = burger;
    } 
}
