package edu.escuelaing.IETI.LearningGuardians.dtos.materias;

import java.util.List;

public class MateriaDto {
    public String id;

    public String nombre;

    public List<String> idTematicas;

    public MateriaDto(String id, String nombre, List<String> idTematicas){
        this.id = id;
        this.nombre = nombre;
        this.idTematicas = idTematicas;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getIdTematicas() {
        return idTematicas;
    }

    public void setIdTematicas(List<String> idTematicas) {
        this.idTematicas = idTematicas;
    }
}
