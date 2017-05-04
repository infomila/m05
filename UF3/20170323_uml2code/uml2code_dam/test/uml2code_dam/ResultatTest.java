package uml2code_dam;

import java.util.Date;
import java.util.List;
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
        
        Alumne paco = new Alumne( 123123, "11111111H", "Paco", "Maroto", "Toloc", new Date(), Persona.Sexe.DONA);
        
        Resultat r1 = new Resultat(paco,m05UF1,2016);
        //---------------------------------------
        assertEquals( paco ,  r1.getAlumne());
        assertEquals( m05UF1, r1.getUF());
        assertEquals( 2016, r1.getCurs());
        
        assertEquals(r1,  paco.getResultat(0) );        
        assertEquals(r1,  m05UF1.getResultat(0) );
        //---------------------------------------
                                
        Resultat r2 = new Resultat(paco,m05UF1,2017);
        Resultat r3 = new Resultat(paco,m05UF2,2016);
        Resultat r4 = new Resultat(paco,m05UF2,2016);
        
        Resultat r = paco.getResultat("ICC0", 5, 2, 2016);
        assertEquals(r3 , r);
        
        //-----------------------------------------------------------------
        Resultat rBis = m05UF1.getResultat("11111111H", 2017);                
        assertEquals(r2, rBis);
        
        //-----------------------------------------------------------------
        List<Resultat> resultatsDenPaco = m05UF1.getResultat("11111111H");
        assertEquals(2,resultatsDenPaco.size());
        assertEquals(r1,resultatsDenPaco.get(0));
        assertEquals(r2,resultatsDenPaco.get(1));
   
    }

    
    
}
