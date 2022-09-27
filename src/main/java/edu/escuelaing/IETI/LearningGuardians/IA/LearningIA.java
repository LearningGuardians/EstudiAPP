package edu.escuelaing.IETI.LearningGuardians.IA;

import edu.escuelaing.IETI.LearningGuardians.entities.PlanOperativo;
import org.javatuples.Pair;


import javax.persistence.Tuple;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class LearningIA {

    private LocalTime LlegadaCasa = null;

    private ConcurrentHashMap<String, Pair> extraCurriculares = new ConcurrentHashMap<>();

    private PlanOperativo p_operativo;

    public LearningIA(PlanOperativo planOperativo){
        this.p_operativo = planOperativo;
        llegadaCasa();
    }

    /**
     * Funcion generada para insertar en un ConcurrentHashMap los valores de las actividades extracurriculares
     */
    private void insertExtraCurriculares(){
        String extra = this.p_operativo.getExtraCurriculares();
        String[] firstSplit = extra.split(",");
        for(String extraCurricular: firstSplit){
            Pair<String, String> pairTuple = new Pair<>(extraCurricular.split(".")[1].split("-")[0],extraCurricular.split(".")[1].split("-")[1]);
            extraCurriculares.put(extraCurricular.split(".")[0],pairTuple);
        }
    }


    /**
     * Funcion usada para generar la posible llegada del estudiante a la casa. Se le da 1 hora y media
     * contando como referencia la hora en la que sale del colegio que puso el estudiante
     */
    public void llegadaCasa() {
        LocalTime llegada = null;
        LocalTime salida = null;
        try{
            salida = LocalTime.parse(p_operativo.getSalidaColegio());
            llegada = LocalTime.of(salida.getHour()+1, salida.getMinute()+30);
            this.LlegadaCasa = llegada;
        }
        catch (DateTimeParseException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Funcion creada para revisar que tipo de estudio se le debe poner al estudiante de acuerdo a la fecha en que este
     * estipulada la actividad. Este caso no debe aplicar para cuando es una semana normal, osea que no tiene actividades
     * como quiz o parcial por presentar.
     * @return
     */
    public String TipoEstudio(){
        int until_days = (int)LocalDate.parse(p_operativo.getFechaActividad()).until(LocalDate.now(), ChronoUnit.DAYS);
        if(until_days >= 3){
            return "REFUERZO SENCILLO";
        }
        else if(until_days == 2){
            return "REFUERZO MEDIANO";
        }
        else if(until_days == 1){
            return "REFUERZO EXTENSO";
        }
        return null;
    }

    /**
     * Getter llegada casa
     * @return
     */
    public LocalTime getLlegadaCasa() {
        return LlegadaCasa;
    }

    /**
     * Setter llegada casa
     * @param llegadaCasa
     */
    public void setLlegadaCasa(LocalTime llegadaCasa) {
        LlegadaCasa = llegadaCasa;
    }
}
