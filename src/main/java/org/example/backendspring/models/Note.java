package org.example.backendspring.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Note {

    @Setter
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    public double value ;

    @ManyToOne
    public Eleve eleve ;

    @ManyToOne
    public Evaluation evaluation ;

    @ManyToOne
    public Bulletin bulletin ;
}
