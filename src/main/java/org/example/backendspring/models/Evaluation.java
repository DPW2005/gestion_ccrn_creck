package org.example.backendspring.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
public class Evaluation {

    @Setter
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(unique = true)
    public String name  ;

    @ManyToOne
    public Examen examen ;

    @ManyToOne
    public Enseignement enseignement ;

    @OneToMany(mappedBy = "evaluation")
    public List<Note> notes ;
}
