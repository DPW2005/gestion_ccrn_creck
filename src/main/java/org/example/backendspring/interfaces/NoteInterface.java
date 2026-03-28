package org.example.backendspring.interfaces;

import org.example.backendspring.dto.NoteDto;
import org.example.backendspring.models.Bulletin;
import org.example.backendspring.models.Eleve;
import org.example.backendspring.models.Evaluation;
import org.example.backendspring.models.Note;

import java.util.List;

public interface NoteInterface {

    void createNewNote(NoteDto noteDto) ;

    void modifyNote(long id , NoteDto noteDto) ;

    void deleteNote(long id) ;

    Note findById(long id) ;

    Note findByName(String name) ;

    List<Note> findAll() ;

    List<Note> findAllByEleve(Eleve eleve) ;

    List<Note> findAllByEvaluation(Evaluation evaluation) ;

    List<Note> findAllByBulletin(Bulletin bulletin) ;
}
