package facturacio;

import java.util.ArrayList;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Representació d'una Factura. Les factures s'identifiquen amb un número, es
 * fan en una data concreta, i a mÃ©s, contenen una llista ordenada de linies de
 * factura.
 * @author bernat
 * @version 1.0
 * @updated 13-mar-2012 18:26:16
 */
public class Factura {

    private ArrayList<LiniaFactura> linies;
    private long numero;
    private Date data;
    
    public Factura(int unNumero) {
        this.numero = unNumero;
        this.linies = new ArrayList<LiniaFactura>();
        this.data = new Date();
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void afegirLinia(LiniaFactura l) {
        if (l != null) {
            linies.add(l);
        }
    }

    public void eliminarLinia(int num) {
        if (num >= 0 && num < linies.size()) {
            linies.remove(num);
        }
    }

    public String toXML() {
        
        int numLinia=1;
        
        String xml="";         
        NumberFormat nf = DecimalFormat.getNumberInstance( new Locale("ca", "es"));
        nf.setMaximumFractionDigits(2);
        
        
        
        double baseImposableTotal = 0, ivaAcumulatTotal = 0, total=0;
        xml += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        xml += "<factura numero=\""+this.numero+"\" >\n";
        xml += "<linies>\n";
        
        int liniesEnLiquidacio=0, liniesNovetat=0, liniesNormals=0, linies2x1=0;
        // Recorregut per totes les línies de la factura
        for (LiniaFactura lin : linies) {
            // Càlculs dels imports de la línia
            Producte p = lin.getProd();
            double preuProducte = p.getPreu();
 
            // segons el tipus de producte, el preu es pot modificar
            switch(p.getTipus()) {
                case Producte.EN_LIQUIDACIO:
                {
                    preuProducte = preuProducte * 0.30;
                    //-------------------------------
                    liniesEnLiquidacio++;    
                    //-------------------------------
                    double baseImposableLinia = lin.getNumeroUnitats() * preuProducte; 
                    double ivaLinia = baseImposableLinia * p.getTipusIva() / 100;
                    baseImposableTotal += baseImposableLinia;
                    ivaAcumulatTotal += ivaLinia;
                    xml += "\t<linia tip=\"LIQUIDACIO\" num=\""+numLinia+"\">\n";
                    xml += "\t\t<bi>"+nf.format(baseImposableLinia)+"</bi>\n";
                    xml += "\t\t<iva>"+nf.format(ivaLinia)+"</iva>\n";
                    xml += "\t\t<total>"+nf.format(baseImposableLinia+ivaLinia)+"</total>\n";
                    xml += "\t</linia>\n";                      break;
                }
                case Producte.EN_PROMOCIO_2X1:  
                {
                    int unitatsPagades = (int) (lin.getNumeroUnitats() / 2);
                    // Si el nombre  de productes es senar, cal incrementar en un les unitats pagades
                    unitatsPagades += lin.getNumeroUnitats() % 2;
                    preuProducte = preuProducte * (unitatsPagades / (double) lin.getNumeroUnitats());
                    //-------------------------------
                    linies2x1++;
                    //-------------------------------
                    double baseImposableLinia = lin.getNumeroUnitats() * preuProducte; 
                    double ivaLinia = baseImposableLinia * p.getTipusIva() / 100;
                    baseImposableTotal += baseImposableLinia;
                    ivaAcumulatTotal += ivaLinia;
                    xml += "\t<linia tip=\"2X1\" num=\""+numLinia+"\">\n";
                    xml += "\t\t<bi>"+nf.format(baseImposableLinia)+"</bi>\n";
                    xml += "\t\t<iva>"+nf.format(ivaLinia)+"</iva>\n";
                    xml += "\t\t<total>"+nf.format(baseImposableLinia+ivaLinia)+"</total>\n";
                    xml += "\t</linia>\n";                      break;
                }
                case Producte.NOVETAT:
                {
                    preuProducte = preuProducte * 1.30;
                    //-------------------------------
                    liniesNovetat++;
                    //-------------------------------
                    double baseImposableLinia = lin.getNumeroUnitats() * preuProducte; 
                    double ivaLinia = baseImposableLinia * p.getTipusIva() / 100;
                    baseImposableTotal += baseImposableLinia;
                    ivaAcumulatTotal += ivaLinia;
                    xml += "\t<linia tip=\"NOVETAT\" num=\""+numLinia+"\">\n";
                    xml += "\t\t<bi>"+nf.format(baseImposableLinia)+"</bi>\n";
                    xml += "\t\t<iva>"+nf.format(ivaLinia)+"</iva>\n";
                    xml += "\t\t<total>"+nf.format(baseImposableLinia+ivaLinia)+"</total>\n";
                    xml += "\t</linia>\n";                      break;
                } 
                case Producte.NORMAL: 
                {
                    double descompteRappel = 0;
                    int unitats = lin.getNumeroUnitats();
                    if (unitats >= 50 && unitats < 100) {
                        descompteRappel = 10;
                    } else if (unitats >= 100 && unitats < 200) {
                        descompteRappel = 20;
                    } else if (unitats >= 200) {
                        descompteRappel = 30;
                    }
                    preuProducte = preuProducte * (1 - descompteRappel / 100);
                    //-------------------------------
                    liniesNormals++;
                    //-------------------------------
                    double baseImposableLinia = lin.getNumeroUnitats() * preuProducte; 
                    double ivaLinia = baseImposableLinia * p.getTipusIva() / 100;
                    baseImposableTotal += baseImposableLinia;
                    ivaAcumulatTotal += ivaLinia;
                    xml += "\t<linia tip=\"NORMAL\" num=\""+numLinia+"\">\n";
                    xml += "\t\t<bi>"+nf.format(baseImposableLinia)+"</bi>\n";
                    xml += "\t\t<iva>"+nf.format(ivaLinia)+"</iva>\n";
                    xml += "\t\t<total>"+nf.format(baseImposableLinia+ivaLinia)+"</total>\n";
                    xml += "\t</linia>\n";                
                    break;
                }
            }
            numLinia++;
        }
        
        total = baseImposableTotal+ ivaAcumulatTotal;
        
        xml += "</linies>\n";
        xml += "<base_imposable>"+nf.format(baseImposableTotal)+"</base_imposable>\n";
        xml += "<iva>"+nf.format(ivaAcumulatTotal)+"</iva>\n";
        xml += "<total>"+nf.format(total)+"</total>\n";
        xml += "<resum>\n";
        xml += "\t<numero_linies tip=\"LIQUIDACIO\">"+liniesEnLiquidacio+"</total>\n";
        xml += "\t<numero_linies tip=\"2x1\">"+linies2x1+"</total>\n";
        xml += "\t<numero_linies tip=\"NORMAL\">"+liniesNormals+"</total>\n";
        xml += "\t<numero_linies tip=\"NOVETAT\">"+liniesNovetat+"</total>\n";
        xml += "</resum>\n";
        xml += "</factura>\n";
        return xml;
    }
}


