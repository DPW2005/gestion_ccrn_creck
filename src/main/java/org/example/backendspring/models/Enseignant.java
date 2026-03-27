package org.example.backendspring.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
public class Enseignant {

    @Setter
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    public String name ;

    public String phone ;

    @OneToMany(mappedBy = "enseignant")
    public List<Enseignement> enseignements ;

}
