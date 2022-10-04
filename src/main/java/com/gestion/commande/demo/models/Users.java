package com.gestion.commande.demo.models;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Users implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String password;

    @ManyToOne
    @JoinColumn(name = "role" , referencedColumnName = "id")
    protected Role role ;

}
