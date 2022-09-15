package edu.escuelaing.IETI.LearningGuardians.dtos;
/**
 *		------------------------------------------------------------------------
 *		------------------------ ActividadDto ---------------------------------------
 *		------------------------------------------------------------------------
 *
 * CLASE: Clase encargada de ser un mapeo de la entidad Actividad de manera que
 * proporciona seguridad en el momento de ser utilizada la entidad, ya que no se
 * entrega la propia entidad
 *
 * @author : Santiago Buitrago
 *
 * @version 1.3 Final
 **/

import edu.escuelaing.IETI.LearningGuardians.entities.Estado;
import edu.escuelaing.IETI.LearningGuardians.entities.Materia;

import java.time.LocalDateTime;

public class ActividadDto {

    private Integer ID;
    private String nombre;
    private String descripcion;
    private Materia materia;
    private Integer calificacion;
    private LocalDateTime fechaCalificacion;
    private String comentarios;
    private LocalDateTime fechaPublicacion;
    private LocalDateTime fechaCierre;
    private Estado estado;

    public ActividadDto(Integer ID, String nombre, String descripcion, Materia materia, Integer calificacion, LocalDateTime fechaCalificacion, String comentarios, LocalDateTime fechaPublicacion, LocalDateTime fechaCierre, Estado estado){
        this.ID=ID;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.materia=materia;
        this.calificacion=calificacion;
        this.fechaCalificacion=fechaCalificacion;
        this.comentarios=comentarios;
        this.fechaPublicacion=fechaPublicacion;
        this.fechaCierre=fechaCierre;
        this.estado=estado;
    }

    public Integer getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Materia getMateria() {
        return materia;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public LocalDateTime getFechaCalificacion() {
        return fechaCalificacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public LocalDateTime getFechaCierre() {
        return fechaCierre;
    }

    public Estado getEstado() {
        return estado;
    }
}