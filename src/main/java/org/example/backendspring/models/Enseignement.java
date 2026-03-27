package org.example.backendspring.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.backendspring.enums.Day;

import java.util.List;

@Entity
@Data
public class Enseignement {

    @Setter
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    public String name ;

    @ElementCollection
    public List<String> days ;

    @OneToMany(mappedBy = "enseignement")
    public List<Evaluation> evaluations ;

    @ManyToOne
    public Enseignant enseignant ;

    @ManyToOne
    public Matiere matiere ;

    @ManyToOne
    public Classe classe ;
}
