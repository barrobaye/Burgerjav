package com.gestion.commande.demo.models;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Boissons {

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return this.mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public TailleBoissons getTaille() {
        return this.taille;
    }

    public void setTaille(TailleBoissons taille) {
        this.taille = taille;
    }
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String mark;
    public String image;


    @ManyToOne
    @JoinColumn(name = "taille", referencedColumnName ="id")
    private TailleBoissons taille;
}

