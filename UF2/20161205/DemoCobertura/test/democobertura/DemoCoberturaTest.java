/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democobertura;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class DemoCoberturaTest {
    
    public DemoCoberturaTest() {
    }

    @Test
    public void testMain() {
    }

    @Test
    public void testFuncioProva() {
        DemoCobertura dc = new DemoCobertura();
        dc.funcioProva(0, 0);
        dc.funcioProva(0, 4);
        dc.funcioProva(1, 3);
    }
    
}
