package edu.escuelaing.IETI.LearningGuardians.controllers;

import edu.escuelaing.IETI.LearningGuardians.dtos.materias.MateriaDto;
import edu.escuelaing.IETI.LearningGuardians.dtos.materias.TematicaDto;
import edu.escuelaing.IETI.LearningGuardians.entities.materias.Materia;
import edu.escuelaing.IETI.LearningGuardians.entities.materias.Tematica;
import edu.escuelaing.IETI.LearningGuardians.services.MateriasService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Materias")
public class MateriasController {

    private final MateriasService service;

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public MateriasController(MateriasService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MateriaDto>> getAllMaterias(){
        try{
            List<Materia> materias = service.getAllMaterias();
            List<MateriaDto> materiaDtos = new ArrayList<MateriaDto>();
            for(Materia m : materias){
                materiaDtos.add(modelMapper.map(m, MateriaDto.class));
            }
            return new ResponseEntity<>(materiaDtos, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping
    public ResponseEntity<List<TematicaDto>> getAllTematicas(){
        try{
            List<Tematica> tematicas = service.getAllTematicas();
            List<TematicaDto> tematicaDtos = new ArrayList<TematicaDto>();
            for(Tematica m : tematicas){
                tematicaDtos.add(modelMapper.map(m, TematicaDto.class));
            }
            return new ResponseEntity<>(tematicaDtos, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MateriaDto> findMateriaById(@PathVariable String id){
        try {
            return new ResponseEntity<>(modelMapper.map(service.findMateriaById(id), MateriaDto.class),HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

}
