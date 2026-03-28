package org.example.backendspring.services;

import org.example.backendspring.dto.NoteDto;
import org.example.backendspring.interfaces.NoteInterface;
import org.example.backendspring.models.Bulletin;
import org.example.backendspring.models.Eleve;
import org.example.backendspring.models.Evaluation;
import org.example.backendspring.models.Note;
import org.example.backendspring.repositories.BulletinRepository;
import org.example.backendspring.repositories.EleveRepository;
import org.example.backendspring.repositories.EvaluationRepository;
import org.example.backendspring.repositories.NoteRepository;

import java.util.List;

public class NoteService implements NoteInterface {

    private final NoteRepository noteRepository ;

    private final EvaluationRepository evaluationRepository ;

    private final EleveRepository eleveRepository ;

    private final BulletinRepository bulletinRepository ;

    NoteService(NoteRepository noteRepository, EvaluationRepository evaluationRepository, EleveRepository eleveRepository, BulletinRepository bulletinRepository) {
        this.noteRepository = noteRepository;
        this.evaluationRepository = evaluationRepository;
        this.eleveRepository = eleveRepository;
        this.bulletinRepository = bulletinRepository;
    }

    @Override
    public void createNewNote(NoteDto noteDto) {
        Eleve eleve = this.eleveRepository.findByName(noteDto.studentName) ;
        Evaluation evaluation = this.evaluationRepository.findByName(noteDto.subjectName) ;
        Bulletin bulletin = this.bulletinRepository.findByName(noteDto.reportCardName) ;
        Note note = new Note() ;
        note.name = noteDto.subjectName+"_"+noteDto.studentName ;
        note.value = noteDto.value ;
        note.eleve = eleve ;
        note.evaluation = evaluation ;
        note.bulletin = bulletin ;

        this.noteRepository.save(note) ;
    }

    @Override
    public void modifyNote(long id, NoteDto noteDto) {
        Note note = this.findById(id) ;
        Eleve eleve = this.eleveRepository.findByName(noteDto.studentName) ;
        Evaluation evaluation = this.evaluationRepository.findByName(noteDto.subjectName) ;
        Bulletin bulletin = this.bulletinRepository.findByName(noteDto.reportCardName) ;
        note.name = noteDto.subjectName+"_"+noteDto.studentName ;
        note.value = noteDto.value ;
        note.eleve = eleve ;
        note.evaluation = evaluation ;
        note.bulletin = bulletin ;

        this.noteRepository.save(note) ;
    }

    @Override
    public void deleteNote(long id) {
        this.noteRepository.deleteById(id) ;
    }

    @Override
    public Note findById(long id) {
        return this.noteRepository.findById(id).get() ;
    }

    @Override
    public Note findByName(String name) {
        return this.noteRepository.findByName(name) ;
    }

    @Override
    public List<Note> findAll() {
        return this.noteRepository.findAll() ;
    }

    @Override
    public List<Note> findAllByEleve(String studentName) {
        Eleve eleve = this.eleveRepository.findByName(studentName) ;
        return this.noteRepository.findAllByEleve(eleve) ;
    }

    @Override
    public List<Note> findAllByEvaluation(String subjectName) {
        Evaluation evaluation = this.evaluationRepository.findByName(subjectName) ;
        return this.noteRepository.findAllByEvaluation(evaluation) ;
    }

    @Override
    public List<Note> findAllByBulletin(String reportCardName) {
        Bulletin bulletin = this.bulletinRepository.findByName(reportCardName) ;
        return this.noteRepository.findAllByBulletin(bulletin) ;
    }
}
