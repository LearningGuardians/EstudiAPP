package edu.escuelaing.IETI.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.IETI.LearningGuardians.dto.PlanOperativoDto;
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
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanOperativoDto> findById(@RequestParam String id){
        return null;
    }

    @PostMapping
    public ResponseEntity<PlanOperativoDto> create(@RequestBody PlanOperativoDto pOperativoDto){
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanOperativoDto> update(@RequestBody PlanOperativoDto pOperativoDto,@RequestParam String id){
        return null;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@RequestParam String id){
        return null;
    }
}