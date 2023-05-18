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
public class Licence {

    @EmbeddedId
    LicKey id ;

    @Lob
    String texte ;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Logiciel> logiciellicence = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    List<Composant> composantlicence = new ArrayList<>();

}
