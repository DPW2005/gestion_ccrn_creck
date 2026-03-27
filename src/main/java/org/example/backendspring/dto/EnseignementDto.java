package org.example.backendspring.dto;

import lombok.Data;

import java.util.List;

@Data
public class EnseignementDto {

    public List<String> days ;

    public String teacherName ;

    public String lessonName ;

    public String className ;
}
