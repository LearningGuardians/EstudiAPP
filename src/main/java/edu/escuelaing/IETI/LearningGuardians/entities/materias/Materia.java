package edu.escuelaing.IETI.LearningGuardians.entities.materias;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("materia")
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
