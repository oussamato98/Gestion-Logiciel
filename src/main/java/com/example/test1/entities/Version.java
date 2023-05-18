package com.example.test1.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Version  {

    int majeur ;
    int mineur ;
}
