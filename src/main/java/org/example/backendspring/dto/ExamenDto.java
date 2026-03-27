package org.example.backendspring.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExamenDto {

    public String name ;

    public LocalDate start ;

    public LocalDate finish ;
}
