package org.example.backendspring.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
public class Classe {

    @Setter
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    public String name ;

    public String place ;

    @OneToMany(mappedBy = "classe")
    public List<Enseignement> enseignements ;

    @OneToMany(mappedBy = "classe")
    public List<Eleve> eleves ;

    @OneToMany(mappedBy = "classe")
    public List<Appel> appels ;

    @ManyToMany(mappedBy = "classes")
    public List<Examen> examens ;


}
