package org.example.backendspring.webcontroller;

import org.example.backendspring.dto.ClasseDto;
import org.example.backendspring.interfaces.ClasseInterface;
import org.example.backendspring.models.Classe;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class ClasseWebController {

    private final ClasseInterface classeInterface ;

    public ClasseWebController(ClasseInterface classeInterface) {
        this.classeInterface = classeInterface;
    }

    @PostMapping("/classes")
    void createNewClasse(@RequestBody ClasseDto classeDto) {
        this.classeInterface.createNewClasse(classeDto);
    }

    @PutMapping("/classes/id/{id}")
    void modifyClasse(@PathVariable("id") long id , @RequestBody ClasseDto classeDto) {
        this.classeInterface.modifyClasse(id , classeDto);
    }

    @DeleteMapping("/classes/id/{id}")
    void deleteClasse(@PathVariable("id") long id) {
        this.classeInterface.deleteClasse(id);
    }

    @PutMapping("/classes/id/{id}/enseignement/{enseignement}")
    void addEnseignementToList(@PathVariable("id") long id , @PathVariable("enseignement") String teachName) {
        this.classeInterface.addEnseignementToList(id , teachName);
    }

    @PutMapping("/classes/id/{id}/examen/{examen}")
    void addExamenToList(@PathVariable("id") long id , @PathVariable("examen") String examName) {
        this.classeInterface.addExamenToList(id , examName);
    }

    @PutMapping("/classes/id/{id}/eleve/{eleve}")
    void addEleveToList(long id , String studentName) {
        this.classeInterface.addEleveToList(id , studentName);
    }

    @PutMapping("/classes/id/{id}/appel/{appel}")
    void addAppelToList(@PathVariable("id") long id , @PathVariable("appel") String callName) {
        this.classeInterface.addAppelToList(id , callName);
    }

    @GetMapping("/classes/id/{id}")
    Classe findById(@PathVariable("id") long id) {
        return this.classeInterface.findById(id) ;
    }

    @GetMapping("/classes/name/{name}")
    Classe findByName(String name) {
        return this.classeInterface.findByName(name) ;
    }

    @GetMapping("/classes")
    List<Classe> findAll() {
        return this.classeInterface.findAll() ;
    }

    @GetMapping("/classes/examen/{examen}")
    List<Classe> findAllByExamen(@PathVariable("examen") String examName) {
        return this.classeInterface.findAllByExamen(examName) ;
    }
}
