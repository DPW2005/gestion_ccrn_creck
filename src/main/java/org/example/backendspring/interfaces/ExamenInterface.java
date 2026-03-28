package org.example.backendspring.interfaces;

import org.example.backendspring.dto.ExamenDto;
import org.example.backendspring.models.Examen;

import java.time.LocalDate;
import java.util.List;

public interface ExamenInterface {

    void createNewExamen(ExamenDto examenDto) ;

    void modifyExamen(long id , ExamenDto examenDto) ;

    void deleteExamen(long id) ;

    void addClasseToList(long id , String className) ;

    void addBulletinToList(long id , String reportCardName) ;

    void addEvaluationToList(long id , String subjectName) ;

    Examen findById(long id) ;

    Examen findByName(String name) ;

    List<Examen> findAll() ;

    List<Examen> findAllByStart(LocalDate start) ;

    List<Examen> findAllByClasse(String className) ;
}
