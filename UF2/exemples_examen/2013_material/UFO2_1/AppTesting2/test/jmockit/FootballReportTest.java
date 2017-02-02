/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jmockit;

import apptesting.CountryNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class FootballReportTest {
    
    public FootballReportTest() {
    }

    /**
     * Test of reporter method, of class FootballReport.
     */
    @Test
    public void testReporter() {
        FootballReport fr = new FootballReport();

        // Brasil si que existeix a la BD
        String informeXML;
        try {
            informeXML = fr.getReport(Pais.BRASIL);
            assertEquals( "<country name='BRASIL' population='123123123'>www.brasil.com</COUNTRY>" , 
                       informeXML  ) ;
            
        } catch (CountryNotFoundException ex) {fail("Error no esperat");}
        
        try {
            informeXML = fr.getReport(Pais.CUBA);
            fail("CUBA no existeix a la BD, com has arribat fins aquí?");
        } catch(CountryNotFoundException e) {
            
        }

    }
}
