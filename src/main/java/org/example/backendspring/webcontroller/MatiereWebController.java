package org.example.backendspring.webcontroller;

import org.example.backendspring.dto.MatiereDto;
import org.example.backendspring.interfaces.MatiereInterface;
import org.example.backendspring.models.Matiere;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class MatiereWebController {

    private final MatiereInterface matiereInterface ;

    public MatiereWebController(MatiereInterface matiereInterface) {
        this.matiereInterface = matiereInterface;
    }

    @PostMapping("/matieres")
    void createNewMatiere(@RequestBody MatiereDto matiereDto) {
        this.matiereInterface.createNewMatiere(matiereDto);
    }

    @PutMapping("/matieres/id/{id}")
    void modifyMatiere(@PathVariable("id") long id , @RequestBody MatiereDto matiereDto) {
        this.matiereInterface.modifyMatiere(id , matiereDto);
    }

    @DeleteMapping("/matieres/id/{id}")
    void deleteMatiere(@PathVariable("id") long id) {
        this.matiereInterface.deleteMatiere(id);
    }

    @PutMapping("/matieres/id/{id}/enseignement/{enseignement}")
    void addEnseignementToList(@PathVariable("id") long id , @PathVariable("enseignement") String teachName) {
        this.matiereInterface.addEnseignementToList(id , teachName);
    }

    @GetMapping("/matieres/id/{id}")
    Matiere findById(@PathVariable("id") long id) {
        return this.matiereInterface.findById(id) ;
    }

    @GetMapping("/matieres/name/{name}")
    Matiere findByName(String name) {
        return this.matiereInterface.findByName(name) ;
    }

    @GetMapping("/matieres")
    List<Matiere> findAll() {
        return this.matiereInterface.findAll() ;
    }
}
