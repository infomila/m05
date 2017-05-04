
package uml2code_dam;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class ModulTest {
    
    public ModulTest() {
    }

    @Test
    public void testGeneral() {
        CicleFormatiu daw = new CicleFormatiu("ICC0", "Desenvolupament d'Aplicacions Web");
        CicleFormatiu dam = new CicleFormatiu("ICC0", "Desenvolupament d'Aplicacions Multiplataforma");
        Modul m05 =  new Modul(daw, 5, "ED");
        Modul m09 =  new Modul(daw, 5, "DIW");
        
        assertEquals(true,daw.teModul(m05));
        assertEquals(true,daw.teModul(m09));
        assertEquals(daw, m05.getCicle());
        assertEquals(daw, m09.getCicle());
        
        // canviem el mòdul 5 de cicle
        m05.setCicle(dam);
        
        assertEquals(dam, m05.getCicle());        
        assertEquals(true,dam.teModul(m05));
        //assertEquals(false,daw.teModul(m05)); // @ARRRRHHHHHHHHHHHH TODO
        
        m05.setCicle(null);
        assertEquals(false,dam.teModul(m05));
        
        daw.removeModul(m09);
        assertEquals(false,daw.teModul(m09));
        assertEquals(null, m09.getCicle());
    }
}
