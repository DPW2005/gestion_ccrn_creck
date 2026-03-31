package org.example.backendspring.webcontroller;

import org.example.backendspring.dto.EnseignantDto;
import org.example.backendspring.interfaces.EnseignantInterface;
import org.example.backendspring.models.Enseignant;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class EnseignantWebController {

    private final EnseignantInterface enseignantInterface ;

    public EnseignantWebController(EnseignantInterface enseignantInterface) {
        this.enseignantInterface = enseignantInterface;
    }

    @PostMapping("/enseignants")
    void createNewEnseignant(@RequestBody EnseignantDto enseignantDto) {
        this.enseignantInterface.createNewEnseignant(enseignantDto);
    }

    @PutMapping("/enseignants/id/{id}")
    void modifyEnseignant(@PathVariable("id") long id , @RequestBody EnseignantDto enseignantDto) {
        this.enseignantInterface.modifyEnseignant(id , enseignantDto);
    }

    @DeleteMapping("/enseignants/id/{id}")
    void deleteEnseignant(@PathVariable("id") long id) {
        this.enseignantInterface.deleteEnseignant(id);
    }

    @PutMapping("/enseignants/id/{id}/enseignement/{enseignement}")
    void addEnseignementToList(@PathVariable("id") long id , @PathVariable("enseignement") String teachName) {
        this.enseignantInterface.addEnseignementToList(id , teachName);
    }

    @GetMapping("/enseignants/id/{id}")
    Enseignant findById(long id) {
        return this.enseignantInterface.findById(id) ;
    }

    @GetMapping("/enseignants/name/{name}")
    Enseignant findByName(String name) {
        return this.enseignantInterface.findByName(name) ;
    }

    @GetMapping("/enseignants/phone/{phone}")
    Enseignant findByPhone(String phone) {
        return this.enseignantInterface.findByPhone(phone) ;
    }

    @GetMapping("/enseignants")
    List<Enseignant> findAll() {
        return this.enseignantInterface.findAll() ;
    }

    @GetMapping("/enseignants/matiere/{matiere}")
    List<Enseignant> findAllByLesson(@PathVariable("matiere") String lessonName) {
        return this.enseignantInterface.findAllByLesson(lessonName) ;
    }
}
