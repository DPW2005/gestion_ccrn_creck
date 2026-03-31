package org.example.backendspring.webcontroller;

import org.example.backendspring.dto.NoteDto;
import org.example.backendspring.interfaces.NoteInterface;
import org.example.backendspring.models.Note;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class NoteWebController {

    private final NoteInterface noteInterface ;

    public NoteWebController(NoteInterface noteInterface) {
        this.noteInterface = noteInterface;
    }

    @PostMapping("/notes")
    void createNewNote(@RequestBody NoteDto noteDto) {
        this.noteInterface.createNewNote(noteDto);
    }

    @PutMapping("/notes/id/{id}")
    void modifyNote(@PathVariable("id") long id , @RequestBody NoteDto noteDto) {
        this.noteInterface.modifyNote(id , noteDto);
    }

    @DeleteMapping("/notes/id/{id}")
    void deleteNote(@PathVariable("id") long id) {
        this.noteInterface.deleteNote(id);
    }

    @GetMapping("/notes/id/{id}")
    Note findById(@PathVariable("id") long id) {
        return this.noteInterface.findById(id) ;
    }

    @GetMapping("/notes/name/{name}")
    Note findByName(@PathVariable("name") String name) {
        return this.noteInterface.findByName(name) ;
    }

    @GetMapping("/notes")
    List<Note> findAll() {
        return this.noteInterface.findAll() ;
    }

    @GetMapping("/notes/eleve/{eleve}")
    List<Note> findAllByEleve(@PathVariable("eleve") String studentName) {
        return this.noteInterface.findAllByEleve(studentName) ;
    }

    @GetMapping("/notes/evaluation/{evaluation}")
    List<Note> findAllByEvaluation(@PathVariable("evaluation") String subjectName) {
        return this.noteInterface.findAllByEvaluation(subjectName) ;
    }

    @GetMapping("/notes/bulletin/{bulletin}")
    List<Note> findAllByBulletin(@PathVariable("bulletin") String reportCardName) {
        return this.noteInterface.findAllByBulletin(reportCardName) ;
    }
}
