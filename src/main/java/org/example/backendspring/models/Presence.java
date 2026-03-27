package org.example.backendspring.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Presence {

    @Setter
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    public String name ;

    public Boolean present ;

    @ManyToOne
    public Eleve eleve ;

    @ManyToOne
    public Appel appel ;
}
