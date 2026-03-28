package org.example.backendspring.interfaces;

import org.example.backendspring.dto.BulletinDto;
import org.example.backendspring.models.Bulletin;

import java.util.List;

public interface BulletinInterface {

    void createNewBulletin(BulletinDto bulletinDto) ;

    void modifyBulletin(long id , BulletinDto bulletinDto) ;

    void deleteBulletin(long id) ;

    void addNoteToList(long id , String noteName) ;

    Bulletin findById(long id) ;

    Bulletin findByName(String name) ;

    List<Bulletin> findAll() ;

    List<Bulletin> findAllByEleve(String studentName) ;

    List<Bulletin> findAllByExamen(String examName) ;
}
