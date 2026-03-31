package org.example.backendspring.services;

import org.example.backendspring.dto.EtablissementDto;
import org.example.backendspring.interfaces.EtablissementInterface;
import org.example.backendspring.models.Eleve;
import org.example.backendspring.models.Etablissement;
import org.example.backendspring.repositories.EleveRepository;
import org.example.backendspring.repositories.EtablissementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtablissementService implements EtablissementInterface {

    private final EtablissementRepository etablissementRepository ;

    private final EleveRepository eleveRepository ;

    EtablissementService(EtablissementRepository etablissementRepository, EleveRepository eleveRepository) {
        this.etablissementRepository = etablissementRepository;
        this.eleveRepository = eleveRepository;
    }

    @Override
    public void createNewEtablissement(EtablissementDto etablissementDto) {
        Etablissement etablissement = new Etablissement() ;
        etablissement.name = etablissementDto.name ;
        etablissement.address = etablissementDto.address ;

        this.etablissementRepository.save(etablissement) ;
    }

    @Override
    public void modifyEtablissement(long id, EtablissementDto etablissementDto) {
        Etablissement etablissement = this.findById(id) ;
        etablissement.name = etablissementDto.name ;
        etablissement.address = etablissementDto.address ;

        this.etablissementRepository.save(etablissement) ;
    }

    @Override
    public void deleteEtablissement(long id) {
        this.etablissementRepository.deleteById(id) ;
    }

    @Override
    public void addEleveToList(long id, String studentName) {
        Etablissement etablissement = this.findById(id) ;
        Eleve eleve = this.eleveRepository.findByName(studentName) ;
        etablissement.eleves.add(eleve) ;

        this.etablissementRepository.save(etablissement) ;
    }

    @Override
    public Etablissement findById(long id) {
        return this.etablissementRepository.findById(id).get() ;
    }

    @Override
    public Etablissement findByName(String name) {
        return this.etablissementRepository.findByName(name) ;
    }

    @Override
    public List<Etablissement> findAll() {
        return this.etablissementRepository.findAll() ;
    }

    @Override
    public List<Etablissement> findByAddress(String address) {
        return this.etablissementRepository.findAllByAddress(address) ;
    }
}
