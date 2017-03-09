/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import solucio.Cercle;
import solucio.ColeccioFormes;
import solucio.Forma;
import solucio.Quadrat;
import solucio.Triangle;

/**
 *
 * @author Professor
 */
public class ColeccioFormesTest {
    
    public ColeccioFormesTest() {
    }

  
    /**
     * Test of informeFormes method, of class ColeccioFormes.
     */
    @Test
    public void testInformeFormes() {
        ColeccioFormes c = new ColeccioFormes();
        c.addForma(new Triangle(2));
        c.addForma(new Cercle(2));
        c.addForma(new Cercle(3));
        c.addForma(new Quadrat(3));
        c.addForma(new Triangle(4));
        c.addForma(new Quadrat(3));
        c.addForma(new Quadrat(1));
        String resultat = 
                "========================"+"\n" +
                "- Figura <2>: Triangle	 mida - 2.0 - area 2"+"\n" +
                "- Figura <3>: Cercle	 mida - 2.0 - area 12,57"+"\n" +
                "- Figura <4>: Cercle	 mida - 3.0 - area 28,27"+"\n" +
                "- Figura <5>: Quadrat	 mida - 3.0 - area 9"+"\n" +
                "- Figura <6>: Triangle	 mida - 4.0 - area 8"+"\n" +
                "- Figura <7>: Quadrat	 mida - 3.0 - area 9"+"\n" +
                "- Figura <8>: Quadrat	 mida - 1.0 - area 1"+"\n" +
                "========================"+"\n" +
                "Total figures:7, area total:69,84"+"\n" +
                "========================"+"\n" +
                "Total Quadrats:3, area final:19"+"\n" +
                "========================"+"\n" +
                "Total Cercles:2, area final:40,84"+"\n" +
                "========================"+"\n" +
                "Total triangles:2, area final:10"+"\n" +
                "========================"+"\n";
        
        assertTrue( "informe erroni:", resultat.equals(c.informeFormes()));
    }
}
