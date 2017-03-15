/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecterefaccioexamen;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class FlotaTest {
     
    /**
     * Test of getInformeFlota method, of class Flota.
     */
    @Test
    public void testGetInformeFlota() {
        Flota f = new Flota();
        f.addVehicle(new Camio(10000,  "3423-VFC", TipusBenzina.GASOIL, 800));
        f.addVehicle(new Camio(20000,  "3643-FCV", TipusBenzina.GASOIL, 900));
        f.addVehicle(new Cotxe(2000, "3333-DDR", TipusBenzina.GASOLINA_95, 60));
        f.addVehicle(new Cotxe(2500,  "5555-DDR", TipusBenzina.GASOIL, 80));
        f.addVehicle(new Moto(120,  "3423-XXX", TipusBenzina.GASOLINA_95, 20));        
        String resultatEsperat = 
                        "========================================\n"+
                        "===   Informe de la flota de vehicles  =\n"+
                        "========================================\n"+
                        "Camió amb matricula 3423-VFC\n"+
                        "Consum: 34 l/100Km\n"+
                        "        45,56 €/100Km\n"+
                        "----------------------------------------\n"+
                        "Camió amb matricula 3643-FCV\n"+
                        "Consum: 36 l/100Km\n"+
                        "        48,24 €/100Km\n"+
                        "----------------------------------------\n"+
                        "Cotxe amb matricula 3333-DDR\n"+
                        "Consum: 6 l/100Km\n"+
                        "        8,82 €/100Km\n"+
                        "----------------------------------------\n"+
                        "Cotxe amb matricula 5555-DDR\n"+
                        "Consum: 6 l/100Km\n"+
                        "        8,04 €/100Km\n"+
                        "----------------------------------------\n"+
                        "Moto amb matricula 3423-XXX\n"+
                        "Consum: 2 l/100Km\n"+
                        "        2,94 €/100Km\n"+
                        "----------------------------------------\n"+
                        "========================================\n"+
                        "===    Resum de consums per tipus    ===\n"+
                        "========================================\n"+
                        "Camions:93,80 €/100Km\n"+
                        "Cotxes:16,86 €/100Km\n"+
                        "Motos:2,94 €/100Km\n";
        assertEquals(resultatEsperat, f.getInformeFlota());
    }

}
