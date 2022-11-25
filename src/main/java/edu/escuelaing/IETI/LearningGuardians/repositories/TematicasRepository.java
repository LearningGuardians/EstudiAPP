package edu.escuelaing.IETI.LearningGuardians.repositories;

import edu.escuelaing.IETI.LearningGuardians.entities.subjects.Tematica;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TematicasRepository extends MongoRepository<Tematica,String> {
}
