package org.example.backendspring.webcontroller;

import org.example.backendspring.dto.BulletinDto;
import org.example.backendspring.interfaces.BulletinInterface;
import org.example.backendspring.models.Bulletin;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class BulletinWebController {

    private final BulletinInterface bulletinInterface ;

    public BulletinWebController(BulletinInterface bulletinInterface) {
        this.bulletinInterface = bulletinInterface;
    }

    @PostMapping("/bulletins")
    void createNewBulletin(@RequestBody BulletinDto bulletinDto) {
        this.bulletinInterface.createNewBulletin(bulletinDto) ;
    }

    @PutMapping("/bulletins/id/{id}")
    void modifyBulletin(@PathVariable("id") long id , @RequestBody BulletinDto bulletinDto) {
        this.bulletinInterface.modifyBulletin(id , bulletinDto);
    }

    @DeleteMapping("/bulletins/id/{id}")
    void deleteBulletin(@PathVariable("id") long id) {
        this.bulletinInterface.deleteBulletin(id);
    }

    @PutMapping("/bulletins/id/{id}/note/{note}")
    void addNoteToList(@PathVariable("id") long id , @PathVariable("note") String noteName) {
        this.bulletinInterface.addNoteToList(id , noteName);
    }

    @GetMapping("/bulletins/id/{id}")
    Bulletin findById(@PathVariable("id") long id) {
        return this.bulletinInterface.findById(id) ;
    }

    @GetMapping("/bulletins/name/{name}")
    Bulletin findByName(String name) {
        return this.bulletinInterface.findByName(name) ;
    }

    @GetMapping("/bulletins")
    List<Bulletin> findAll() {
        return this.bulletinInterface.findAll() ;
    }

    @GetMapping("/bulletins/eleve/{eleve}")
    List<Bulletin> findAllByEleve(@PathVariable("eleve") String studentName) {
        return this.bulletinInterface.findAllByEleve(studentName) ;
    }

    @GetMapping("/bulletins/examen/{examen}")
    List<Bulletin> findAllByExamen(@PathVariable("examen") String examName) {
        return this.bulletinInterface.findAllByExamen(examName) ;
    }
}
