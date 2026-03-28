package org.example.backendspring.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
public class Bulletin {

    @Setter
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(unique = true)
    public String name ;

    @ManyToOne
    public Eleve eleve ;

    @ManyToOne
    public Examen examen ;

    @OneToMany(mappedBy = "bulletin")
    public List<Note> notes ;

}
