package edu.escuelaing.IETI.LearningGuardians.services.implementations;

import edu.escuelaing.IETI.LearningGuardians.entities.materias.Materia;
import edu.escuelaing.IETI.LearningGuardians.entities.materias.Tematica;
import edu.escuelaing.IETI.LearningGuardians.repositories.MateriasRepository;
import edu.escuelaing.IETI.LearningGuardians.repositories.TematicasRepository;
import edu.escuelaing.IETI.LearningGuardians.services.MateriasService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MateriasServiceImplementation implements MateriasService {

    private final MateriasRepository m_Mongo;
    private final TematicasRepository t_Mongo;

    /**
     * Constructor del Servicio de las Materias
     * @param m_Mongo valor para hacer consultas en el cluster Mongo
     */
    public MateriasServiceImplementation(MateriasRepository m_Mongo, TematicasRepository t_Mongo) {
        this.m_Mongo = m_Mongo;
        this.t_Mongo = t_Mongo;
    }

    /**
     * Crea una materia con la informacion dada
     * @return La materia Creada
     */
    @Override
    public Materia createMateria(Materia materia) {
        m_Mongo.save(materia);
        return findMateriaById(materia.id);
    }

    /**
     * Crea una tematica con la informacion dada
     * @param idMateria Materia a la que pertenece la tematica
     * @return La tematica creada
     */
    @Override
    public Tematica createTematica(Tematica tematica, String idMateria) {
        t_Mongo.save(tematica);
        Materia materia = findMateriaById(idMateria);
        materia.idTematicas.add(tematica.id);
        updateMateria(idMateria,materia);
        return findTematicaById(tematica.id);
    }

    /**
     * Busca una materia Según su ID
     * @param id El Identificador de la materia
     * @return La materia encontrada según el ID
     */
    @Override
    public Materia findMateriaById(String id) {
        return (Materia) m_Mongo.findById(id).get();
    }

    /**
     * Busca una Tematica Según su ID
     * @param id El Identificador de la tematica
     * @return La tematica encontrada según el ID
     */
    @Override
    public Tematica findTematicaById(String id) {
        return (Tematica) t_Mongo.findById(id).get();
    }

    /**
     * @return Lista de todas las materias registradas
     */
    @Override
    public List<Materia> getAllMaterias() {
        return m_Mongo.findAll();
    }

    /**
     * @return Lista de todas las tematicas registradas
     */
    @Override
    public List<Tematica> getAllTematicas() {
        return t_Mongo.findAll();
    }

    /**
     * Buscar todas las tematicas de una materia
     * @param idMateria ID de la materia a la que pertenecen las tematicas
     * @return Lista de tematicas d euna materia
     */
    @Override
    public List<Tematica> getTematicasByMateria(String idMateria) {
        ArrayList<Tematica> tematicas = new ArrayList<>();
        List<String> ids = findMateriaById(idMateria).idTematicas;
        for(String id : ids ){
            tematicas.add(findTematicaById(id));
        }
        return tematicas;
    }

    /**
     * Actualiza la materia dado su ID
     * @param id ID de la materia a modificar
     * @param newMateria Información de la materia a actualizar
     * @return Materia Actualizada
     */
    @Override
    public Materia updateMateria(String id, Materia newMateria) {
        m_Mongo.save(newMateria);
        return (Materia) m_Mongo.findById(id).get();
    }

    /**
     * Actualiza la tematica dado su ID
     * @param id ID de la tematica a modificar
     * @param newTematica Información de la tematica a actualizar
     * @return Tematica Actualizada
     */
    @Override
    public Tematica updateTematica(String id, Tematica newTematica) {
        t_Mongo.save(newTematica);
        return (Tematica) t_Mongo.findById(id).get();
    }

    /**
     * Elimina una materia por su ID
     * @param id ID de la materia a eliminar
     * @return Si la materia fue eliminada satisfactoriamente
     */
    @Override
    public Boolean deleteMateriaById(String id) {
        boolean flag;
        try {
            m_Mongo.deleteById(id);
            flag = true;
        } catch (Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * Elimina una tematica por su ID
     * @param id ID de la tematica a eliminar
     * @return Si la tematica fue eliminada satisfactoriamente
     */
    @Override
    public Boolean deleteTematicaById(String id) {
        boolean flag;
        try {
            t_Mongo.deleteById(id);
            flag = true;
        } catch (Exception e){
            flag = false;
        }
        return flag;
    }
}
