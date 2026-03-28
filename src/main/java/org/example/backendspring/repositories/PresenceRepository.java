package org.example.backendspring.repositories;

import org.example.backendspring.models.Appel;
import org.example.backendspring.models.Eleve;
import org.example.backendspring.models.Presence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PresenceRepository extends JpaRepository<Presence , Long> {

    Presence findByName(String name) ;

    List<Presence> findAllByEleve(Eleve eleve) ;

    List<Presence> findAllByAppel(Appel appel) ;
}
