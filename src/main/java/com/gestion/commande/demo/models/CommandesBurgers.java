package com.gestion.commande.demo.models;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Getter
@Entity
@Setter
public class CommandesBurgers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numéro;

    @ManyToOne
    @JoinColumn(name = "commandes", referencedColumnName = "id")
    private Commandes commandes;

    @ManyToOne
    @JoinColumn(name = "burgers", referencedColumnName = "id")
    private Burgers burgers;
}

