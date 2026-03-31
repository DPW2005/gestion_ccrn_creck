package org.example.backendspring.services;

import org.example.backendspring.dto.ClasseDto;
import org.example.backendspring.interfaces.ClasseInterface;
import org.example.backendspring.models.*;
import org.example.backendspring.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService implements ClasseInterface {

    private final ClasseRepository classeRepository ;

    private final EnseignementRepository enseignementRepository ;

    private  final EleveRepository eleveRepository ;

    private final AppelRepository appelRepository ;

    private final ExamenRepository examenRepository ;

    ClasseService(ClasseRepository classeRepository , EnseignementRepository enseignementRepository , EleveRepository eleveRepository , AppelRepository appelRepository , ExamenRepository examenRepository){
        this.classeRepository = classeRepository ;
        this.enseignementRepository = enseignementRepository ;
        this.eleveRepository = eleveRepository ;
        this.appelRepository = appelRepository ;
        this.examenRepository = examenRepository ;
    }

    @Override
    public void createNewClasse(ClasseDto classeDto) {
        Classe classe = new Classe() ;
        classe.name = classeDto.name ;
        classe.place = classeDto.place ;

        this.classeRepository.save(classe) ;
    }

    @Override
    public void modifyClasse(long id, ClasseDto classeDto) {
        Classe classe = this.findById(id) ;
        classe.name = classeDto.name ;
        classe.place = classeDto.place ;

        this.classeRepository.save(classe) ;
    }

    @Override
    public void deleteClasse(long id) {
        this.classeRepository.deleteById(id) ;
    }

    @Override
    public void addEnseignementToList(long id, String teachName) {
        Classe classe = this.findById(id) ;
        Enseignement enseignement = this.enseignementRepository.findByName(teachName) ;
        classe.enseignements.add(enseignement) ;

        this.classeRepository.save(classe) ;
    }

    @Override
    public void addExamenToList(long id, String examName) {
        Classe classe = this.findById(id) ;
        Examen examen = this.examenRepository.findByName(examName) ;
        classe.examens.add(examen) ;

        this.classeRepository.save(classe) ;
    }

    @Override
    public void addEleveToList(long id, String studentName) {
        Classe classe = this.findById(id) ;
        Eleve eleve = this.eleveRepository.findByName(studentName) ;
        classe.eleves.add(eleve) ;

        this.classeRepository.save(classe) ;
    }

    @Override
    public void addAppelToList(long id, String callName) {
        Classe classe = this.findById(id) ;
        Appel appel = this.appelRepository.findByName(callName) ;
        classe.appels.add(appel) ;

        this.classeRepository.save(classe) ;
    }

    @Override
    public Classe findById(long id) {
        return this.classeRepository.findById(id).get() ;
    }

    @Override
    public Classe findByName(String name) {
        return this.classeRepository.findByName(name) ;
    }

    @Override
    public List<Classe> findAll() {
        return this.classeRepository.findAll() ;
    }

    @Override
    public List<Classe> findAllByExamen(String examName) {
        List<Classe> classes = this.findAll() ;
        Examen examen = this.examenRepository.findByName(examName) ;
        classes.removeIf(classe -> !classe.examens.contains(examen));
        return classes;
    }
}
