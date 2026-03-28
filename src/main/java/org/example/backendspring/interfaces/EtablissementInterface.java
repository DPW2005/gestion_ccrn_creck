package org.example.backendspring.interfaces;

import org.example.backendspring.dto.EtablissementDto;
import org.example.backendspring.models.Etablissement;

import java.util.List;

public interface EtablissementInterface {

    void createNewEtablissement(EtablissementDto etablissementDto) ;

    void modifyEtablissement(long id , EtablissementDto etablissementDto) ;

    void deleteEtablissement(long id) ;

    void addEleveToList(long id , String studentName) ;

    Etablissement findById(long id) ;

    Etablissement findByName(String name) ;

    List<Etablissement> findAll() ;

    List<Etablissement> findByAddress(String address) ;
}
