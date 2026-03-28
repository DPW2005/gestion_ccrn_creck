package org.example.backendspring.interfaces;

import org.example.backendspring.dto.MatiereDto;
import org.example.backendspring.models.Matiere;

import java.util.List;

public interface MatiereInterface {

    void createNewMatiere(MatiereDto matiereDto) ;

    void modifyMatiere(long id , MatiereDto matiereDto) ;

    void deleteMatiere(long id) ;

    void addEnseignementToList(long id , String teachName) ;

    Matiere findById(long id) ;

    Matiere findByName(String name) ;

    List<Matiere> findAll() ;
}
