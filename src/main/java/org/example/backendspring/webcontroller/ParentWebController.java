package org.example.backendspring.webcontroller;

import org.example.backendspring.dto.ParentDto;
import org.example.backendspring.interfaces.ParentInterface;
import org.example.backendspring.models.Parent;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class ParentWebController {

    private final ParentInterface parentInterface ;

    public ParentWebController(ParentInterface parentInterface) {
        this.parentInterface = parentInterface;
    }

    @PostMapping("/parents")
    void createNewParent(@RequestBody ParentDto parentDto) {
        this.parentInterface.createNewParent(parentDto);
    }

    @PutMapping("/parents/id/{id}")
    void modifyParent(@PathVariable("id") long id , @RequestBody ParentDto parentDto) {
        this.parentInterface.modifyParent(id , parentDto);
    }

    @DeleteMapping("/parents/id/{id}")
    void deleteParent(@PathVariable("id") long id) {
        this.parentInterface.deleteParent(id);
    }

    @PutMapping("/parents/id/{id}/eleve/{eleve}")
    void addEleveToList(@PathVariable("id") long id , @PathVariable("eleve") String studentName) {
        this.parentInterface.addEleveToList(id , studentName);
    }

    @GetMapping("/parents/id/{id}")
    Parent findById(@PathVariable("id") long id) {
        return this.parentInterface.findById(id) ;
    }

    @GetMapping("/parents/name/{name}")
    Parent findByName(@PathVariable("name") String name) {
        return this.parentInterface.findByName(name) ;
    }

    @GetMapping("/parents/phone/{phone}")
    Parent findByPhone(@PathVariable("phone") String phone) {
        return this.parentInterface.findByPhone(phone) ;
    }

    @GetMapping("/parents")
    List<Parent> findAll() {
        return this.parentInterface.findAll() ;
    }

    @GetMapping("/parents/adresse/{adresse}")
    List<Parent> findAllByAddress(@PathVariable("adresse") String address) {
        return this.parentInterface.findAllByAddress(address) ;
    }

    @GetMapping("/parents/eleve/{eleve}")
    List<Parent> findAllByEleve(@PathVariable("eleve") String studentName) {
        return this.parentInterface.findAllByEleve(studentName) ;
    }
}
