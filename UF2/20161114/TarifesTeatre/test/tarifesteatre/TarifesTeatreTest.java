/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarifesteatre;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class TarifesTeatreTest {
    
    public TarifesTeatreTest() {
    }



    @Test
    public void testGetPreu() {
        
        int edats[] = { 0,2,3,   4,5,6,11,  12,13,30,59,  60, 61, 70,119 };
        
        TipusSeient tipus[] = { 
            TipusSeient.PLATEA, 
            TipusSeient.LATERAL,
            TipusSeient.PRIMER_PIS, 
            TipusSeient.SEGON_PIS };
        // TipusSeient tipus[] = TipusSeient.values();
        
                 
        double preus[][] = {
            {0,     0,      0,      0},
            {0,     0,      0,      0},
            {0,     0,      0,      0},
            
            {45,    37.5,   30,     22.5},
            {45,    37.5,   30,     22.5},
            {45,    37.5,   30,     22.5},
            {45,    37.5,   30,     22.5},
            
            {60,    50,     40,     30},
            {60,    50,     40,     30},
            {60,    50,     40,     30},
            {60,    50,     40,     30},
            
            {30,    10,     8,      6},
            {30,    10,     8,      6},
            {30,    10,     8,      6},
            {30,    10,     8,      6}
            
        };

        
        TarifesTeatre tt = new TarifesTeatre();
        
        for(int e=0;e<edats.length;e++) {
            for(int t=0;t<tipus.length;t++) {
                
                int edat = edats[e];
                TipusSeient tip = tipus[t];
                double preuEsperat = preus[e][t];
                
                double preuObtingut = tt.getPreu(tip, edat);
                String missatgeError = "Tipus butaca:"+tip+" edat:"+edat;
                assertEquals(missatgeError, preuEsperat, preuObtingut, 0.001);
                
            }
        }
        
        
        try {
            tt.getPreu(TipusSeient.PLATEA, -1);
            fail("");
        }catch(Exception ex) {}
        
           try {
            tt.getPreu(TipusSeient.PLATEA, 120 );
            fail("");
        }catch(Exception ex) {}     
          
    }

   
    
}
