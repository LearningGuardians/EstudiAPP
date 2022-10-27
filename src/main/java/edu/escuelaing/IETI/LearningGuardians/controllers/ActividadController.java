package edu.escuelaing.IETI.LearningGuardians.controllers;

/**
 *		------------------------------------------------------------------------
 *		------------------------ ActividadController --------------------------------
 *		------------------------------------------------------------------------
 *
 * CLASE: Clase encargada de controlar los endpoints para las diferentes funciones solicitadas,
 * donde se reciben las solicitudes de la aplicacion web
 *
 * @author : Santiago Buitrago
 *
 * @version 1.3 Final
 **/

import edu.escuelaing.IETI.LearningGuardians.dtos.ActividadDto;
import edu.escuelaing.IETI.LearningGuardians.entities.Actividad;
import edu.escuelaing.IETI.LearningGuardians.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@RestController
@RequestMapping("/actividad")
//@CrossOrigin(origins = "http://localhost")
public class ActividadController {

    private ActividadService actividadService ;

    @Autowired
    public ActividadController(ActividadService actividadServiceImpl) {
        this.actividadService = actividadServiceImpl;
    }

    @PostMapping("/insertar")
    public ResponseEntity<Actividad> insertar(@RequestBody ActividadDto actividadDto) {
        System.out.println("INSERTANDO ACTIVIDAD --------------------------------------");
        return ResponseEntity.ok(actividadService.insertar( new Actividad(actividadDto)));
    }

    @GetMapping( "/consultar/{ID}" )
    public ResponseEntity<Optional<Actividad>> consultar(@PathVariable String ID) {
        return ResponseEntity.ok(actividadService.consultar(ID));
    }

    @GetMapping
    public ResponseEntity<List<Actividad>> consultarTodos() {
        return ResponseEntity.ok(actividadService.consultarTodos());
    }

    @PutMapping( "/modificar/{ID}" )
    public ResponseEntity<Actividad> modificar(@RequestBody ActividadDto actividadDto, @PathVariable String ID) {
        return ResponseEntity.ok(actividadService.modificar(new Actividad(actividadDto),ID));
    }
}