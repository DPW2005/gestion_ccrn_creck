package org.example.backendspring.services;

import org.example.backendspring.dto.ExamenDto;
import org.example.backendspring.interfaces.ExamenInterface;
import org.example.backendspring.models.Bulletin;
import org.example.backendspring.models.Classe;
import org.example.backendspring.models.Evaluation;
import org.example.backendspring.models.Examen;
import org.example.backendspring.repositories.BulletinRepository;
import org.example.backendspring.repositories.ClasseRepository;
import org.example.backendspring.repositories.EvaluationRepository;
import org.example.backendspring.repositories.ExamenRepository;

import java.time.LocalDate;
import java.util.List;

public class ExamenService implements ExamenInterface {

    private final ExamenRepository examenRepository ;

    private final ClasseRepository classeRepository ;

    private final BulletinRepository bulletinRepository ;

    private final EvaluationRepository evaluationRepository ;

    ExamenService(ExamenRepository examenRepository, ClasseRepository classeRepository, BulletinRepository bulletinRepository, EvaluationRepository evaluationRepository) {
        this.examenRepository = examenRepository;
        this.classeRepository = classeRepository;
        this.bulletinRepository = bulletinRepository;
        this.evaluationRepository = evaluationRepository;
    }

    @Override
    public void createNewExamen(ExamenDto examenDto) {
        Examen examen = new Examen() ;
        examen.name = examenDto.name ;
        examen.start = examenDto.start ;
        examen.finish = examenDto.finish ;

        this.examenRepository.save(examen) ;
    }

    @Override
    public void modifyExamen(long id, ExamenDto examenDto) {
        Examen examen = this.findById(id) ;
        examen.name = examenDto.name ;
        examen.start = examenDto.start ;
        examen.finish = examenDto.finish ;

        this.examenRepository.save(examen) ;
    }

    @Override
    public void deleteExamen(long id) {
        this.examenRepository.deleteById(id) ;
    }

    @Override
    public void addClasseToList(long id, String className) {
        Examen examen = this.findById(id) ;
        Classe classe = this.classeRepository.findByName(className) ;
        examen.classes.add(classe) ;

        this.examenRepository.save(examen) ;
    }

    @Override
    public void addBulletinToList(long id, String reportCardName) {
        Examen examen = this.findById(id) ;
        Bulletin bulletin = this.bulletinRepository.findByName(reportCardName) ;
        examen.bulletins.add(bulletin) ;

        this.examenRepository.save(examen) ;
    }

    @Override
    public void addEvaluationToList(long id, String subjectName) {
        Examen examen = this.findById(id) ;
        Evaluation evaluation = this.evaluationRepository.findByName(subjectName) ;
        examen.evaluations.add(evaluation) ;

        this.examenRepository.save(examen) ;
    }

    @Override
    public Examen findById(long id) {
        return this.examenRepository.findById(id).get() ;
    }

    @Override
    public Examen findByName(String name) {
        return this.examenRepository.findByName(name) ;
    }

    @Override
    public List<Examen> findAll() {
        return this.examenRepository.findAll() ;
    }

    @Override
    public List<Examen> findAllByStart(LocalDate start) {
        return this.examenRepository.findAllByStart(start) ;
    }

    @Override
    public List<Examen> findAllByClasse(String className) {
        List<Examen> examens = this.findAll() ;
        Classe classe = this.classeRepository.findByName(className) ;
        examens.removeIf(examen -> !examen.classes.contains(classe)) ;
        return examens ;
    }
}
