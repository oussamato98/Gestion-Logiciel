package com.example.test1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {

    @Id
    String nom ;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Logiciel> logicielListSecondaire = new ArrayList<>();
    @OneToMany(mappedBy = "categorieListPrincipale",fetch = FetchType.EAGER)
    List<Logiciel> logicielListPricipale = new ArrayList<>();
}
