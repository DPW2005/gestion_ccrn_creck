package org.example.backendspring.repositories;

import org.example.backendspring.models.Eleve;
import org.example.backendspring.models.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParentRepository extends JpaRepository<Parent , Long> {

    Parent findByName(String name) ;

    Parent findByPhone(String phone) ;

    List<Parent> findAllByAddress(String address) ;
}
