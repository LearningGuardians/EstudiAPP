package edu.escuelaing.IETI.LearningGuardians.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.escuelaing.IETI.LearningGuardians.IA.LearningIA;
import edu.escuelaing.IETI.LearningGuardians.repositories.PlanOperativo_Repository;

import org.springframework.beans.factory.annotation.Autowired;
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
    public PlanOpBdService(@Autowired PlanOperativo_Repository po_mongo) {
        this.po_Mongo = po_mongo;
    }

    /**
     * Funcion generada para crear un plan operativo de acuerdo con el nombre del usuario
     * @param pOp
     * @return
     */
    @Override
    public PlanOperativo create(PlanOperativo pOp) {
        po_Mongo.save(pOp);
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

    /**
     * Mediante un filtro hacia todos los elementos de la base de datos, se revisa los planes operativos
     * que tengan como due??o al usuario definido.
     * @param name
     */
    @Override
    public List<PlanOperativo> getAllFromUser(String name){
        List<PlanOperativo> all = getAll();
        List<PlanOperativo> onlyUser = new ArrayList();
        for(PlanOperativo po : all){
            if(po.getNombreEstudiante().equals(name)){
                onlyUser.add(po);
            }
        }
        return onlyUser;
    }
}
