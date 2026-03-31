package org.example.backendspring.webcontroller;

import org.example.backendspring.dto.EvaluationDto;
import org.example.backendspring.interfaces.EvaluationInterface;
import org.example.backendspring.models.Evaluation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class EvaluationWebController {

    private final EvaluationInterface evaluationInterface ;

    public EvaluationWebController(EvaluationInterface evaluationInterface) {
        this.evaluationInterface = evaluationInterface;
    }

    @PostMapping("/evaluations")
    void createNewEvaluation(@RequestBody EvaluationDto evaluationDto) {
        this.evaluationInterface.createNewEvaluation(evaluationDto);
    }

    @PutMapping("/evaluations/id/{id}")
    void modifyEvaluation(@PathVariable("id") long id , @RequestBody EvaluationDto evaluationDto) {
        this.evaluationInterface.modifyEvaluation(id , evaluationDto);
    }

    @DeleteMapping("/evaluations/id/{id}")
    void deleteEvaluation(@PathVariable("id") long id) {
        this.evaluationInterface.deleteEvaluation(id);
    }

    @PutMapping("/evaluations/id/{id}/note/{note}")
    void addNoteToList(@PathVariable("id") long id , @PathVariable("note") String noteName) {
        this.evaluationInterface.deleteEvaluation(id);
    }

    @GetMapping("/evaluations/id/{id}")
    Evaluation findById(@PathVariable("id") long id) {
        return this.evaluationInterface.findById(id) ;
    }

    @GetMapping("/evaluations/name/{name}")
    Evaluation findByName(@PathVariable("name") String name) {
        return this.evaluationInterface.findByName(name) ;
    }

    @GetMapping("/evaluations")
    List<Evaluation> findAll() {
        return this.evaluationInterface.findAll() ;
    }

    @GetMapping("/evaluations/examen/{examen}")
    List<Evaluation> findAllByExamen(@PathVariable("examen") String examName) {
        return this.evaluationInterface.findAllByExamen(examName) ;
    }

    @GetMapping("/evaluations/enseignement/{enseignement}")
    List<Evaluation> findAllByEnseignement(@PathVariable("enseignement") String teachName) {
        return this.evaluationInterface.findAllByEnseignement(teachName) ;
    }
}
