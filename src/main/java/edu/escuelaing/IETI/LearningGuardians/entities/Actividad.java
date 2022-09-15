package edu.escuelaing.IETI.LearningGuardians.entities;

/**
 *		------------------------------------------------------------------------
 *		------------------------ Actividad --------------------------------
 *		------------------------------------------------------------------------
 *
 * CLASE: Entidad principal, siendo la clase que representa a cada una de las actividades a las cuales se ingresan
 * en la pagina web
 *
 * @author : Santiago Buitrago
 *
 * @version 1.3 Final
 **/

import edu.escuelaing.IETI.LearningGuardians.dto.ActividadDto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Actividad {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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

    public Actividad(ActividadDto actividadDto) {
        ID =actividadDto.getID();
        nombre=actividadDto.getNombre();
        descripcion=actividadDto.getDescripcion();
        materia=actividadDto.getMateria();
        calificacion=actividadDto.getCalificacion();
        fechaCalificacion=actividadDto.getFechaCalificacion();
        comentarios=actividadDto.getComentarios();
        fechaPublicacion=actividadDto.getFechaPublicacion();
        fechaCierre=actividadDto.getFechaCierre();
        estado=actividadDto.getEstado();
    }

    public Actividad() {}
}
