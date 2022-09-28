package edu.escuelaing.IETI.LearningGuardians.services.implementations;

import java.util.List;

import edu.escuelaing.IETI.LearningGuardians.IA.LearningIA;
import edu.escuelaing.IETI.LearningGuardians.repositories.PlanOperativo_Repository;
import org.springframework.stereotype.Service;

import edu.escuelaing.IETI.LearningGuardians.entities.PlanOperativo;
import edu.escuelaing.IETI.LearningGuardians.services.PlanOpService;

@Service
public class PlanOpBdService implements PlanOpService {

    private final PlanOperativo_Repository po_Mongo;

    private LearningIA IA;

    /**
     * Constructor Servicio Plan operativo. Se asigna valor po_mongo para
     * hacer consultas en Cluster Mongo
     *
     * @param po_mongo
     * @param ia
     */
    public PlanOpBdService(PlanOperativo_Repository po_mongo, LearningIA ia) {
        this.po_Mongo = po_mongo;
        IA = ia;
    }

    /**
     * Funcion generada para crear un plan operativo de acuerdo con el nombre del usuario
     * @param pOp
     * @return
     */
    @Override
    public PlanOperativo create(PlanOperativo pOp) {
        po_Mongo.save(pOp);
        IA = new LearningIA(pOp);
        return pOp;
    }

    /**
     * Funcion generada para retornar el plan operativo dado por un identificador
     * @param id
     * @return
     */
    @Override
    public PlanOperativo findById(String id) {
        return (PlanOperativo) po_Mongo.findById(id).get();
    }

    /**
     * Funcion generada para retornar la lista de todos los planes operativos
     * @return
     */
    @Override
    public List<PlanOperativo> getAll() {
        return po_Mongo.findAll();
    }

    /**
     * Funcion generada para actualizar un plan operativo. Este se busca de acuerdo
     * a un identificador y luego se le cambia la info a la dada por el usuario
     * @param operative_plan Informacion del plan operativo a actualizar
     * @param id Id del pla operativo a actualizar
     * @return
     */
    @Override
    public PlanOperativo update(PlanOperativo operative_plan, String id) {
        po_Mongo.save(operative_plan);
        return (PlanOperativo) po_Mongo.findById(id).get();
    }

    /**
     *Funcion generada para eliminar un plan operativo de acuerdo con un identificador
     * @param id
     */
    @Override
    public void deleteById(String id) {
        po_Mongo.deleteById(id);
    }
}
