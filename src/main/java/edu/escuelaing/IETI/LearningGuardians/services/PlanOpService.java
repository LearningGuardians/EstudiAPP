package edu.escuelaing.IETI.LearningGuardians.services;

import java.util.List;

import edu.escuelaing.IETI.LearningGuardians.entities.PlanOperativo;

public interface PlanOpService {
    
    /**
     * Crea un plan operativo con la informacion dada
     * @return El plan operativo Creado
     */
    PlanOperativo create(PlanOperativo pOp);

    /**
     * Busca el plan operativo segun el id
     * @return El plan operativo encontrado por el Id
     */
    PlanOperativo findById(String id);

    /**
     * @return Lista de todos los planes operativos registrados
     */
    List<PlanOperativo> getAll();

    /**
     * Actualiza el plan operativo seleccionado, dado su id
     * @param pOp Informacion del plan operativo a actualizar
     * @param id Id del pla operativo a actualizar
     * @return Plan operativo actualizado
     */
    PlanOperativo update(PlanOperativo pOp, String id);

    /**
     * Elimina el plan operativo dado su id
     * @return Id del plan operativo a eliminar
     */
    void deleteById(String id);

    /**
     * Retorna la lista de planes operativos que tenga un usuario especifico
     * @param name
     * @return
     */
    List<PlanOperativo> getAllFromUser(String name);
}
