package com.example.test1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application extends Logiciel{

    @ManyToMany(fetch = FetchType.EAGER)
    List<Logiciel> logicielapplication = new ArrayList<>();


}
