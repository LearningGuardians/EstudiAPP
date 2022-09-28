package edu.escuelaing.IETI.LearningGuardians.repositories;

import edu.escuelaing.IETI.LearningGuardians.entities.PlanOperativo;
import edu.escuelaing.IETI.LearningGuardians.entities.materias.Materia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MateriasRepository extends MongoRepository<Materia,String> {
}
