/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uml2code_daw;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class ResultatTest {
    
    public ResultatTest() {
    }
   @Test
    public void testGeneral() {
        CicleFormatiu daw = new CicleFormatiu("ICC0", "Desenvolupament d'Aplicacions Web");
        Modul m05 =  new Modul(daw, 5, "ED");
        
        Modul.UF m05UF1 = new Modul.UF(m05, 1,"Desenvolupament de programari", 20);
        Modul.UF m05UF2 = new Modul.UF(m05, 2,"Optimització de programari", 20);
        Modul.UF m05UF3 = new Modul.UF(m05, 3,"Introducció al disseny orientat a objectes", 20);
        
        
        Alumne paco = new Alumne(123123, "1111111H", "Paco", "Maroto","Pérez",new Date(),Alumne.Sexe.HOME);
        
        Resultat resultatM5uf1 = new Resultat(paco,m05UF1, 2016 );
        assertEquals( paco, resultatM5uf1.getAlumne());
        assertEquals( m05UF1, resultatM5uf1.getUF());
        assertEquals( 2016, resultatM5uf1.getCurs());
        
        assertEquals(resultatM5uf1, paco.getResultat(0));
        assertEquals(resultatM5uf1, m05UF1.getResultat(0));
        
        //-------------------------
        // intento repetir el mateix resultat
        try {
            paco.addResultat(resultatM5uf1);
            fail("No es pot permetre repetir resultats");
        } catch(Exception ex) {
            
        }
         //-------------------------
        resultatM5uf1.setmNotaOrdinaria(4);
        Resultat resultatM5uf2 = new Resultat(paco,m05UF2, 2016 );
        resultatM5uf2.setmNotaOrdinaria(5);
        Resultat resultatM5uf3 = new Resultat(paco,m05UF3, 2016 );
        resultatM5uf3.setmNotaOrdinaria(7);
        Resultat resultatM5uf2_15 = new Resultat(paco,m05UF2, 2015 );
        resultatM5uf2.setmNotaOrdinaria(4);
        Resultat resultatM5uf3_15 = new Resultat(paco,m05UF3, 2015 );
        resultatM5uf2.setmNotaOrdinaria(3);
       
        //----------------------------------------
        
        Resultat r = 
                paco.getResultat("ICC0", 5, 1, 2016 ) ;
        
        assertEquals(resultatM5uf1, r);        
    
        
        
        
    }
    
}
