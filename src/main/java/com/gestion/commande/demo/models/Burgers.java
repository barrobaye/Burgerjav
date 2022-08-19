package com.gestion.commande.demo.models;





import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Getter
@Setter
public class Burgers {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    public String libelle;
    public Integer prix;
    public String description;
    public Integer nbr;

 
    @OneToMany(mappedBy = "burgers")
    private List<CommandesBurgers> commandesBurgers = new ArrayList<>(); 

}
