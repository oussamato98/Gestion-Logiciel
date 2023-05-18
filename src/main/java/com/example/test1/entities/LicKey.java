package com.example.test1.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
@Embeddable
@Data
public class LicKey implements Serializable {

    String nom ;
    @Embedded
    Version version ;
    String langue ;
}
