/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buelin;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class BuelinTest {
    
    public BuelinTest() {
    }

    @Test
    public void testGetSobrecostPerEquipatge() {
        
        
        //-----------------------------------------------------------------------
        //          EQUIPATGE DE MÀ
        //-----------------------------------------------------------------------        
        float tolerancia = 0.001f;
        Buelin b = new Buelin();
        // Sense EM
        float s = b.getSobrecostPerEquipatge(null, 10, null, false);
        assertEquals(0, s, tolerancia);
        //------------------------------------------------
        // Sense EM
        s = b.getSobrecostPerEquipatge(new int[]{}, 10, null, false);
        assertEquals(0, s, tolerancia);
        //------------------------------------------------
        // EM dimensions normals
        s = b.getSobrecostPerEquipatge(new int[]{10,20,26}, 10, null, false);
        assertEquals(0, s, tolerancia);
        //------------------------------------------------       
        //   EM dimensions normals amb excès de pes
        s = b.getSobrecostPerEquipatge(new int[]{10,20,26}, 25, null, false);
        assertEquals(0, s, tolerancia);
        //------------------------------------------------        
        //  EM excés dimensions X
        s = b.getSobrecostPerEquipatge(new int[]{31,20,26}, 15, null, false);
        assertEquals(60, s, tolerancia);
        //------------------------------------------------   
        //  EM excés dimensions Y
        s = b.getSobrecostPerEquipatge(new int[]{10,31,26}, 15, null, false);
        assertEquals(60, s, tolerancia);
        //------------------------------------------------   
        //  EM excés dimensions Z
        s = b.getSobrecostPerEquipatge(new int[]{10,10,31}, 15, null, false);
        assertEquals(60, s, tolerancia);
        //------------------------------------------------          
        //  EM excés dimensions X + excés de pes  $$$$$$$$
        s = b.getSobrecostPerEquipatge(new int[]{31,20,26}, 25, null, false);
        assertEquals(160, s, tolerancia);
        //------------------------------------------------  
        try {
            b.getSobrecostPerEquipatge(new int[]{10,10,10}, -2, null, false);
            fail("");
        } catch (Exception e) {
        }
        //------------------------------------------------  
        try {
            b.getSobrecostPerEquipatge(new int[]{-10,10,10}, 15, null, false);
            fail("");
        } catch (Exception e) {
        }
        //------------------------------------------------  
        try {
            b.getSobrecostPerEquipatge(new int[]{10,-10,10}, 15, null, false);
            fail("");
        } catch (Exception e) {
        }
        //------------------------------------------------  
        try {
            b.getSobrecostPerEquipatge(new int[]{10,10,-10}, 15, null, false);
            fail("");
        } catch (Exception e) {
        }
        //------------------------------------------------  
        try {
            b.getSobrecostPerEquipatge(new int[]{10,10}, 15, null, false);
            fail("");
        } catch (Exception e) {
        }
        //------------------------------------------------  
        try {
            b.getSobrecostPerEquipatge(new int[]{10,10,10,10}, 15, null, false);
            fail("");
        } catch (Exception e) {
        }        
        
        
        //-----------------------------------------------------------------------
        //          MALETES
        //-----------------------------------------------------------------------
        //------------------------------------------------   
        // 0 maletes
        s = b.getSobrecostPerEquipatge(null, 0, null, false);
        assertEquals(0, s, tolerancia);       
        s = b.getSobrecostPerEquipatge(null, 0, new int[]{}, false);
        assertEquals(0, s, tolerancia);   
        // 1 maleta
        s = b.getSobrecostPerEquipatge(null, 0, new int[]{10}, false);
        assertEquals(0, s, tolerancia);          
        s = b.getSobrecostPerEquipatge(null, 0, new int[]{19}, false);
        assertEquals(0, s, tolerancia);  
        s = b.getSobrecostPerEquipatge(null, 0, new int[]{20}, false);
        assertEquals(0, s, tolerancia);           
        s = b.getSobrecostPerEquipatge(null, 0, new int[]{21}, false);
        assertEquals(20, s, tolerancia);  
        // dues maletes
        s = b.getSobrecostPerEquipatge(null, 0, new int[]{19,19}, false);
        assertEquals(0, s, tolerancia); 
        s = b.getSobrecostPerEquipatge(null, 0, new int[]{19,21}, false);
        assertEquals(20, s, tolerancia);  
        s = b.getSobrecostPerEquipatge(null, 0, new int[]{21,19}, false);
        assertEquals(20, s, tolerancia);  
        s = b.getSobrecostPerEquipatge(null, 0, new int[]{21,21}, false);
        assertEquals(40, s, tolerancia);    
        
        //tres maletes
        s = b.getSobrecostPerEquipatge(null, 0, new int[]{19,19,19}, false);
        assertEquals(190, s, tolerancia); 
        s = b.getSobrecostPerEquipatge(null, 0, new int[]{21,19,21}, false);
        assertEquals(230, s, tolerancia);          
        
        
        /// fora de rang        
        try {
            s = b.getSobrecostPerEquipatge(null, 0, new int[]{-1}, false);
            fail("");
        } catch (Exception e) {}
        
        try {
            s = b.getSobrecostPerEquipatge(null, 0, new int[]{12, -1}, false);
            fail("");
        } catch (Exception e) {}
        
        
        
        
        //-----------------------------------------------------------------------
        //          AMB TARJA DE CRÈDIT
        //-----------------------------------------------------------------------
        s = b.getSobrecostPerEquipatge(null, 0, new int[]{15,15}, true);
        assertEquals(0, s, tolerancia);          
        
        s = b.getSobrecostPerEquipatge(null, 0, new int[]{21,15}, true);
        assertEquals(22, s, tolerancia);      
        
        
        
        //-----------------------------------------------------------------------
        //          CAS COMBINAT
        //-----------------------------------------------------------------------        
        
        s = b.getSobrecostPerEquipatge(new int[]{31, 10, 20}, 21, new int[]{21,15, 10}, true);
        assertEquals(202, s, tolerancia);   
        
    }
    
}
