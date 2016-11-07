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
public class ProvaTest {
    
    public ProvaTest() {
    }

    /**
     * Test of aplicaDescompte method, of class Prova.
     */
    @Test
    public void testAplicaDescompte() {
        
        Prova p = new Prova();
        
        double p1 = p.aplicaDescompte(10.0, 0.0);
        assertEquals(10.0, p1, 0.001);
        
        double p2 = p.aplicaDescompte(10.0, 10/100.0);
        assertEquals(9, p2, 0.001);
        
        double p3 = p.aplicaDescompte(10.0, -0.2);
        assertEquals(9, p2, 0.001);
                
               
    }
    
}
