package org.example.backendspring.interfaces;

import org.example.backendspring.dto.PresenceDto;
import org.example.backendspring.models.Appel;
import org.example.backendspring.models.Eleve;
import org.example.backendspring.models.Presence;

import java.util.List;

public interface PresenceInterface {

    void createNewPresence(PresenceDto presenceDto) ;

    void modifyPresence(long id , PresenceDto presenceDto) ;

    void deletePresence(long id) ;

    Presence findById(long id) ;

    Presence findByName(String name) ;

    List<Presence> findAll() ;

    List<Presence> findAllByEleve(Eleve eleve) ;

    List<Presence> findAllByAppel(Appel appel) ;
}
