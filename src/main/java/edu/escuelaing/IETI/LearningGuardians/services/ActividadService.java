package edu.escuelaing.IETI.LearningGuardians.services;
/**
 *		------------------------------------------------------------------------
 *		------------------------ ActividadService --------------------------------
 *		------------------------------------------------------------------------
 *
 * INTERFAZ: Encargada de proponer los diferentes servicios mediante funciones que
 * se pueden implementar a necesidad de lo requerido
 *
 * @author : Santiago Buitrago
 *
 * @version 1.3 Final
 **/


import edu.escuelaing.IETI.LearningGuardians.entities.Actividad;

import java.util.List;
import java.util.Optional;

public interface ActividadService {
    Actividad insertar(Actividad actividad );
    Optional<Actividad> consultar(Integer ID );
    List<Actividad> consultarTodos();
    Actividad modificar(Actividad actividad, Integer ID );
    boolean eliminar( Integer ID );
}
