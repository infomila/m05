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
        
        CicleFormatiu dam = new CicleFormatiu("ICB0", "Desenv.Aplicacions Multiplataforma");

        Grup segon = new Grup(dam , 2, "A");
        
        //segon.setCicle(dam);
        
        assertEquals( dam, segon.getCicle());
        
        assertEquals( segon , dam.getGrup(0));
        
    }
 
}
