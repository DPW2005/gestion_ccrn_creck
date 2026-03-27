package org.example.backendspring.repositories;

import org.example.backendspring.models.Enseignement;
import org.example.backendspring.models.Evaluation;
import org.example.backendspring.models.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation , Long> {

    Evaluation findByName(String name) ;

    List<Evaluation> findAllByExamen(Examen examen) ;

    List<Evaluation> findAllByEnseignement(Enseignement enseignement) ;
}
