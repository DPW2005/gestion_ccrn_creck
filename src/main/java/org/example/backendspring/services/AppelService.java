package org.example.backendspring.services;

import org.example.backendspring.dto.AppelDto;
import org.example.backendspring.interfaces.AppelInterface;
import org.example.backendspring.models.Appel;
import org.example.backendspring.models.Classe;
import org.example.backendspring.models.Presence;
import org.example.backendspring.repositories.AppelRepository;
import org.example.backendspring.repositories.ClasseRepository;
import org.example.backendspring.repositories.PresenceRepository;

import java.time.LocalDate;
import java.util.List;

public class AppelService implements AppelInterface {

    private final AppelRepository appelRepository ;

    private final ClasseRepository classeRepository ;

    private final PresenceRepository presenceRepository ;

    AppelService(AppelRepository appelRepository , ClasseRepository classeRepository , PresenceRepository presenceRepository){
        this.appelRepository = appelRepository ;
        this.classeRepository = classeRepository ;
        this.presenceRepository = presenceRepository ;
    }

    @Override
    public void createNewAppel(AppelDto appelDto) {
        Classe classe = this.classeRepository.findByName(appelDto.className) ;
        Appel appel = new Appel() ;
        appel.name = appelDto.className+"_"+appelDto.date.toString() ;
        appel.date = appelDto.date ;
        appel.classe = classe ;

        this.appelRepository.save(appel) ;
    }

    @Override
    public void modifyAppel(long id, AppelDto appelDto) {
        Appel appel = this.findById(id);
        Classe classe = this.classeRepository.findByName(appelDto.className) ;
        appel.name = appelDto.className+"_"+appelDto.date.toString() ;
        appel.date = appelDto.date ;
        appel.classe = classe ;

        this.appelRepository.save(appel) ;
    }

    @Override
    public void deleteAppel(long id) {
        this.appelRepository.deleteById(id) ;
    }

    @Override
    public void addPresenceToList(long id, String presenceName) {
        Appel appel = this.findById(id);
        Presence presence = this.presenceRepository.findByName(presenceName) ;
        appel.presences.add(presence) ;

        this.appelRepository.save(appel) ;
    }

    @Override
    public Appel findById(long id) {
        return this.appelRepository.findById(id).get() ;
    }

    @Override
    public Appel findByName(String name) {
        return this.appelRepository.findByName(name) ;
    }

    @Override
    public List<Appel> findAll() {
        return this.appelRepository.findAll() ;
    }

    @Override
    public List<Appel> findAllByDate(String date) {
        return this.appelRepository.findAllByDate(LocalDate.parse(date)) ;
    }

    @Override
    public List<Appel> findAllByClasse(String className) {
        Classe classe = this.classeRepository.findByName(className) ;
        return this.appelRepository.findAllByClasse(classe) ;
    }
}
