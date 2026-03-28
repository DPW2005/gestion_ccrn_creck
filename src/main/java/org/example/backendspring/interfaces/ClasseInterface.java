package org.example.backendspring.interfaces;

import org.example.backendspring.dto.ClasseDto;
import org.example.backendspring.models.Classe;

import java.util.List;

public interface ClasseInterface {

    void createNewClasse(ClasseDto classeDto) ;

    void modifyClasse(long id , ClasseDto classeDto) ;

    void deleteClasse(long id) ;

    void addEnseignementToList(long id , String teachName) ;

    void addEleveToList(long id , String studentName) ;

    void addAppelToList(long id , String callName) ;

    Classe findById(long id) ;

    Classe findByName(String name) ;

    List<Classe> findAll() ;

    List<Classe> findAllByExamen(String examName) ;
}
