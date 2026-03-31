package org.example.backendspring.webcontroller;

import org.example.backendspring.dto.ExamenDto;
import org.example.backendspring.interfaces.ExamenInterface;
import org.example.backendspring.models.Examen;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class ExamenWebController {

    private final ExamenInterface examenInterface ;

    public ExamenWebController(ExamenInterface examenInterface) {
        this.examenInterface = examenInterface;
    }

    @PostMapping("/examens")
    void createNewExamen(@RequestBody ExamenDto examenDto) {
        this.examenInterface.createNewExamen(examenDto);
    }

    @PutMapping("/examens/id/{id}")
    void modifyExamen(@PathVariable("id") long id , @RequestBody ExamenDto examenDto) {
        this.examenInterface.modifyExamen(id , examenDto);
    }

    @DeleteMapping("/examens/id/{id}")
    void deleteExamen(@PathVariable("id") long id) {
        this.examenInterface.deleteExamen(id);
    }

    @PutMapping("/examens/id/{id}/classe/{classe}")
    void addClasseToList(@PathVariable("id") long id , @PathVariable("classe") String className) {
        this.examenInterface.addClasseToList(id , className);
    }

    @PutMapping("/examens/id/{id}/bulletin/{bulletin}")
    void addBulletinToList(@PathVariable("id") long id , @PathVariable("bulletin") String reportCardName) {
        this.examenInterface.addBulletinToList(id , reportCardName);
    }

    @PutMapping("/examens/id/{id}/evaluation/{evaluation}")
    void addEvaluationToList(@PathVariable("id") long id , @PathVariable("evaluation") String subjectName) {
        this.examenInterface.addEvaluationToList(id , subjectName);
    }

    @GetMapping("/examens/id/{id}")
    Examen findById(@PathVariable("id") long id) {
        return this.examenInterface.findById(id) ;
    }

    @GetMapping("/examens/name/{name}")
    Examen findByName(@PathVariable("name") String name) {
        return this.examenInterface.findByName(name) ;
    }

    @GetMapping("/examens")
    List<Examen> findAll() {
        return this.examenInterface.findAll() ;
    }

    @GetMapping("/examens/debut/{debut}")
    List<Examen> findAllByStart(@PathVariable("debut") String start) {
        return this.examenInterface.findAllByStart(start) ;
    }

    @GetMapping("/examens/classe/{classe}")
    List<Examen> findAllByClasse(@PathVariable("classe") String className) {
        return this.examenInterface.findAllByClasse(className) ;
    }
}
