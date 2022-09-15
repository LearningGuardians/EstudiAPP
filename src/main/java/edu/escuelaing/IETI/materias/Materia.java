package edu.escuelaing.IETI.materias;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Materia {
    @Id
    public String id;

    public String nombre;

    public List<Tematica> tematicas;

    public Materia(){}
    public Materia(String nombre, List<Tematica> tematicas){
        this.nombre = nombre;
        this.tematicas = tematicas;
    }

    
}
