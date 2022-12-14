package edu.escuelaing.IETI.LearningGuardians.IA;

import edu.escuelaing.IETI.LearningGuardians.entities.PlanOperativo;
import org.javatuples.Pair;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ConcurrentHashMap;

public class LearningIA {

    private LocalTime LlegadaCasa = null;

    private ConcurrentHashMap<String, Pair> extraCurriculares = new ConcurrentHashMap<>();

    private ConcurrentHashMap<String, Pair> particionEstudio = new ConcurrentHashMap<>();

    private final PlanOperativo p_operativo;

    public LearningIA(PlanOperativo planOperativo) {
        this.p_operativo = planOperativo;
        start();
    }

    /**
     * Ejecuta la IA para que empiece a revisar a partir de los datos del JSON que estudio
     * es optimo para el estudiante
     */
    public void start() {
        this.extraCurriculares = insertExtraCurriculares();
        llegadaCasa();
        reparticionEstudio(TipoEstudio());
    }

    /**
     * Funcion generada para insertar en un ConcurrentHashMap los valores de las actividades extracurriculares
     */
    private ConcurrentHashMap<String, Pair> insertExtraCurriculares() {
        try {
            String extra = this.p_operativo.getExtraCurriculares();
            String[] firstSplit = extra.split(",");
            for (String extraCurricular : firstSplit) {
                Pair<String, String> pairTuple = new Pair<>(extraCurricular.split(".")[1].split("-")[0], extraCurricular.split(".")[1].split("-")[1]);
                extraCurriculares.put(extraCurricular.split(".")[0], pairTuple);
            }
            return extraCurriculares;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Funcion usada para generar la posible llegada del estudiante a la casa. Se le da 1 hora y media
     * contando como referencia la hora en la que sale del colegio que puso el estudiante
     * <p>
     * En caso que se tenga actividades extracurriculares, se revisa la que este mas tarde y desde ahi
     * se le da la hora de llegada
     */
    public void llegadaCasa() {
        LocalTime llegada = null;
        LocalTime salida = null;
        try {
            salida = LocalTime.parse(p_operativo.getSalidaColegio());
            llegada = LocalTime.of(salida.getHour() + 1, salida.getMinute() + 30);
            this.LlegadaCasa = llegada;
            if (getExtraCurriculares() != null) {
                this.LlegadaCasa = LatestExtra().plusMinutes(40);
            }
        } catch (DateTimeParseException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Funcion generada para retornar el tiempo estimado de llegada de acuerdo a la ultima
     * extracurricular. Se toma el tiempo de salida de esta y se le a??ade 40 minutos
     *
     * @return
     */
    private LocalTime LatestExtra() {
        LocalTime LateExtra = LocalTime.of(0, 0);
        for (String extraKey : this.extraCurriculares.keySet()) {
            LocalTime newTime = LocalTime.parse(this.extraCurriculares.get(extraKey).getValue1().toString());
            if (newTime.isAfter(LateExtra)) {
                LateExtra = newTime;
            }
        }
        return LateExtra;
    }

    /**
     * Funcion creada para revisar que tipo de estudio se le debe poner al estudiante de acuerdo a la fecha en que este
     * estipulada la actividad. Este caso no debe aplicar para cuando es una semana normal, osea que no tiene actividades
     * como quiz o parcial por presentar.
     *
     * @return
     */
    public String TipoEstudio() {
        int until_days = (int) LocalDate.parse(p_operativo.getFechaActividad()).until(LocalDate.now(), ChronoUnit.DAYS);
        if (until_days >= 3) {
            return "REFUERZO SENCILLO";
        } else if (until_days == 2) {
            return "REFUERZO MEDIANO";
        } else if (until_days == 1) {
            return "REFUERZO EXTENSO";
        }
        return null;
    }

    /**
     * Funcion generada para retornar el ConcurrentHashMap con la particion de horas del dia, esto de
     * acuerdo con que tipo de estudio se le escogio al estudiante
     *
     * @param tipo
     */
    public void reparticionEstudio(String tipo) {
        switch (tipo) {
            case "REFUERZO SENCILLO":
                this.particionEstudio = particion(15, 40, LocalTime.of(8, 0));
                break;
            case "REFUERZO MEDIANO":
                this.particionEstudio = particion(20, 30, LocalTime.of(9, 30));
                break;
            case "REFUERZO EXTENSO":
                this.particionEstudio = particion(35, 20, LocalTime.of(11, 20));
                break;

        }
    }

    /**
     * Funcion generada para generar la particion de estudio de acuerdo con la hora de inicio del estudiante,
     * el descanso que se le da y la hora maxima de estudio
     *
     * CAMBIO -> QUE PASA SI EL ESTUDIANTE SE QUIERE PASAR DE HORA Y SEGUIR ESTUDIANDO ??
     *
     * @param tiempoEstudio
     * @param descanso
     * @param horaMaxima
     * @return
     */
    public ConcurrentHashMap particion(int tiempoEstudio, int descanso, LocalTime horaMaxima) {
        ConcurrentHashMap<String, Pair> particionFinal = new ConcurrentHashMap<>();
        LocalTime horaInicio = this.LlegadaCasa;
        LocalTime horaFin = null;
        int var = 0;
        while (!horaInicio.equals(horaMaxima)) {
            //Insercion de particion en hashmap
            var += 1;
            //Suma a la hora de fin los minutos de estudio
            horaFin = horaInicio.plusMinutes(tiempoEstudio);
            particionFinal.put("Estudio_" + var, new Pair<>(horaInicio, horaFin));
            // se deja la nueva hora de inicio como la de fin mas un descanso, segun lo establecido por IA
            horaInicio = horaInicio.plusMinutes(descanso);
        }
        return particionFinal;
    }

    /**
     * Getter llegada casa
     *
     * @return
     */
    public LocalTime getLlegadaCasa() {
        return LlegadaCasa;
    }

    /**
     * Setter llegada casa
     *
     * @param llegadaCasa
     */
    public void setLlegadaCasa(LocalTime llegadaCasa) {
        LlegadaCasa = llegadaCasa;
    }

    /**
     * Getter Extracurriculares
     *
     * @return
     */
    public ConcurrentHashMap<String, Pair> getExtraCurriculares() {
        return extraCurriculares;
    }

    /**
     * Setter Extracurriculares
     */
    public void setExtraCurriculares(ConcurrentHashMap<String, Pair> extraCurriculares) {
        this.extraCurriculares = extraCurriculares;
    }

    /**
     * Getter Particion Estudio
     *
     * @return
     */
    public ConcurrentHashMap getParticionEstudio() {
        return particionEstudio;
    }

    /**
     * Setter Particion Estudio
     * @param particionEstudio
     */
    public void setParticionEstudio(ConcurrentHashMap particionEstudio) {
        this.particionEstudio = particionEstudio;
    }
}
