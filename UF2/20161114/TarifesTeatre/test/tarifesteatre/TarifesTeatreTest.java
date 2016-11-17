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
    public void testXungo(){}

    @Test
    public void testGetPreu() {
        
        int edats[] = {2,3,4,5,6,11,12,13,30,59,60,61,70};
        
        TipusSeient tipus[] = { 
            TipusSeient.PLATEA, 
            TipusSeient.LATERAL,
            TipusSeient.PRIMER_PIS  ,
            TipusSeient.SEGON_PIS                
        };
 
        double preus[][] = {
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
            
            {30,    10,     8,      6} ,             
            {30,    10,     8,      6} ,            
            {30,    10,     8,      6}               
        };
        
        TarifesTeatre tt = new TarifesTeatre();
        
        for(int e=0;e<edats.length;e++) {
            for(int t=0;t<tipus.length;t++){
                double preuEsperat = preus[e][t];
                int edat = edats[e];
                TipusSeient tip = tipus[t];
                
                System.out.println("edat:"+edat+"; tipus:"+tip);
                assertEquals( preuEsperat, tt.getPreu(tip, edat) , 0.001);
            }
        }
        
        
    }
    
}
