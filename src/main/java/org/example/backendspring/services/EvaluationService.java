package org.example.backendspring.services;

import org.example.backendspring.dto.EvaluationDto;
import org.example.backendspring.interfaces.EvaluationInterface;
import org.example.backendspring.models.Enseignement;
import org.example.backendspring.models.Evaluation;
import org.example.backendspring.models.Examen;
import org.example.backendspring.models.Note;
import org.example.backendspring.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationService implements EvaluationInterface {

    private final EvaluationRepository evaluationRepository ;

    private final ExamenRepository examenRepository ;

    private final EnseignementRepository enseignementRepository ;

    private final NoteRepository noteRepository ;

    EvaluationService(EvaluationRepository evaluationRepository, ExamenRepository examenRepository, EnseignementRepository enseignementRepository, NoteRepository noteRepository) {
        this.evaluationRepository = evaluationRepository;
        this.examenRepository = examenRepository;
        this.enseignementRepository = enseignementRepository;
        this.noteRepository = noteRepository;
    }

    @Override
    public void createNewEvaluation(EvaluationDto evaluationDto) {
        Examen examen = this.examenRepository.findByName(evaluationDto.examName) ;
        Enseignement enseignement = this.enseignementRepository.findByName(evaluationDto.teachName) ;
        Evaluation evaluation = new Evaluation() ;
        evaluation.name = evaluationDto.examName+"_"+evaluationDto.teachName ;
        evaluation.examen = examen ;
        evaluation.enseignement = enseignement ;

        this.evaluationRepository.save(evaluation) ;
    }

    @Override
    public void modifyEvaluation(long id, EvaluationDto evaluationDto) {
        Evaluation evaluation = this.findById(id) ;
        Examen examen = this.examenRepository.findByName(evaluationDto.examName) ;
        Enseignement enseignement = this.enseignementRepository.findByName(evaluationDto.teachName) ;
        evaluation.name = evaluationDto.examName+"_"+evaluationDto.teachName ;
        evaluation.examen = examen ;
        evaluation.enseignement = enseignement ;

        this.evaluationRepository.save(evaluation) ;
    }

    @Override
    public void deleteEvaluation(long id) {
        this.evaluationRepository.deleteById(id) ;
    }

    @Override
    public void addNoteToList(long id, String noteName) {
        Evaluation evaluation = this.findById(id) ;
        Note note = this.noteRepository.findByName(noteName) ;
        evaluation.notes.add(note) ;

        this.evaluationRepository.save(evaluation) ;
    }

    @Override
    public Evaluation findById(long id) {
        return this.evaluationRepository.findById(id).get() ;
    }

    @Override
    public Evaluation findByName(String name) {
        return this.evaluationRepository.findByName(name) ;
    }

    @Override
    public List<Evaluation> findAll() {
        return this.evaluationRepository.findAll() ;
    }

    @Override
    public List<Evaluation> findAllByExamen(String examName) {
        Examen examen = this.examenRepository.findByName(examName) ;
        return this.evaluationRepository.findAllByExamen(examen) ;
    }

    @Override
    public List<Evaluation> findAllByEnseignement(String teachName) {
        Enseignement enseignement = this.enseignementRepository.findByName(teachName) ;
        return this.evaluationRepository.findAllByEnseignement(enseignement) ;
    }
}
