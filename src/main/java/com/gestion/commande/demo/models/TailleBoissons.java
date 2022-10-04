package com.gestion.commande.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class TailleBoissons {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    public  Integer quantité;
    public  Integer prix;
    public String nomtaille;

    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName ="id")
    public  TypeBoissons type;

}
