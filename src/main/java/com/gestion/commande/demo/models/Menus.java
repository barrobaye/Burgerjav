package com.gestion.commande.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class Menus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String libelle;
    public int prix;
    public String description;

    @ManyToOne
    @JoinColumn(name = "frite",referencedColumnName = "id")
    private Frite frite ;

    @ManyToOne
    @JoinColumn(name = "tailleboissons",referencedColumnName = "id")
    private TailleBoissons tailleboissons ;


}
