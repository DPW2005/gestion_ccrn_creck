package org.example.backendspring.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EleveDto {

    public  String matriculate ;

    public String name ;

    public LocalDate birthday ;

    public LocalDate registration ;

    public String ill ;

    public boolean badge ;

    public String className ;

    public String schoolName ;
}
