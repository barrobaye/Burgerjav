package com.gestion.commande.demo.models;







import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Burgers {

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getPrix() {
        return this.prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<CommandesBurgers> getCommandesBurgers() {
        return this.commandesBurgers;
    }

    public void setCommandesBurgers(List<CommandesBurgers> commandesBurgers) {
        this.commandesBurgers = commandesBurgers;
    }
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
