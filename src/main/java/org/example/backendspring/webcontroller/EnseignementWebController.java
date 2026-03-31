package org.example.backendspring.webcontroller;

import org.example.backendspring.dto.EnseignementDto;
import org.example.backendspring.interfaces.EnseignementInterface;
import org.example.backendspring.models.Enseignement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class EnseignementWebController {

    private final EnseignementInterface enseignementInterface ;

    public EnseignementWebController(EnseignementInterface enseignementInterface) {
        this.enseignementInterface = enseignementInterface;
    }

    @PostMapping("/enseignements")
    void createNewEnseignement(@RequestBody EnseignementDto enseignementDto) {
        this.enseignementInterface.createNewEnseignement(enseignementDto);
    }

    @PutMapping("/enseignements/id/{id}")
    void modifyEnseignement(@PathVariable("id") long id , @RequestBody EnseignementDto enseignementDto) {
        this.enseignementInterface.modifyEnseignement(id , enseignementDto);
    }

    @DeleteMapping("/enseignements/id/{id}")
    void deleteEnseignement(@PathVariable("id") long id) {
        this.enseignementInterface.deleteEnseignement(id);
    }

    @PutMapping("/enseignements/id/{id}/evaluation/{evaluation}")
    void addEvaluationToList(@PathVariable("id") long id , @PathVariable("evaluation") String subjectName) {
        this.enseignementInterface.addEvaluationToList(id , subjectName);
    }

    @GetMapping("/enseignements/id/{id}")
    Enseignement findById(@PathVariable("id") long id) {
        return this.enseignementInterface.findById(id) ;
    }

    @GetMapping("/enseignements/name/{name}")
    Enseignement findByName(String name) {
        return this.enseignementInterface.findByName(name) ;
    }

    @GetMapping("/enseignements")
    List<Enseignement> findAll() {
        return this.enseignementInterface.findAll() ;
    }

    @GetMapping("/enseignements/classe/{classe}")
    List<Enseignement> findAllByClasse(@PathVariable("classe") String className) {
        return this.enseignementInterface.findAllByClasse(className) ;
    }

    @GetMapping("/enseignements/matiere/{matiere}")
    List<Enseignement> findAllByMatiere(@PathVariable("matiere") String lessonName) {
        return this.enseignementInterface.findAllByMatiere(lessonName) ;
    }

    @GetMapping("/enseignements/enseignant/{enseignant}")
    List<Enseignement> findAllByEnseignant(@PathVariable("enseignant") String teacherName) {
        return this.enseignementInterface.findAllByEnseignant(teacherName) ;
    }

    @GetMapping("/enseignements/jour/{jour}")
    List<Enseignement> findAllByDay(@PathVariable("jour") String day) {
        return this.enseignementInterface.findAllByDay(day) ;
    }
}
