package edu.escuelaing.IETI.LearningGuardians.services;

import java.util.List;

import edu.escuelaing.IETI.LearningGuardians.entities.PlanOperativo;

public interface PlanOpService {
    
    /**
     * Crea un plan operativo con la informacion dada
     * @return El plan operativo Creado
     */
    PlanOpService create(PlanOperativo pOp);

    /**
     * Busca el plan operativo segun el id
     * @return El plan operativo encontrado por el Id
     */
    PlanOpService findByid(String id);

    /**
     * @return Lista de todos los planes operativos registrados
     */
    List<PlanOpService> getAll();

    /**
     * Actualiza el plan operativo seleccionado, dado su id
     * @param pOp Informacion del plan operativo a actualizar
     * @param id Id del pla operativo a actualizar
     * @return Plan operativo actualizado
     */
    PlanOpService update(PlanOperativo pOp, String id);

    /**
     * Elimina el plan operativo dado su id
     * @return Id del plan operativo a eliminar
     */
    PlanOpService deleteById();
}
