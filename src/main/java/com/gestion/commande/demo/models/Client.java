package com.gestion.commande.demo.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private id;
    private nom;
    private prenom;
    private email;
    private passwd;
    private teléphone;
    
}
