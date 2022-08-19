package com.gestion.commande.demo.models;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("GESTIONNAIRE")
@Getter
@Setter
public class Gestionnaire extends Users {
    
}
