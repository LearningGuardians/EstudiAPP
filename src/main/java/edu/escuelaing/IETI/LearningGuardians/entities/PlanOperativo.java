package edu.escuelaing.IETI.LearningGuardians.entities;

import org.springframework.data.annotation.Id;

import edu.escuelaing.IETI.LearningGuardians.dtos.PlanOperativoDto;

import java.time.LocalDate;

public class PlanOperativo {

    @Id
    private String id;
    private String nombreEstudiante;
    private String Materia;
    private String Tematica;
    private String fechaDeCreacion;
    private String porcentaje;

    /**
     * Constructor vacio, en caso que se quiera crear con los datos basicos
     * entonces se le deja un identificador y la fecha de creacion
     */
    public PlanOperativo(){
        this.id = String.valueOf(Math.floor(Math.random()*10+1));
        this.fechaDeCreacion = LocalDate.now().toString();
    }

    /**
     * Constructor generado para la creacion de planes operativos, donde el usuario da todos los parametros
    */
    public PlanOperativo(PlanOperativoDto operativoDto){
        this.id = operativoDto.getId();
        this.nombreEstudiante = operativoDto.getNombreEstudiante();
        this.Materia=operativoDto.getMateria();
        this.Tematica = operativoDto.getTematica();
        this.fechaDeCreacion = operativoDto.getFecha();
        this.porcentaje = operativoDto.getPorcentaje();
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
        return fechaDeCreacion;
    }
    public void setFecha(String fecha) {
        this.fechaDeCreacion = fecha;
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

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }
}
