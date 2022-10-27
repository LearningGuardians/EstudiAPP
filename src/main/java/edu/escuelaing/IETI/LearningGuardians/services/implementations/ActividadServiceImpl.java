package edu.escuelaing.IETI.LearningGuardians.services.implementations;
/**
 *		------------------------------------------------------------------------
 *		------------------------ ActividadServiceMySql --------------------------------
 *		------------------------------------------------------------------------
 *
 * CLASE: Implementando la interfaz de 'ActividadService', se implementan y desarrollan
 * los diferentes metodos a necesesidad segun las funciones requeridas, en donde
 * por medio de la interfaz de 'ActividadRepository' se utilizan las solicitudes que llegan
 * de los enpoints para hacer la respectiva funcion y coneccion con la base de datos,
 * segun o que se requiere
 *
 * @author : Santiago Buitrago
 *
 * @version 1.3 Final
 **/

import edu.escuelaing.IETI.LearningGuardians.entities.Actividad;

import edu.escuelaing.IETI.LearningGuardians.repositories.ActividadRepository;
import edu.escuelaing.IETI.LearningGuardians.services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadServiceImpl implements ActividadService {


    private final ActividadRepository actividadRepository;


    public ActividadServiceImpl(@Autowired ActividadRepository actividadRepository )
    {
        this.actividadRepository = actividadRepository;
    }

    @Override
    public Actividad insertar(Actividad actividad)
    {
        actividadRepository.save(actividad);
        return actividad;
    }

    @Override
    public Optional<Actividad> consultar(String ID) {
        return actividadRepository.findById(ID);
    }

    @Override
    public List<Actividad> consultarTodos() {
        System.out.println(actividadRepository.findAll());
        return (List<Actividad>) actividadRepository.findAll();
    }

    @Override
    public Actividad modificar(Actividad actividad, String ID) {
        eliminar(ID);
        return actividadRepository.save(actividad);
    }
    @Override
    public boolean eliminar(String ID) {
        actividadRepository.deleteById(ID);
        return true;
    }
}