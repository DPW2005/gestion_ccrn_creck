package org.example.backendspring.services;

import org.example.backendspring.dto.MatiereDto;
import org.example.backendspring.interfaces.MatiereInterface;
import org.example.backendspring.models.Enseignement;
import org.example.backendspring.models.Matiere;
import org.example.backendspring.repositories.EnseignementRepository;
import org.example.backendspring.repositories.MatiereRepository;

import java.util.List;

public class MatiereService implements MatiereInterface {

    private final MatiereRepository matiereRepository ;

    private final EnseignementRepository enseignementRepository ;

    MatiereService(MatiereRepository matiereRepository, EnseignementRepository enseignementRepository) {
        this.matiereRepository = matiereRepository;
        this.enseignementRepository = enseignementRepository;
    }

    @Override
    public void createNewMatiere(MatiereDto matiereDto) {
        Matiere matiere = new Matiere() ;
        matiere.name = matiereDto.name ;
        matiere.hours = matiereDto.hours ;

        this.matiereRepository.save(matiere) ;
    }

    @Override
    public void modifyMatiere(long id, MatiereDto matiereDto) {
        Matiere matiere = this.findById(id) ;
        matiere.name = matiereDto.name ;
        matiere.hours = matiereDto.hours ;

        this.matiereRepository.save(matiere) ;
    }

    @Override
    public void deleteMatiere(long id) {
        this.matiereRepository.deleteById(id) ;
    }

    @Override
    public void addEnseignementToList(long id, String teachName) {
        Matiere matiere = this.findById(id) ;
        Enseignement enseignement = this.enseignementRepository.findByName(teachName) ;
        matiere.enseignements.add(enseignement) ;

        this.matiereRepository.save(matiere) ;
    }

    @Override
    public Matiere findById(long id) {
        return this.matiereRepository.findById(id).get() ;
    }

    @Override
    public Matiere findByName(String name) {
        return this.matiereRepository.findByName(name) ;
    }

    @Override
    public List<Matiere> findAll() {
        return this.matiereRepository.findAll() ;
    }
}
