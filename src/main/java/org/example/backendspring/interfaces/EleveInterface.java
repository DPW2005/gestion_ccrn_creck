package org.example.backendspring.interfaces;

import org.example.backendspring.dto.EleveDto;
import org.example.backendspring.models.Eleve;

import java.time.LocalDate;
import java.util.List;

public interface EleveInterface {

    void createNewEleve(EleveDto eleveDto) ;

    void modifyEleve(long id , EleveDto eleveDto) ;

    void deleteEleve(long id) ;

    void addPresenceToList(long id , String presenceName) ;

    void addNoteToList(long id , String noteName) ;

    void addBulletinToList(long id , String reportCardName) ;

    void addParentToList(long id , String parentName) ;

    Eleve findById(long id) ;

    Eleve findByMatriculate(String matriculate) ;

    Eleve findByName(String name) ;

    List<Eleve> findAll() ;

    List<Eleve> findAllByIll(String ill) ;

    List<Eleve> findAllByClasse(String className) ;

    List<Eleve> findAllByEtablissement(String schoolName) ;

    List<Eleve> findAllByBadge(boolean badge) ;

    List<Eleve> findAllByParent(String parentName) ;

    List<Eleve> findByRegistration(String firstDate , String secondDate) ;
}