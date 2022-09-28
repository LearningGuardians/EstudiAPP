package edu.escuelaing.IETI.LearningGuardians.dtos.materias;

public class TematicaDto {
    public String id;

    public String nombre;

    public int nivel;

    public TematicaDto(String id, String nombre, int nivel) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
