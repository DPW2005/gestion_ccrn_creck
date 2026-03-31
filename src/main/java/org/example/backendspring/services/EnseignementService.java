package org.example.backendspring.services;

import org.example.backendspring.dto.EnseignementDto;
import org.example.backendspring.interfaces.EnseignementInterface;
import org.example.backendspring.models.*;
import org.example.backendspring.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignementService implements EnseignementInterface {

    private final EnseignementRepository enseignementRepository ;

    private final EvaluationRepository evaluationRepository ;

    private final ClasseRepository classeRepository ;

    private final EnseignantRepository enseignantRepository ;

    private final MatiereRepository matiereRepository ;

    EnseignementService(EnseignementRepository enseignementRepository, EvaluationRepository evaluationRepository, ClasseRepository classeRepository, EnseignantRepository enseignantRepository, MatiereRepository matiereRepository) {
        this.enseignementRepository = enseignementRepository;
        this.evaluationRepository = evaluationRepository;
        this.classeRepository = classeRepository;
        this.enseignantRepository = enseignantRepository;
        this.matiereRepository = matiereRepository;
    }

    @Override
    public void createNewEnseignement(EnseignementDto enseignementDto) {
        Enseignant enseignant = this.enseignantRepository.findByName(enseignementDto.teacherName) ;
        Matiere matiere = this.matiereRepository.findByName(enseignementDto.lessonName) ;
        Classe classe = this.classeRepository.findByName(enseignementDto.className) ;
        Enseignement enseignement = new Enseignement() ;
        enseignement.name = enseignementDto.lessonName+"_"+enseignementDto.className ;
        enseignement.days = enseignementDto.days ;
        enseignement.enseignant = enseignant ;
        enseignement.matiere = matiere ;
        enseignement.classe = classe ;

        this.enseignementRepository.save(enseignement) ;
    }

    @Override
    public void modifyEnseignement(long id, EnseignementDto enseignementDto) {
        Enseignement enseignement = this.findById(id) ;
        Enseignant enseignant = this.enseignantRepository.findByName(enseignementDto.teacherName) ;
        Matiere matiere = this.matiereRepository.findByName(enseignementDto.lessonName) ;
        Classe classe = this.classeRepository.findByName(enseignementDto.className) ;
        enseignement.name = enseignementDto.lessonName+"_"+enseignementDto.className ;
        enseignement.days = enseignementDto.days ;
        enseignement.enseignant = enseignant ;
        enseignement.matiere = matiere ;
        enseignement.classe = classe ;

        this.enseignementRepository.save(enseignement) ;
    }

    @Override
    public void deleteEnseignement(long id) {
        this.enseignementRepository.deleteById(id) ;
    }

    @Override
    public void addEvaluationToList(long id, String subjectName) {
        Enseignement enseignement = this.findById(id) ;
        Evaluation evaluation = this.evaluationRepository.findByName(subjectName) ;
        enseignement.evaluations.add(evaluation) ;

        this.enseignementRepository.save(enseignement) ;
    }

    @Override
    public Enseignement findById(long id) {
        return this.enseignementRepository.findById(id).get() ;
    }

    @Override
    public Enseignement findByName(String name) {
        return this.enseignementRepository.findByName(name) ;
    }

    @Override
    public List<Enseignement> findAll() {
        return this.enseignementRepository.findAll() ;
    }

    @Override
    public List<Enseignement> findAllByClasse(String className) {
        Classe classe = this.classeRepository.findByName(className) ;
        return this.enseignementRepository.findAllByClasse(classe);
    }

    @Override
    public List<Enseignement> findAllByMatiere(String lessonName) {
        Matiere matiere = this.matiereRepository.findByName(lessonName) ;
        return this.enseignementRepository.findAllByMatiere(matiere) ;
    }

    @Override
    public List<Enseignement> findAllByEnseignant(String teacherName) {
        Enseignant enseignant = this.enseignantRepository.findByName(teacherName) ;
        return this.enseignementRepository.findAllByEnseignant(enseignant) ;
    }

    @Override
    public List<Enseignement> findAllByDay(String day) {
        List<Enseignement> enseignements = this.findAll() ;
        enseignements.removeIf(enseignement -> !enseignement.days.contains(day)) ;
        return enseignements;
    }
}
