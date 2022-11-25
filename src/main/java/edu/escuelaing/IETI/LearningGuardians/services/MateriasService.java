package edu.escuelaing.IETI.LearningGuardians.services;

import edu.escuelaing.IETI.LearningGuardians.entities.subjects.Materia;
import edu.escuelaing.IETI.LearningGuardians.entities.subjects.Tematica;
import java.util.List;

public interface MateriasService {
    /**
     * Crea una materia con la informacion dada
     * @return La materia Creada
     */
    Materia createMateria(Materia materia);

    /**
     * Crea una tematica con la informacion dada
     * @param idMateria Materia a la que pertenece la tematica
     * @return La tematica creada
     */
    Tematica createTematica(Tematica tematica, String idMateria);

    /**
     * Busca una materia Según su ID
     * @param id El Identificador de la materia
     * @return La materia encontrada según el ID
     */
    Materia findMateriaById(String id);

    /**
     * Busca una Tematica Según su ID
     * @param id El Identificador de la tematica
     * @return La tematica encontrada según el ID
     */
    Tematica findTematicaById(String id);

    /**
     * @return Lista de todas las materias registradas
     */
    List<Materia> getAllMaterias();

    /**
     * @return Lista de todas las tematicas registradas
     */
    List<Tematica> getAllTematicas();

    /**
     * Buscar todas las tematicas de una materia
     * @param idMateria ID de la materia a la que pertenecen las tematicas
     * @return Lista de tematicas d euna materia
     */
    List<Tematica> getTematicasByMateria(String idMateria);

    /**
     * Actualiza la materia dado su ID
     * @param id ID de la materia a modificar
     * @param newMateria Información de la materia a actualizar
     * @return Materia Actualizada
     */
    Materia updateMateria(String id, Materia newMateria);

    /**
     * Actualiza la tematica dado su ID
     * @param id ID de la tematica a modificar
     * @param newTematica Información de la tematica a actualizar
     * @return Tematica Actualizada
     */
    Tematica updateTematica(String id, Tematica newTematica);

    /**
     * Elimina una materia por su ID
     * @param id ID de la materia a eliminar
     * @return Si la materia fue eliminada satisfactoriamente
     */
    Boolean deleteMateriaById(String id);

    /**
     * Elimina una tematica por su ID
     * @param id ID de la tematica a eliminar
     * @return Si la tematica fue eliminada satisfactoriamente
     */
    Boolean deleteTematicaById(String id);
}
