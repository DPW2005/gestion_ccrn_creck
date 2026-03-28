package org.example.backendspring.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Examen {

    @Setter
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(unique = true)
    public String name ;

    public LocalDate start ;

    public LocalDate finish ;

    @ManyToMany
    @JoinTable(name = "exam_class", joinColumns = @JoinColumn(name = "examen_id"), inverseJoinColumns = @JoinColumn(name = "classe_id"))
    public List<Classe> classes ;

    @OneToMany(mappedBy = "examen")
    public List<Bulletin> bulletins ;

    @OneToMany(mappedBy = "examen")
    public List<Evaluation> evaluations ;

}
