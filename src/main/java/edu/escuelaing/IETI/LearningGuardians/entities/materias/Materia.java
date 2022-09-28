package edu.escuelaing.IETI.LearningGuardians.entities.materias;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Materia {
    @Id
    public String id;

    public String nombre;

    public List<String> idTematicas;

    public Materia(){}
    public Materia(String nombre, List<String> tematicas){
        this.nombre = nombre;
        this.idTematicas = tematicas;
    }
}
