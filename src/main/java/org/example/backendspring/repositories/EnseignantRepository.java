package org.example.backendspring.repositories;

import org.example.backendspring.models.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignant , Long> {

    Enseignant findByName(String name) ;

    Enseignant findByPhone(String phone) ;
}
