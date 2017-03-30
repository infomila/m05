/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml2code_dam;

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
        Grup gr = new Grup(cf, 2, "A");
        
        //gr.setCicle(cf);
        
        
        assertEquals( gr, cf.getGrup(0)  );
        
    }
 
    @Test
    public void testCanviarDeGrup(){
        CicleFormatiu daw = new CicleFormatiu("ICC0", "Desenvolupament d'Aplicacions Web");
        CicleFormatiu dam = new CicleFormatiu("ICCB", "Desenvolupament d'Aplicacions Multi.");
        Grup gr = new Grup(dam, 2, "A");
        
        //dam.addGrup(gr);        
        assertEquals( dam ,gr.getCicle());
        
        // canvi de cicle
        gr.setCicle(daw);
        assertEquals( daw ,gr.getCicle());
        assertEquals( true ,daw.teGrup(gr));
        assertEquals( false ,dam.teGrup(gr));
        
        
        
        
    }

    @Test
    public void testGetCicle() {
    }

    @Test
    public void testSetCicle() {
    }

    @Test
    public void testGetCurs() {
    }

    @Test
    public void testGetSubgrup() {
    }
}
