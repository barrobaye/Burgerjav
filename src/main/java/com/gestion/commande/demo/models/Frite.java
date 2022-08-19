package com.gestion.commande.demo.models;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Frite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  Integer prix;

    @OneToMany(mappedBy="frite")
    private List<Menus> menus = new ArrayList<>();
}
