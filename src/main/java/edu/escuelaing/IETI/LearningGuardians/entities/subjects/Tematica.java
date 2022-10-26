package edu.escuelaing.IETI.LearningGuardians.entities.subjects;

import org.springframework.data.annotation.Id;

public class Tematica {
    @Id
    public String id;

    public String nombre;

    public Materia materia;

    public int nivel;

    public Tematica(){};

    public Tematica( String nombre, Materia materia, int nivel){
        this.nombre = nombre;
        this.materia = materia;
        this.nivel = nivel;
    }
}
