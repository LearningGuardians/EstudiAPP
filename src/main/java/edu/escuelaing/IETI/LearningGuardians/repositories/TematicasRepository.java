package edu.escuelaing.IETI.LearningGuardians.repositories;

import edu.escuelaing.IETI.LearningGuardians.entities.materias.Materia;
import edu.escuelaing.IETI.LearningGuardians.entities.materias.Tematica;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TematicasRepository extends MongoRepository<Tematica,String> {
}
