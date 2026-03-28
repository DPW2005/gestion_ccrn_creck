package org.example.backendspring.interfaces;

import org.example.backendspring.dto.EvaluationDto;
import org.example.backendspring.models.Enseignement;
import org.example.backendspring.models.Evaluation;
import org.example.backendspring.models.Examen;

import java.util.List;

public interface EvaluationInterface {

    void createNewEvaluation(EvaluationDto evaluationDto) ;

    void modifyEvaluation(long id , EvaluationDto evaluationDto) ;

    void deleteEvaluation(long id) ;

    void addNoteToList(long id , String noteName) ;

    Evaluation findById(long id) ;

    Evaluation findByName(String name) ;

    List<Evaluation> findAll() ;

    List<Evaluation> findAllByExamen(String examName) ;

    List<Evaluation> findAllByEnseignement(String teachName) ;
}
