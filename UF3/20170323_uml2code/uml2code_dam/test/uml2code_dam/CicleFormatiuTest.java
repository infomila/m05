/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml2code_dam;

import java.util.Iterator;
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
    public void testGeneral() {
        
        CicleFormatiu dam = new CicleFormatiu("ICB0", "Desenv.Aplicacions Multiplataforma");
        
        Grup segon = new Grup(dam, 2, "A");
                
        //dam.afegirGrup(segon);
        
        //----------------------------------
        
        assertEquals( dam, segon.getCicle());
        //-----------------------------------
        
        
        assertEquals( 1 , dam.getNumGrups() );
        assertEquals( segon, dam.getGrup(0));
        Iterator<Grup> it = dam.getIteratorGrup();
        while(it.hasNext()){
            assertEquals( segon,it.next());
        }
        assertEquals( true,dam.esborrarGrup(new Grup(dam, 3, "C")));
        assertEquals( true,dam.esborrarGrup(segon));
        assertEquals( 0 , dam.getNumGrups() );
        
    }
 
    
}
