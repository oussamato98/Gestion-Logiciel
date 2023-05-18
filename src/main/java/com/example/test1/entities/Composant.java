package com.example.test1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Composant {

    @EmbeddedId
    CompKey id ;
    String description ;
    URL url ;
    @ManyToOne
    Logiciel logiciel  ;

    @ManyToMany(mappedBy = "composantlicence",fetch = FetchType.EAGER)
    List<Licence> licencecomposant = new ArrayList<>();
}
