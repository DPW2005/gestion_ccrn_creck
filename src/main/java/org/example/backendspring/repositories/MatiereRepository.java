package org.example.backendspring.repositories;

import org.example.backendspring.models.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereRepository extends JpaRepository<Matiere , Long> {

    Matiere findByName(String name) ;
}
