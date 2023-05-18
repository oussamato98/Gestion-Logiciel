package com.example.test1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Logiciel {

    @EmbeddedId
    LogKey id ;
    @NonNull
    String Description ;
    @NonNull
    URL url ;
    @ManyToMany(mappedBy = "logicielListSecondaire",fetch = FetchType.EAGER)
    List<Categorie> categorieListSecondaire = new ArrayList<>();
    @ManyToOne
    public Categorie categorieListPrincipale ;

    @ManyToMany(mappedBy = "logiciellicence",fetch = FetchType.EAGER)
    List<Licence> licenceList = new ArrayList<>() ;

    @OneToMany(mappedBy = "logiciel",fetch = FetchType.EAGER)
    List<Composant> composantList = new ArrayList<>();

    @ManyToMany(mappedBy = "logicielapplication",fetch = FetchType.EAGER)
    List<Application> applicationList = new ArrayList<>();


}
