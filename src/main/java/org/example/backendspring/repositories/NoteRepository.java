package org.example.backendspring.repositories;

import org.example.backendspring.models.Bulletin;
import org.example.backendspring.models.Eleve;
import org.example.backendspring.models.Evaluation;
import org.example.backendspring.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note , Long> {

    List<Note> findAllByEleve(Eleve eleve) ;

    List<Note> findAllByEvaluation(Evaluation evaluation) ;

    List<Note> findAllByBulletin(Bulletin bulletin) ;
}
