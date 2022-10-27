package edu.escuelaing.IETI.LearningGuardians.repositories;
/**
 *		------------------------------------------------------------------------
 *		------------------------ UserRepository --------------------------------
 *		------------------------------------------------------------------------
 *
 * Interfaz: Encargada de conectarse con la base de datos, razon por la cual extiende de
 *  'CrudRepository' el cual permite tener las diferentes funciones teniendo la coneccion
 *  a la base de datos, bajo los parametros del archivo 'aplicattion.properties'
 *
 * @author : Santiago Buitrago
 *
 * @version 1.3 Final
 **/


import edu.escuelaing.IETI.LearningGuardians.entities.Actividad;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActividadRepository extends MongoRepository<Actividad, String> {
}
