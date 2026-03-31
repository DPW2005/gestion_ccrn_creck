package org.example.backendspring.interfaces;

import org.example.backendspring.dto.ParentDto;
import org.example.backendspring.models.Parent;

import java.util.List;

public interface ParentInterface {

    void createNewParent(ParentDto parentDto) ;

    void modifyParent(long id , ParentDto parentDto) ;

    void deleteParent(long id) ;

    void addEleveToList(long id , String studentName) ;

    Parent findById(long id) ;

    Parent findByName(String name) ;

    Parent findByPhone(String phone) ;

    List<Parent> findAll() ;

    List<Parent> findAllByAddress(String address) ;

    List<Parent> findAllByEleve(String studentName) ;
}
