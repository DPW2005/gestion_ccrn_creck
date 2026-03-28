package org.example.backendspring.services;

import org.example.backendspring.dto.PresenceDto;
import org.example.backendspring.interfaces.PresenceInterface;
import org.example.backendspring.models.Appel;
import org.example.backendspring.models.Eleve;
import org.example.backendspring.models.Presence;
import org.example.backendspring.repositories.AppelRepository;
import org.example.backendspring.repositories.EleveRepository;
import org.example.backendspring.repositories.PresenceRepository;

import java.util.List;

public class PresenceService implements PresenceInterface {

    private final PresenceRepository presenceRepository ;

    private final AppelRepository appelRepository ;

    private  final EleveRepository eleveRepository ;

    PresenceService(PresenceRepository presenceRepository, AppelRepository appelRepository, EleveRepository eleveRepository) {
        this.presenceRepository = presenceRepository;
        this.appelRepository = appelRepository;
        this.eleveRepository = eleveRepository;
    }

    @Override
    public void createNewPresence(PresenceDto presenceDto) {
        Eleve eleve = this.eleveRepository.findByName(presenceDto.studentName) ;
        Appel appel = this.appelRepository.findByName(presenceDto.callName) ;
        Presence presence = new Presence() ;
        presence.name = presenceDto.callName+"_"+presenceDto.studentName ;
        presence.present = presenceDto.present ;
        presence.eleve = eleve ;
        presence.appel = appel ;

        this.presenceRepository.save(presence) ;
    }

    @Override
    public void modifyPresence(long id, PresenceDto presenceDto) {
        Presence presence = this.findById(id) ;
        Eleve eleve = this.eleveRepository.findByName(presenceDto.studentName) ;
        Appel appel = this.appelRepository.findByName(presenceDto.callName) ;
        presence.name = presenceDto.callName+"_"+presenceDto.studentName ;
        presence.present = presenceDto.present ;
        presence.eleve = eleve ;
        presence.appel = appel ;

        this.presenceRepository.save(presence) ;
    }

    @Override
    public void deletePresence(long id) {
        this.presenceRepository.deleteById(id) ;
    }

    @Override
    public Presence findById(long id) {
        return this.presenceRepository.findById(id).get() ;
    }

    @Override
    public Presence findByName(String name) {
        return this.presenceRepository.findByName(name) ;
    }

    @Override
    public List<Presence> findAll() {
        return this.presenceRepository.findAll() ;
    }

    @Override
    public List<Presence> findAllByEleve(String studentName) {
        Eleve eleve = this.eleveRepository.findByName(studentName) ;
        return this.presenceRepository.findAllByEleve(eleve) ;
    }

    @Override
    public List<Presence> findAllByAppel(String callName) {
        Appel appel = this.appelRepository.findByName(callName) ;
        return this.presenceRepository.findAllByAppel(appel) ;
    }
}
