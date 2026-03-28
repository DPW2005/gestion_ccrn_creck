package org.example.backendspring.services;

import org.example.backendspring.dto.BulletinDto;
import org.example.backendspring.interfaces.BulletinInterface;
import org.example.backendspring.models.Bulletin;
import org.example.backendspring.models.Eleve;
import org.example.backendspring.models.Examen;
import org.example.backendspring.models.Note;
import org.example.backendspring.repositories.BulletinRepository;
import org.example.backendspring.repositories.EleveRepository;
import org.example.backendspring.repositories.ExamenRepository;
import org.example.backendspring.repositories.NoteRepository;

import java.util.List;

public class BulletinService implements BulletinInterface {

    private final BulletinRepository bulletinRepository ;

    private final EleveRepository eleveRepository ;

    private  final ExamenRepository examenRepository ;

    private final NoteRepository noteRepository ;

    BulletinService(BulletinRepository bulletinRepository , EleveRepository eleveRepository , ExamenRepository examenRepository , NoteRepository noteRepository){
        this.bulletinRepository = bulletinRepository ;
        this.eleveRepository = eleveRepository ;
        this.examenRepository = examenRepository ;
        this.noteRepository = noteRepository ;
    }

    @Override
    public void createNewBulletin(BulletinDto bulletinDto) {
        Eleve eleve = this.eleveRepository.findByName(bulletinDto.studentName) ;
        Examen examen = this.examenRepository.findByName(bulletinDto.examName) ;
        Bulletin bulletin = new Bulletin() ;
        bulletin.name = bulletinDto.studentName+"_"+bulletinDto.examName ;
        bulletin.eleve = eleve ;
        bulletin.examen = examen ;

        this.bulletinRepository.save(bulletin) ;
    }

    @Override
    public void modifyBulletin(long id, BulletinDto bulletinDto) {
        Bulletin bulletin = this.findById(id) ;
        Eleve eleve = this.eleveRepository.findByName(bulletinDto.studentName) ;
        Examen examen = this.examenRepository.findByName(bulletinDto.examName) ;
        bulletin.name = bulletinDto.studentName+"_"+bulletinDto.examName ;
        bulletin.eleve = eleve ;
        bulletin.examen = examen ;

        this.bulletinRepository.save(bulletin) ;
    }

    @Override
    public void deleteBulletin(long id) {
        this.bulletinRepository.deleteById(id) ;
    }

    @Override
    public void addNoteToList(long id, String noteName) {
        Bulletin bulletin = this.findById(id) ;
        Note note = this.noteRepository.findByName(noteName) ;
        bulletin.notes.add(note) ;

        this.bulletinRepository.save(bulletin) ;
    }

    @Override
    public Bulletin findById(long id) {
        return this.bulletinRepository.findById(id).get() ;
    }

    @Override
    public Bulletin findByName(String name) {
        return this.bulletinRepository.findByName(name) ;
    }

    @Override
    public List<Bulletin> findAll() {
        return this.bulletinRepository.findAll() ;
    }

    @Override
    public List<Bulletin> findAllByEleve(String studentName) {
        Eleve eleve = this.eleveRepository.findByName(studentName) ;
        return this.bulletinRepository.findAllByEleve(eleve) ;
    }

    @Override
    public List<Bulletin> findAllByExamen(String examName) {
        Examen examen = this.examenRepository.findByName(examName) ;
        return this.bulletinRepository.findAllByExamen(examen) ;
    }
}
