package org.example.backendspring.webcontroller;

import org.example.backendspring.dto.AppelDto;
import org.example.backendspring.interfaces.AppelInterface;
import org.example.backendspring.models.Appel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class AppelWebController {

    private final AppelInterface appelInterface ;


    public AppelWebController(AppelInterface appelInterface) {
        this.appelInterface = appelInterface;
    }

    @PostMapping("/appels")
    void createNewAppel(@RequestBody AppelDto appelDto) {
        this.appelInterface.createNewAppel(appelDto) ;
    }

    @PutMapping("/appels/id/{id}")
    void modifyAppel(@PathVariable("id") long id , @RequestBody AppelDto appelDto) {
        this.appelInterface.modifyAppel(id , appelDto);
    }

    @DeleteMapping("/appels/id/{id}")
    void deleteAppel(@PathVariable("id") long id) {
        this.appelInterface.deleteAppel(id);
    }

    @PutMapping("/appels/id/{id}/presence/{presence}")
    void addPresenceToList(@PathVariable("id") long id , @PathVariable("presence") String presenceName) {
        this.appelInterface.addPresenceToList(id , presenceName);
    }

    @GetMapping("/appels/id/{id}")
    Appel findById(@PathVariable("id") long id) {
        return this.appelInterface.findById(id) ;
    }

    @GetMapping("/appels/name/{name}")
    Appel findByName(String name) {
        return this.appelInterface.findByName(name) ;
    }

    @GetMapping("/appels")
    List<Appel> findAll() {
        return this.appelInterface.findAll() ;
    }

    @GetMapping("appels/date/{date}")
    List<Appel> findAllByDate(@PathVariable("date") String date) {
        return this.appelInterface.findAllByDate(date) ;
    }

    @GetMapping("appels/classe/{classe}")
    List<Appel> findAllByClasse(@PathVariable("classe") String className) {
        return this.appelInterface.findAllByClasse(className) ;
    }
}
