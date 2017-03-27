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
public class CicleFormatiuTest {
    
    public CicleFormatiuTest() {
    }
    
    @Test 
        public void esborraGrup() {
        CicleFormatiu dam = new CicleFormatiu("ICCB", "Desenvolupament d'Aplicacions Multi.");
        Grup gr = new Grup(2, "A");
        
        // anul·lant el grup del cicle del grup des de cicle
        dam.addGrup(gr);
        assertEquals( true ,dam.teGrup(gr));
        dam.removeGrup(gr);
        assertEquals( null ,gr.getCicle());
        assertEquals( false ,dam.teGrup(gr));
        
        // anul·lant el grup del cicle del grup des de grup
        dam.addGrup(gr);
        assertEquals( true ,dam.teGrup(gr));
        gr.setCicle(null);
        assertEquals( null ,gr.getCicle());
        assertEquals( false ,dam.teGrup(gr));
        
    }

    @Test
    public void testCanviarDeGrup(){
        CicleFormatiu daw = new CicleFormatiu("ICC0", "Desenvolupament d'Aplicacions Web");
        CicleFormatiu dam = new CicleFormatiu("ICCB", "Desenvolupament d'Aplicacions Multi.");
        Grup gr = new Grup(2, "A");
        
        dam.addGrup(gr);
        assertEquals( dam ,gr.getCicle());
        
        // canvi de cicle
        daw.addGrup(gr);
        assertEquals( daw ,gr.getCicle());
        assertEquals( true ,daw.teGrup(gr));
        assertEquals( false ,dam.teGrup(gr));                            
    }
    
    @Test
    public void testGeneral() {
        
        CicleFormatiu cf = new CicleFormatiu("ICC0", "Desenvolupament d'Aplicacions Web");
        Grup gr = new Grup(2, "A");
        
        assertEquals( 0, cf.getNumGrups() );
        
        cf.addGrup(gr);

        try {
            cf.addGrup(null);
            fail("error");
        } catch(Exception ex) {  } 
        
        
        //------------------------------
        
        assertEquals( cf, gr.getCicle() );
        
        
        assertEquals(2,  cf.getGrup(0).getCurs() );
        assertEquals("A",  cf.getGrup(0).getSubgrup());
        assertEquals( 1 , cf.getNumGrups() );
        
        boolean esborrat = cf.removeGrup(new Grup(2, "KAKA"));
        assertEquals(false, esborrat);
        
        esborrat = cf.removeGrup(gr);
        assertEquals(true, esborrat);
        assertEquals( 0 , cf.getNumGrups());
        
    }

}
