package org.example.backendspring.repositories;

import org.example.backendspring.models.Classe;
import org.example.backendspring.models.Eleve;
import org.example.backendspring.models.Etablissement;
import org.example.backendspring.models.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EleveRepository extends JpaRepository<Eleve , Long> {

    Eleve findByMatriculate(String matriculate) ;

    Eleve findByName(String name) ;

    List<Eleve> findAllByIll(String ill) ;

    List<Eleve> findAllByClasse(Classe classe) ;

    List<Eleve> findAllByEtablissement(Etablissement etablissement) ;

    List<Eleve> findAllByBadge(boolean badge) ;
}
