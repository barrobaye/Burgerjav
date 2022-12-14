package com.gestion.commande.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Burgers {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    public String libelle;
    public Integer prix;
    public String description;
    public String image;


    @OneToMany(mappedBy = "burgers")
    private List<CommandesBurgers> commandesBurgers = new ArrayList<>(); 

}
