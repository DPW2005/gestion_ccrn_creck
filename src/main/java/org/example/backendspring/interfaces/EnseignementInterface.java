package org.example.backendspring.interfaces;

import org.example.backendspring.dto.EnseignementDto;
import org.example.backendspring.models.Enseignement;

import java.util.List;

public interface EnseignementInterface {

    void createNewEnseignement(EnseignementDto enseignementDto) ;

    void modifyEnseignement(long id , EnseignementDto enseignementDto) ;

    void deleteEnseignement(long id) ;

    void addEvaluationToList(long id , String subjectName) ;

    Enseignement findById(long id) ;

    Enseignement findByName(String name) ;

    List<Enseignement> findAll() ;

    List<Enseignement> findAllByClasse(String className) ;

    List<Enseignement> findAllByMatiere(String lessonName) ;

    List<Enseignement> findAllByEnseignant(String teacherName) ;

    List<Enseignement> findAllByDay(String day) ;
}
