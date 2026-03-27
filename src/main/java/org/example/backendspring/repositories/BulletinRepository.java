package org.example.backendspring.repositories;

import org.example.backendspring.models.Bulletin;
import org.example.backendspring.models.Eleve;
import org.example.backendspring.models.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BulletinRepository extends JpaRepository<Bulletin , Long> {

    Bulletin findByName(String name) ;

    List<Bulletin> findAllByEleve(Eleve eleve) ;

    List<Bulletin> findAllByExamen(Examen examen) ;
}
