package org.example.backendspring.repositories;

import org.example.backendspring.models.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExamenRepository extends JpaRepository<Examen , Long> {

    Examen findByName(String name) ;

    List<Examen> findAllByStart(LocalDate start) ;
}
