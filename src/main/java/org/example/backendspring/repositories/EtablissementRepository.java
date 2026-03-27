package org.example.backendspring.repositories;

import org.example.backendspring.models.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtablissementRepository extends JpaRepository<Etablissement , Long> {

    Etablissement findByName(String name) ;

    List<Etablissement> findAllByAddress(String address) ;
}
