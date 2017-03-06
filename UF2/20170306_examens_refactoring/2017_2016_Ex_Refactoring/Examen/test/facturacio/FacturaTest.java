package facturacio;

import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author bernat
 */
public class FacturaTest {
    
    public FacturaTest() {
    }

    /**
     * Test of toXML method, of class Factura.
     */
    @Test
    public void testToXML() {
               
        Producte p1, p2, p3, p4;
        
        p1 = new Producte(1, "Patates", BigDecimal.valueOf(3.20), TipusProdEnum.NORMAL, 4);
        p2 = new Producte(2, "Ous", BigDecimal.valueOf(10.50), TipusProdEnum.EN_PROMOCIO_2X1, 8);
        p3 = new Producte(3, "Ous caducats", BigDecimal.valueOf(10.50), TipusProdEnum.EN_LIQUIDACIO, 8 );
        p4 = new Producte(4, "iPad3", BigDecimal.valueOf(550.20), TipusProdEnum.NOVETAT, 18);
            
        
        Factura f = new Factura(1);
        f.afegirLinia(new LiniaFactura(p1, 2));
        f.afegirLinia(new LiniaFactura(p1, 50));
        f.afegirLinia(new LiniaFactura(p1, 100));
        f.afegirLinia(new LiniaFactura(p1, 200));
        
        f.afegirLinia(new LiniaFactura(p2, 12));
        f.afegirLinia(new LiniaFactura(p2, 13));
        
        f.afegirLinia(new LiniaFactura(p3, 12));
        f.afegirLinia(new LiniaFactura(p4, 2));
        
        String sortidaEsperada="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<factura numero=\"1\" >\n<linies>\n\t<linia tip=\"NORMAL\" num=\"1\">\n\t\t<bi>6,4</bi>\n\t\t<iva>0,26</iva>\n\t\t<total>6,66</total>\n\t</linia>\n\t<linia tip=\"NORMAL\" num=\"2\">\n\t\t<bi>144</bi>\n\t\t<iva>5,76</iva>\n\t\t<total>149,76</total>\n\t</linia>\n\t<linia tip=\"NORMAL\" num=\"3\">\n\t\t<bi>256</bi>\n\t\t<iva>10,24</iva>\n\t\t<total>266,24</total>\n\t</linia>\n\t<linia tip=\"NORMAL\" num=\"4\">\n\t\t<bi>448</bi>\n\t\t<iva>17,92</iva>\n\t\t<total>465,92</total>\n\t</linia>\n\t<linia tip=\"2X1\" num=\"5\">\n\t\t<bi>63</bi>\n\t\t<iva>5,04</iva>\n\t\t<total>68,04</total>\n\t</linia>\n\t<linia tip=\"2X1\" num=\"6\">\n\t\t<bi>73,5</bi>\n\t\t<iva>5,88</iva>\n\t\t<total>79,38</total>\n\t</linia>\n\t<linia tip=\"LIQUIDACIO\" num=\"7\">\n\t\t<bi>37,8</bi>\n\t\t<iva>3,02</iva>\n\t\t<total>40,82</total>\n\t</linia>\n\t<linia tip=\"NOVETAT\" num=\"8\">\n\t\t<bi>1.430,52</bi>\n\t\t<iva>257,49</iva>\n\t\t<total>1.688,01</total>\n\t</linia>\n</linies>\n<base_imposable>2.459,22</base_imposable>\n<iva>305,61</iva>\n<total>2.764,83</total>\n<resum>\n\t<numero_linies tip=\"LIQUIDACIO\">1</total>\n\t<numero_linies tip=\"2x1\">2</total>\n\t<numero_linies tip=\"NORMAL\">4</total>\n\t<numero_linies tip=\"NOVETAT\">1</total>\n</resum>\n</factura>\n";
        String sortidaReal = f.toXML();
        System.out.println(sortidaReal+"\n=================\n"+sortidaEsperada);
        assertEquals("validació de generació XML errònia", sortidaEsperada, sortidaReal);

        
    }
}
