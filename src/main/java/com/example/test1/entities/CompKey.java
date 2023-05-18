package com.example.test1.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import java.io.Serializable;
@Embeddable
@Data
public class CompKey implements Serializable {
    String code ;
    @Embedded
    Version version;
}
