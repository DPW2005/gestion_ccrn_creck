package org.example.backendspring.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Appel {

    @Setter
    @Getter
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    public String name ;

    public LocalDate date ;

    @ManyToOne
    public Classe classe ;

    @OneToMany(mappedBy = "appel")
    public List<Presence> presences ;

}
