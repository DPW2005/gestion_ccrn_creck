package org.example.backendspring.services;

import org.example.backendspring.dto.EnseignantDto;
import org.example.backendspring.interfaces.EnseignantInterface;
import org.example.backendspring.models.Enseignant;
import org.example.backendspring.models.Enseignement;
import org.example.backendspring.models.Matiere;
import org.example.backendspring.repositories.EnseignantRepository;
import org.example.backendspring.repositories.EnseignementRepository;
import org.example.backendspring.repositories.MatiereRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantService implements EnseignantInterface {

    private final EnseignantRepository enseignantRepository ;

    private final EnseignementRepository enseignementRepository ;

    private final MatiereRepository matiereRepository ;

    EnseignantService(EnseignantRepository enseignantRepository, EnseignementRepository enseignementRepository, MatiereRepository matiereRepository) {
        this.enseignantRepository = enseignantRepository;
        this.enseignementRepository = enseignementRepository;
        this.matiereRepository = matiereRepository;
    }

    @Override
    public void createNewEnseignant(EnseignantDto enseignantDto) {
        Enseignant enseignant = new Enseignant() ;
        enseignant.name = enseignantDto.name ;
        enseignant.phone = enseignantDto.phone ;

        this.enseignantRepository.save(enseignant) ;
    }

    @Override
    public void modifyEnseignant(long id, EnseignantDto enseignantDto) {
        Enseignant enseignant = this.findById(id) ;
        enseignant.name = enseignantDto.name ;
        enseignant.phone = enseignantDto.phone ;

        this.enseignantRepository.save(enseignant) ;
    }

    @Override
    public void deleteEnseignant(long id) {
        this.enseignantRepository.deleteById(id) ;
    }

    @Override
    public void addEnseignementToList(long id, String teachName) {
        Enseignant enseignant = this.findById(id) ;
        Enseignement enseignement = this.enseignementRepository.findByName(teachName) ;
        enseignant.enseignements.add(enseignement) ;

        this.enseignantRepository.save(enseignant) ;
    }

    @Override
    public Enseignant findById(long id) {
        return this.enseignantRepository.findById(id).get() ;
    }

    @Override
    public Enseignant findByName(String name) {
        return this.enseignantRepository.findByName(name) ;
    }

    @Override
    public Enseignant findByPhone(String phone) {
        return this.enseignantRepository.findByPhone(phone) ;
    }

    @Override
    public List<Enseignant> findAll() {
        return this.enseignantRepository.findAll() ;
    }

    @Override
    public List<Enseignant> findAllByLesson(String lessonName) {
        List<Enseignant> enseignants = this.findAll() ;
        Matiere matiere = this.matiereRepository.findByName(lessonName) ;
        enseignants.removeIf(enseignant -> {
            enseignant.enseignements.removeIf(enseignement -> !enseignement.matiere.equals(matiere));
            return enseignant.enseignements.isEmpty() ;
        }) ;
        return enseignants ;
    }
}
