package uml2code_dam;

import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BERNAT
 */
public class CicleFormatiuTest {
    
    public CicleFormatiuTest() {
    }

    
    @Test
    public void testCanviGrups() {
        
        CicleFormatiu dam = new CicleFormatiu("ICB0", "Desenv.Aplicacions Multiplataforma");
        CicleFormatiu daw = new CicleFormatiu("ICC0", "Desenv.Aplicacions Web");
        
        Grup segon = new Grup(dam, 2, "A");
        assertEquals( dam, segon.getCicle());
        
        daw.afegirGrup(segon);
        assertEquals( daw, segon.getCicle());
        assertEquals( false, dam.teGrup(segon));
        assertEquals( true, daw.teGrup(segon));
                    
    }
    
    @Test
    public void testGeneral() {
        
        CicleFormatiu dam = new CicleFormatiu("ICB0", "Desenv.Aplicacions Multiplataforma");
        
        Grup segon = new Grup(dam, 2, "A");
                
        //dam.afegirGrup(segon);
        
        //----------------------------------
        
        assertEquals( dam, segon.getCicle());
        //-----------------------------------
        
        
        assertEquals( 1 , dam.getNumGrups() );
        assertEquals( segon, dam.getGrup(0));
        Iterator<Grup> it = dam.getIteratorGrup();
        while(it.hasNext()){
            assertEquals( segon,it.next());
        }
        assertEquals( true,dam.esborrarGrup(new Grup(dam, 3, "C")));
        assertEquals( true,dam.esborrarGrup(segon));
        assertEquals( 0 , dam.getNumGrups() );
        
    }
 
    
}
