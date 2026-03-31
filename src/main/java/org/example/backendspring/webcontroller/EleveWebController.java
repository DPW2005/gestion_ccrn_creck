package org.example.backendspring.webcontroller;

import org.example.backendspring.dto.EleveDto;
import org.example.backendspring.interfaces.EleveInterface;
import org.example.backendspring.models.Eleve;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class EleveWebController {

    private final EleveInterface eleveInterface ;

    public EleveWebController(EleveInterface eleveInterface) {
        this.eleveInterface = eleveInterface;
    }

    @PostMapping("/eleves")
    void createNewEleve(@RequestBody EleveDto eleveDto) {
        this.eleveInterface.createNewEleve(eleveDto);
    }

    @PutMapping("/eleves/id/{id}")
    void modifyEleve(@PathVariable("id") long id , @RequestBody EleveDto eleveDto) {
        this.eleveInterface.modifyEleve(id , eleveDto);
    }

    @DeleteMapping("/eleves/id/{id}")
    void deleteEleve(@PathVariable("id") long id) {
        this.eleveInterface.deleteEleve(id);
    }

    @PutMapping("/eleves/id/{id}/presence/{presence}")
    void addPresenceToList(@PathVariable("id") long id , @PathVariable("presence") String presenceName) {
        this.eleveInterface.addPresenceToList(id , presenceName);
    }

    @PutMapping("/eleves/id/{id}/note/{note}")
    void addNoteToList(@PathVariable("id") long id , @PathVariable("note") String noteName) {
        this.eleveInterface.addNoteToList(id , noteName);
    }

    @PutMapping("/eleves/id/{id}/bulletin/{bulletin}")
    void addBulletinToList(@PathVariable("id") long id , @PathVariable("bulletin") String reportCardName) {

    }

    @PutMapping("/eleves/id/{id}/parent/{parent}")
    void addParentToList(@PathVariable("id") long id , @PathVariable("parent") String parentName) {
        this.eleveInterface.addParentToList(id , parentName);
    }

    @GetMapping("/eleves/id/{id}")
    Eleve findById(@PathVariable("id") long id) {
        return this.eleveInterface.findById(id) ;
    }

    @GetMapping("/eleves/matriculate/{matriculate}")
    Eleve findByMatriculate(@PathVariable("matriculate") String matriculate) {
        return this.eleveInterface.findByMatriculate(matriculate) ;
    }

    @GetMapping("/eleves/name/{name}")
    Eleve findByName(@PathVariable("name") String name) {
        return this.eleveInterface.findByName(name) ;
    }

    @GetMapping("/eleves")
    List<Eleve> findAll() {
        return this.eleveInterface.findAll() ;
    }

    @GetMapping("/eleves/ill/{ill}")
    List<Eleve> findAllByIll(@PathVariable("ill") String ill) {
        return this.eleveInterface.findAllByIll(ill) ;
    }

    @GetMapping("/eleves/classe/{classe}")
    List<Eleve> findAllByClasse(@PathVariable("classe") String className) {
        return this.eleveInterface.findAllByClasse(className) ;
    }

    @GetMapping("/eleves/etablissement/{etablissement}")
    List<Eleve> findAllByEtablissement(@PathVariable("etablissement") String schoolName) {
        return this.eleveInterface.findAllByEtablissement(schoolName) ;
    }

    @GetMapping("/eleves/badge/{badge}")
    List<Eleve> findAllByBadge(@PathVariable("badge") boolean badge) {
        return this.eleveInterface.findAllByBadge(badge) ;
    }

    @GetMapping("/eleves/parent/{parent}")
    List<Eleve> findAllByParent(@PathVariable("parent") String parentName) {
        return this.eleveInterface.findAllByParent(parentName) ;
    }

    @GetMapping("/eleves/inscrit-entre/{date1}/et/{date2}")
    List<Eleve> findByRegistration(@PathVariable("date1") String firstDate , @PathVariable("date2") String secondDate) {
        return this.eleveInterface.findByRegistration(firstDate , secondDate) ;
    }
}
