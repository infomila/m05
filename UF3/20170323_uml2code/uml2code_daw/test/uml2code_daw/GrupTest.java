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
public class GrupTest {
    
    public GrupTest() {
    }

    @Test
    public void testGeneral() {
        CicleFormatiu cf = new CicleFormatiu("ICC0", "Desenvolupament d'Aplicacions Web");
        Grup gr = new Grup(2, "A");
        
        gr.setCicle(cf);
        
        
        assertEquals( gr, cf.getGrup(0)  );
        
    }
 
}
