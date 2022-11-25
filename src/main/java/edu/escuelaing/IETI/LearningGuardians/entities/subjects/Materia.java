package edu.escuelaing.IETI.LearningGuardians.entities.subjects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("materia")
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
