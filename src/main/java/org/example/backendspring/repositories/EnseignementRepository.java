package org.example.backendspring.repositories;

import org.example.backendspring.models.Classe;
import org.example.backendspring.models.Enseignant;
import org.example.backendspring.models.Enseignement;
import org.example.backendspring.models.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnseignementRepository extends JpaRepository<Enseignement , Long> {

    Enseignement findByName(String name) ;

    List<Enseignement> findAllByClasse(Classe classe) ;

    List<Enseignement> findAllByMatiere(Matiere matiere) ;

    List<Enseignement> findAllByEnseignant(Enseignant enseignant) ;
}
