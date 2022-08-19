package com.gestion.commande.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class CommandeMenus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numéro;

    @ManyToOne
    @JoinColumn(name = "commandes", referencedColumnName = "id")
    private Commandes commandes;

    @ManyToOne
    @JoinColumn(name = "menus" , referencedColumnName = "id")
    private Menus menus;
}
