/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojunit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class SegurataTest {
    
    public SegurataTest() {
    }

    /**
     * Test of pucEntrar method, of class Segurata.
     */
    @Test
    public void testPucEntrar() {
        
        Segurata s = new Segurata();
        int edats[] = new int[] {16,17,25,130,15,8,0};
        boolean potEntrar[] = new boolean[] {true,true,true,true,false, false};

        for(int i=0;i<edats.length-1;i++) {
         assertEquals(potEntrar[i], s.pucEntrar(edats[i]));
        }        
        testejarEdatForaDeRang(-2);
        testejarEdatForaDeRang(135);
             
    }
    
    private void testejarEdatForaDeRang(int edat) {
         try {
            Segurata s = new Segurata();
            s.pucEntrar(edat);
            fail();
        } catch(Exception ex) {}    
    }
    
    
    
    @Test
    public void testPucEntrarV2() {
        
        Segurata s = new Segurata();
        int edats[] = new int[] {6, 16,17,25,130,15,8,0};
        float suborn[] = new float[] { 0,9,10,11,19,20,21, 25};
                
        boolean potEntrar[][] = new boolean[][] {
            //{0,  9,    10,   11,    19,  20,   21,   25};
            {false,false,false,false,false,true, true, true},   // 6            
            {true, true, true, true, true, true, true, true},   // 16
            {true, true, true, true, true, true, true, true},   // 17
            {true, true, true, true, true, true, true, true},   // 25
            {true, true, true, true, true, true, true, true},   // 130
            {false,false,true, true, true, true, true, true},   // 15
            {false,false,false,false,false,true, true, true},   // 8
            {false,false,false,false,false,true, true, true},    // 0
        };

        for(int i=0;i<edats.length-1;i++) {
            for(int n=0;n<suborn.length-1;n++) {                
                // Si no �s coleguilla, dep�n de la casu�stica d'edats
                // i suborns:
                System.out.println("edats[i]"+edats[i]+"-suborn[n]"+suborn[n]+"\n");
                assertEquals(potEntrar[i][n], s.pucEntrar(edats[i], false, suborn[n]));
                
                // Si �s coleguilla sempre pot entrar
                assertEquals(true, s.pucEntrar(edats[i], true, suborn[n]));
            }
        }
        
        try {
            s.pucEntrar(3000   , true, 0);
            fail("Edats >130 no permeses");
            
        } catch(Exception ex){}
        try {
            s.pucEntrar(-5   , true, 0);
            fail("Edats <0 no permeses");
        } catch(Exception ex){}
        try {
            s.pucEntrar( 5   , true, -50);
            fail("Suborn <0 no permes");
        } catch(Exception ex){}
        
        
             
    }    
}
