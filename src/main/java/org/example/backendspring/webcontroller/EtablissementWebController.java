package org.example.backendspring.webcontroller;

import org.example.backendspring.dto.EtablissementDto;
import org.example.backendspring.interfaces.EtablissementInterface;
import org.example.backendspring.models.Etablissement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class EtablissementWebController {

    private final EtablissementInterface etablissementInterface ;

    public EtablissementWebController(EtablissementInterface etablissementInterface) {
        this.etablissementInterface = etablissementInterface;
    }

    @PostMapping("/etablissements")
    void createNewEtablissement(@RequestBody EtablissementDto etablissementDto) {
        this.etablissementInterface.createNewEtablissement(etablissementDto);
    }

    @PutMapping("/etablissements/id/{id}")
    void modifyEtablissement(@PathVariable("id") long id , @RequestBody EtablissementDto etablissementDto) {
        this.etablissementInterface.modifyEtablissement(id , etablissementDto);
    }

    @DeleteMapping("/etablissements/id/{id}")
    void deleteEtablissement(@PathVariable("id") long id) {
        this.etablissementInterface.deleteEtablissement(id);
    }

    @PutMapping("/etablissements/id/{id}/eleve/{eleve}")
    void addEleveToList(@PathVariable("id") long id , @PathVariable("eleve") String studentName) {
        this.etablissementInterface.addEleveToList(id , studentName);
    }

    @GetMapping("/etablissements/id/{id}")
    Etablissement findById(@PathVariable("id") long id) {
        return this.etablissementInterface.findById(id) ;
    }

    @GetMapping("/etablissements/name/{name}")
    Etablissement findByName(@PathVariable("name") String name) {
        return this.etablissementInterface.findByName(name) ;
    }

    @GetMapping("/etablissements")
    List<Etablissement> findAll() {
        return this.etablissementInterface.findAll() ;
    }

    @GetMapping("/etablissements/adresse/{adresse}")
    List<Etablissement> findByAddress(@PathVariable("adresse") String address) {
        return this.etablissementInterface.findByAddress(address) ;
    }
}
