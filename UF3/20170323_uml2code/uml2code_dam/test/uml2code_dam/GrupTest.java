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
    public void esborrarGrup() {
        CicleFormatiu dam = new CicleFormatiu("ICB0", "Desenv.Aplicacions Multiplataforma");
         
        Grup segon = new Grup(dam, 2, "A");
        
        dam.esborrarGrup(segon);
        
        assertEquals( null,   segon.getCicle());
        assertEquals( false , dam.teGrup(segon));
        
        
    }
    
    @Test
    public void testCanviGrups() {
        
        CicleFormatiu dam = new CicleFormatiu("ICB0", "Desenv.Aplicacions Multiplataforma");
        CicleFormatiu daw = new CicleFormatiu("ICC0", "Desenv.Aplicacions Web");
        
        Grup segon = new Grup(dam, 2, "A");
        assertEquals( dam, segon.getCicle());
        
        //daw.afegirGrup(segon);
        segon.setCicle(daw);
        assertEquals( daw, segon.getCicle());
        assertEquals( false, dam.teGrup(segon));
        assertEquals( true, daw.teGrup(segon));
                    
    }    
    @Test
    public void testGeneral() {
        
        CicleFormatiu dam = new CicleFormatiu("ICB0", "Desenv.Aplicacions Multiplataforma");

        Grup segon = new Grup(dam , 2, "A");
        
        //segon.setCicle(dam);
        
        assertEquals( dam, segon.getCicle());
        
        assertEquals( segon , dam.getGrup(0));
        
    }
 
}
