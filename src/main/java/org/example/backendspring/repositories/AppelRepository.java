package org.example.backendspring.repositories;

import org.example.backendspring.models.Appel;
import org.example.backendspring.models.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppelRepository extends JpaRepository<Appel , Long> {

    Appel findByName(String name) ;

    List<Appel> findAllByDate(LocalDate date) ;

    List<Appel> findAllByClasse(Classe classe) ;
}
