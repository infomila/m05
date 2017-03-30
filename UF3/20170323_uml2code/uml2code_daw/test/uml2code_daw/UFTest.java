/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml2code_daw;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class UFTest {
    
    public UFTest() {
    }
    
    @Test
    public void testGeneral() {
        CicleFormatiu daw = new CicleFormatiu("ICC0", "Desenvolupament d'Aplicacions Web");
        Modul m05 =  new Modul(daw, 5, "ED");
        Modul m09 =  new Modul(daw, 5, "DIW");
        
        Modul.UF m05UF1 = new Modul.UF(m05, 1,"Desenvolupament de programari", 20);
        Modul.UF m05UF2 = new Modul.UF(m05, 2,"Optimització de programari", 20);
        Modul.UF m05UF3 = new Modul.UF(m05, 3,"Introducció al disseny orientat a objectes", 20);
   
        assertEquals(3, m05.getNumUFs());
        
        // si afegim una repetida no la compta
        try {
            Modul.UF m05UF4 = new Modul.UF(m05, 3,"Introducció al disseny orientat a objectes", 20);
            fail("Repetits no admisibles");
        }catch(Exception ex){
            // el que esperem és que passi per aquí
        }
        assertEquals(3, m05.getNumUFs());
        
        m05.removeUF(0);
        assertEquals(2, m05.getNumUFs());
        
         
    }
    
}
