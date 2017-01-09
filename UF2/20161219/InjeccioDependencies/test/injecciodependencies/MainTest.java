/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package injecciodependencies;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class MainTest {
    
    public MainTest() {
    }

 
    @Test
    public void testFerOfertesClients() {
        
        Main m = new Main();
        Missatger.setModeTest(true);
        m.ferOfertesClients(/*new MissatgerFals()*/);
        Missatger.setModeTest(false);
    }
    
}
