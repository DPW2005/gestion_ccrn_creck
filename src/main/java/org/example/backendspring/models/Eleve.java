package org.example.backendspring.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Eleve {

    @Setter
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(unique = true)
    public String matriculate ;

    @Column(unique = true)
    public  String name ;

    public LocalDate birthday ;

    public LocalDate registration ;

    public String ill ;

    @ManyToOne
    public Classe classe ;

    @ManyToOne
    public Etablissement etablissement ;

    @OneToMany(mappedBy = "eleve")
    public List<Presence> presences ;

    @OneToMany(mappedBy = "eleve")
    public List<Note> notes ;

    @OneToMany(mappedBy = "eleve")
    public List<Bulletin> bulletins ;

    @ManyToMany
    @JoinTable(name = "eleve_parent", joinColumns = @JoinColumn(name = "eleve_id"), inverseJoinColumns = @JoinColumn(name = "parent_id"))
    public List<Parent> parents ;

}
