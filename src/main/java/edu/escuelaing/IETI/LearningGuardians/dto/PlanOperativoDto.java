package edu.escuelaing.IETI.LearningGuardians.dto;

public class PlanOperativoDto {
    
    private String id;

    private String NombreEstudiante
    private String Materia;
    private String Tematica;
    private String fecha;
    private String porcentaje;

    public PlanOperativoDto(){
        
    }

    public String getMateria() {
        return Materia;
    }
    public void setMateria(String materia) {
        Materia = materia;
    }
    public String getTematica() {
        return Tematica;
    }
    public void setTematica(String tematica) {
        Tematica = tematica;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getPorcentaje() {
        return porcentaje;
    }
    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
