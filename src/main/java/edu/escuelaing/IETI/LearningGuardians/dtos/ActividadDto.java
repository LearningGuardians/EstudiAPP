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
import java.util.Date;

public class ActividadDto {

    private String ID;
    private String nombre;
    private String descripcion;
    private Materia materia;
    private Integer calificacion;
    private Date fechaCalificacion;
    private String comentarios;
    private Date fechaPublicacion;
    private Date fechaCierre;
    private Estado estado;

    public ActividadDto(String ID, String nombre, String descripcion, Materia materia, Integer calificacion, Date fechaCalificacion, String comentarios, Date fechaPublicacion, Date fechaCierre, Estado estado){
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

    public String getID() {
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

    public Date getFechaCalificacion() {
        return fechaCalificacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public Estado getEstado() {
        return estado;
    }
}