/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.iesmila.ED.UF2.capsa_blanca;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class TheIncredibleMachineTest {
    
    public TheIncredibleMachineTest() {
    }

    @Test
    public void testCrunch() {
        
        
        TheIncredibleMachine tim = new TheIncredibleMachine();
        tim.crunch(new int[]{
                10,7,7,7,7,7,7, // stage 0
                3,3,3,3,4,4,4,4,5,5,5,5,// stage 1
                1,8,1,5});// stage 2
    }
    
}
