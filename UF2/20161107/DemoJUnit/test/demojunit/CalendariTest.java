/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojunit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class CalendariTest {
    
    public CalendariTest() {
    }

    /**
     * Test of esDiaFestiu method, of class Calendari.
     */
    @Test
    public void testEsDiaFestiu() {
        
        Calendari c = new Calendari();
        
        boolean esFestiu1 = c.esDiaFestiu(10,10,2010);                       
        assertEquals( false, esFestiu1);
        
        boolean esFestiu2 = c.esDiaFestiu(25,12,2010); 
        assertEquals( true, esFestiu2);
        try {
            
            boolean esFestiu3 = c.esDiaFestiu(25,12,-2010);
            // A.
            // Si estic aquí, alguna cosa està podrida....
            fail();
        } catch(Exception ex) {
            //B
        }
        
    }
    
}
