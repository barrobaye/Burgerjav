package com.gestion.commande.demo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Commandes {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id ;
    private Date dateDuCommande;
    private EtatCommandes etatCommandes;

    @OneToMany(mappedBy = "commandes")
    private List<CommandesBurgers> CommandesBurgers = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDuCommande() {
        return dateDuCommande;
    }

    public void setDateDuCommande(Date dateDuCommande) {
        this.dateDuCommande = dateDuCommande;
    }

    public EtatCommandes getEtatCommandes() {
        return etatCommandes;
    }

    public void setEtatCommandes(EtatCommandes etatCommandes) {
        this.etatCommandes = etatCommandes;
    }

    public List<CommandesBurgers> getCommandesBurgers() {
        return CommandesBurgers;
    }

    public void setCommandesBurgers(List<CommandesBurgers> commandesBurgers) {
        CommandesBurgers = commandesBurgers;
    }
    
}
