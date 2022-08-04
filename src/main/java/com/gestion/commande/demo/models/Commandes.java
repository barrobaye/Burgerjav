package com.gestion.commande.demo.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Commandes {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id ;
    public Date DateduCommande;
    public EtatCommandes etatCommandes;
    
}
