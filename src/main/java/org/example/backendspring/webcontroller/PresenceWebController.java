package org.example.backendspring.webcontroller;

import org.example.backendspring.dto.PresenceDto;
import org.example.backendspring.interfaces.PresenceInterface;
import org.example.backendspring.models.Presence;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class PresenceWebController {

    private final PresenceInterface presenceInterface ;

    public PresenceWebController(PresenceInterface presenceInterface) {
        this.presenceInterface = presenceInterface;
    }

    @PostMapping("/presences")
    void createNewPresence(@RequestBody PresenceDto presenceDto) {
        this.presenceInterface.createNewPresence(presenceDto);
    }

    @PutMapping("/presences/id/{id}")
    void modifyPresence(@PathVariable("id") long id , @RequestBody PresenceDto presenceDto) {
        this.presenceInterface.modifyPresence(id , presenceDto);
    }

    @DeleteMapping("/presences/id/{id}")
    void deletePresence(@PathVariable("id") long id) {
        this.presenceInterface.deletePresence(id);
    }

    @GetMapping("/presences/id/{id}")
    Presence findById(@PathVariable("id") long id) {
        return this.presenceInterface.findById(id) ;
    }

    @GetMapping("/presences/name/{name}")
    Presence findByName(@PathVariable("name") String name) {
        return this.presenceInterface.findByName(name) ;
    }


    @GetMapping("/presences")
    List<Presence> findAll() {
        return this.presenceInterface.findAll() ;
    }


    @GetMapping("/presences/eleve/{eleve}")
    List<Presence> findAllByEleve(@PathVariable("eleve") String studentName) {
        return this.presenceInterface.findAllByEleve(studentName) ;
    }


    @GetMapping("/presences/appel/{appel}")
    List<Presence> findAllByAppel(@PathVariable("appel") String callName) {
        return this.presenceInterface.findAllByAppel(callName) ;
    }
}
