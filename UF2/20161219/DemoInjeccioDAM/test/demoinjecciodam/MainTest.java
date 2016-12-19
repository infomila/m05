/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoinjecciodam;

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
    public void testMailMassiu() {
        Missatger.setModeTest(true);
        Main m = new Main();
        m.mailMassiu(/*new MissatgerFals()*/);
        m.mailMassiu();
        m.mailMassiu();
        m.mailMassiu();
        Missatger.setModeTest(false);
    }
    
}
