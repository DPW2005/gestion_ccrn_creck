package org.example.backendspring.repositories;

import org.example.backendspring.models.Classe;
import org.example.backendspring.models.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClasseRepository extends JpaRepository<Classe , Long> {

    Classe findByName(String name) ;
}
