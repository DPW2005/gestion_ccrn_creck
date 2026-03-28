package org.example.backendspring.services;

import org.example.backendspring.dto.EleveDto;
import org.example.backendspring.interfaces.EleveInterface;
import org.example.backendspring.models.*;
import org.example.backendspring.repositories.*;

import java.time.LocalDate;
import java.util.List;

public class EleveService implements EleveInterface {

    private  final EleveRepository eleveRepository ;

    private final ClasseRepository classeRepository ;

    private final EtablissementRepository etablissementRepository ;

    private final PresenceRepository presenceRepository ;

    private final NoteRepository noteRepository ;

    private final BulletinRepository bulletinRepository ;

    private final ParentRepository parentRepository ;

    EleveService(EleveRepository eleveRepository, ClasseRepository classeRepository, EtablissementRepository etablissementRepository, PresenceRepository presenceRepository, NoteRepository noteRepository, BulletinRepository bulletinRepository, ParentRepository parentRepository) {
        this.eleveRepository = eleveRepository;
        this.classeRepository = classeRepository;
        this.etablissementRepository = etablissementRepository;
        this.presenceRepository = presenceRepository;
        this.noteRepository = noteRepository;
        this.bulletinRepository = bulletinRepository;
        this.parentRepository = parentRepository;
    }

    @Override
    public void createNewEleve(EleveDto eleveDto) {
        Classe classe = this.classeRepository.findByName(eleveDto.className) ;
        Etablissement etablissement = this.etablissementRepository.findByName(eleveDto.schoolName) ;
        Eleve eleve = new Eleve() ;
        eleve.matriculate = eleveDto.matriculate ;
        eleve.name = eleveDto.name ;
        eleve.birthday = eleveDto.birthday ;
        eleve.registration = eleveDto.registration ;
        eleve.ill = eleveDto.ill ;
        eleve.classe = classe ;
        eleve.etablissement = etablissement ;

        this.eleveRepository.save(eleve) ;
    }

    @Override
    public void modifyEleve(long id, EleveDto eleveDto) {
        Eleve eleve = this.findById(id) ;
        Classe classe = this.classeRepository.findByName(eleveDto.className) ;
        Etablissement etablissement = this.etablissementRepository.findByName(eleveDto.schoolName) ;
        eleve.matriculate = eleveDto.matriculate ;
        eleve.name = eleveDto.name ;
        eleve.birthday = eleveDto.birthday ;
        eleve.registration = eleveDto.registration ;
        eleve.ill = eleveDto.ill ;
        eleve.classe = classe ;
        eleve.etablissement = etablissement ;

        this.eleveRepository.save(eleve) ;
    }

    @Override
    public void deleteEleve(long id) {
        this.eleveRepository.deleteById(id) ;
    }

    @Override
    public void addPresenceToList(long id, String presenceName) {
        Eleve eleve = this.findById(id) ;
        Presence presence = this.presenceRepository.findByName(presenceName) ;
        eleve.presences.add(presence) ;

        this.eleveRepository.save(eleve) ;
    }

    @Override
    public void addNoteToList(long id, String noteName) {
        Eleve eleve = this.findById(id) ;
        Note note = this.noteRepository.findByName(noteName) ;
        eleve.notes.add(note) ;

        this.eleveRepository.save(eleve) ;
    }

    @Override
    public void addBulletinToList(long id, String reportCardName) {
        Eleve eleve = this.findById(id) ;
        Bulletin bulletin = this.bulletinRepository.findByName(reportCardName) ;
        eleve.bulletins.add(bulletin) ;

        this.eleveRepository.save(eleve) ;
    }

    @Override
    public void addParentToList(long id, String parentName) {
        Eleve eleve = this.findById(id) ;
        Parent parent = this.parentRepository.findByName(parentName) ;
        eleve.parents.add(parent) ;

        this.eleveRepository.save(eleve) ;
    }

    @Override
    public Eleve findById(long id) {
        return this.eleveRepository.findById(id).get() ;
    }

    @Override
    public Eleve findByMatriculate(String matriculate) {
        return this.eleveRepository.findByMatriculate(matriculate) ;
    }

    @Override
    public Eleve findByName(String name) {
        return this.eleveRepository.findByName(name) ;
    }

    @Override
    public List<Eleve> findAll() {
        return this.eleveRepository.findAll() ;
    }

    @Override
    public List<Eleve> findAllByIll(String ill) {
        return this.eleveRepository.findAllByIll(ill) ;
    }

    @Override
    public List<Eleve> findAllByClasse(String className) {
        Classe classe = this.classeRepository.findByName(className) ;
        return this.eleveRepository.findAllByClasse(classe) ;
    }

    @Override
    public List<Eleve> findAllByEtablissement(String schoolName) {
        Etablissement etablissement = this.etablissementRepository.findByName(schoolName) ;
        return this.eleveRepository.findAllByEtablissement(etablissement) ;
    }

    @Override
    public List<Eleve> findAllByBadge(boolean badge) {
        return this.eleveRepository.findAllByBadge(badge) ;
    }

    @Override
    public List<Eleve> findAllByParent(String parentName) {
        List<Eleve> eleves = this.findAll() ;
        Parent parent = this.parentRepository.findByName(parentName) ;
        eleves.removeIf(eleve -> !eleve.parents.contains(parent)) ;
        return eleves ;
    }

    @Override
    public List<Eleve> findByRegistration(LocalDate firstDate, LocalDate secondDate) {
        List<Eleve> eleves = this.findAll() ;
        eleves.removeIf(eleve -> !(eleve.registration.isAfter(firstDate) && eleve.registration.isBefore(secondDate))) ;
        return eleves;
    }
}
