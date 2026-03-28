package org.example.backendspring.interfaces;

import org.example.backendspring.dto.AppelDto;
import org.example.backendspring.models.Appel;

import java.time.LocalDate;
import java.util.List;

public interface AppelInterface {

    void createNewAppel(AppelDto appelDto) ;

    void modifyAppel(long id , AppelDto appelDto) ;

    void deleteAppel(long id) ;

    void addPresenceToList(long id , String presenceName) ;

    Appel findById(long id) ;

    Appel findByName(String name) ;

    List<Appel> findAll() ;

    List<Appel> findAllByDate(String date) ;

    List<Appel> findAllByClasse(String className) ;


}
