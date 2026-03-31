package org.example.backendspring.services;

import org.example.backendspring.dto.ParentDto;
import org.example.backendspring.interfaces.ParentInterface;
import org.example.backendspring.models.Eleve;
import org.example.backendspring.models.Parent;
import org.example.backendspring.repositories.EleveRepository;
import org.example.backendspring.repositories.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService implements ParentInterface {

    private final ParentRepository parentRepository ;

    private final EleveRepository eleveRepository ;

    public ParentService(ParentRepository parentRepository, EleveRepository eleveRepository) {
        this.parentRepository = parentRepository;
        this.eleveRepository = eleveRepository;
    }

    @Override
    public void createNewParent(ParentDto parentDto) {
        Parent parent = new Parent() ;
        parent.name = parentDto.name ;
        parent.address = parentDto.address ;
        parent.phone = parentDto.phone ;

        this.parentRepository.save(parent) ;
    }

    @Override
    public void modifyParent(long id, ParentDto parentDto) {
        Parent parent = this.findById(id) ;
        parent.name = parentDto.name ;
        parent.address = parentDto.address ;
        parent.phone = parentDto.phone ;

        this.parentRepository.save(parent) ;
    }

    @Override
    public void deleteParent(long id) {
        this.parentRepository.deleteById(id) ;
    }

    @Override
    public void addEleveToList(long id, String studentName) {
        Parent parent = this.findById(id) ;
        Eleve eleve = this.eleveRepository.findByName(studentName) ;
        parent.eleves.add(eleve) ;

        this.parentRepository.save(parent) ;
    }

    @Override
    public Parent findById(long id) {
        return this.parentRepository.findById(id).get() ;
    }

    @Override
    public Parent findByName(String name) {
        return this.parentRepository.findByName(name) ;
    }

    @Override
    public Parent findByPhone(String phone) {
        return this.parentRepository.findByPhone(phone) ;
    }

    @Override
    public List<Parent> findAll() {
        return this.parentRepository.findAll() ;
    }

    @Override
    public List<Parent> findAllByAddress(String address) {
        return this.parentRepository.findAllByAddress(address) ;
    }

    @Override
    public List<Parent> findAllByEleve(String studentName) {
        List<Parent> parents = this.findAll() ;
        Eleve eleve = this.eleveRepository.findByName(studentName) ;
        parents.removeIf(parent -> !parent.eleves.contains(eleve)) ;
        return parents;
    }
}
