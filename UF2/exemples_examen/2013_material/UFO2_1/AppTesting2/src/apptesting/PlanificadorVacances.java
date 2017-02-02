package apptesting;

import java.util.List;

public class PlanificadorVacances {
       
    /**
     * La funció intenta planificar una reunió de la duració especificada (horesReunio) 
     * tenint en  compte totes les reunions que ja estan planificades 
     * anteriorment (reunionsProgramades). 
     * La reunió es planificarà al primer forat disponible que es trobi sense reunions.
     * 
     * Les reunions es poden començar a programar a partir del dia 1 si hi ha forat.
     * Cal tenir en compte que l'horari laboral en el que es poden programar les 
     * reunions és de 9:00 a 20:59:59' ( p.ex. si la reunió és d'una hora, es pot programar 
     * de 20 1 21 hores )
     * 
     * Una reunió no pot quedar partida. Si no cap sencera en un forat, es mou endavant.
     * 
     * La reunió es pot planificar com a màxim el dia ultimDiaProgramable (inclòs), si 
     * no es troba cap forat en aquests dies, es retorna un null.
     * 
     * @param horesReunio les hores que durarà la reunió
     * @param reunions les reunions que hi ha planificades actualment, començant
     * @param maximsDiesEspera màxim dia en els que es pot progamar la reunió (inclòs).
     * 
     * @return la reunió que s'ha pogut planificar, o null si no s'ha pogut trobar forat.
     */
    public Reunio planificaReunio(  int horesReunio, 
                                    List<Reunio> reunionsProgramades, 
                                    int ultimDiaProgramable) 
    {
        Reunio r = new Reunio(1,2,1);
        return r;
    }
}
