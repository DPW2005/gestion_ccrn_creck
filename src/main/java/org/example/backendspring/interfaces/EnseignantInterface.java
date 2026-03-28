package org.example.backendspring.interfaces;

import org.example.backendspring.dto.EnseignantDto;
import org.example.backendspring.models.Enseignant;

import java.util.List;

public interface EnseignantInterface {

    void createNewEnseignant(EnseignantDto enseignantDto) ;

    void modifyEnseignant(long id , EnseignantDto enseignantDto) ;

    void deleteEnseignant(long id) ;

    void addEnseignementToList(long id , String teachName) ;

    Enseignant findById(long id) ;

    Enseignant findByName(String name) ;

    Enseignant findByPhone(String phone) ;

    List<Enseignant> findAll() ;

    List<Enseignant> findAllByLesson(String lessonName) ;
}
