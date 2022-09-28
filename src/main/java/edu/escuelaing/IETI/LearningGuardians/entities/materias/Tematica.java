package edu.escuelaing.IETI.LearningGuardians.entities.materias;

import org.springframework.data.annotation.Id;

public class Tematica {
    @Id
    public String id;

    public String nombre;

    public int nivel;

    public Tematica(){};

    public Tematica( String nombre, int nivel){
        this.nombre = nombre;
        this.nivel = nivel;
    }
}
