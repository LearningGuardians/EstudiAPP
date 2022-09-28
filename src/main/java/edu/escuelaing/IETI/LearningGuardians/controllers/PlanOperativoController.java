package edu.escuelaing.IETI.LearningGuardians.controllers;

import java.util.ArrayList;
import java.util.List;

import edu.escuelaing.IETI.LearningGuardians.dtos.PlanOperativoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.escuelaing.IETI.LearningGuardians.entities.PlanOperativo;
import edu.escuelaing.IETI.LearningGuardians.services.PlanOpService;

@RestController
@RequestMapping("/pOperativos")
public class PlanOperativoController {
    
    private final PlanOpService service;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public PlanOperativoController(PlanOpService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PlanOperativoDto>> getAll(){
        try{
            List<PlanOperativo> users = service.getAll();
            List<PlanOperativoDto> usersConvert = new ArrayList<PlanOperativoDto>();
            for(PlanOperativo operatives : users){
                usersConvert.add(modelMapper.map(operatives, PlanOperativoDto.class));
            }
            return new ResponseEntity<>(usersConvert, HttpStatus.ACCEPTED);
        }
        catch(Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanOperativoDto> findById(@PathVariable String id){
        try{
            return new ResponseEntity<>(modelMapper.map(service.findById(id), PlanOperativoDto.class),HttpStatus.ACCEPTED);
        }
        catch(Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Funcion generada para crear e insertar un plan operativo
     * @param pOperativoDto
     * @return
     */
    @PostMapping
    public ResponseEntity<PlanOperativoDto> create(@RequestBody PlanOperativoDto pOperativoDto){
        try{
            PlanOperativo newUser = new PlanOperativo(pOperativoDto);
            service.create(newUser);
            return new ResponseEntity<>(pOperativoDto, HttpStatus.ACCEPTED);
        }
        catch(Exception ex){
            return new ResponseEntity<>(null,HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanOperativoDto> update(@RequestBody PlanOperativo p_operativo,@RequestParam String id){
        try{
            return new ResponseEntity<>(modelMapper.map(service.update(p_operativo,id), PlanOperativoDto.class), HttpStatus.ACCEPTED);
        }
        catch(Exception ex){
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@RequestParam String id){
        try{
            service.deleteById(id);
            return new ResponseEntity<>(true,HttpStatus.ACCEPTED);
        }
        catch(Exception ex){
            return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
        }
    }
}