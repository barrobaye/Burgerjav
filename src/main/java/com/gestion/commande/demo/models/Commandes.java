package com.gestion.commande.demo.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Getter
@Setter
@Entity
public class Commandes {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id ;
    private Date dateDuCommande;
    private EtatCommandes etatCommandes;

    @OneToMany(mappedBy = "commandes")
    private List<CommandesBurgers> CommandesBurgers = new ArrayList<>();



}
